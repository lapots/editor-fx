package com.lapots.breed.editor.fx;

import com.lapots.breed.editor.domain.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ApplicationController {
    @FXML
    private TextField character_name;

    @FXML
    private void handleCharacterCreation(ActionEvent event) {
        PlayerCharacter character = createCharacter();
    }

    private PlayerCharacter createCharacter() {
        PlayerCharacter character = new PlayerCharacter();
        character.setName(blankIfNull(character_name.getText()));
        return character;
    }

    private String blankIfNull(String field) {
        return field == null? "" : field;
    }
}
