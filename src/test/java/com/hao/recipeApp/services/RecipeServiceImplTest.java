package com.hao.recipeApp.services;

import com.hao.recipeApp.converters.RecipeCommandToRecipe;
import com.hao.recipeApp.converters.RecipeToRecipeCommand;
import com.hao.recipeApp.domain.Recipe;
import com.hao.recipeApp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeCommandToRecipe recipeToCommandConverter;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommandConverter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeToCommandConverter, recipeToRecipeCommandConverter);
    }

    @Test
    public void getRecipeByIdTest() {
        //create mock recipe
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        //return the mock recipe set when calling getRecipes()
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.findById(1L);
        //the recipe set should have only 1 recipe
        assertEquals(1, recipeReturned.getId().intValue());
        //findAll method of the repository should only be called once
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void getRecipesTest() {
        //given
        Recipe recipe = new Recipe();
        Set<Recipe> testRecipes = new HashSet<>();
        testRecipes.add(recipe);

        //when
        when(recipeService.getRecipes()).thenReturn(testRecipes);
        Set<Recipe> recipes = recipeService.getRecipes();

        //then
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }

    @Test
    public void testDeleteById(){
        //given
        Long deteleId = Long.valueOf(2L);

        //when
        recipeService.deleteById(deteleId);

        //then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}