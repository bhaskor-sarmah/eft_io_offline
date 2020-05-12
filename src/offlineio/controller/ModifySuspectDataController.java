/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import offlineio.models.SuspectBasicDetails;
import offlineio.repository.SuspectRepository;
import offlineio.util.StaticAppData;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class ModifySuspectDataController implements Initializable {

    @FXML
    private Label lblTempId;
    @FXML
    private Label lblSuspectName;
    @FXML
    private ImageView imgBasicDetails;
    @FXML
    private ImageView imgAddressDetails;
    @FXML
    private ImageView imgFamilyDetails;
    @FXML
    private ImageView imgBiometricDetails;
    @FXML
    private ImageView imgDocumentDetails;
    @FXML
    private ImageView imgLocationDetails;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SuspectBasicDetails s = SuspectRepository.findSuspectById(StaticAppData.getModifySuspectId());
        if (s.getTemp_id() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error fetching Suspect Data");
            alert.showAndWait();
            Platform.runLater(() -> {
                try {
                    ScreenController screenController = new ScreenController();
                    Stage primaryStage = (Stage) lblTempId.getScene().getWindow();
                    primaryStage.setScene(new Scene(screenController.activate("home")));
                    primaryStage.centerOnScreen();
                } catch (Exception e) {
                    System.out.println("Exception : " + e.getMessage());
                }
            });

        } else {
            lblTempId.setText(s.getTemp_id());
            lblSuspectName.setText(s.getFirst_name() + " " + ((s.getMiddle_name().equals("")) ? s.getLast_name() : s.getMiddle_name() + " " + s.getLast_name()));
            imgBasicDetails.setImage(new Image(getClass().getResourceAsStream("../resources/" + ((s.getFinal_save_basic().equals("Y")) ? "icon_done" : "icon_notdone") + "/icons_person.png")));
            imgAddressDetails.setImage(new Image(getClass().getResourceAsStream("../resources/" + ((s.getFinal_save_basic().equals("Y")) ? "icon_done" : "icon_notdone") + "/icons_home_address.png")));
            imgFamilyDetails.setImage(new Image(getClass().getResourceAsStream("../resources/" + ((s.getFinal_save_basic().equals("Y")) ? "icon_done" : "icon_notdone") + "/icons_family.png")));
            imgBiometricDetails.setImage(new Image(getClass().getResourceAsStream("../resources/" + ((s.getFinal_save_basic().equals("Y")) ? "icon_done" : "icon_notdone") + "/icons_fingerprint.png")));
            imgDocumentDetails.setImage(new Image(getClass().getResourceAsStream("../resources/" + ((s.getFinal_save_basic().equals("Y")) ? "icon_done" : "icon_notdone") + "/icons_upload_document.png")));
        }
    }

    @FXML
    private void onSuspectBasicDetailsClick(MouseEvent event) {
        try {
            ScreenController screenController = new ScreenController();
            Stage primaryStage = (Stage) lblTempId.getScene().getWindow();
            primaryStage.setScene(new Scene(screenController.activate("suspectBasicDetails")));
            primaryStage.centerOnScreen();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    @FXML
    private void onSuspectAddressDetailsClick(MouseEvent event) {
    }

    @FXML
    private void onSuspectFamilyMemberClick(MouseEvent event) {
    }

    @FXML
    private void onSuspectBiometricDetailsClick(MouseEvent event) {
    }

    @FXML
    private void onSuspectDocumentUploadClick(MouseEvent event) {
    }

    @FXML
    private void onSuspectGPSDetailsClicked(MouseEvent event) {
    }

    @FXML
    private void onPreviewClick(MouseEvent event) {
    }

    @FXML
    private void onBackClick(MouseEvent event) {
        try {
            ScreenController screenController = new ScreenController();
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(screenController.activate("home")));
            primaryStage.centerOnScreen();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    @FXML
    private void onLogoutClick(MouseEvent event) {
        try {
            ScreenController screenController = new ScreenController();
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(screenController.activate("login")));
            primaryStage.centerOnScreen();
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

}
