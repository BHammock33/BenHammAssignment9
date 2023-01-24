package com.coderscampus.BenHammAssignment9.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.coderscampus.BenHammAssignment9.Domain.Recipe;

@Service
public class RecipeService {
	@Autowired
	FileService fileService = new FileService();
	
	private List<Recipe> recipes;
	
	public List<Recipe> getAllRecipes(){
		if(CollectionUtils.isEmpty(recipes)) {
			try {
				recipes = fileService.getRecipies("recipes.txt");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return recipes;
	}
	
	public List<Recipe> createGlutenList() throws IOException {
		return getAllRecipes().stream().distinct().filter(x -> x.getGlutenFree()).collect(Collectors.toList());

	}

	public List<Recipe> createVeggieList() throws IOException {
		return getAllRecipes().stream().filter(x -> x.getVegetarian())
				.collect(Collectors.toList());

	}

	public List<Recipe> createVeganList() throws IOException {
		return getAllRecipes().stream().distinct().filter(x -> x.getVegan())
				.collect(Collectors.toList());

	}

	public List<Recipe> createVeggieVeganList() throws IOException {
		return getAllRecipes().stream().filter(x -> x.getGlutenFree()).filter(y -> y.getVegan()).collect(Collectors.toList());
	}

	public List<Recipe> createAllList() throws IOException {
		return getAllRecipes();
	}

}
