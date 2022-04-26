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
package com.github.idelstak.snakefx.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainViewController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private BorderPane mainPane;
    @FXML
    private HBox topBox;
    @FXML
    private Button exitButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        System.out.println("Loaded fxml file from: " + location);

        exitButton.visibleProperty().bind(settingsButton.visibleProperty());
        backButton.visibleProperty().bind(settingsButton.visibleProperty().not());
        saveButton.visibleProperty().bind(exitButton.visibleProperty().not());
    }

    @FXML
    void displaySettings(ActionEvent event) {
        settingsButton.setVisible(false);
        event.consume();
    }

    @FXML
    void backToMain(ActionEvent event) {
        settingsButton.setVisible(true);
        event.consume();
    }

    @FXML
    void exit(ActionEvent event) {
        var btns = new ButtonType[]{
            new ButtonType("Yes", ButtonData.CANCEL_CLOSE),
            new ButtonType("No", ButtonData.OK_DONE)
        };
        var alert = new Alert(Alert.AlertType.CONFIRMATION, "", btns);
        
        alert.setTitle("Exit");
        alert.setHeaderText("Are you sure you want to exit the game?");
        alert.setContentText("Game progress will be saved");
        
        alert.showAndWait()
                .map(ButtonType::getButtonData)
                .filter(bd -> bd == ButtonData.CANCEL_CLOSE)
                .ifPresent(bd -> Platform.exit());
        
        event.consume();
    }

    @FXML
    void saveSettings(ActionEvent event) {
        event.consume();
    }

}
