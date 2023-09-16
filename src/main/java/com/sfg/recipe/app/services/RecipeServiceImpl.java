package com.sfg.recipe.app.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sfg.recipe.app.commands.RecipeCommand;
import com.sfg.recipe.app.converters.RecipeCommandToRecipe;
import com.sfg.recipe.app.converters.RecipeToRecipeCommand;
import com.sfg.recipe.app.exceptions.NotFoundException;
import com.sfg.recipe.app.model.Recipe;
import com.sfg.recipe.app.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	private final RecipeCommandToRecipe recipeCommandToRecipe;
	private final RecipeToRecipeCommand recipeToRecipeCommand;

	public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
			RecipeToRecipeCommand recipeToRecipeCommand) {
		super();
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	@Override
	public Set<Recipe> getRecipies() {
		log.debug("In recipe service impl getRecipies method.");
		Set<Recipe> recipes = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}

	@Override
	public Recipe findById(Long id) {
		Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
		if (!optionalRecipe.isPresent())
			throw new NotFoundException("Recipe not found. For id: "+id);
		return optionalRecipe.get();
	}

	@Transactional
	@Override
	public RecipeCommand saveRecipeCommand(RecipeCommand command) {
		Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
		Recipe savedRecipe = recipeRepository.save(detachedRecipe);
		log.debug("saved Recipe: "+savedRecipe.getId());
		return recipeToRecipeCommand.convert(savedRecipe);
	}

	@Transactional
	@Override
	public RecipeCommand findCommandById(Long id) {
		Recipe recipe = recipeRepository.findById(id).orElse(null);
		RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);
		return recipeCommand;
	}

	@Override
	public void deleleById(Long id) {
		recipeRepository.deleteById(id);
	}
	
}
