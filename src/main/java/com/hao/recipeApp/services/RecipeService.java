package com.hao.recipeApp.services;

import com.hao.recipeApp.commands.RecipeCommand;
import com.hao.recipeApp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

    RecipeCommand findCommandById(Long id);

    void deleteById(Long id);
}
