package com.github.idelstak.snakefx;

import javafx.scene.layout.Region;

class SnakeController {

    private final SnakeViewBuilder viewBuilder;

    SnakeController() {
        this.viewBuilder = new SnakeViewBuilder(this::displaySettings);
    }

    Region getView() {
        return viewBuilder.build();
    }

    String getTitle() {
        return "SnakeFX";
    }

    private void displaySettings(Runnable postDisplay) {
        postDisplay.run();
    }
}
