package com.sfg.recipe.app.controllers;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sfg.recipe.app.commands.RecipeCommand;
import com.sfg.recipe.app.exceptions.NotFoundException;
import com.sfg.recipe.app.services.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RecipeController {

	private static final String RECIPE_RECIPEFORM_URL = "recipe/recipeform";
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
		return RECIPE_RECIPEFORM_URL;
	}

	@GetMapping("/recipe/{id}/update")
	public String updateRecipe(Model model, @PathVariable String id) {
		RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));
		model.addAttribute("recipe", recipeCommand);
		return RECIPE_RECIPEFORM_URL;
	}

	@PostMapping("/recipe")
	public String saveOrUpdate(@Validated @ModelAttribute("recipe") RecipeCommand command, BindingResult result) {

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> {
				log.debug(error.toString());
				System.out.println("ERROR: " + error.toString());
			});
			return RECIPE_RECIPEFORM_URL;
		}else {
			System.out.println("No ERROR");
		}

		RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(command);
		return "redirect:/recipe/" + savedRecipeCommand.getId() + "/show";
	}

	@GetMapping("/recipe/{id}/delete")
	public String deleteRecipe(@PathVariable String id) {
		recipeService.deleleById(Long.valueOf(id));
		return "redirect:/";
	}

	@ResponseStatus(NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleNotFound(Exception exception) {
		log.debug("handling not found exception");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("exceptionType", "404 Not Found!!!");
		modelAndView.addObject("exception", exception.getMessage());
		return modelAndView;
	}

}
