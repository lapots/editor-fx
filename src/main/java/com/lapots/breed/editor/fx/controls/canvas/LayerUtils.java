package com.lapots.breed.editor.fx.controls.canvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class LayerUtils {

    public static Canvas createLayer(double width, double height, Paint color) {
        Canvas layer = new Canvas(width, height);
        GraphicsContext gc = layer.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, layer.getWidth(), layer.getHeight());
        layer.toFront();
        return layer;
    }
}
