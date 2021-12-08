/**
 * @author Nicholas Shortt
 * @studentID 100630003
 * @date December 08, 2021
 */
package ca.durhamcollege.oop3200f2021ice12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage stage) throws IOException
    {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");

        // 1. Create Control(s)
        Label helloLabel = new Label("Hello, World!");
        Label goodByeLabel = new Label("Good Bye!");
        Button clickMeButton = new Button("Click Me");

        // 1.2 Configure Controls
        Font font = Font.font("Consolas", FontWeight.BOLD, 20);
        clickMeButton.setFont(font);

        // 1.3 Create Event Handling
        clickMeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                System.out.println("ClickMe Button CLicked!");

                helloLabel.setText("Clicked!");
            }
        });

        // 2. Create Container
        //HBox hBox = new HBox(helloLabel, clickMeButton);
        //VBox vBox = new VBox(helloLabel, clickMeButton);
        GridPane gridPane = new GridPane();

        gridPane.add(helloLabel, 1, 0);
        gridPane.add(goodByeLabel, 1, 1);
        gridPane.add(clickMeButton, 2, 2);


        // 3. Create Scene and Add Container
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // 4. Add Scene to Stage
        stage.setScene(scene);

        // 5. Show Stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}