package com.sfg.recipe.app.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sfg.recipe.app.model.Recipe;

@Service
public interface RecipeService {
	public Set<Recipe> getRecipies();
}
