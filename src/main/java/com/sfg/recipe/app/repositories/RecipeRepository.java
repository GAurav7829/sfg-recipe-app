package com.sfg.recipe.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sfg.recipe.app.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
