package com.hao.recipeApp.services;

import com.hao.recipeApp.commands.RecipeCommand;
import com.hao.recipeApp.converters.RecipeCommandToRecipe;
import com.hao.recipeApp.converters.RecipeToRecipeCommand;
import com.hao.recipeApp.domain.Recipe;
import com.hao.recipeApp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    private RecipeCommandToRecipe recipeToCommandConverter;
    private RecipeToRecipeCommand recipeToRecipeCommandConverter;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeToCommandConverter, RecipeToRecipeCommand recipeToRecipeCommandConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeToCommandConverter = recipeToCommandConverter;
        this.recipeToRecipeCommandConverter = recipeToRecipeCommandConverter;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("RecipeServiceImpl:");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id){
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe not found!");
        }

        return recipeOptional.get();
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe recipe = recipeToCommandConverter.convert(recipeCommand);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeToRecipeCommandConverter.convert(savedRecipe);
    }
}
    