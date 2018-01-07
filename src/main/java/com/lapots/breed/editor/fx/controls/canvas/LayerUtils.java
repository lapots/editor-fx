package com.lapots.breed.editor.fx.controls.canvas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class LayerUtils {

    public static Canvas createColoredLayer(double width, double height, Paint color) {
        Canvas layer = new Canvas(width, height);
        GraphicsContext gc = layer.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, layer.getWidth(), layer.getHeight());
        layer.toFront();
        return layer;
    }

    public static Canvas createBlankLayer(double width, double height) {
        Canvas layer = new Canvas(width, height);
        GraphicsContext gc = layer.getGraphicsContext2D();
        gc.fillRect(0, 0, layer.getWidth(), layer.getHeight());
        layer.toFront();
        return layer;
    }

    public static double nearestDivision(double value, int divider) {
        while (value % divider != 0) {
            value--;
        }
        return value;
    }
}
