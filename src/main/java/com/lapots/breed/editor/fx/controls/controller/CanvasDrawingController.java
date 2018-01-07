package com.lapots.breed.editor.fx.controls.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CanvasDrawingController implements Initializable {

    @FXML
    private PlayerOptionsController controller;

    @FXML
    private Canvas character_canvas;

    @FXML
    private ComboBox<String> layersBox;

    private List<Canvas> layers = new ArrayList<>();
    private ObservableList<String> layersList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = character_canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, character_canvas.getWidth(), character_canvas.getHeight());
        layers.add(character_canvas);

        layersList.add("layer " + layers.size());
        layersBox.setItems(layersList);
        layersBox.getSelectionModel().selectLast();
        layersBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            layers.get(newValue.intValue()).toFront();
            System.out.println("Current layer: " + (newValue.intValue() + 1));
        });
    }

    @FXML
    private void handleAddLayer(ActionEvent event) {
        addLayer();
        layersBox.getSelectionModel().selectLast();
    }

    public int addLayer() {
        Canvas layer = new Canvas(character_canvas.getWidth(), character_canvas.getHeight());
        layers.add(layer);
        layersList.add("layer " + layers.size());
        return layers.size();
    }

    public GraphicsContext getLayer(int layer) {
        if (layer < 0 || layer > layers.size()) {
            return null;
        }
        return layers.get(layer).getGraphicsContext2D();
    }
}
