package com.lapots.breed.editor.fx.controls.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class CanvasDrawingController implements Initializable {

    @FXML
    private PlayerOptionsController controller;

    @FXML
    private Canvas character_canvas;
    private GraphicsContext gc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = character_canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, character_canvas.getWidth(), character_canvas.getHeight());
    }
}
