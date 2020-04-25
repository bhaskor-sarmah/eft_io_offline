/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import offlineio.controller.ScreenController;
import offlineio.repository.LoginDao;
import offlineio.util.StaticAppData;

/**
 *
 * @author Bhaskor
 */
public class OfflineIO extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ScreenController screenController = new ScreenController();
        screenController.addScreen("completedForm", getClass().getResource("fxml/CompletedForm.fxml"));
        screenController.addScreen("furtherInvestigation", getClass().getResource("fxml/FurtherInvestigation.fxml"));
        screenController.addScreen("home", getClass().getResource("fxml/Home.fxml"));
        screenController.addScreen("login", getClass().getResource("fxml/Login.fxml"));
        screenController.addScreen("masterData", getClass().getResource("fxml/MasterData.fxml"));
        screenController.addScreen("modifySuspectData", getClass().getResource("fxml/ModifySuspectData.fxml"));
        screenController.addScreen("newSuspect", getClass().getResource("fxml/NewSuspect.fxml"));
        screenController.addScreen("patiallyCompleted", getClass().getResource("fxml/PartiallyCompletedForm.fxml"));
        screenController.addScreen("passcode", getClass().getResource("fxml/Passcode.fxml"));
        screenController.addScreen("resetPassword", getClass().getResource("fxml/ResetPassword.fxml"));
        screenController.addScreen("suspectAddressDetails", getClass().getResource("fxml/SuspectAddressDetails.fxml"));
        screenController.addScreen("suspectBasicDetails", getClass().getResource("fxml/SuspectBasicDetails.fxml"));
        screenController.addScreen("suspectSync", getClass().getResource("fxml/SuspectSync.fxml"));
        screenController.addScreen("masterVersion", getClass().getResource("fxml/ViewMaster.fxml"));

//        stage.setTitle("Offline IO Application");
//        stage.setScene(new Scene(screenController.activate("suspectBasicDetails")));
//        stage.getIcons().add(new Image(getClass().getResourceAsStream("resources/eft_logo.png")));
//        stage.setResizable(false);
//        stage.show();


        boolean pin_found = LoginDao.checkIfPinPresent();

        if (pin_found) {
            stage.setTitle("Offline IO Application");
            StaticAppData.setNextWindow("home");
            stage.setScene(new Scene(screenController.activate("passcode")));
            stage.getIcons().add(new Image(getClass().getResourceAsStream("resources/eft_logo.png")));
            stage.setResizable(false);
            stage.show();
        } else {
            stage.setTitle("Offline IO Application");
            StaticAppData.setNextWindow("masterData");
            stage.setScene(new Scene(screenController.activate("login")));
            stage.getIcons().add(new Image(getClass().getResourceAsStream("resources/eft_logo.png")));
            stage.setResizable(false);
            stage.show();
        }
    }
}
