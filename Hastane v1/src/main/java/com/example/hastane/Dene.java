package com.example.hastane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Dene extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Ziyaretlerim.fxml"));
        Scene scene1 = new Scene(loader.load());
        stage.setScene(scene1);
        stage.show();
    }
}
