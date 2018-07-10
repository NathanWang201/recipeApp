package com.hao.recipeApp.converters;

import com.hao.recipeApp.commands.NotesCommand;
import com.hao.recipeApp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    @Override
    @Nullable
    public NotesCommand convert(Notes source) {
        if(source == null){
            return null;
        }

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}
