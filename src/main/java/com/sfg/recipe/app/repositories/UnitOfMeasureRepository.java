package com.sfg.recipe.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sfg.recipe.app.model.UnitOfMeasure;

@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	
	Optional<UnitOfMeasure> findByDescription(String description);
	
}
