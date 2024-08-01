package com.example.assign2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private Pane mainPane;

    @FXML
    private Text heading;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonPrev;
    private double nextPaneY = 100;


    @FXML
    protected void initialize(){

        APICharacters api = new APICharacters();
        CharacterList characterList = api.getAllCHaracters("https://rickandmortyapi.com/api/character");

        setDataMain(characterList);

    }

    private void setDataMain(CharacterList characterList){
        APICharacters api = new APICharacters();


        if(characterList.info.prev==null) {
            buttonPrev.setVisible(false);
        }
        else{
            buttonPrev.setVisible(true);
        }

        buttonNext.setOnAction(e->{
            CharacterAllInfo info= characterList.info;
            CharacterList characterList1= api.getAllCHaracters(info.next);
            mainPane.getChildren().clear();
            mainPane.getChildren().addAll(buttonNext,buttonPrev,heading);
            nextPaneY = 100;
            setDataMain(characterList1);
        });


        buttonPrev.setOnAction(e->{
            CharacterAllInfo info= characterList.info;
            CharacterList characterList1= api.getAllCHaracters(info.prev);
            mainPane.getChildren().clear();
            mainPane.getChildren().addAll(buttonNext,buttonPrev,heading);
            nextPaneY = 100;
            setDataMain(characterList1);
        });

        for (Character character : characterList.results) {
            Pane newPane=new Pane();
            VBox vbox = new VBox();
            HBox  hbox=new HBox();
            Label label=new Label();
            Label labelAlive=new Label();


            Image image = new Image(character.image);
            ImageView img = new ImageView(image);

            label.setText(character.name);


            labelAlive.setText(character.status);
            label.setId(String.valueOf(character.id));
            label.setOnMouseClicked(( event)->{
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("character.fxml"));
                            Parent scene2Root = loader.load();
                            CharacterController characterController = loader.getController();
                            // Pass data to the controller
                            String characterId = label.getId(); // Replace with the actual logic to get the ID
                            characterController.setData(characterId);

                            Scene scene2 = new Scene(scene2Root);
                            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene2);


                        }catch (IOException a) {
                            a.printStackTrace();
                        }
                    }
            );

            img.setImage(image);
            img.getStyleClass().add("image");
            img.setFitWidth(100);  // Adjust width as necessary
            img.setFitHeight(100); // Adjust height as necessary

            label.getStyleClass().add("heading");
            labelAlive.getStyleClass().add("labelAlive");

            hbox.getStyleClass().add("paneIndividual");
            vbox.getStyleClass().add("paneIndividual");
            newPane.getStyleClass().add("paneIndividual");
            newPane.setLayoutY(nextPaneY);
            if(character.id%2==0){
                newPane.setLayoutX(330);
                nextPaneY+=150;
            }
            else{
                newPane.setLayoutX(30);
            }

            mainPane.getChildren().add(newPane);
            newPane.getChildren().addAll(hbox);
            hbox.getChildren().addAll(img,vbox);
            vbox.getChildren().addAll(label,labelAlive);
            mainPane.setMinHeight(nextPaneY+10);
        }
    }


}
