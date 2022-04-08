package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PrimaryController implements Initializable {

    @FXML
    private Label pokemonName;

    @FXML
    private TextField pokemonNameTxt;

    public String test;

    @FXML
    private ComboBox<String> comboBox;

    public List<Pokemon> listOfPokemon;
    @FXML
    private Pokemon pkmSelected;

    public Pokemon getPkmSelected() {
        return pkmSelected;
    }

    public void setPkmSelected(Pokemon pkmSelected) {
        this.pkmSelected = pkmSelected;
    }

    /**
     * Action Method to show the pokemon info from the textBox
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void buttonPressed(ActionEvent event) throws IOException {

        String pokemonN = pokemonNameTxt.getText();

       /* List<Pokemon> lstPokemon = new ArrayList<Pokemon>();
        lstPokemon = App.fetchPokemonByLimit(150);*/

        System.out.println("POKEMON NAME KEYBOARD" + pokemonN);

        for (Pokemon pkm : listOfPokemon) {
            System.out.println(pkm.getName());

            if (Objects.equals(pkm.getName(), pokemonN)) {

                System.out.println("POKEMON FOUND IT " + pkm.getName());


                FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
                Parent root = loader.load();
                SecondaryController secondary = loader.getController();
                secondary.setLabelNameText("Name: " + pkm.getName());
                secondary.setLabelTypeText("Type : " + pkm.getLstPokemonType().toString());
                secondary.setLabelIdText("# " + pkm.getId());
                System.out.println("NAIL " + pkm.getName());


                Stage stage = new Stage();
                stage.setScene(new Scene(root));

                stage.show();


            }

        }

        // App.setRoot("secondary");


    }


    /**
     * Meethod to show the pokemon info from the list
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void listPressed(ActionEvent event) throws IOException {

        String pokemonN = comboBox.getValue();

      /*  List<Pokemon> lstPokemon = new ArrayList<Pokemon>();
        lstPokemon = App.fetchPokemonByLimit(150);*/


        System.out.println("POKEMON NAME KEYBOARD" + pokemonN);

        for (Pokemon pkm : listOfPokemon) {
            System.out.println(pkm.getName());

            if (Objects.equals(pkm.getName(), pokemonN)) {

                System.out.println("POKEMON FOUND IT " + pkm.getName());


                FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
                Parent root = loader.load();
                SecondaryController secondary = loader.getController();
                secondary.setLabelNameText("Name: " + pkm.getName());
                secondary.setLabelTypeText("Type : " + pkm.getLstPokemonType().toString());
                secondary.setLabelIdText("# " + pkm.getId());
                System.out.println("NAIL " + pkm.getName());


                Stage stage = new Stage();
                stage.setScene(new Scene(root));

                stage.show();


            }

        }

        // App.setRoot("secondary");


    }



/*    public String transferMessage() {
        //Display the message
        System.out.println("POKEMON SELECT TEST "+nail.getText());


      return nail.getText();
    }*/

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");

        /*ImageView image = new ImageView();
        image.getClass().getResource()*/
    }

    /**
     * at init get all the 150 pokemons
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] cmbxName = new String[150];

        try {

            listOfPokemon = App.fetchPokemonByLimit(150);

            for (int i = 0; i < listOfPokemon.size(); i++) {
                cmbxName[i] = String.valueOf(listOfPokemon.get(i).getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        comboBox.getItems().addAll(cmbxName);
    }
}
