package com.github.idelstak.snakefx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SnakeMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var gameController = new SnakeController();
        
        stage.setScene(new Scene(gameController.getView()));
        stage.setTitle(gameController.getTitle());
        stage.show();
    }

}
