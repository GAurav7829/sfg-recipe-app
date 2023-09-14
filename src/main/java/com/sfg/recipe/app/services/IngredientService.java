package com.sfg.recipe.app.services;

import com.sfg.recipe.app.commands.IngredientCommand;

public interface IngredientService {
	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
	IngredientCommand saveIngredientCommand(IngredientCommand command);
	void deleteById(Long recipeId, Long idToDelete);
}
