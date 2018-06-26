package com.hao.recipeApp;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeAppApplication {

	public static void main(String[] args) {
		System.out.println("Main function");
		SpringApplication.run(RecipeAppApplication.class, args);
	}
}
