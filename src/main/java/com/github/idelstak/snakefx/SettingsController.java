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

import com.github.idelstak.snakefx.enums.Difficulty;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class SettingsController {

    public Button upSetting;
    public Button downSetting;
    public Button leftSetting;
    public Button rightSetting;

    @FXML
    void easypush(ActionEvent event) {
        Game.difficulty = Difficulty.EASY;
    }

    @FXML
    void mediumpush(ActionEvent event) {
        Game.difficulty = Difficulty.MEDIUM;
    }

    @FXML
    void hardpush(ActionEvent event) {
        Game.difficulty = Difficulty.HARD;
    }

    @FXML
    void return_push(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene exit = new Scene(menu);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(exit);
        stage.show();
    }

    KeyCode upKey = KeyCode.W;
    KeyCode downKey = KeyCode.S;
    KeyCode leftKey = KeyCode.A;
    KeyCode rightKey = KeyCode.D;

    public void savepush(ActionEvent event) {
        Game.RightKey = rightKey;
        Game.LeftKey = leftKey;
        Game.UpKey = upKey;
        Game.DownKey = downKey;
    }

    public void GetUPKey(KeyEvent keyEvent) {
        if (keyEvent.getCode() != downKey && keyEvent.getCode() != leftKey && keyEvent.getCode() != rightKey) {
            upKey = keyEvent.getCode();
            String UP = upKey.toString();
            upSetting.setText(UP);
        }
    }

    public void GetDownKey(KeyEvent keyEvent) {
        if (keyEvent.getCode() != upKey && keyEvent.getCode() != leftKey && keyEvent.getCode() != rightKey) {
            downKey = keyEvent.getCode();
            String UP = downKey.toString();
            downSetting.setText(UP);
        }
    }

    public void GetLeftKey(KeyEvent keyEvent) {
        if (keyEvent.getCode() != downKey && keyEvent.getCode() != upKey && keyEvent.getCode() != rightKey) {
            leftKey = keyEvent.getCode();
            String UP = leftKey.toString();
            leftSetting.setText(UP);
        }
    }

    public void GetRightKey(KeyEvent keyEvent) {
        if (keyEvent.getCode() != downKey && keyEvent.getCode() != leftKey && keyEvent.getCode() != upKey) {
            rightKey = keyEvent.getCode();
            String UP = rightKey.toString();
            rightSetting.setText(UP);
        }
    }
}
