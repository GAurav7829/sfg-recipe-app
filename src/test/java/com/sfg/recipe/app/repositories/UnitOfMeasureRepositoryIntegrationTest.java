package com.sfg.recipe.app.repositories;


import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sfg.recipe.app.model.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIntegrationTest {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void findByDescription() {
		Optional<UnitOfMeasure> findByDescription = unitOfMeasureRepository.findByDescription("Teaspoon");
		assertEquals("Teaspoon", findByDescription.get());
	}
	
}
