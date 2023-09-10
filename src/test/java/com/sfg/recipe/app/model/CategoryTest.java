package com.sfg.recipe.app.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {
	
	Category category;
	
	@Before
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void getId() throws Exception {
		Long id = 4L;
		category.setId(id);
		assertEquals(id, category.getId());
	}

}
