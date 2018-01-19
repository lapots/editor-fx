package com.lapots.breed.editor.fx.controls.controller;

import com.lapots.breed.editor.domain.PlayerCharacter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.lapots.breed.editor.fx.controls.UiConstants.DEFAULT_CHAR_HEIGHT_CM;
import static com.lapots.breed.editor.fx.controls.UiConstants.DEFAULT_CHAR_NAME;
import static com.lapots.breed.editor.util.StringUtils.defaultIfBlank;

public class PlayerOptionsController implements Initializable{

    @FXML
    private TextField character_name;

    @FXML
    private Slider heightSlider;

    @FXML
    private Label heightLabel;

    public PlayerCharacter createCharacter() {
        PlayerCharacter character = new PlayerCharacter();
        character.setName(defaultIfBlank(character_name.getText(), DEFAULT_CHAR_NAME));
        // FIXME: I assume heightSlider won't return null
        character.setHeight(defaultIfBlank(String.valueOf(heightSlider.getValue()), DEFAULT_CHAR_HEIGHT_CM));
        return character;
    }

    // TODO: refactor for proper layer controller support
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        heightSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            // TODO: find something better
            heightLabel.setText(Integer.valueOf(newValue.toString().split("\\.", 2)[0]).toString());
        });
    }
}
