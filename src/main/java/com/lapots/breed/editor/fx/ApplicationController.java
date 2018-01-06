package com.lapots.breed.editor.fx;

import com.lapots.breed.editor.domain.PlayerCharacter;
import com.lapots.breed.editor.fx.controls.controller.CanvasDrawingController;
import com.lapots.breed.editor.fx.controls.controller.PlayerOptionsController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ApplicationController {

    @FXML
    private CanvasDrawingController canvasController;
    @FXML
    private PlayerOptionsController playerOptionsController;

    @FXML
    private void handleCharacterCreation(ActionEvent event) {
        PlayerCharacter character = playerOptionsController.createCharacter();
        System.out.println("Character was created: " + character);
    }

}
