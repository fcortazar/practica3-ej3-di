package com.di.practica33;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HelloApplication extends Application {
    public static void main(String[] args) {launch(args);}
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Desvanecer Círculo");

        Circle circle = new Circle(50, Color.BLUE); // Círculo azul con radio 50
        Circle redCircle = new Circle(50, Color.RED); // Círculo rojo con radio 50
        redCircle.setOpacity(0); //Establecer la opacidad a 0

        Button button = new Button("Alternar Círculos");

        FadeTransition fadeOutBlue = new FadeTransition(Duration.seconds(1), circle);
        fadeOutBlue.setToValue(0); // Establecer el valor de opacidad a 0 (transparente) al final de la transición

        FadeTransition fadeInRed = new FadeTransition(Duration.seconds(1), redCircle);
        fadeInRed.setToValue(1); // Establecer el valor de opacidad a 1 (visible) al final de la transición

        FadeTransition fadeInBlue = new FadeTransition(Duration.seconds(1), circle);
        fadeInBlue.setToValue(1); // Establecer el valor de opacidad a 1 (visible) al final de la transición

        FadeTransition fadeOutRed = new FadeTransition(Duration.seconds(1), redCircle);
        fadeOutRed.setToValue(0); // Establecer el valor de opacidad a 0 (transparente) al final de la transición

        // Evento al hacer clic en el botón
        button.setOnAction(e -> {
            if (circle.getOpacity() > 0) {
                // Si el círculo azul es visible, desaparecer azul y hacer visible rojo
                fadeOutBlue.play();
                fadeInRed.play();
            } else {
                // Si el círculo azul no es visible, desaparecer rojo y hacer visible azul
                fadeOutRed.play();
                fadeInBlue.play();
            }
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(redCircle, circle, button); // Cambiar el orden de los nodos

        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
