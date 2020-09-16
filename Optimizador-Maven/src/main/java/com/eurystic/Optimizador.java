package com.eurystic;

import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static com.eurystic.Services.InputParameters.readEscenarios;

public class Optimizador extends Application {

    Stage primaryStage;

    @Override
    public void start (Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/eurystic/Views/VistaPrincipal.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        borderlessWindow(root, primaryStage);
        primaryStage.show();

        primaryStage.setTitle("Programador de Producción de Mallas");

//        new FadeIn(root).play();
    }

    public static void main(String[] args) throws IOException{
        readEscenarios();
        launch(args);
    }

    public static void borderlessWindow(Parent root, Stage primaryStage) {
        AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);

        //grab your root here
        root.setOnMousePressed(event -> {
            xOffset.set(event.getSceneX());
            yOffset.set(event.getSceneY());
        });

        //move around here
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset.get());
            primaryStage.setY(event.getScreenY() - yOffset.get());
        });

        primaryStage.show();
    }
}
