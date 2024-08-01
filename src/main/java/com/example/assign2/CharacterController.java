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

public class CharacterController {
    @FXML
    private Text GenderChar;

    @FXML
    private ImageView ImageChar;

    @FXML
    private Text LocationChar;

    @FXML
    private Text NameChar;

    @FXML
    private Text SpeciesChar;

    @FXML
    private Text StatusChar;

    private Character character;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent scene1Root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene1 = new Scene(scene1Root);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene1);
    }



//    @FXML
//    protected void initialize() {
//        // Initialization logic that does not depend on external data can go here.
//        // For example:
//        if (name != null) {
//            // Ensure the character is set before trying to access it
//            System.out.println(character.name);
//            name.setText(character.name);
//            if (CharImage != null) {
//                Image image = new Image(character.url); // Ensure `character.imageUrl` is a valid path
//                CharImage.setImage(image);
//            }
//        }
//    }

    public void setData(String id) {
        // Fetch the character data and update UI
        APICharacters api = new APICharacters();
        this.character = api.getOneCharacter(id);

        NameChar.setText(character.name);
        Image image=new Image(character.image);
        ImageChar.setImage(image);
        SpeciesChar.setText(character.species);
        CharacterLocation location=character.location;
        LocationChar.setText(location.name);
        StatusChar.setText(character.status);
        GenderChar.setText(character.gender);
//        if (character != null) {
//            // Update UI components
//            NameChar.setText(character.name);
//            if (ImageChar != null) {
//                Image image = new Image(character.image); // Ensure `character.imageUrl` is a valid path
//                ImageChar.setImage(image);
//            }
//        } else {
//            System.out.println("Character data is null for ID: " + id);
//        }
    }
}
