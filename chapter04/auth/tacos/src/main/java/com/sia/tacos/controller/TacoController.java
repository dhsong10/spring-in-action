package com.sia.tacos.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.sia.tacos.domain.Ingredient;
import com.sia.tacos.domain.Order;
import com.sia.tacos.domain.Taco;
import com.sia.tacos.domain.Ingredient.Type;
import com.sia.tacos.repository.IngredientRepository;
import com.sia.tacos.repository.TacoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("order")
@RequestMapping("/design")
public class TacoController {
    
    private IngredientRepository ingredientRepository;
    private TacoRepository tacoRepository;

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    public TacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String designTaco(Model model) {

        List<Ingredient> ingredients = ingredientRepository.findAll();

        addIngredientToModel(model, ingredients);

        return "design";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processDesign(@ModelAttribute Taco taco, @ModelAttribute Order order) {
        
        Taco savedTaco = tacoRepository.save(taco);

        order.addTaco(savedTaco);

        return "redirect:/orders/current";
    }

    private void addIngredientToModel(Model model, List<Ingredient> ingredients) {

        Type[] types = Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterIngredientByType(ingredients, type));
        }

    }

    private List<Ingredient> filterIngredientByType(List<Ingredient> ingredients, Type type) {

        return ingredients.stream().filter(i -> i.getType().equals(type)).collect(Collectors.toList());

    }
}
