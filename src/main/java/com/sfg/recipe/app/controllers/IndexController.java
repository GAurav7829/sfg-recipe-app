package com.sfg.recipe.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfg.recipe.app.services.RecipeService;

@Controller
public class IndexController {
	
	private final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		LOG.debug("Getting Index page");
		model.addAttribute("recipies", recipeService.getRecipies());
		return "index";
	}

}
