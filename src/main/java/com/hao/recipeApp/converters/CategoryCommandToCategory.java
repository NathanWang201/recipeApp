package com.hao.recipeApp.converters;


import com.hao.recipeApp.commands.CategoryCommand;
import com.hao.recipeApp.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Override
    @Nullable
    public Category convert(CategoryCommand source) {
        if(source == null){
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
