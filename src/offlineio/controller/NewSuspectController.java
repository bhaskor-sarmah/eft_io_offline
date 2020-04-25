/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class NewSuspectController implements Initializable {

    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtMiddleName;
    @FXML
    private TextField txtLastName;
    @FXML
    private ChoiceBox<?> selVillage;
    @FXML
    private Label lblMessage;
    @FXML
    private TextField txtFirstName1;
    @FXML
    private TextField txtMiddleName1;
    @FXML
    private TextField txtFirstName12;
    @FXML
    private ChoiceBox<?> selVillage1;
    @FXML
    private TextField txtFirstName121;
    @FXML
    private TextField txtFirstName1211;
    @FXML
    private TextField txtFirstName1212;
    @FXML
    private TextField txtLastName1;
    @FXML
    private TextField txtMiddleName11;
    @FXML
    private TextField txtFirstName11;
    @FXML
    private ChoiceBox<?> selVillage2;
    @FXML
    private TextField txtFirstName111;
    @FXML
    private TextField txtFirstName11111;
    @FXML
    private TextField txtFirstName111112;
    @FXML
    private TextField txtFirstName1111;
    @FXML
    private TextField txtFirstName111111;
    @FXML
    private ChoiceBox<?> selVillage21;
    @FXML
    private TextField txtMiddleName13;
    @FXML
    private TextField txtLastName2;
    @FXML
    private TextField txtMiddleName12;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup gender = new ToggleGroup();
        ToggleGroup maritalStatus = new ToggleGroup();
        ToggleGroup passport = new ToggleGroup();
    }    

    @FXML
    private void onSaveClick(MouseEvent event) {
    }

    @FXML
    private void onBackClick(MouseEvent event) {
    }

    @FXML
    private void onLogoutClick(MouseEvent event) {
    }
    
}
