package com.example.blackjackfront;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class FrontEnd extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the root layout
        BorderPane tableLayout = new BorderPane();
        tableLayout.setPadding(new Insets(10));
        tableLayout.setStyle("-fx-background-color: green");

        /*CardHolder ch = new CardHolder(1);
        List<Card> cards = ch.getCards();*/
        Card[] massiv = new Card[] {new Card("2♦"), new Card("5♦"), new Card("Q♠")};
        List<Card> cards = Arrays.asList(massiv);

        // Create a card and add stuff to it
        HBox cardrow = new HBox(10);
        for (Card c : cards) {
            VBox cardContent = new VBox();
            Group cardPic = new Group();

            Text valueText = new Text(c.getRank());
            valueText.setFont(Font.font("Arial", FontWeight.BOLD, 50));

            String suitFile;
            switch (c.getSuit()) {
                case "♣" -> suitFile = "clubs.png";
                case "♦" -> suitFile = "diamonds.png";
                case "♠" -> suitFile = "spades.png";
                case "♥" -> suitFile = "hearts.png";
                default -> suitFile = null;
            }
            File suitImageFile = new File(suitFile);
            String imagePath = suitImageFile.toURI().toString();
            ImageView suitImage = new ImageView(new Image(imagePath));
            suitImage.setFitWidth(50);
            suitImage.setFitHeight(50);

            cardContent.getChildren().addAll(valueText, suitImage);

            Rectangle background = new Rectangle(100, 150, Color.GHOSTWHITE);

            cardPic.getChildren().addAll(background, cardContent);

            cardrow.getChildren().add(cardPic);
        }


        // Position the card group at the bottom center of the table
        BorderPane.setAlignment(cardrow, Pos.CENTER);
        tableLayout.setBottom(cardrow);

        // Create the scene and show the stage
        Scene scene = new Scene(tableLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blackjack Table");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}