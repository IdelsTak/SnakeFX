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
package com.github.idelstak.snakefx.views;

import com.github.idelstak.snakefx.controllers.SettingsViewController;
import com.github.idelstak.snakefx.model.Settings;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;

public class SnakeMainView extends BorderPane {

    private final Settings settings;

    public SnakeMainView(Settings settings) {
        this.settings = settings;

        super.setPrefSize(500, 400);
        super.setTop(menu());
    }

    private Node menu() {
        var play = new Button("Play");

        var settingsBtn = new Button("Settings");
        settingsBtn.setOnAction(evt -> {
            var view = new SettingsViewController(settings).getView();

            var dlg = new Dialog<Boolean>();
            dlg.setTitle("Game Settings");
            dlg.setDialogPane((DialogPane) view);
            dlg.setResultConverter(dlgBtn -> {
                ButtonBar.ButtonData data = dlgBtn == null ? null : dlgBtn.getButtonData();
                return data == ButtonBar.ButtonData.OK_DONE;
            });

            dlg.showAndWait().ifPresent(bln -> {
                System.out.println("Settings should be saved? " + bln);
            });

        });
        var exit = new Button("Exit");
        var toolBar = new ToolBar(play, settingsBtn, exit);

        return toolBar;
    }
}
