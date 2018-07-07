package com.hao.recipeApp.services;

import com.hao.recipeApp.domain.Recipe;
import com.hao.recipeApp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        //create mock recipe
        Recipe recipe = new Recipe();
        Set<Recipe> testRecipes = new HashSet<>();
        testRecipes.add(recipe);

        //return the mock recipe set when calling getRecipes()
        when(recipeService.getRecipes()).thenReturn(testRecipes);
        Set<Recipe> recipes = recipeService.getRecipes();
        //the recipe set should have only 1 recipe
        assertEquals(recipes.size(), 1);
        //findAll method of the repository should only be called once
        verify(recipeRepository, times(1)).findAll();
    }
}