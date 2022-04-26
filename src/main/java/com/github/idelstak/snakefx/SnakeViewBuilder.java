package com.github.idelstak.snakefx;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.util.Builder;

class SnakeViewBuilder implements Builder<Region> {

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
        var exit = new Button("Exit");
        var toolBar = new ToolBar(play, settings, exit);

        return toolBar;
    }

}
