package com.sfg.recipe.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.recipe.app.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
