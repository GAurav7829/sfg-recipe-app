package com.sfg.recipe.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sfg.recipe.app.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@GetMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		log.debug("Getting Index page");
		model.addAttribute("recipies", recipeService.getRecipies());
		return "index";
	}

}
