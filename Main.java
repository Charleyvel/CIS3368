package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //backdrop for the scene
        //sample.fxml is where we declare our visible and non visible actors (host/container controls)
        //Layout based on rectangle container shapes (VBoxes / HBoxes etc)
        // HBox - Horizontal container, lays things out Horizontally [ ][ ][ ]

        // VBox - Horizontal container, lays things out Vetically [ ]
        //                                                        [ ]

        primaryStage.setTitle("Employee Manager 2000"); //Display window title
        primaryStage.setScene(new Scene(root, 800, 500)); //whats shown in the window (backdrop and the size)
        primaryStage.show(); //"turn on the lights for people to see". You have to show the stage!
    }
    //There is not supposed to be code in the mail file
    //Stage - Window its displayed
    //Scene - new scenes or pages on the same stage. Every scene has a certain size and root (backdrop)

    public static void main(String[] args) {
        launch(args);
    }
}
