/*
 * The MIT License
 * Copyright © 2022 Hiram K
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.idelstak.snakefx;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.util.Builder;

class SnakeViewBuilder implements Builder<Region> {

    SnakeViewBuilder() {
    }

    @Override
    public Region build() {
        var gamePane = new BorderPane();

        gamePane.setPrefSize(500, 400);
        gamePane.setTop(menu());

        return gamePane;
    }

    private Node menu() {
        var play = new Button("Play");

        var settings = new Button("Settings");
        settings.setOnAction(evt -> {

            var dialogPane = new DialogPane();
            
            dialogPane.setContent(new SettingsViewController().build());
            dialogPane.getButtonTypes().setAll(
                    new ButtonType[]{
                        new ButtonType("Save", ButtonData.OK_DONE),
                        new ButtonType("Return", ButtonData.CANCEL_CLOSE)
                    }
            );

            var dialog = new Dialog<Void>();

            dialog.setDialogPane(dialogPane);
            dialog.showAndWait();

        });
        var exit = new Button("Exit");
        var toolBar = new ToolBar(play, settings, exit);

        return toolBar;
    }

}
