package com.lapots.breed.editor.fx.controls.canvas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LayerController {
    private static final Color DEFAULT_LAYER_COLOR = Color.WHITE;
    private Pane canvasPane;
    private GridLayerController gridLayerController;
    private List<Canvas> layers = new ArrayList<>();
    private ObservableList<String> layersList = FXCollections.observableArrayList();

    public LayerController(Pane pane) {
        canvasPane = pane;
        gridLayerController = new GridLayerController(pane);

        createLayer(Color.WHITE);
    }

    public void addEmptyLayer() {
        createLayer(null);
        gridLayerController.switchGrid(); // TODO: issue with no grid and blank
    }

    public void toFront(int index) {
        layers.get(index).toFront();
    }

    private Canvas createLayer(Color background) {
        Canvas layer;
        if (background != null) {
            layer = LayerUtils.createColoredLayer(canvasPane.getPrefWidth(), canvasPane.getPrefHeight(), background);
        } else {
            layer = LayerUtils.createBlankLayer(canvasPane.getPrefWidth(), canvasPane.getPrefHeight());
        }

        layersList.add("Layer " + (layersList.size() + 1));
        canvasPane.getChildren().add(layer);
        layers.add(layer);
        return layer;
    }

    public void checkGridAndSet() {
        gridLayerController.switchGrid();
    }
}
