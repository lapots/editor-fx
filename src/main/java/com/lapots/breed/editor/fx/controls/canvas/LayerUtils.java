package com.lapots.breed.editor.fx.controls.canvas;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

public class LayerUtils {

    public static Canvas createLayer(double width, double height, Paint color) {
        Canvas layer = new Canvas(width, height);
        GraphicsContext gc = layer.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, 0, layer.getWidth(), layer.getHeight());
        layer.toFront();
        return layer;
    }

    public static void drawText(GraphicsContext gc, TextAlignment align, VPos baseline, Color color, String message,
                                double x0, double y0) {
        gc.setTextAlign(align);
        gc.setTextBaseline(baseline);
        gc.setFill(color);
        gc.fillText(message, x0, y0);
    }
}
