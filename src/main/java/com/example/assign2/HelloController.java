package com.example.assign2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class HelloController {

    @FXML
    private Pane mainPane;
    private double nextPaneY = 50;

    @FXML
    protected void initialize(){

        APICharacters api = new APICharacters();
        CharacterList characterList = api.getAllCHaracters();
        System.out.println("Characters: ");

        for (Character character : characterList.results) {
            System.out.println("ID: " + character.id + ", Name: " + character.name + "url");
            // Add other fields as necessary
            Pane newPane=new Pane();

            VBox vbox = new VBox();

            Button button= new Button();
            Label label=new Label();

            Image image = new Image(character.image);
            ImageView img = new ImageView(image);

            newPane.getStyleClass().add("paneIndividual");
            vbox.getStyleClass().add("paneIndividual");
            label.setText(character.name);

            button.setId(String.valueOf(character.id));
            button.setOnAction(e->{
                System.out.println(button.getId());
                Character newChar=api.getOneCharacter(button.getId());
                System.out.println(newChar.toString());
            });
            button.setText(character.name);
            button.getStyleClass().add("button");


            img.setImage(image);
            img.setFitWidth(100);  // Adjust width as necessary
            img.setFitHeight(100); // Adjust height as necessary

            newPane.setLayoutY(nextPaneY);
            if(character.id%2==0){
                newPane.setLayoutX(300);
                nextPaneY+=150;
            }
            else{
                newPane.setLayoutX(100);
            }




            mainPane.getChildren().add(newPane);
            newPane.getChildren().addAll(vbox);
            vbox.getChildren().addAll( img, button);
            mainPane.setMinHeight(nextPaneY+10);

        }


    }


}
