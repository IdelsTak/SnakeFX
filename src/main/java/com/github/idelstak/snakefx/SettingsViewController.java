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

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Builder;

class SettingsViewController implements Builder<Node> {

    SettingsViewController() {
    }

    @Override
    public Node build() {
        var hardRB = new RadioButton("Hard");
        var mediumRB = new RadioButton("Medium");
        var easyRB = new RadioButton("Easy");

        new ToggleGroup().getToggles().addAll(hardRB, mediumRB, easyRB);

        var difficultyBox = new HBox(hardRB, mediumRB, easyRB);
        difficultyBox.setSpacing(6);

        var levelBox = new VBox(new Text("Difficulty"), difficultyBox);
        levelBox.setSpacing(6);

        var up = new Label("Up:");
        up.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(up, Priority.ALWAYS);

        var down = new Label("Down:");
        down.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(down, Priority.ALWAYS);

        var left = new Label("Left:");
        left.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(left, Priority.ALWAYS);

        var right = new Label("Right:");
        right.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(right, Priority.ALWAYS);

        var upBox = new HBox(up, new Text("W"));
        var downBox = new HBox(down, new Text("S"));
        var leftBox = new HBox(left, new Text("A"));
        var rightBox = new HBox(right, new Text("D"));

        var controlsBox = new VBox(new Text("Controls"), upBox, downBox, leftBox, rightBox);
        controlsBox.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, new CornerRadii(12), null)));
        controlsBox.setSpacing(6);
        controlsBox.setPadding(new Insets(6));

        var innerBox = new VBox(controlsBox, levelBox);
        innerBox.setSpacing(24);
        innerBox.setPadding(new Insets(0, 18, 18, 18));

        var outerBox = new VBox(innerBox);
        outerBox.setPadding(new Insets(24));

        return outerBox;
    }

}
