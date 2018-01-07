package com.lapots.breed.editor.fx.controls.canvas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class LayerController {
    private List<Canvas> layers = new ArrayList<>();
    private ObservableList<String> layersList = FXCollections.observableArrayList();

    public LayerController(Canvas initial) {
        layers.add(initial);
        layersList.add("Layer 1"); // initial
    }

    public void fillLayer(int index, Color color) {
        Canvas layer = layers.get(index);
        GraphicsContext gc = layer.getGraphicsContext2D();

        gc.setFill(color);
        gc.fillRect(0, 0, layer.getWidth(), layer.getHeight());
    }

    // investigate refactoring with component as a core
    public void bindComboBox(ComboBox<String> layersBox) {
        layersBox.setItems(layersList);
    }

    public void layerToFront(int index) {
        layers.get(index).toFront();
        System.out.println("Current layer: " + (index + 1));
    }

    public void addSameLayer(int sameIndex) {
        Canvas same = layers.get(sameIndex);
        Canvas layer = new Canvas(same.getWidth(), same.getHeight());

        layers.add(layer);
        layersList.add("Layer " + layers.size());
    }

    public GraphicsContext getLayerDrawingContext(int index) {
        return layers.get(index).getGraphicsContext2D();
    }
}
