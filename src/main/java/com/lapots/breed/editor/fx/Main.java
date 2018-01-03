package com.lapots.breed.editor.fx;

import javafx.application.Application;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Editor");
        primaryStage.setScene(new Scene(new StackPane(), 300, 250));
        primaryStage.show();
    }

}
