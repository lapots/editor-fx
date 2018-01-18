package com.lapots.breed.editor.fx.controls.canvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

import static com.lapots.breed.editor.fx.controls.UiConstants.*;

public class GridLayerController {
    private Canvas gridLayer;
    private boolean showGrid;

    public GridLayerController(Pane pane) {
        init(pane);
    }

    @PostConstruct
    private void init(Pane pane) {
        gridLayer =
                LayerUtils.createColoredLayer(pane.getPrefWidth(), pane.getPrefHeight(), BLANK_COLOR);
        GraphicsContext gc = gridLayer.getGraphicsContext2D();
        gc.setStroke(DEFAULT_GRID_COLOR);
        gc.setLineWidth(GRID_LINE_WIDTH);

        double averageHeight = LayerUtils.nearestDivision(gridLayer.getHeight(), GRID_LINES_NUMBER);
        double heightItem = averageHeight / GRID_LINES_NUMBER;
        IntStream.iterate(1, x -> x + 1)
                .limit(GRID_LINES_NUMBER - 2)
                .forEach(x ->
                        gc.strokeLine(0, x * heightItem, gridLayer.getWidth(), x * heightItem)
                );
        pane.getChildren().add(gridLayer); // no more use for Pane
    }

    public void showGrid() {
        gridLayer.toFront();
    }

    public void switchGrid() {
        if (showGrid) {
            showGrid = false;
            gridLayer.toBack();;
        } else {
            showGrid = true;
            gridLayer.toFront();
        }
    }
}
