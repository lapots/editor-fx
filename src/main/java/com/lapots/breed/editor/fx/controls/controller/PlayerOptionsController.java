package com.lapots.breed.editor.fx.controls.controller;

import com.lapots.breed.editor.domain.PlayerCharacter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static com.lapots.breed.editor.fx.controls.UiConstants.DEFAULT_CHAR_HEIGHT_CM;
import static com.lapots.breed.editor.fx.controls.UiConstants.DEFAULT_CHAR_NAME;
import static com.lapots.breed.editor.util.StringUtils.defaultIfBlank;

public class PlayerOptionsController {

    @FXML
    private TextField character_name;

    @FXML
    private TextField character_height;

    public PlayerCharacter createCharacter() {
        PlayerCharacter character = new PlayerCharacter();
        character.setName(defaultIfBlank(character_name.getText(), DEFAULT_CHAR_NAME));
        character.setHeight(defaultIfBlank(character_height.getText(), DEFAULT_CHAR_HEIGHT_CM));
        return character;
    }
}
