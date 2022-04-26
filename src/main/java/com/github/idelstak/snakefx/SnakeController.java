package com.github.idelstak.snakefx;

import javafx.scene.layout.Region;

class SnakeController {

    private final SnakeViewBuilder viewBuilder = new SnakeViewBuilder();

    SnakeController() {
    }

    Region getView() {
        return viewBuilder.build();
    }

    String getTitle() {
        return "SnakeFX";
    }

}
