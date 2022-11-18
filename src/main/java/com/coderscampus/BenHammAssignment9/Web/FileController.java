package com.coderscampus.BenHammAssignment9.Web;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.BenHammAssignment9.Domain.Recipe;
import com.coderscampus.BenHammAssignment9.Service.FileService;

@RestController
public class FileController {

	@GetMapping("/gluten-free")

	public List<Recipe> FileService() throws IOException {
		FileService fileService = new FileService();
		List<Recipe> recipes = fileService.createGlutenList();
		return recipes;

	}

	@GetMapping("/vegan")
	public List<Recipe> Vegan() throws IOException {
		FileService fileService = new FileService();
		List<Recipe> vegan = fileService.createVeganList();
		return vegan;
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganAndGlutenFree() throws IOException {
		FileService fileService = new FileService();
		List<Recipe> vAndGFree = fileService.createVeggieVeganList();
		return vAndGFree;
	}

	@GetMapping("/vegetarian")
	public List<Recipe> vegetarian() throws IOException {
		FileService fileService = new FileService();
		List<Recipe> vegetarian = fileService.createVeggieList();
		return vegetarian;
	}

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() throws IOException {
		FileService fileService = new FileService();
		List<Recipe> recipiesList = fileService.createAllList();
		return recipiesList;
	}

}
