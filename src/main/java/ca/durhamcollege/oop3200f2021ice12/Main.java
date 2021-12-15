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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application
{
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage stage) throws IOException
    {
        stage.setTitle("Hello World!");

        // 1. Create Control(s)
        Label imageLabel = new Label("XBox Series X!");

        Button clickMeButton = new Button("Click Me");
        clickMeButton.setStyle("-fx-font-family: Arial;");

        FileInputStream imagePath = new FileInputStream("src/main/java/ca/durhamcollege/oop3200f2021ice12/xboxseriesx.jpg");

        // Step 1 for Images: Load Image
        Image xboxSeriesX = new Image(imagePath);

        // Step 2 for Images: Setup ImageView to contain image
        ImageView consoleImageView = new ImageView(xboxSeriesX);
        consoleImageView.setFitWidth(400);
        consoleImageView.setPreserveRatio(true);

        FileInputStream ps5Path = new FileInputStream("src/main/java/ca/durhamcollege/oop3200f2021ice12/ps5.jpg");
        Image ps5 = new Image(ps5Path);

        // 1.2 Configure Controls
        //Font font = Font.font("Consolas", FontWeight.BOLD, 20);
        //clickMeButton.setFont(font);

        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                imageLabel.setText("PS5!");
                consoleImageView.setImage(ps5);
            }
        }
        clickMeButton.setOnAction(new ButtonClickHandler());


        // 1.3 Create Event Handling
        /*clickMeButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                imageLabel.setText("PS5!");
                consoleImageView.setImage(ps5);
            }
        });*/

        // 2. Create Container
        HBox hBox = new HBox(10, imageLabel);
        hBox.setStyle("-fx-alignment: center;");

        HBox hBox2 = new HBox(10, consoleImageView);

        GridPane gridPane = new GridPane();

        gridPane.setMinSize(6, 8);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        gridPane.add(hBox, 0, 0);
        gridPane.add(hBox2, 0, 1);
        gridPane.add(consoleImageView, 0, 2);
        gridPane.add(clickMeButton, 2, 2);

        gridPane.setStyle("-fx-border-color: black; -fx-font-size: 20; -fx-font-family: Consolas;");


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