package com.sfg.recipe.app.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.sfg.recipe.app.model.Recipe;
import com.sfg.recipe.app.services.RecipeServiceImpl;

public class IndexControllerTest {

	@Mock
	RecipeServiceImpl recipeService;
	@Mock
	Model model;
	IndexController indexController;

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);
	}
	
	@Test
	public void testMockMvc() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void getIndexPage() throws Exception {
		// given
		Set<Recipe> recipes = new HashSet<>();
		Recipe recipe1 = new Recipe();
		recipe1.setId(1L);
		recipes.add(recipe1);
		Recipe recipe2 = new Recipe();
		recipe2.setId(2L);
		recipes.add(recipe2);

		when(recipeService.getRecipies()).thenReturn(recipes);

		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		// when
		String viewName = indexController.getIndexPage(model);

		// then
		assertEquals("index", viewName);
		verify(recipeService, times(1)).getRecipies();
//		verify(model, times(1)).addAttribute(eq("recipies"), anySet());
		verify(model, times(1)).addAttribute(eq("recipies"), argumentCaptor.capture());
		Set setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}
}
