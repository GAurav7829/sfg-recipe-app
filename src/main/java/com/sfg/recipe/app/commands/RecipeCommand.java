package com.sfg.recipe.app.commands;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import com.sfg.recipe.app.model.Difficulty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
	private Long id;

	@NotBlank
	@Size(min = 3, max = 255)
	private String description;

	@Min(1)
	@Max(999)
	private Integer prepTime;

	@Min(1)
	@Max(999)
	private Integer cookTime;

	@Min(1)
	@Max(100)
	private Integer servings;
	private String source;

	@URL
	private String url;

	@NotBlank
	private String directions;

	private Byte[] image;
	private Set<IngredientCommand> ingredients = new HashSet<>();
	private Difficulty difficulty;
	private NotesCommand notes;
	private Set<CategoryCommand> categories = new HashSet<>();
}
