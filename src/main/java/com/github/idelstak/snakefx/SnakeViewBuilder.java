package com.github.idelstak.snakefx;

import java.util.function.Consumer;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.util.Builder;

class SnakeViewBuilder implements Builder<Region> {

    private final Consumer<Runnable> settingsDisplay;

    SnakeViewBuilder(Consumer<Runnable> settingsDisplay) {
        this.settingsDisplay = settingsDisplay;
    }

    @Override
    public Region build() {
        var pane = new BorderPane();

        pane.setPrefSize(500, 400);
        pane.setTop(menu());

        return pane;
    }

    private Node menu() {
        var play = new Button("Play");

        var settings = new Button("Settings");
        settings.setOnAction(evt -> {
            settings.setDisable(true);
            settingsDisplay.accept(() -> {
                settings.setDisable(false);
                evt.consume();
            });
        });
        var exit = new Button("Exit");
        var toolBar = new ToolBar(play, settings, exit);

        return toolBar;
    }

}
