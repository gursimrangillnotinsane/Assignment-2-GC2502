package com.example.assign2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/*
* Main class which runs the initial fxml file
* */
public class HelloApplication extends Application {
    public static Stage parentWindow;
    @Override
    public void start(Stage stage) throws IOException {
        parentWindow = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 661, 600);
        stage.getIcons().add(new Image(getClass().getResource("Images/mainIcon.png").toString()));
        stage.setTitle("Rick And Morty Characters");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}