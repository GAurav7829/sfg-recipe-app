package com.sfg.recipe.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sfg.recipe.app.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
