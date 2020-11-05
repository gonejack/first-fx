package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HelloFX extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        var javaVersion = System.getProperty("java.version");
        var javafxVersion = System.getProperty("javafx.version");
        var centerLabel = new Label(String.format("Hello, JavaFX %s, running on Java %s.", javafxVersion, javaVersion));

        var btn = new Button("这是一个按钮");
        btn.setOnMouseClicked(ev -> {
            centerLabel.setText(String.valueOf(ev.getClickCount()));
            centerLabel.setDisable(!centerLabel.isDisabled());
        });

        var pane = new FlowPane(Orientation.VERTICAL, centerLabel, btn);
        pane.setAlignment(Pos.CENTER);
        pane.setColumnHalignment(HPos.CENTER);

        var scene = new Scene(pane, 640, 480);

        stage.setScene(scene);
        stage.show();
    }
}
