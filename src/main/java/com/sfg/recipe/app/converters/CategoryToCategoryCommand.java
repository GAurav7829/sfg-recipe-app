package com.sfg.recipe.app.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.sfg.recipe.app.commands.CategoryCommand;
import com.sfg.recipe.app.model.Category;

import lombok.Synchronized;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

	@Synchronized
	@Nullable
	@Override
	public CategoryCommand convert(Category source) {
		if(null == source)
			return null;
		final CategoryCommand category = new CategoryCommand();
		category.setId(source.getId());
		category.setDescription(source.getDescription());
		return category;
	}

}
