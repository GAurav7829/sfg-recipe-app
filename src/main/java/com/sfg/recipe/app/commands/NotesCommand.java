package com.sfg.recipe.app.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
	private Long id;
    private String recipeNotes;
}
