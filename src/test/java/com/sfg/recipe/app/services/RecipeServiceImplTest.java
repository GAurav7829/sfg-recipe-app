package com.sfg.recipe.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sfg.recipe.app.model.Recipe;
import com.sfg.recipe.app.repositories.RecipeRepository;

public class RecipeServiceImplTest {
	
	RecipeServiceImpl recipeService;
	@Mock
	RecipeRepository recipeRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);
	}
	
	@Test
	public void getRecipies() throws Exception {
		Recipe recipe = new Recipe();
		Set<Recipe> recipeData = new HashSet<>();
		recipeData.add(recipe);
		
		when(recipeRepository.findAll()).thenReturn(recipeData);
		
		Set<Recipe> recipes = recipeService.getRecipies();
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}

}
