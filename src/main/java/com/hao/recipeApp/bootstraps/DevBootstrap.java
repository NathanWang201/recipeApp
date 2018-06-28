package com.hao.recipeApp.bootstraps;

import com.hao.recipeApp.domain.*;
import com.hao.recipeApp.enums.Difficulty;
import com.hao.recipeApp.repositories.CategoryRepository;
import com.hao.recipeApp.repositories.RecipeRepository;
import com.hao.recipeApp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    CategoryRepository categoryRepository;
    RecipeRepository recipeRepository;
    UnitOfMeasureRepository unitOfMeasureRepository;

    public DevBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    public void initData(){
        List<Recipe> recipes = new ArrayList<>();

        Optional<UnitOfMeasure> teaspoonUOM = unitOfMeasureRepository.findByDescription("Teaspoon");
        Optional<UnitOfMeasure> tablespoonUOM = unitOfMeasureRepository.findByDescription("Tablespoon");
        Optional<UnitOfMeasure> cupUOM = unitOfMeasureRepository.findByDescription("Cup");
        Optional<UnitOfMeasure> pinchUOM = unitOfMeasureRepository.findByDescription("Pinch");
        Optional<UnitOfMeasure> ounceUOM = unitOfMeasureRepository.findByDescription("Ounce");
        Optional<UnitOfMeasure> poundUOM = unitOfMeasureRepository.findByDescription("Pound");
        Optional<UnitOfMeasure> inchUOM = unitOfMeasureRepository.findByDescription("Inch");

        Optional<Category> americanCategory = categoryRepository.findByDescription("American");
        Optional<Category> italianCategory = categoryRepository.findByDescription("Italian");
        Optional<Category> mexicanCategory = categoryRepository.findByDescription("Mexican");
        Optional<Category> chineseCategory = categoryRepository.findByDescription("Chinese");

        Recipe chickenTaco = new Recipe();
        chickenTaco.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        chickenTaco.setNotes(new Notes(chickenTaco,"Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)"));
        chickenTaco.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        chickenTaco.setPrepTime(20);
        chickenTaco.setCookTime(15);
        chickenTaco.setServings(4);
        chickenTaco.setSource("simplyrecipes");
        chickenTaco.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
//        chickenTaco.setImage(new byte[]());

        chickenTaco.getIngredients().add(new Ingredient("ancho chili powder", new BigDecimal(2), chickenTaco, tablespoonUOM.get()));
        chickenTaco.getIngredients().add(new Ingredient("dried oregano", new BigDecimal(1), chickenTaco, teaspoonUOM.get()));
        chickenTaco.getIngredients().add(new Ingredient("dried cumin", new BigDecimal(1), chickenTaco, teaspoonUOM.get()));
        chickenTaco.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), chickenTaco, teaspoonUOM.get()));
        chickenTaco.getIngredients().add(new Ingredient("salt", new BigDecimal(1/2), chickenTaco, teaspoonUOM.get()));
        chickenTaco.getIngredients().add(new Ingredient("clove garlic, finely chopped", new BigDecimal(1), chickenTaco, teaspoonUOM.get()));
        chickenTaco.getIngredients().add(new Ingredient("finely grated orange zest", new BigDecimal(1), chickenTaco, teaspoonUOM.get()));
        chickenTaco.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), chickenTaco, teaspoonUOM.get()));
        chickenTaco.getIngredients().add(new Ingredient("olive oil", new BigDecimal(2), chickenTaco, teaspoonUOM.get()));
        chickenTaco.getIngredients().add(new Ingredient("skinless, boneless chicken thighs", new BigDecimal(4), chickenTaco, teaspoonUOM.get()));

        chickenTaco.setDifficulty(Difficulty.EASY);
        chickenTaco.getCategories().add(americanCategory.get());
        recipes.add(chickenTaco);

        Recipe chickenSoup = new Recipe();
        chickenSoup.setDirections("1 Soak dried mushrooms: Soak the dried mushrooms in the hot water for 20 minutes. Use a bowl or a smaller pot to keep the mushrooms submerged in the water.\n" +
                "\n" +
                "2 Marinate chicken: While the mushrooms are soaking, mix the soy, sugar, salt and cornstarch in a large bowl. Make sure there are no cornstarch lumps. Add the chicken and ginger to the bowl, toss to coat with the marinade, and set aside.\n" +
                "\n" +
                "3 Slice mushrooms, add to chicken: When the mushrooms have softened, remove from the water (saving the soaking liquid) and slice thin. Add the mushrooms into the bowl with the chicken. If the soaking water has grit in it, pour the soaking water though a fine-meshed sieve lined with a paper towel into another bowl.\n" +
                "\n" +
                "4 Cook chicken, mushrooms with mushroom soaking water: Put the chicken mushroom mixture, and the mushroom soaking liquid into a pot and bring to a boil. Lower the heat to a bare simmer, cover the pot and cook gently for 25 minutes. Serve hot.");
        chickenSoup.setNotes(new Notes(chickenSoup,"Typically for this recipe one would use bone-in chicken thighs hacked into big pieces with a cleaver, or with poultry shears. The bones help create flavor and richness for the stock. You can use boneless chicken thighs if you prefer. Or use bone-in, and then remove the bones after the chicken has cooked, before serving."));
        chickenSoup.setDescription("A simple, light Chinese chicken soup with chicken thighs, shiitake mushrooms and ginger.");
        chickenSoup.setPrepTime(20);
        chickenSoup.setCookTime(25);
        chickenSoup.setServings(4);
        chickenSoup.setSource("simplyrecipes");
        chickenSoup.setUrl("https://www.simplyrecipes.com/recipes/chicken_soup_with_ginger_and_shiitake_mushrooms/");
//        chickenTaco.setImage(new byte[]());

        chickenSoup.getIngredients().add(new Ingredient("dried shiitake mushrooms (dried is much preferable to fresh in this recipe)", new BigDecimal(2), chickenSoup, ounceUOM.get()));
        chickenSoup.getIngredients().add(new Ingredient("boiling water", new BigDecimal(3), chickenSoup, cupUOM.get()));
        chickenSoup.getIngredients().add(new Ingredient("chicken thighs, preferably bone-in, cut into chunks", new BigDecimal(1), chickenSoup, poundUOM.get()));
        chickenSoup.getIngredients().add(new Ingredient("fresh ginger, peeled and sliced very thin", new BigDecimal(1), chickenSoup, inchUOM.get()));
        chickenSoup.getIngredients().add(new Ingredient("soy sauce (use gluten-free soy sauce for gluten-free version)", new BigDecimal(2), chickenSoup, tablespoonUOM.get()));
        chickenSoup.getIngredients().add(new Ingredient("sugar", new BigDecimal(2), chickenSoup, teaspoonUOM.get()));
        chickenSoup.getIngredients().add(new Ingredient("salt", new BigDecimal(1), chickenSoup, pinchUOM.get()));
        chickenSoup.getIngredients().add(new Ingredient("cornstarch", new BigDecimal(1), chickenSoup, teaspoonUOM.get()));

        chickenSoup.setDifficulty(Difficulty.EASY);
        chickenSoup.getCategories().add(chineseCategory.get());
        recipes.add(chickenSoup);

        recipeRepository.saveAll(recipes);
    }
}
