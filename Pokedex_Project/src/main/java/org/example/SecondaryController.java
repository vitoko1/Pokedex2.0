package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;

public class SecondaryController implements Initializable {


    @FXML
    private Label pokemonName;
    @FXML
    private Label pokemonType;

    @FXML
    private Label idPokemon;


    @FXML
    private TableView tabAbout;


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    /**
     * init
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        try {
            Parent root = loader.load();

            PrimaryController primary = loader.getController();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method to set the pokemonName Label
     * @param string
     */
    public void setLabelNameText(String string) {
        pokemonName.setText(string);
    }
    /**
     * Method to set the idPokemon Label
     * @param string
     */
    public void setLabelIdText(String string) {
        idPokemon.setText(string);
    }
    /**
     * Method to set the pokemonType Label
     * @param string
     */
    public void setLabelTypeText(String string) {
        pokemonType.setText(string);
    }




}