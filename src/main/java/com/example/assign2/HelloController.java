package com.example.assign2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

/*
* Class that controls the main view
* */
public class HelloController {

    @FXML
    private Pane mainPane;

    @FXML
    private Text mainHeading;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonPrev;
    private double nextPaneY = 100;


    /**
     * gets all the characters info and put it in an arraylist, and pass it to another function to populate the view
     */
    @FXML
    protected void initialize(){
        APICharacters api = new APICharacters();
        CharacterList characterList = api.getAllCHaracters("https://rickandmortyapi.com/api/character");

        setDataMain(characterList);

    }
    /**
     * to populate the view with data
     * @param characterList - containing all the character's data
     */
    private void setDataMain(CharacterList characterList){
        APICharacters api = new APICharacters();

//      makes the "previous page" button  invisible if there is no page to go back to
        if(characterList.getInfo().getPrev()==null) {
            buttonPrev.setVisible(false);
        }
        else{
            buttonPrev.setVisible(true);
        }

//      gets the characters on the next page and populates the view accordingly
        buttonNext.setOnAction(e->{
            CharacterAllInfo info= characterList.getInfo();
            CharacterList characterList1= api.getAllCHaracters(info.getNext());
            mainPane.getChildren().clear();
            mainPane.getChildren().addAll(buttonNext,buttonPrev,mainHeading);
            nextPaneY = 100;
            setDataMain(characterList1);
        });

//      gets the characters on the previous page and populates the view accordingly
        buttonPrev.setOnAction(e->{
            CharacterAllInfo info= characterList.getInfo();
            CharacterList characterList1= api.getAllCHaracters(info.getPrev());
            mainPane.getChildren().clear();
            mainPane.getChildren().addAll(buttonNext,buttonPrev,mainHeading);
            nextPaneY = 100;
            setDataMain(characterList1);
        });
//      a loop to populate the view
        for (Character character : characterList.getResults()) {
            Pane newPane=new Pane();
            VBox vbox = new VBox();
            HBox  hbox=new HBox();
            Label label=new Label();
            Label labelAlive=new Label();


            Image image = new Image(character.getImage());
            ImageView img = new ImageView(image);

            label.setText(character.getName());
            labelAlive.setText(character.getStatus());
            label.setId(String.valueOf(character.getId()));

//          it takes the user to the next view containing the information about the character clicked
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
                            stage.setTitle(character.getName());
                            stage.getIcons().clear();
                            stage.getIcons().add(new Image(character.getImage()));
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

            mainHeading.getStyleClass().add("mainHeading");
            hbox.getStyleClass().add("paneIndividual");
            vbox.getStyleClass().add("paneIndividual");
            vbox.getStyleClass().add("vbox");
            newPane.getStyleClass().add("paneIndividual");
            newPane.setLayoutY(nextPaneY);
            if(character.getId()%2==0){
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
