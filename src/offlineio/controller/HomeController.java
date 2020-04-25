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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import offlineio.util.StaticAppData;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class HomeController implements Initializable {

    @FXML
    private Label lblScopeCode;
    @FXML
    private Label lblScopeText;
    @FXML
    private Label lblUserName;
    @FXML
    private Label lblSyncCountBig;
    @FXML
    private Label lblSyncCount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onHomeClick(MouseEvent event) {
        ScreenController screenController = new ScreenController();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(screenController.activate("home")));
    }

    @FXML
    private void onAddSuspect(MouseEvent event) {
        ScreenController screenController = new ScreenController();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        StaticAppData.setNextWindow("newSuspect");
        primaryStage.setScene(new Scene(screenController.activate("passcode")));
    }

    @FXML
    private void onClickPartialForm(MouseEvent event) {
        ScreenController screenController = new ScreenController();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        StaticAppData.setNextWindow("patiallyCompleted");
        primaryStage.setScene(new Scene(screenController.activate("passcode")));
    }

    @FXML
    private void onClickCompletedForm(MouseEvent event) {
        ScreenController screenController = new ScreenController();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        StaticAppData.setNextWindow("completedForm");
        primaryStage.setScene(new Scene(screenController.activate("passcode")));
    }

    @FXML
    private void onClickFurtherInvestigation(MouseEvent event) {
        ScreenController screenController = new ScreenController();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        StaticAppData.setNextWindow("furtherInvestigation");
        primaryStage.setScene(new Scene(screenController.activate("login")));
    }

    @FXML
    private void onClickSuspectSync(MouseEvent event) {
        ScreenController screenController = new ScreenController();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        StaticAppData.setNextWindow("suspectSync");
        primaryStage.setScene(new Scene(screenController.activate("login")));
    }

    @FXML
    private void onClickMasterDataSync(MouseEvent event) {
//        ScreenController screenController = new ScreenController();
//        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        primaryStage.setScene(new Scene(screenController.activate("patiallyCompleted")));
    }

    @FXML
    private void onClickPasswordChange(MouseEvent event) {
//        ScreenController screenController = new ScreenController();
//        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        primaryStage.setScene(new Scene(screenController.activate("patiallyCompleted")));
    }

}
