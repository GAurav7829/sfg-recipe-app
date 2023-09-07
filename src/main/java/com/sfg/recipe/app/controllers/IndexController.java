package com.sfg.recipe.app.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sfg.recipe.app.model.Category;
import com.sfg.recipe.app.model.UnitOfMeasure;
import com.sfg.recipe.app.repositories.CategoryRepository;
import com.sfg.recipe.app.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		Optional<Category> american = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");

		System.out.println(american.get().getId() + " : " + american.get().getDescription());
		System.out.println(cup.get().getId() + " : " + cup.get().getDescription());

		return "index";
	}

}
