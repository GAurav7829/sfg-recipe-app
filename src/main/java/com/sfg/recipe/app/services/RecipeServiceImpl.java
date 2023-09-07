package com.sfg.recipe.app.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sfg.recipe.app.model.Recipe;
import com.sfg.recipe.app.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipies() {
		Set<Recipe> recipes = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
		return recipes;
	}
}
