package com.sia.mytacoapplication.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.sia.mytacoapplication.domain.Ingredient;
import com.sia.mytacoapplication.domain.Order;
import com.sia.mytacoapplication.domain.Taco;
import com.sia.mytacoapplication.domain.Ingredient.Type;
import com.sia.mytacoapplication.repository.IngredientRepository;
import com.sia.mytacoapplication.repository.TacoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "design")
@SessionAttributes("order")
public class TacoDesignController {

    private IngredientRepository ingredientRepository;
    private TacoRepository tacoRepository;

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    public TacoDesignController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String design(Model model) {

        List<Ingredient> ingredients = ingredientRepository.findAll();

        addIngredientToModel(model, ingredients);
        
        return "design";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String processDesign(Taco taco, @ModelAttribute Order order) {

        Taco savedTaco = tacoRepository.save(taco);
        log.info(savedTaco.toString());
        log.info(order.toString());

        order.addTaco(savedTaco);

        return "redirect:/orders/current";

    }

    private void addIngredientToModel(Model model, List<Ingredient> ingredients) {

        Type[] types = Type.values();

        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(), filterIngredientByType(ingredients, type));
        }

    }

    private List<Ingredient> filterIngredientByType(List<Ingredient> ingredients, Type type) {

        return ingredients
                .stream()
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());

    }
}
