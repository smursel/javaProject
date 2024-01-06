package com.example.hastane.Siniflar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class App extends Application implements Initializable {
    public static ArrayList<Hasta> hastalar = new ArrayList<Hasta>() ;
    public static ArrayList<Hastane> Hastaneler = new ArrayList<Hastane>() ;
    public static ArrayList<Hekim> hekimler = new ArrayList<Hekim>();
    public static Stage stage;  //mevcut stage

    @Override
    public void start(Stage primaryStage){
        Hastaneler.forEach(hastane -> hastane.hekimler.forEach(hekim -> hekimler.add(hekim)));

        stage = primaryStage;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
            AnchorPane root = loader.load();
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