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

        var settingsBtn = new Button("Settings");
        settingsBtn.setOnAction(evt -> {

            var settings = new Settings();

            settings.difficultyProperty().addListener((obs, ov, nv) -> {
                System.out.printf("Observable: %s; old val: %s; new val: %s\n", obs, ov, nv);
            });

            var dialog = new SettingsViewController(settings).build();

            dialog.showAndWait().ifPresent(settings::setDifficulty);

        });
        var exit = new Button("Exit");
        var toolBar = new ToolBar(play, settingsBtn, exit);

        return toolBar;
    }

}
