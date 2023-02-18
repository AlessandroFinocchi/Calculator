package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(loader.load());
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setResizable(false);
            stage.setTitle("Calculator");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
            ((HelloController)loader.getController()).init(stage);
            stage.show();
        }
        catch(Exception e){
            Logger.getAnonymousLogger().log(Level.INFO, e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}