package com.sfg.recipe.app.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sfg.recipe.app.commands.RecipeCommand;
import com.sfg.recipe.app.model.Recipe;

@Service
public interface RecipeService {
	Set<Recipe> getRecipies();
	Recipe findById(Long id);
	RecipeCommand saveRecipeCommand(RecipeCommand command);
	RecipeCommand findCommandById(Long id);
	void deleleById(Long id);
}
