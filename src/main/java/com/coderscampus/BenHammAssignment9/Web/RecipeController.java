package com.coderscampus.BenHammAssignment9.Web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.BenHammAssignment9.Domain.Recipe;
import com.coderscampus.BenHammAssignment9.Service.RecipeService;

@RestController
public class RecipeController {
	
	@Autowired
	RecipeService recipeService = new RecipeService();

	@GetMapping("/gluten-free")
	public List<Recipe> FileService() throws IOException {
		//List<Recipe> recipes = recipeService.createGlutenList();
		return recipeService.createGlutenList();

	}

	@GetMapping("/vegan")
	public List<Recipe> Vegan() throws IOException {
		//List<Recipe> vegan = recipeService.createVeganList();
		return recipeService.createVeganList();
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGlutenFree() throws IOException {
		//List<Recipe> vAndGFree = recipeService.createVeggieVeganList();
		return recipeService.createVeggieVeganList();
	}

	@GetMapping("/vegetarian")
	public List<Recipe> vegetarian() throws IOException {
		//List<Recipe> vegetarian = recipeService.createVeggieList();
		return recipeService.createVeggieList();
	}

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() throws IOException {
		//List<Recipe> recipiesList = recipeService.createAllList();
		return recipeService.getAllRecipes();
	}

}
