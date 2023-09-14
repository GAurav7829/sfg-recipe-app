package com.sfg.recipe.app.services;

import java.util.Set;

import com.sfg.recipe.app.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {
	Set<UnitOfMeasureCommand> listAllUoms();
}
