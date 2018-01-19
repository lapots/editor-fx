package com.lapots.breed.editor.fx.controls.canvas;

public class MathUtils {

    public static double nearestDivision(double value, int divider) {
        while (value % divider != 0) {
            value--;
        }
        return value;
    }
}
