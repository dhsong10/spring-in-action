package com.sia.tacos.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.sia.tacos.converter.IngredientByIdConverter;
import com.sia.tacos.entity.Ingredient;
import com.sia.tacos.entity.Order;
import com.sia.tacos.entity.Taco;
import com.sia.tacos.entity.Ingredient.Type;
import com.sia.tacos.repository.IngredientRepository;
import com.sia.tacos.repository.TacoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/design")
@SessionAttributes(value = "order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    private TacoRepository tacoRepository;
    private IngredientByIdConverter converter;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository, IngredientByIdConverter converter) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
        this.converter = converter;
    }

    @ModelAttribute(value = "taco")
    public Taco taco() {
        return new Taco();
    }

    @ModelAttribute(value = "order")
    public Order order() {
        return new Order();
    }
    
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("taco", new Taco());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);

        Taco saved = tacoRepository.save(design);
        order.addDesign(saved);
        return "redirect:/orders/current";    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());
    }
}
