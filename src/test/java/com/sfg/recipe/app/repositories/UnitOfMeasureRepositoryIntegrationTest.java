package com.sfg.recipe.app.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sfg.recipe.app.model.UnitOfMeasure;

@DataJpaTest
public class UnitOfMeasureRepositoryIntegrationTest {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	public void findByDescription() {
		Optional<UnitOfMeasure> findByDescription = unitOfMeasureRepository.findByDescription("Teaspoon");
		assertEquals("Teaspoon", findByDescription.get().getDescription());
	}
	
}
