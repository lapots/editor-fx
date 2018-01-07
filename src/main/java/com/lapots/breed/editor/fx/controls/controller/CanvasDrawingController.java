package com.lapots.breed.editor.fx.controls.controller;

import com.lapots.breed.editor.fx.controls.canvas.LayerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class CanvasDrawingController implements Initializable {

    @FXML
    private PlayerOptionsController controller;

    @FXML
    private Canvas character_canvas;

    @FXML
    private ComboBox<String> layersBox;
    private LayerController layerController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        layerController = new LayerController(character_canvas);
        layerController.fillLayer(0, Color.WHITE);
        layerController.bindComboBox(layersBox);

        layersBox.getSelectionModel().selectLast();
        layersBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            layerController.layerToFront(newValue.intValue());
        });
    }

    @FXML
    private void handleAddLayer(ActionEvent event) {
        layerController.addSameLayer(0);
        layersBox.getSelectionModel().selectLast();
    }
}
