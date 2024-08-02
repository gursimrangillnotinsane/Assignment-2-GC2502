package com.example.assign2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.jar.Attributes;

import javafx.scene.image.ImageView;

/*
* Controller-class for the single character scene
* */

public class CharacterController {
    @FXML
    private Text genderChar;

    @FXML
    private ImageView imageChar;

    @FXML
    private Text locationChar;

    @FXML
    private Text nameChar;

    @FXML
    private Text speciesChar;

    @FXML
    private Text statusChar;

    private Character character;

    /**
     * To go back to the main view
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent scene1Root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene1 = new Scene(scene1Root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResource("Images/mainIcon.png").toString()));
        stage.setTitle("Rick And Morty Characters");
        stage.setScene(scene1);
    }


    /**
     * Gets the info about a single character and populates the scene
     * @param id of the character
     */
    public void setData(String id) {
        // Fetch the character data and update UI
        APICharacters api = new APICharacters();
        this.character = api.getOneCharacter(id);

        nameChar.setText(character.getName());
        Image image=new Image(character.getImage());
        imageChar.setImage(image);
        speciesChar.setText(character.getSpecies());
        CharacterLocation location=character.getLocation();
        locationChar.setText(location.getName());
        statusChar.setText(character.getStatus());
        genderChar.setText(character.getGender());
    }
}
