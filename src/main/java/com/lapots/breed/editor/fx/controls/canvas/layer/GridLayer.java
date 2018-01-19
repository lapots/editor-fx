package com.lapots.breed.editor.fx.controls.canvas.layer;

import com.lapots.breed.editor.fx.controls.canvas.AbstractCanvasWrapper;
import com.lapots.breed.editor.fx.controls.canvas.LayerUtils;
import com.lapots.breed.editor.fx.controls.canvas.MathUtils;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.stream.IntStream;

import static com.lapots.breed.editor.fx.controls.UiConstants.*;

public class GridLayer extends AbstractCanvasWrapper {
    public GridLayer(Pane pane) {
        super(pane);
    }

    @Override
    protected void init(Pane pane) {
        Canvas layer = LayerUtils.createLayer(pane.getPrefWidth(), pane.getPrefHeight(), BLANK_COLOR);
        GraphicsContext gc = layer.getGraphicsContext2D();
        gc.setStroke(DEFAULT_GRID_COLOR);
        gc.setLineWidth(GRID_LINE_WIDTH);

        // horizontal lines
        double averageHeight = MathUtils.nearestDivision(layer.getHeight(), GRID_LINES_NUMBER);
        double heightItem = averageHeight / GRID_LINES_NUMBER;
        IntStream.iterate(1, x -> x + 1)
                .limit(GRID_LINES_NUMBER - 1)
                .forEach(x ->
                    gc.strokeLine(0, x * heightItem, layer.getWidth(), x * heightItem)
                );

        // middle dashed line
        double middle = layer.getWidth() / 2;
        gc.setLineDashes(MIDDLE_DASH_NUMBER);
        gc.strokeLine(middle, MIDDLE_DASH_LINE_OFFSET,
                middle, layer.getHeight() - MIDDLE_DASH_LINE_OFFSET );

        // draw text labels
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFill(Color.RED);
        gc.fillText(String.valueOf(MAX_HEIGHT), DEFAULT_MARGIN, heightItem - DEFAULT_MARGIN);

        gc.setTextAlign(TextAlignment.LEFT);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFill(Color.RED);
        gc.fillText("0", 0, pane.getPrefHeight() - heightItem - DEFAULT_MARGIN);

        setCanvas(layer);
    }
}
