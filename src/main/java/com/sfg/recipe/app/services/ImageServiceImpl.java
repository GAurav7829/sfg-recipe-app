package com.sfg.recipe.app.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sfg.recipe.app.model.Recipe;
import com.sfg.recipe.app.repositories.RecipeRepository;

@Service
public class ImageServiceImpl implements ImageService {

	private final RecipeRepository recipeRepository;

    public ImageServiceImpl( RecipeRepository recipeService) {
        this.recipeRepository = recipeService;
    }
    
	@Override
	public void saveImageFile(Long recipeId, MultipartFile file) {
		try {
			Recipe recipe = recipeRepository.findById(recipeId).get();
			Byte[] byteObjects = new Byte[file.getBytes().length];
			
			int i=0;
			for(byte b:file.getBytes()) {
				byteObjects[i++] = b;
			}
			recipe.setImage(byteObjects);
			recipeRepository.save(recipe);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
