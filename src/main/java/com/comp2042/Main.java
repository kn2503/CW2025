package com.comp2042;

import com.comp2042.controller.GameController;
import com.comp2042.controller.GuiController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Main extends Application {

    private static final int Window_Width = 410;
    private static final int Window_Height = 510;

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL location = getClass().getClassLoader().getResource("gameLayout.fxml");
        ResourceBundle resources = null;
        FXMLLoader fxmlLoader = new FXMLLoader(location, resources);
        Parent root = fxmlLoader.load();
        GuiController c = fxmlLoader.getController();

        primaryStage.setTitle("Tetris"); //Set application title
        Scene scene = new Scene(root, Window_Width, Window_Height); //Remove magic numbers
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false); //Prevent resizing to avoid layout issues
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/tetris.png"))); //Set application icon
        new GameController(c);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
