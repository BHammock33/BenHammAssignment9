package com.coderscampus.BenHammAssignment9.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVFormat.Builder;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.coderscampus.BenHammAssignment9.Domain.Recipe;

@Component
public class FileService {


//	@Autowired
	//private Recipe recipe;
	
	List<Recipe> recipiesList = new ArrayList<>();

	public List<Recipe> getRecipies(String fileName) throws IOException {
		
		Reader in = new FileReader(fileName);
		Builder builder = CSVFormat.DEFAULT.builder().setEscape('\\').setIgnoreSurroundingSpaces(true)
				.setHeader(Headers.class);
		
		
		List<CSVRecord> records = builder.build().parse(in).getRecords();
		for (CSVRecord record : records) {
			//ApplicationContext context = new AnnotationConfigApplicationContext(BHA9Config.class);
			//Recipe recipe =context.getBean(Recipe.class);
			Recipe recipe = new Recipe();
			if (record.getRecordNumber() != 1) {
				//Recipe recipe = applicationContext.getBean(Recipe.class);
				Integer cookingMinutes = Integer.parseInt(record.get(Headers.CookingMinutes));
				Boolean dairyFree = Boolean.valueOf(record.get(Headers.DairyFree));
				Boolean glutenFree = Boolean.valueOf(record.get(Headers.GlutenFree));
				String instructions = record.get(Headers.Instructions);
				Double preparationMinutes = Double.valueOf(record.get(Headers.PreparationMinutes));
				Double pricePerserving = Double.valueOf(record.get(Headers.PricePerServing));
				Integer readyInMinutes = Integer.parseInt(record.get(Headers.ReadyInMinutes));
				Integer servings = Integer.parseInt(record.get(Headers.Servings));
				Double spoonacularScore = Double.valueOf(record.get(Headers.SpoonacularScore));
				String title = record.get(Headers.Title);
				Boolean vegan = Boolean.valueOf(record.get(Headers.Vegan));
				Boolean vegetarian = Boolean.valueOf(record.get(Headers.Vegan));

				recipe.setCookingMinutes(cookingMinutes);
				recipe.setDairyFree(dairyFree);
				recipe.setGlutenFree(glutenFree);
				recipe.setInstructions(instructions);
				recipe.setPreperationMinutes(preparationMinutes);
				recipe.setPricePerServing(pricePerserving);
				recipe.setReadyInMinutes(readyInMinutes);
				recipe.setServings(servings);
				recipe.setSpoonacularScore(spoonacularScore);
				recipe.setTitle(title);
				recipe.setVegan(vegan);
				recipe.setVegetarian(vegetarian);

				recipiesList.add(recipe);

			}

		}

		return recipiesList;

	}

	enum Headers {
		CookingMinutes, DairyFree, GlutenFree, Instructions, PreparationMinutes, PricePerServing, ReadyInMinutes,
		Servings, SpoonacularScore, Title, Vegan, Vegetarian
	}
}
