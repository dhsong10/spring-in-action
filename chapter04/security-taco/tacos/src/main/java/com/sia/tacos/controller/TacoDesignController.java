package com.sia.tacos.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.sia.tacos.domain.Ingredient;
import com.sia.tacos.domain.Order;
import com.sia.tacos.domain.Taco;
import com.sia.tacos.domain.Ingredient.Type;
import com.sia.tacos.repository.IngredientRepository;
import com.sia.tacos.repository.TacoRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute("taco")
    public Taco taco() {
        return new Taco();
    }

    @Autowired
    public TacoDesignController(IngredientRepository ingredientRepository, TacoRepository tacoRepository) {
        this.ingredientRepository = ingredientRepository;
        this.tacoRepository = tacoRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String design(Model model) {

        addIngredientsToModel(model);

        return "design";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processDesign(@ModelAttribute Taco taco, @ModelAttribute Order order) {

        Taco savedTaco = tacoRepository.save(taco);

        log.info(savedTaco.toString());

        order.addTaco(savedTaco);
        
        return "redirect:/orders/current";
    }

    private void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepository.findAll();

        Type[] types = Type.values();
        for(Type type : types) {

            String key = type.toString().toLowerCase();
            List<Ingredient> value = filterIngredientByType(ingredients, type);

            model.addAttribute(key, value);
        }
    }

    private List<Ingredient> filterIngredientByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());
    }
}
