package com.lapots.breed.editor.fx.controls.canvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public abstract class AbstractCanvasWrapper {
    private Canvas canvas; // layer

    public AbstractCanvasWrapper(Pane pane) {
        init(pane);
        pane.getChildren().add(canvas);
    }

    protected void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    protected Canvas getCanvas() {
        return canvas;
    }

    public boolean isVisible() {
        return canvas.isVisible();
    }

    public void show() {
        canvas.setVisible(true);
        canvas.toFront();
    }

    public void hide() {
        canvas.setVisible(false);
    }

    protected abstract void init(Pane pane);
}
