package com.sfg.recipe.app.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sfg.recipe.app.model.Recipe;
import com.sfg.recipe.app.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
	
	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
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
		if(!optionalRecipe.isPresent())
			throw new RuntimeException("Recipe not found");
		return optionalRecipe.get();
	}
	
	
}
