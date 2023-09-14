package com.sfg.recipe.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sfg.recipe.app.commands.RecipeCommand;
import com.sfg.recipe.app.services.RecipeService;

@Controller
public class RecipeController {

	private final RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/recipe/{id}/show")
	public String getRecipe(Model model, @PathVariable String id) {
		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
		return "recipe/show";
	}
	
	@GetMapping("/recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());
		return "recipe/recipeform";
	}
	
	@GetMapping("/recipe/{id}/update")
	public String updateRecipe(Model model, @PathVariable String id) {
		RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));
		model.addAttribute("recipe", recipeCommand);
		return "recipe/recipeform";
	}
	
	@PostMapping("/recipe")
	public String saveOrUpdate(Model model, @ModelAttribute RecipeCommand command) {
		RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(command);
		return "redirect:/recipe/show/"+savedRecipeCommand.getId();
	}
	
	@GetMapping("/recipe/{id}/delete")
	public String deleteRecipe(@PathVariable String id) {
		recipeService.deleleById(Long.valueOf(id));
		return "redirect:/";
	}

}
