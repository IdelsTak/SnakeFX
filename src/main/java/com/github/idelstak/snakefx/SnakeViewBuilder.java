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
        pane.setTop(setupTop());

        return pane;
    }

    private Node setupTop() {
        var playBtn = new Button("Play");
        var settingsBtn = new Button("Settings");
        var exitBtn = new Button("Exit");
        var toolBar = new ToolBar(playBtn, settingsBtn, exitBtn);

        return toolBar;
    }

}
