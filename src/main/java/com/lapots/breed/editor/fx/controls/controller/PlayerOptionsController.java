package com.lapots.breed.editor.fx.controls.controller;

import com.lapots.breed.editor.domain.PlayerCharacter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PlayerOptionsController {
    @FXML
    private TextField character_name;

    public PlayerCharacter createCharacter() {
        PlayerCharacter character = new PlayerCharacter();
        character.setName(blankIfNull(character_name.getText()));
        return character;
    }

    private String blankIfNull(String field) {
        return field == null? "" : field;
    }
}
