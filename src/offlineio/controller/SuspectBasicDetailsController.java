/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import offlineio.models.SuspectBasicDetails;
import offlineio.payload.response.KeyValuePair;
import offlineio.repository.MasterDao;
import offlineio.repository.SuspectRepository;
import offlineio.util.StaticAppData;
import offlineio.util.Utility;
import offlineio.util.Validations;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class SuspectBasicDetailsController implements Initializable {

    @FXML
    private Label lblMessage;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtMiddleName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtNickName;
    @FXML
    private TextField txtFatherName;
    @FXML
    private TextField txtMotherName;
    @FXML
    private ChoiceBox<KeyValuePair> selBoxVillage;
    @FXML
    private RadioButton rbMale;
    @FXML
    private RadioButton rbFemale;
    @FXML
    private RadioButton rbOther;
    @FXML
    private RadioButton rbNeverMarried;
    @FXML
    private RadioButton rbCurrentlyMarried;
    @FXML
    private RadioButton rbWidow;
    @FXML
    private RadioButton rbDivorced;
    @FXML
    private RadioButton rbSeparated;
    @FXML
    private CheckBox chkBoxHaveDob;
    @FXML
    private DatePicker txtDob;
    @FXML
    private TextField txtPob;
    @FXML
    private ChoiceBox<KeyValuePair> selBoxOccupation;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtMobile;
    @FXML
    private RadioButton rbPassportYes;
    @FXML
    private RadioButton rbPassportNo;
    @FXML
    private TextField txtPassportDetails;
    @FXML
    private TextField txtSuspectHeight;
    @FXML
    private TextField txtSuspectHairColor;
    @FXML
    private TextField txtSuspectEyeColor;
    @FXML
    private TextField txtSuspectComplextion;
    @FXML
    private TextArea txtAreaIdentificationMark;
    @FXML
    private TextField txtSinceWhenInIndia;
    @FXML
    private ChoiceBox<KeyValuePair> selBoxImmigrationRoute;
    @FXML
    private RadioButton rbIsVoterYes;
    @FXML
    private RadioButton rbIsVoterNo;
    @FXML
    private TextField txtVoterName;
    @FXML
    private TextField txtVoterEpic;
    @FXML
    private TextField txtVoterPart;
    @FXML
    private TextField txtVoterPartName;
    @FXML
    private RadioButton rbIsEmployeeYes;
    @FXML
    private RadioButton rbIsEmployeeNo;
    @FXML
    private ChoiceBox<KeyValuePair> selBoxEmpType;
    @FXML
    private TextField txtEmpName;
    @FXML
    private CheckBox chkLandHouse;
    @FXML
    private TextField txtLandHouseFromYear;
    @FXML
    private TextField txtDaagNo;
    @FXML
    private TextField txtPattaNo;
    @FXML
    private TextArea txtAreaLandHouseDetails;
    @FXML
    private TextField txtWitness1;
    @FXML
    private TextField txtWitness2;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private ChoiceBox<KeyValuePair> selPassportCountry;
    @FXML
    private TextField txtAge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        new Thread(() -> {

            ToggleGroup gender = new ToggleGroup();

            rbMale.setToggleGroup(gender);
            rbFemale.setToggleGroup(gender);
            rbOther.setToggleGroup(gender);

            ToggleGroup maritalStatus = new ToggleGroup();

            rbNeverMarried.setToggleGroup(maritalStatus);
            rbCurrentlyMarried.setToggleGroup(maritalStatus);
            rbWidow.setToggleGroup(maritalStatus);
            rbDivorced.setToggleGroup(maritalStatus);
            rbSeparated.setToggleGroup(maritalStatus);

            ToggleGroup passport = new ToggleGroup();
            rbPassportYes.setToggleGroup(passport);
            rbPassportNo.setToggleGroup(passport);

            ToggleGroup voter = new ToggleGroup();
            rbIsVoterYes.setToggleGroup(voter);
            rbIsVoterNo.setToggleGroup(voter);

            ToggleGroup isEmp = new ToggleGroup();
            rbIsEmployeeYes.setToggleGroup(isEmp);
            rbIsEmployeeNo.setToggleGroup(isEmp);

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    mainPane.setVisible(false);

                    // Disabling and Hiding all fields
                    chkBoxHaveDob.setSelected(false);
                    chkLandHouse.setSelected(false);
                    rbMale.setSelected(true);
                    rbNeverMarried.setSelected(true);
                    rbPassportNo.setSelected(true);
                    rbIsVoterNo.setSelected(true);
                    rbIsEmployeeNo.setSelected(true);

                    txtDob.setValue(null);
                    txtDob.setDisable(true);

                    selPassportCountry.setDisable(true);
                    txtPassportDetails.setDisable(true);

                    txtVoterName.setDisable(true);
                    txtVoterEpic.setDisable(true);
                    txtVoterPart.setDisable(true);
                    txtVoterPartName.setDisable(true);

                    selBoxEmpType.setDisable(true);
                    txtEmpName.setDisable(true);

                    txtLandHouseFromYear.setDisable(true);
                    txtDaagNo.setDisable(true);
                    txtPattaNo.setDisable(true);
                    txtAreaLandHouseDetails.setDisable(true);

                    SuspectBasicDetails suspect = SuspectRepository.findSuspectById(StaticAppData.getModifySuspectId());
                    // Populate existing data
                    populateData(suspect);

                    MasterDao dao = new MasterDao();

                    List<KeyValuePair> villList = dao.getVillageList(StaticAppData.getPinThanaCode());
                    KeyValuePair villKey = null;
                    for (KeyValuePair k : villList) {
//                    System.out.println(k.getKey()+"="+suspect.getVillage_of_detection());
                        if (k.getKey().equals(suspect.getVillage_of_detection())) {
                            villKey = k;
                        }
                        selBoxVillage.getItems().add(k);
                    }
//                System.out.println(villKey);
                    if (villKey != null) {
                        selBoxVillage.getSelectionModel().select(villKey);
                    }

                    List<KeyValuePair> occupationList = dao.getOccupationList();
                    KeyValuePair occKey = null;
                    for (KeyValuePair k : occupationList) {
                        if (k.getKey().equals(suspect.getFk_occupation_code())) {
                            occKey = k;
                        }
                        selBoxOccupation.getItems().add(k);
                    }
                    if (occKey != null) {
                        selBoxOccupation.getSelectionModel().select(occKey);
                    }

                    List<KeyValuePair> immigrationList = dao.getImmigrationList();
                    KeyValuePair immKey = null;
                    for (KeyValuePair k : immigrationList) {
                        if (k.getKey().equals(suspect.getFk_immigration_route_code())) {
                            immKey = k;
                        }
                        selBoxImmigrationRoute.getItems().add(k);
                    }
                    if (immKey != null) {
                        selBoxImmigrationRoute.getSelectionModel().select(immKey);
                    }

                    List<KeyValuePair> empTypeList = dao.getEmpTypeList();
                    KeyValuePair empKey = null;
                    for (KeyValuePair k : empTypeList) {
                        if (k.getKey().equals(suspect.getFk_employment_type_code())) {
                            empKey = k;
                        }
                        selBoxEmpType.getItems().add(k);
                    }
                    if (empKey != null) {
                        selBoxEmpType.getSelectionModel().select(empKey);
                    }
                    KeyValuePair keyIndia = new KeyValuePair("India", "India");
                    KeyValuePair keyBangla = new KeyValuePair("Bangladesh", "Bangladesh");
                    KeyValuePair keyOther = new KeyValuePair("Others", "Others");
                    selPassportCountry.getItems().add(keyIndia);
                    selPassportCountry.getItems().add(keyBangla);
                    selPassportCountry.getItems().add(keyOther);

                    if (suspect.getForeign_country_name() != null) {
                        switch (suspect.getForeign_country_name()) {
                            case "India":
                                selPassportCountry.getSelectionModel().select(keyIndia);
                                break;
                            case "Bangladesh":
                                selPassportCountry.getSelectionModel().select(keyBangla);
                                break;
                            case "Others":
                                selPassportCountry.getSelectionModel().select(keyOther);
                                break;
                            default:
                                break;
                        }
                    }

                    selBoxVillage.setDisable(true);
                    mainPane.setVisible(true);
                }
            });
        }).start();

    }

    @FXML
    private void onDobCheckBoxClick(MouseEvent event) {
        if (chkBoxHaveDob.isSelected()) {
            txtDob.setDisable(false);
            txtAge.setText("");
            txtAge.setDisable(true);
        } else {
            txtDob.setValue(null);
            txtAge.setDisable(false);
            txtDob.setDisable(true);
        }
    }

    @FXML
    private void onPassportRadioChange(MouseEvent event) {
        if (rbPassportYes.isSelected()) {
            selPassportCountry.setDisable(false);
            txtPassportDetails.setDisable(false);
        } else if (rbPassportNo.isSelected()) {
            selPassportCountry.setValue(null);
            txtPassportDetails.setText("");
            selPassportCountry.setDisable(true);
            txtPassportDetails.setDisable(true);
        }
    }

    @FXML
    private void onIsVoterChange(MouseEvent event) {
        if (rbIsVoterYes.isSelected()) {

            txtVoterName.setDisable(false);
            txtVoterEpic.setDisable(false);
            txtVoterPart.setDisable(false);
            txtVoterPartName.setDisable(false);

        } else if (rbIsVoterNo.isSelected()) {

            txtVoterName.setText("");
            txtVoterEpic.setText("");
            txtVoterPart.setText("");
            txtVoterPartName.setText("");

            txtVoterName.setDisable(true);
            txtVoterEpic.setDisable(true);
            txtVoterPart.setDisable(true);
            txtVoterPartName.setDisable(true);
        }
    }

    @FXML
    private void onIsEmpChange(MouseEvent event) {

        if (rbIsEmployeeYes.isSelected()) {

            selBoxEmpType.setDisable(false);
            txtEmpName.setDisable(false);

        } else if (rbIsEmployeeNo.isSelected()) {

            selBoxEmpType.getSelectionModel().select(null);
            txtEmpName.setText("");

            selBoxEmpType.setDisable(true);
            txtEmpName.setDisable(true);
        }

    }

    @FXML
    private void onSuspectOwnLandClick(MouseEvent event) {
        if (chkLandHouse.isSelected()) {

            txtLandHouseFromYear.setDisable(false);
            txtDaagNo.setDisable(false);
            txtPattaNo.setDisable(false);
            txtAreaLandHouseDetails.setDisable(false);

        } else {

            txtLandHouseFromYear.setText("");
            txtDaagNo.setText("");
            txtPattaNo.setText("");
            txtAreaLandHouseDetails.setText("");

            txtLandHouseFromYear.setDisable(true);
            txtDaagNo.setDisable(true);
            txtPattaNo.setDisable(true);
            txtAreaLandHouseDetails.setDisable(true);
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

    @FXML
    private void onSaveClick(MouseEvent event) {
        removeAllErrorClass();
        if (doValidateData()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to submit the form ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                SuspectBasicDetails suspect = mapInputToModel();
                suspect.setFinal_save_basic("Y");
                if (saveData(suspect)) {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Success");
                    alert1.setHeaderText("Suspect record saved successfully!");
                    alert1.showAndWait();
                    try {
                        ScreenController screenController = new ScreenController();
                        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        primaryStage.setScene(new Scene(screenController.activate("home")));
                        primaryStage.centerOnScreen();
                    } catch (Exception e) {
                        System.out.println("Exception : " + e.getMessage());
                    }
                } else {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("error");
                    alert1.setHeaderText("Failed saving suspect record");
                    alert1.showAndWait();
                }
            }
        }
    }

    @FXML
    private void onSaveAsDraftClick(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to submit the form ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            SuspectBasicDetails suspect = mapInputToModel();
            suspect.setFinal_save_basic("N");
            if (saveData(suspect)) {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Success");
                alert1.setHeaderText("Suspect Draft data saved successfully!");
                alert1.showAndWait();
                try {
                    ScreenController screenController = new ScreenController();
                    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    primaryStage.setScene(new Scene(screenController.activate("home")));
                    primaryStage.centerOnScreen();
                } catch (Exception e) {
                    System.out.println("Exception : " + e.getMessage());
                }
            } else {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("error");
                alert1.setHeaderText("Failed saving suspect draft data");
                alert1.showAndWait();
            }
        }
    }

    public void removeAllErrorClass() {
        txtFirstName.getStyleClass().remove("error");
        txtMiddleName.getStyleClass().remove("error");
        txtLastName.getStyleClass().remove("error");
        txtNickName.getStyleClass().remove("error");
        txtFatherName.getStyleClass().remove("error");
        txtMotherName.getStyleClass().remove("error");
        selBoxVillage.getStyleClass().remove("error");
        rbMale.getStyleClass().remove("error");
        rbFemale.getStyleClass().remove("error");
        rbOther.getStyleClass().remove("error");
        rbNeverMarried.getStyleClass().remove("error");
        rbCurrentlyMarried.getStyleClass().remove("error");
        rbWidow.getStyleClass().remove("error");
        rbDivorced.getStyleClass().remove("error");
        rbSeparated.getStyleClass().remove("error");
        chkBoxHaveDob.getStyleClass().remove("error");
        txtDob.getStyleClass().remove("error");
        txtPob.getStyleClass().remove("error");
        selBoxOccupation.getStyleClass().remove("error");
        txtAge.getStyleClass().remove("error");
        txtEmail.getStyleClass().remove("error");
        txtMobile.getStyleClass().remove("error");
        rbPassportYes.getStyleClass().remove("error");
        rbPassportNo.getStyleClass().remove("error");
        selPassportCountry.getStyleClass().remove("error");
        txtPassportDetails.getStyleClass().remove("error");
        txtSuspectHeight.getStyleClass().remove("error");
        txtSuspectHairColor.getStyleClass().remove("error");
        txtSuspectEyeColor.getStyleClass().remove("error");
        txtSuspectComplextion.getStyleClass().remove("error");
        txtAreaIdentificationMark.getStyleClass().remove("error");
        txtSinceWhenInIndia.getStyleClass().remove("error");
        selBoxImmigrationRoute.getStyleClass().remove("error");
        rbIsVoterYes.getStyleClass().remove("error");
        rbIsVoterNo.getStyleClass().remove("error");
        txtVoterName.getStyleClass().remove("error");
        txtVoterEpic.getStyleClass().remove("error");
        txtVoterPart.getStyleClass().remove("error");
        txtVoterPartName.getStyleClass().remove("error");
        rbIsEmployeeYes.getStyleClass().remove("error");
        rbIsEmployeeNo.getStyleClass().remove("error");
        selBoxEmpType.getStyleClass().remove("error");
        txtEmpName.getStyleClass().remove("error");
        chkLandHouse.getStyleClass().remove("error");
        txtLandHouseFromYear.getStyleClass().remove("error");
        txtDaagNo.getStyleClass().remove("error");
        txtPattaNo.getStyleClass().remove("error");
        txtAreaLandHouseDetails.getStyleClass().remove("error");
        txtWitness1.getStyleClass().remove("error");
        txtWitness2.getStyleClass().remove("error");
    }

    public void populateData(SuspectBasicDetails suspect) {
        if (suspect.getFirst_name() != null && !suspect.getFirst_name().equals("")) {
            txtFirstName.setText(suspect.getFirst_name());
        }
        if (suspect.getMiddle_name() != null && !suspect.getMiddle_name().equals("")) {
            txtMiddleName.setText(suspect.getMiddle_name());
        }
        if (suspect.getLast_name() != null && !suspect.getLast_name().equals("")) {
            txtLastName.setText(suspect.getLast_name());
        }
        if (suspect.getSuspect_alias_name() != null && !suspect.getSuspect_alias_name().equals("")) {
            txtNickName.setText(suspect.getSuspect_alias_name());
        }
        if (suspect.getFather_name() != null && !suspect.getFather_name().equals("")) {
            txtFatherName.setText(suspect.getFather_name());
        }
        if (suspect.getMother_name() != null && !suspect.getMother_name().equals("")) {
            txtMotherName.setText(suspect.getMother_name());
        }

        // Gender Block
        if (suspect.getFk_gender_code() != null) {
            switch (suspect.getFk_gender_code()) {
                case "M":
                    rbMale.setSelected(true);
                    break;
                case "F":
                    rbFemale.setSelected(true);
                    break;
                case "O":
                    rbOther.setSelected(true);
                    break;
                default:
                    break;
            }
        }
        // Maritial Status Block
        if (suspect.getFk_marital_status_code() != null) {
            switch (suspect.getFk_marital_status_code()) {
                case "1":
                    rbNeverMarried.setSelected(true);
                    break;
                case "2":
                    rbCurrentlyMarried.setSelected(true);
                    break;
                case "3":
                    rbWidow.setSelected(true);
                    break;
                case "4":
                    rbDivorced.setSelected(true);
                    break;
                case "5":
                    rbSeparated.setSelected(true);
                    break;
                default:
                    break;
            }
        }


        if (suspect.getAge() != null && !suspect.getAge().equals("")) {
            txtAge.setText(suspect.getAge());
        }
        
        if (suspect.getDate_of_birth() != null && !suspect.getDate_of_birth().equals("")) {
            chkBoxHaveDob.setSelected(true);
            txtDob.setDisable(false);
            txtAge.setText("");
            txtAge.setDisable(true);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd");
            try {
                txtDob.setValue(Utility.REVERSE_LOCAL_DATE(suspect.getDate_of_birth()));
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            }
//            txtDob.setDisable(false);
        }

        if (suspect.getPlace_of_birth() != null && !suspect.getPlace_of_birth().equals("")) {
            txtPob.setText(suspect.getPlace_of_birth());
        }

        if (suspect.getEmail() != null && !suspect.getEmail().equals("")) {
            txtEmail.setText(suspect.getEmail());
        }

        if (suspect.getMobile_no() != null && !suspect.getMobile_no().equals("")) {
            txtMobile.setText(suspect.getMobile_no());
        }

        // Foreign Passport Block
        if (suspect.getHas_foreign_passport() != null) {
            switch (suspect.getHas_foreign_passport()) {
                case "Y":
                    rbPassportYes.setSelected(true);
                    selPassportCountry.setDisable(false);
                    txtPassportDetails.setDisable(false);
                    break;
                case "N":
                    rbPassportNo.setSelected(true);
                    break;
                default:
                    break;
            }
        }

        if (suspect.getForeign_passport_details() != null && !suspect.getForeign_passport_details().equals("")) {
            txtPassportDetails.setText(suspect.getForeign_passport_details());
        }

        if (suspect.getHeight() != null && !suspect.getHeight().equals("")) {
            txtSuspectHeight.setText(suspect.getHeight());
        }

        if (suspect.getHair() != null && !suspect.getHair().equals("")) {
            txtSuspectHairColor.setText(suspect.getHair());
        }

        if (suspect.getEye() != null && !suspect.getEye().equals("")) {
            txtSuspectEyeColor.setText(suspect.getEye());
        }

        if (suspect.getComplexion() != null && !suspect.getComplexion().equals("")) {
            txtSuspectComplextion.setText(suspect.getComplexion());
        }

        if (suspect.getIdentification_mark() != null && !suspect.getIdentification_mark().equals("")) {
            txtAreaIdentificationMark.setText(suspect.getIdentification_mark());
        }

        if (suspect.getSince_when_staying() != null && !suspect.getSince_when_staying().equals("")) {
            txtSinceWhenInIndia.setText(suspect.getSince_when_staying());
        }

        // Voter Block
        if (suspect.getIs_voter() != null) {
            switch (suspect.getIs_voter()) {
                case "Y":
                    rbIsVoterYes.setSelected(true);
                    txtVoterName.setDisable(false);
                    txtVoterEpic.setDisable(false);
                    txtVoterPart.setDisable(false);
                    txtVoterPartName.setDisable(false);
                    break;
                case "N":
                    rbIsVoterNo.setSelected(true);
                    break;
                default:
                    break;
            }
        }

        if (suspect.getWhen_included_in_er() != null && !suspect.getWhen_included_in_er().equals("")) {
            txtVoterName.setText(suspect.getWhen_included_in_er());
        }

        if (suspect.getEpic_no() != null && !suspect.getEpic_no().equals("")) {
            txtVoterEpic.setText(suspect.getEpic_no());
        }

        if (suspect.getPart_no() != null && !suspect.getPart_no().equals("")) {
            txtVoterPart.setText(suspect.getPart_no());
        }

        if (suspect.getPart_name() != null && !suspect.getPart_name().equals("")) {
            txtVoterPartName.setText(suspect.getPart_name());
        }

        // Is Govt Employee
        if (suspect.getIs_employed() != null) {
            switch (suspect.getIs_employed()) {
                case "Y":
                    rbIsEmployeeYes.setSelected(true);
                    selBoxEmpType.setDisable(false);
                    txtEmpName.setDisable(false);
                    break;
                case "N":
                    rbIsEmployeeNo.setSelected(true);
                    break;
                default:
                    break;
            }
        }

        if (suspect.getEmployer_name() != null && !suspect.getEmployer_name().equals("")) {
            txtEmpName.setText(suspect.getEmployer_name());
        }

        if (suspect.getHas_land_house() != null && !suspect.getHas_land_house().equals("")) {
            if (suspect.getHas_land_house().equals("N")) {
                chkLandHouse.setSelected(false);
            } else if (suspect.getHas_land_house().equals("Y")) {
                chkLandHouse.setSelected(true);
                txtLandHouseFromYear.setDisable(false);
                txtDaagNo.setDisable(false);
                txtPattaNo.setDisable(false);
                txtAreaLandHouseDetails.setDisable(false);
            }
        }

        if (suspect.getLand_house_from() != null && !suspect.getLand_house_from().equals("")) {
            txtLandHouseFromYear.setText(suspect.getLand_house_from());
        }

        if (suspect.getLand_house_dag_no() != null && !suspect.getLand_house_dag_no().equals("")) {
            txtDaagNo.setText(suspect.getLand_house_dag_no());
        }

        if (suspect.getLand_house_patta_no() != null && !suspect.getLand_house_patta_no().equals("")) {
            txtPattaNo.setText(suspect.getLand_house_patta_no());
        }

        if (suspect.getLand_house_details() != null && !suspect.getLand_house_details().equals("")) {
            txtAreaLandHouseDetails.setText(suspect.getLand_house_details());
        }

        if (suspect.getWitness1() != null && !suspect.getWitness1().equals("")) {
            txtWitness1.setText(suspect.getWitness1());
        }

        if (suspect.getWitness2() != null && !suspect.getWitness2().equals("")) {
            txtWitness2.setText(suspect.getWitness2());
        }
    }

    private boolean doValidateData() {
        boolean res = true;
        String msg = "";
        Validations valid = new Validations();
        if (txtFirstName.getText().equals("") || !valid.checkAlphabetOnly(txtFirstName.getText())) {
            txtFirstName.getStyleClass().add("error");
            msg = "Enter a valid First Name";
            txtFirstName.requestFocus();
            res = false;
        } else if (!txtMiddleName.getText().equals("") && !valid.checkAlphabetOnly(txtMiddleName.getText())) {
            txtMiddleName.getStyleClass().add("error");
            msg = "Enter a valid Middle Name";
            txtMiddleName.requestFocus();
            res = false;
        } else if (txtLastName.getText().equals("") || !valid.checkAlphabetOnly(txtFirstName.getText())) {
            txtLastName.getStyleClass().add("error");
            msg = "Enter a valid Last Name";
            txtLastName.requestFocus();
            res = false;
        } else if (txtFatherName.getText().equals("") || !valid.checkAlphabetWithSpace(txtFirstName.getText())) {
            txtFatherName.getStyleClass().add("error");
            msg = "Enter a valid Father's Name";
            txtFatherName.requestFocus();
            res = false;
        } else if (!txtNickName.getText().equals("") && !valid.checkAlphabetWithSpace(txtNickName.getText())) {
            txtNickName.getStyleClass().add("error");
            msg = "Enter a valid Nick Name";
            txtNickName.requestFocus();
            res = false;
        } else if (!txtMotherName.getText().equals("") && !valid.checkAlphabetWithSpace(txtMotherName.getText())) {
            txtMotherName.getStyleClass().add("error");
            msg = "Enter a valid Mother's Name";
            txtMotherName.requestFocus();
            res = false;
        } else if (chkBoxHaveDob.isSelected() && txtDob.getValue() == null) {
            txtDob.getStyleClass().add("error");
            msg = "Select Date of Birth";
            txtDob.requestFocus();
            res = false;
        } else if (!chkBoxHaveDob.isSelected() && (txtAge.getText().equals("") || !valid.checkNumberWithinLength(txtAge.getText(), 0, 3))) {
            txtAge.getStyleClass().add("error");
            msg = "Enter a valid age";
            txtAge.requestFocus();
            res = false;
        } else if (!txtPob.getText().equals("") && !valid.checkAlphabetWithSpace(txtPob.getText())) {
            txtPob.getStyleClass().add("error");
            msg = "Enter a valid Place of Birth";
            txtPob.requestFocus();
            res = false;
        } else if (!txtEmail.getText().equals("") && !valid.checkEmail(txtPob.getText())) {
            txtEmail.getStyleClass().add("error");
            msg = "Enter a valid Email";
            txtEmail.requestFocus();
            res = false;
        } else if (!txtMobile.getText().equals("") && !valid.checkMobile(txtMobile.getText())) {
            txtMobile.getStyleClass().add("error");
            msg = "Enter a valid 10 digit mobile no";
            txtMobile.requestFocus();
            res = false;
        } else if (rbPassportYes.isSelected() && selPassportCountry.getValue() == null) {
            selPassportCountry.getStyleClass().add("error");
            msg = "Select country of passport";
            selPassportCountry.requestFocus();
            res = false;
        } else if (!txtPassportDetails.getText().equals("") && !valid.checkAlphabetWithNumberSpecialCharacters(txtPassportDetails.getText())) {
            txtPassportDetails.getStyleClass().add("error");
            msg = "Enter valid passport details";
            txtPassportDetails.requestFocus();
            res = false;
        } else if (!txtSuspectHeight.getText().equals("") && !valid.checkAlphaNumericWithSpace(txtSuspectHeight.getText())) {
            txtSuspectHeight.getStyleClass().add("error");
            msg = "Enter valid height";
            txtSuspectHeight.requestFocus();
            res = false;
        } else if (!txtSuspectEyeColor.getText().equals("") && !valid.checkAlphabetWithSpace(txtSuspectEyeColor.getText())) {
            txtSuspectEyeColor.getStyleClass().add("error");
            msg = "Enter valid eye color";
            txtSuspectEyeColor.requestFocus();
            res = false;
        } else if (!txtSuspectComplextion.getText().equals("") && !valid.checkAlphabetWithNumberSpecialCharacters(txtSuspectComplextion.getText())) {
            txtSuspectComplextion.getStyleClass().add("error");
            msg = "Enter valid suspect complexion";
            txtSuspectComplextion.requestFocus();
            res = false;
        } else if (!txtAreaIdentificationMark.getText().equals("") && !valid.checkAlphabetWithNumberSpecialCharacters(txtAreaIdentificationMark.getText())) {
            txtAreaIdentificationMark.getStyleClass().add("error");
            msg = "Enter valid identification mark";
            txtAreaIdentificationMark.requestFocus();
            res = false;
        } else if (!txtSinceWhenInIndia.getText().equals("") && !valid.checkNumberWithLength(txtSinceWhenInIndia.getText(), 4)) {
            txtSinceWhenInIndia.getStyleClass().add("error");
            msg = "Enter a valid year";
            txtSinceWhenInIndia.requestFocus();
            res = false;
        } else if (!txtVoterName.getText().equals("") && !valid.checkAlphaNumericWithSpace(txtVoterName.getText())) {
            txtVoterName.getStyleClass().add("error");
            msg = "Enter when name first appeared in voter list";
            txtVoterName.requestFocus();
            res = false;
        } else if (!txtVoterEpic.getText().equals("") && !valid.checkAlphabetWithNumberSpecialCharacters(txtVoterEpic.getText())) {
            txtVoterEpic.getStyleClass().add("error");
            msg = "Enter a valid voter epic no";
            txtVoterEpic.requestFocus();
            res = false;
        } else if (!txtVoterPart.getText().equals("") && !valid.checkAlphabetWithNumberSpecialCharacters(txtVoterPart.getText())) {
            txtVoterPart.getStyleClass().add("error");
            msg = "Enter a valid voter part no";
            txtVoterPart.requestFocus();
            res = false;
        } else if (!txtVoterPartName.getText().equals("") && !valid.checkAlphabetWithNumberSpecialCharacters(txtVoterPartName.getText())) {
            txtVoterPartName.getStyleClass().add("error");
            msg = "Enter a valid voter part name";
            txtVoterPartName.requestFocus();
            res = false;
        } else if (rbIsEmployeeYes.isSelected() && selBoxEmpType.getValue() == null) {
            selBoxEmpType.getStyleClass().add("error");
            msg = "Select employer type";
            selBoxEmpType.requestFocus();
            res = false;
        } else if (!txtEmpName.getText().equals("") && !valid.checkAlphabetWithSpecialCharacters(txtEmpName.getText())) {
            txtEmpName.getStyleClass().add("error");
            msg = "Enter a valid employer name";
            txtEmpName.requestFocus();
            res = false;
        } else if (!txtLandHouseFromYear.getText().equals("") && !valid.checkNumberWithLength(txtLandHouseFromYear.getText(), 4)) {
            txtLandHouseFromYear.getStyleClass().add("error");
            msg = "Enter a valid year";
            txtLandHouseFromYear.requestFocus();
            res = false;
        } else if (!txtDaagNo.getText().equals("") && !valid.checkAlphabetWithNumberSpecialCharacters(txtDaagNo.getText())) {
            txtDaagNo.getStyleClass().add("error");
            msg = "Enter a valid daag no";
            txtDaagNo.requestFocus();
            res = false;
        } else if (!txtPattaNo.getText().equals("") && !valid.checkAlphabetWithNumberSpecialCharacters(txtPattaNo.getText())) {
            txtPattaNo.getStyleClass().add("error");
            msg = "Enter a valid patta no";
            txtPattaNo.requestFocus();
            res = false;
        } else if (!txtWitness1.getText().equals("") && !valid.checkAlphabetWithSpace(txtWitness1.getText())) {
            txtWitness1.getStyleClass().add("error");
            msg = "Enter a valid 1st Witness name";
            txtWitness1.requestFocus();
            res = false;
        } else if (!txtWitness2.getText().equals("") && !valid.checkAlphabetWithSpace(txtWitness2.getText())) {
            txtWitness2.getStyleClass().add("error");
            msg = "Enter a valid 2nd Witness name";
            txtWitness2.requestFocus();
            res = false;
        }
        if (!res) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(msg);
            alert.showAndWait();
        }
        return res;
    }

    private SuspectBasicDetails mapInputToModel() {
        SuspectBasicDetails suspect = SuspectRepository.findSuspectById(StaticAppData.getModifySuspectId());

        suspect.setFirst_name(txtFirstName.getText());
        suspect.setMiddle_name(txtMiddleName.getText());
        suspect.setLast_name(txtLastName.getText());
        suspect.setSuspect_alias_name(txtNickName.getText());
        suspect.setFather_name(txtFatherName.getText());
        suspect.setMother_name(txtMotherName.getText());

        if (rbMale.isSelected()) {
            suspect.setFk_gender_code("M");
        } else if (rbFemale.isSelected()) {
            suspect.setFk_gender_code("F");
        } else if (rbOther.isSelected()) {
            suspect.setFk_gender_code("O");
        }

        if (rbNeverMarried.isSelected()) {
            suspect.setFk_marital_status_code("1");
        } else if (rbCurrentlyMarried.isSelected()) {
            suspect.setFk_marital_status_code("2");
        } else if (rbWidow.isSelected()) {
            suspect.setFk_marital_status_code("3");
        } else if (rbDivorced.isSelected()) {
            suspect.setFk_marital_status_code("4");
        } else if (rbSeparated.isSelected()) {
            suspect.setFk_marital_status_code("5");
        }
        if (chkBoxHaveDob.isSelected()) {
            System.out.println(txtDob.getValue().format(DateTimeFormatter.ISO_DATE));
            suspect.setDate_of_birth(txtDob.getValue().format(DateTimeFormatter.ISO_DATE));
        } else {
            suspect.setAge(txtAge.getText());
        }

        suspect.setPlace_of_birth(txtPob.getText());
        if (selBoxOccupation.getValue() != null) {
            suspect.setFk_occupation_code(selBoxOccupation.getValue().getKey());
        }

        suspect.setEmail(txtEmail.getText());
        suspect.setMobile_no(txtMobile.getText());

        if (rbPassportYes.isSelected()) {
            suspect.setHas_foreign_passport("Y");
            if (selPassportCountry.getValue() != null) {
                suspect.setForeign_country_name(selPassportCountry.getValue().getKey());
            }
            suspect.setForeign_passport_details(txtPassportDetails.getText());
        } else if (rbPassportNo.isSelected()) {
            suspect.setHas_foreign_passport("N");
        }

        suspect.setHeight(txtSuspectHeight.getText());
        suspect.setHair(txtSuspectHairColor.getText());
        suspect.setEye(txtSuspectEyeColor.getText());
        suspect.setComplexion(txtSuspectComplextion.getText());
        suspect.setIdentification_mark(txtAreaIdentificationMark.getText());
        suspect.setSince_when_staying(txtSinceWhenInIndia.getText());

        if (selBoxImmigrationRoute.getValue() != null) {
            suspect.setFk_immigration_route_code(selBoxImmigrationRoute.getValue().getKey());
        }

        if (rbIsVoterYes.isSelected()) {
            suspect.setIs_voter("Y");
            suspect.setWhen_included_in_er(txtVoterName.getText());
            suspect.setEpic_no(txtVoterEpic.getText());
            suspect.setPart_no(txtVoterPart.getText());
            suspect.setPart_name(txtVoterPartName.getText());
        } else if (rbIsVoterNo.isSelected()) {
            suspect.setIs_voter("N");
        }

        if (rbIsEmployeeYes.isSelected()) {
            suspect.setIs_employed("Y");
            if (selBoxEmpType.getValue() != null) {
                suspect.setFk_employment_type_code(selBoxEmpType.getValue().getKey());
            }
            suspect.setEmployer_name(txtEmpName.getText());
        } else if (rbIsEmployeeNo.isSelected()) {
            suspect.setIs_employed("N");
        }
        if (chkLandHouse.isSelected()) {
            suspect.setHas_land_house("Y");
            suspect.setLand_house_from(txtLandHouseFromYear.getText());
            suspect.setLand_house_dag_no(txtDaagNo.getText());
            suspect.setLand_house_patta_no(txtPattaNo.getText());
            suspect.setLand_house_details(txtAreaLandHouseDetails.getText());
        } else {
            suspect.setHas_land_house("N");
        }
        suspect.setWitness1(txtWitness1.getText());
        suspect.setWitness2(txtWitness2.getText());

        return suspect;
    }

    public boolean saveData(SuspectBasicDetails suspect) {
        return SuspectRepository.updateSuspect(suspect);
    }

}
