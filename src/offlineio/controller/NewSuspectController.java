/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import offlineio.models.SuspectAddress;
import offlineio.models.SuspectBasicDetails;
import offlineio.payload.response.KeyValuePair;
import offlineio.repository.MasterDao;
import offlineio.repository.SuspectRepository;
import offlineio.util.Constants;
import offlineio.util.StaticAppData;
import offlineio.util.Utility;
import offlineio.util.Validations;

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
    private TextField txtFatherName;
    @FXML
    private ChoiceBox<KeyValuePair> selVillage;
    @FXML
    private Label lblTempId;
    @FXML
    private Label lblSuspectName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MasterDao dao = new MasterDao();
                List<KeyValuePair> villList = dao.getVillageList(StaticAppData.getPinThanaCode());
                villList.forEach((k) -> {
                    selVillage.getItems().add(k);
                });
            }
        });
//        lblMessage.setText("");
//        lblMessage.setVisible(false);
    }

    @FXML
    private void onSaveClick(MouseEvent event) {

        txtFirstName.getStyleClass().remove("error");
        txtMiddleName.getStyleClass().remove("error");
        txtLastName.getStyleClass().remove("error");
        txtFatherName.getStyleClass().remove("error");
        selVillage.getStyleClass().remove("error");

//        lblMessage.setText("");
//        lblMessage.setVisible(false);
        boolean res = true;
        String msg = "";
        Validations valid = new Validations();
        if (txtFirstName.getText().equals("") || !valid.checkAlphabetOnly(txtFirstName.getText())) {
            txtFirstName.getStyleClass().add("error");
            msg = "Enter a Valid First Name";
            txtFirstName.requestFocus();
            res = false;
        } else if (!txtMiddleName.getText().equals("") && !valid.checkAlphabetOnly(txtMiddleName.getText())) {
            txtMiddleName.getStyleClass().add("error");
            msg = "Enter a Valid Middle Name";
            txtMiddleName.requestFocus();
            res = false;
        } else if (txtLastName.getText().equals("") || !valid.checkAlphabetOnly(txtFirstName.getText())) {
            txtLastName.getStyleClass().add("error");
            msg = "Enter a Valid Last Name";
            txtLastName.requestFocus();
            res = false;
        } else if (txtFatherName.getText().equals("") || !valid.checkAlphabetWithSpace(txtFirstName.getText())) {
            txtFatherName.getStyleClass().add("error");
            msg = "Enter a Valid Father's Name";
            txtFatherName.requestFocus();
            res = false;
        } else if (selVillage.getValue() == null) {
            selVillage.getStyleClass().add("error");
            msg = "Please select village";
            selVillage.requestFocus();
            res = false;
        }
        if (res) {
            MasterDao masterDao = new MasterDao();
            SuspectBasicDetails suspect = new SuspectBasicDetails();
            suspect.setFirst_name(txtFirstName.getText());
            suspect.setMiddle_name(txtMiddleName.getText());
            suspect.setLast_name(txtLastName.getText());
            suspect.setFather_name(txtFatherName.getText());
            suspect.setVillage_of_detection(selVillage.getValue().getKey());

            SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmssMs");
            Calendar myCalendar = Calendar.getInstance();
            Long slnId = Long.parseLong(ft.format(myCalendar.getTime()));
            String defaultOfflineId = "" + Utility.getDeviceId().replaceAll(":", "").toUpperCase() + "-" + slnId;

            suspect.setTemp_id(defaultOfflineId);

            suspect.setCaptured_by(StaticAppData.getPinUser());
            suspect.setDevice_id(Utility.getDeviceId().toUpperCase());
            suspect.setCaptured_loc_lan("");
            suspect.setCaptured_loc_lat("");

            suspect.setIs_ready_for_sync("N");
            suspect.setSync_status("N");

            suspect.setFinal_save_basic("N");
            suspect.setFinal_save_address("N");
            suspect.setFinal_save_biometric("N");
            suspect.setFinal_save_document("N");
            suspect.setFinal_save_family("N");

            suspect.setBio_sync_status("N");
            suspect.setDoc_sync_status("N");

            String defaultaddressOfDetection = "" + Constants.ADDRESS_OF_DETECTION + "-" + slnId;
            SuspectAddress addressOfDetection = new SuspectAddress(defaultaddressOfDetection, defaultOfflineId, Constants.ADDRESS_OF_DETECTION);
            addressOfDetection.setFk_country_code(Constants.INDIA_COUNTRY_CODE);
            addressOfDetection.setFk_state_code(Constants.ASSAM_STATE_CODE);
            addressOfDetection.setFk_district_code(masterDao.getDistrictCodeByThana(StaticAppData.getPinThanaCode()));
            addressOfDetection.setFk_thana_code(StaticAppData.getPinThanaCode());

            addressOfDetection.setFk_suspect_state_code(Constants.ASSAM_STATE_CODE);
            addressOfDetection.setFk_suspect_district_code(masterDao.getDistrictCodeByThana(StaticAppData.getPinThanaCode()));
            addressOfDetection.setFk_suspect_thana_code(StaticAppData.getPinThanaCode());

            addressOfDetection.setDevice_id(Utility.getDeviceId().toUpperCase());
            addressOfDetection.setCreated_by(StaticAppData.getPinUserId());
            addressOfDetection.setCaptured_by(StaticAppData.getPinUserId());

            addressOfDetection.setFk_village_code(selVillage.getValue().getKey());
            if (SuspectRepository.saveSuspectBasic(suspect)) {
                if (SuspectRepository.saveAddress(addressOfDetection)) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Suspect Data Saved Successfully!");
                    alert.showAndWait();
                    try {
                        ScreenController screenController = new ScreenController();
                        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        primaryStage.setScene(new Scene(screenController.activate("home")));
                        primaryStage.centerOnScreen();
                    } catch (Exception e) {
                        System.out.println("Exception : " + e.getMessage());
                    }
                } else {
                    SuspectRepository.deleteSuspectBasic(suspect.getTemp_id());
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Failed Saving Data! Please try again");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Failed Saving Data! Please try again");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(msg);
            alert.showAndWait();
        }

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
