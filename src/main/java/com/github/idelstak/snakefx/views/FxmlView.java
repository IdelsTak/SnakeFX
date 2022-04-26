package com.github.idelstak.snakefx.views;

import java.io.IOException;
import java.util.function.Function;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class FxmlView implements Function<FxmlUrl, Node> {

    @Override
    public Node apply(FxmlUrl fxmlUrl) {
        try {
            return FXMLLoader.load(fxmlUrl.get());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
