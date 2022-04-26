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

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.input.KeyCode;

public class Settings {

    private final ObjectProperty<Difficulty> difficultyProperty;
    private final ObjectProperty<KeyCode> upKeyCodeProperty;
    private final ObjectProperty<KeyCode> downKeyCodeProperty;
    private final ObjectProperty<KeyCode> leftKeyCodeProperty;
    private final ObjectProperty<KeyCode> rightKeyCodeProperty;

    public Settings() {
        this.difficultyProperty = new SimpleObjectProperty<>(this, "Difficulty property", Difficulty.EASY);
        this.upKeyCodeProperty = new SimpleObjectProperty<>(this, "Up key property", KeyCode.W);
        this.downKeyCodeProperty = new SimpleObjectProperty<>(this, "Down key property", KeyCode.S);
        this.leftKeyCodeProperty = new SimpleObjectProperty<>(this, "Left key property", KeyCode.A);
        this.rightKeyCodeProperty = new SimpleObjectProperty<>(this, "Right key property", KeyCode.D);
    }

    public Difficulty getDifficulty() {
        return difficultyProperty.get();
    }

    public void setDifficulty(Difficulty difficulty) {
        difficultyProperty.set(difficulty);
    }

    public ObjectProperty<Difficulty> difficultyProperty() {
        return difficultyProperty;
    }

    public KeyCode getUpKeyCode() {
        return upKeyCodeProperty.get();
    }

    public void setUpKeyCode(KeyCode upKeyCode) {
        upKeyCodeProperty.set(upKeyCode);
    }

    public ObjectProperty<KeyCode> upKeyCodeProperty() {
        return upKeyCodeProperty;
    }

    public KeyCode getDownKeyCode() {
        return downKeyCodeProperty.get();
    }

    public void setDownKeyCode(KeyCode downKeyCode) {
        downKeyCodeProperty.set(downKeyCode);
    }

    public ObjectProperty<KeyCode> downKeyCodeProperty() {
        return downKeyCodeProperty;
    }

    public KeyCode getLeftKeyCode() {
        return leftKeyCodeProperty.get();
    }

    public void setLeftKeyCode(KeyCode leftKeyCode) {
        leftKeyCodeProperty.set(leftKeyCode);
    }

    public ObjectProperty<KeyCode> leftKeyCodeProperty() {
        return leftKeyCodeProperty;
    }

    public KeyCode getRightKeyCode() {
        return rightKeyCodeProperty.get();
    }

    public void setRightKeyCode(KeyCode rightKeyCode) {
        rightKeyCodeProperty.set(rightKeyCode);
    }

    public ObjectProperty<KeyCode> rightKeyCodeProperty() {
        return rightKeyCodeProperty;
    }

    @Override
    public String toString() {
        return "Settings {difficulty = %s}".formatted(getDifficulty());
    }

    public enum Difficulty {
        EASY, MEDIUM, HARD
    }
}
