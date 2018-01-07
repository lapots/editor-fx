package com.lapots.breed.editor.fx.controls.controller;

import com.lapots.breed.editor.fx.controls.canvas.LayerController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CanvasDrawingController implements Initializable {
    private LayerController layerController;

    @FXML
    private ComboBox<String> layersBox;

    @FXML
    private Pane canvasPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        layerController = new LayerController(canvasPane);
        layersBox.setItems(layerController.getLayersList());
        layersBox.getSelectionModel().selectedIndexProperty()
                .addListener((observable, oldValue, newValue) -> {
                    layerController.toFront(newValue.intValue());
                });
        layersBox.getSelectionModel().selectFirst();
        layerController.checkGridAndSet();
    }

    @FXML
    private void handleAddLayer(ActionEvent event) {
        layerController.addEmptyLayer();
        layersBox.getSelectionModel().selectLast();
    }

    @FXML
    private void handleGridEnableDisable(ActionEvent event) {
        layerController.checkGridAndSet();
    }
}
