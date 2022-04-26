package com.github.idelstak.snakefx;

import com.github.idelstak.snakefx.SettingsView.SimpleSettings;
import java.util.Objects;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SettingsView extends Dialog<Settings.Difficulty> {

    private final SimpleSettings defaultSettings;
    private final RadioButton easyRB;
    private final RadioButton mediumRB;
    private final RadioButton hardRB;
    private final ToggleGroup toggleGroup;

    public SettingsView(SimpleSettings defaultSettings) {
        this.defaultSettings = defaultSettings;
        
        easyRB = new RadioButton("Easy");
        mediumRB = new RadioButton("Medium");
        hardRB = new RadioButton("Hard");
        toggleGroup = new ToggleGroup();

        super.setTitle("Game Settings");

        var dialogPane = super.getDialogPane();

        dialogPane.setContent(this.content());
        dialogPane.getButtonTypes().setAll(
                new ButtonType[]{
                    new ButtonType("Save", ButtonBar.ButtonData.OK_DONE),
                    new ButtonType("Return", ButtonBar.ButtonData.CANCEL_CLOSE)
                }
        );

        this.setSelectedDifficulty(this.defaultSettings.getDifficulty());

        super.setResultConverter(dialogButton -> {
            ButtonBar.ButtonData data = dialogButton == null ? null : dialogButton.getButtonData();
            return data == ButtonBar.ButtonData.OK_DONE ? this.getSelectedDifficulty() : null;
        });
    }

    private Node content() {
        toggleGroup.getToggles().setAll(hardRB, mediumRB, easyRB);

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

    private Settings.Difficulty getSelectedDifficulty() {
        var selected = toggleGroup.getToggles()
                .stream()
                .filter(Toggle::isSelected)
                .map(RadioButton.class::cast)
                .findFirst()
                .orElseThrow();

        if (Objects.equals(easyRB, selected)) {
            return Settings.Difficulty.EASY;
        } else if (Objects.equals(mediumRB, selected)) {
            return Settings.Difficulty.MEDIUM;
        } else {
            return Settings.Difficulty.HARD;
        }
    }

    private void setSelectedDifficulty(Settings.Difficulty difficulty) {
        switch (difficulty) {
            case EASY ->
                easyRB.setSelected(true);
            case MEDIUM ->
                mediumRB.setSelected(true);
            case HARD ->
                hardRB.setSelected(true);
            default ->
                easyRB.setSelected(true);
        }
    }

    public class SimpleSettings {

        private final Settings.Difficulty difficulty;
        private final KeyCode upCode;
        private final KeyCode downCode;
        private final KeyCode leftCode;
        private final KeyCode rightCode;

        public SimpleSettings(Settings settings) {
            this(
                    settings.getDifficulty(),
                    settings.getUpKeyCode(),
                    settings.getDownKeyCode(),
                    settings.getLeftKeyCode(),
                    settings.getRightKeyCode()
            );
        }

        public SimpleSettings(
                Settings.Difficulty difficulty,
                KeyCode upCode,
                KeyCode downCode,
                KeyCode leftCode,
                KeyCode rightCode
        ) {
            this.difficulty = difficulty;
            this.upCode = upCode;
            this.downCode = downCode;
            this.leftCode = leftCode;
            this.rightCode = rightCode;
        }

        public Settings.Difficulty getDifficulty() {
            return difficulty;
        }

        public KeyCode getUpKeyCode() {
            return upCode;
        }

        public KeyCode getDownKeyCode() {
            return downCode;
        }

        public KeyCode getLeftKeyCode() {
            return leftCode;
        }

        public KeyCode getRightKeyCode() {
            return rightCode;
        }

    }
}
