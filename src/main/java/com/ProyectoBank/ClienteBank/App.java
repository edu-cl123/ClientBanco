package com.ProyectoBank.ClienteBank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("inicio"), 640, 480);
        stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("bank.png"))));
        stage.setTitle("Select rol");
        stage.setScene(scene);
        stage.show();
    }
    public static void loadScene(Stage stage, String fxml, String title) throws IOException {
        Parent p = loadFXML(fxml);
        Scene s = new Scene(p);
        stage.setScene(s);
        stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("bank.png"))));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.showAndWait();
    }

    public static void closeScene(Stage stage) {
        stage.close();
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}