package com.example.hastane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class App extends Application implements Initializable {
    //public static ArrayList<Hastalar> obj = new ArrayList<>();
    public static Stage stage;  //mevcut stage

    @Override
    public void start(Stage primaryStage){
        stage = primaryStage;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/BorderPane.fxml"));
            BorderPane root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
