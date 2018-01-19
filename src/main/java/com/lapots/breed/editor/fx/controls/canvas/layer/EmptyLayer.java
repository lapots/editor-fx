package com.lapots.breed.editor.fx.controls.canvas.layer;

import com.lapots.breed.editor.fx.controls.canvas.AbstractCanvasWrapper;
import com.lapots.breed.editor.fx.controls.canvas.LayerUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

import static com.lapots.breed.editor.fx.controls.UiConstants.DEFAULT_LAYER_COLOR;

public class EmptyLayer extends AbstractCanvasWrapper {

    public EmptyLayer(Pane pane) {
        super(pane);
    }

    @Override
    protected void init(Pane pane) {
        Canvas layer = LayerUtils.createLayer(pane.getPrefWidth(), pane.getPrefHeight(), DEFAULT_LAYER_COLOR);
        setCanvas(layer);
    }
}
