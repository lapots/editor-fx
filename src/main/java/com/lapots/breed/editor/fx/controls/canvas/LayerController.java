package com.lapots.breed.editor.fx.controls.canvas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Data
public class LayerController {
    private static final Color BLANK = Color.rgb(0, 0, 0, 0);
    private Pane canvasPane;
    private Canvas gridLayer;
    private List<Canvas> layers = new ArrayList<>();
    private boolean showGrid;
    private ObservableList<String> layersList = FXCollections.observableArrayList();
    private int gridIndex = 1;

    public LayerController(Pane pane) {
        canvasPane = pane;
        addBackgroundLayer();
        addGridLayer();
    }

    public void toFront(int index) {
        layers.get(index).toFront();
    }

    public void addEmptyLayer() {
        Canvas initialLayer = (Canvas) canvasPane.getChildren().get(0);
        Canvas layer = LayerUtils.createBlankLayer(initialLayer.getWidth(), initialLayer.getHeight());
        layersList.add("Layer " + (layersList.size() + 1));
        canvasPane.getChildren().add(layer);

        layers.add(layer);
        showGridIfEnabled(); // TODO: doesn't work
    }

    private void addBackgroundLayer() {
        Canvas backgroundLayer =
                LayerUtils.createColoredLayer(canvasPane.getPrefWidth(), canvasPane.getPrefHeight(), Color.WHITE);
        layersList.add("Layer 1");
        canvasPane.getChildren().add(backgroundLayer);

        layers.add(backgroundLayer);
    }

    private void addGridLayer() {
        gridLayer =
                LayerUtils.createColoredLayer(canvasPane.getPrefWidth(), canvasPane.getPrefHeight(), BLANK);
        GraphicsContext gc = gridLayer.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);

        double averageHeight = LayerUtils.nearestDivision(gridLayer.getHeight(), 8);
        double heightItem = averageHeight / 8;
        IntStream.iterate(1, x -> x + 1)
                .limit(6)
                .forEach(x ->
                    gc.strokeLine(0, x * heightItem, gridLayer.getWidth(), x * heightItem)
                );
        canvasPane.getChildren().add(gridLayer);
    }

    private void showGridIfEnabled() {
        if (showGrid) {
            gridLayer.toFront();
        }
    }

    public void checkGridAndSet() {
        if (showGrid) {
            showGrid = false;
            gridLayer.toBack();
        } else {
            showGrid = true;
            gridLayer.toFront();
        }
    }
}
