package com.lapots.breed.editor.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class ApplicationController {

    @FXML
    private void handleClickMe(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Button clicked");
        alert.setContentText("You clicked the button!");
        alert.setHeaderText("");
        alert.showAndWait();
    }
}
