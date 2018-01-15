package com.lapots.breed.editor.fx.controls.canvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

public class GridLayerController {
    private static final Color GRID_COLOR = Color.BLUE;
    private static final int NUMBER_OF_LINES = 8;
    private static final int LINE_WIDTH = 1;
    private Canvas gridLayer;
    private boolean showGrid;

    public GridLayerController(Pane pane) {
        init(pane);
    }

    @PostConstruct
    private void init(Pane pane) {
        gridLayer =
                LayerUtils.createColoredLayer(pane.getPrefWidth(), pane.getPrefHeight(), LayerUtils.blankColor());
        GraphicsContext gc = gridLayer.getGraphicsContext2D();
        gc.setStroke(GRID_COLOR);
        gc.setLineWidth(LINE_WIDTH);

        double averageHeight = LayerUtils.nearestDivision(gridLayer.getHeight(), NUMBER_OF_LINES);
        double heightItem = averageHeight / NUMBER_OF_LINES;
        IntStream.iterate(1, x -> x + 1)
                .limit(NUMBER_OF_LINES - 2)
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
