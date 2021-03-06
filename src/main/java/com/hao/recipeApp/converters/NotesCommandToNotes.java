package com.hao.recipeApp.converters;

import com.hao.recipeApp.commands.NotesCommand;
import com.hao.recipeApp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Override
    @Nullable
    public Notes convert(NotesCommand source) {
        if(source == null){
            return null;
        }

        Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
