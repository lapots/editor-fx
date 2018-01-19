package com.lapots.breed.editor.fx.controls.canvas.layer;

import com.lapots.breed.editor.fx.controls.canvas.AbstractCanvasWrapper;
import com.lapots.breed.editor.fx.controls.canvas.LayerUtils;
import com.lapots.breed.editor.fx.controls.canvas.MathUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import static com.lapots.breed.editor.fx.controls.UiConstants.*;

public class CharacterLayer extends AbstractCanvasWrapper {
    public CharacterLayer(Pane pane) {
        super(pane);
    }

    @Override
    protected void init(Pane pane) {
        Canvas layer = LayerUtils.createLayer(pane.getPrefWidth(), pane.getPrefHeight(), BLANK_COLOR);

        GraphicsContext gc = layer.getGraphicsContext2D();
        gc.setStroke(CHARACTER_LINE_COLOR);
        gc.setLineWidth(CHARACTER_LINE_WIDTH);

        double middle = layer.getWidth() / 2;
        double averageHeight = MathUtils.nearestDivision(layer.getHeight(), GRID_LINES_NUMBER);
        gc.strokeOval(middle - 12.5, averageHeight / GRID_LINES_NUMBER,
                25, averageHeight / GRID_LINES_NUMBER);

        setCanvas(layer);
    }
}
