package com.hao.recipeApp.services;

import com.hao.recipeApp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
