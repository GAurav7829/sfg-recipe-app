package com.sfg.recipe.app.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.sfg.recipe.app.commands.UnitOfMeasureCommand;
import com.sfg.recipe.app.model.UnitOfMeasure;

import lombok.Synchronized;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasureCommand convert(UnitOfMeasure source) {
		if(null==source)
			return null;
		final UnitOfMeasureCommand unitOfMeasure = new UnitOfMeasureCommand();
		unitOfMeasure.setId(source.getId());
		unitOfMeasure.setDescription(source.getDescription());
		return unitOfMeasure;
	}
	
}
