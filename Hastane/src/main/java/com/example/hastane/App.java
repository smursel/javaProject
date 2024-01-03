package com.example.hastane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        //FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/Fxml/Signin.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/Fxml/Client/AnaSayfa.fxml"));
        Scene scene = new Scene(fxmlLoader2.load());
        stage.setScene(scene);
        stage.show();
    }

}
