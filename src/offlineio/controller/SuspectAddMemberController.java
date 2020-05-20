/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import offlineio.payload.response.KeyValuePair;
import offlineio.repository.MasterDao;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class SuspectAddMemberController implements Initializable {

    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane mainVbox;

    private List<KeyValuePair> relationList = new ArrayList<>();

    private int memberCount = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MasterDao dao = new MasterDao();
        relationList = dao.getRelationList();
    }

    @FXML
    private void onSaveClick(MouseEvent event) {
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
    private void onAddMemberClick(MouseEvent event) {
        memberCount++;
        AnchorPane newPane = new AnchorPane();
        newPane.setPrefHeight(180);
        newPane.setPrefWidth(979);
        newPane.setLayoutY((memberCount - 1) * 180);
        newPane.setStyle("-fx-border-color: #3364FF; -fx-border-radius: 10 10 10 10;");
        newPane.setId("anchorPaneMem" + memberCount);

        AnchorPane heading = new AnchorPane();
        heading.setLayoutX(3.0);
        heading.setLayoutY(4.0);
        heading.setPrefHeight(30.0);
        heading.setPrefWidth(980.0);
        heading.setStyle("-fx-background-color: #595959; -fx-background-radius: 10 10 10 10; -fx-border-radius: 10 10 10 10;");

        Label headingLabel = new Label();
        headingLabel.setAlignment(Pos.CENTER);
        headingLabel.setLayoutY(5.0);
        headingLabel.setPrefHeight(20.0);
        headingLabel.setPrefWidth(980.0);
        headingLabel.setFont(new Font("Arial Bold", 16));
        headingLabel.setText("Family Member - " + memberCount);
        headingLabel.setTextAlignment(TextAlignment.CENTER);
        headingLabel.setTextFill(Color.web("#FFFFFF"));
        headingLabel.setId("headingLabel" + memberCount);
        heading.getChildren().add(headingLabel);

        newPane.getChildren().add(heading);
        Label familyNameLabel = new Label();
        familyNameLabel.setLayoutX(24.0);
        familyNameLabel.setLayoutY(56.0);
        familyNameLabel.setPrefHeight(25.0);
        familyNameLabel.setPrefWidth(134.0);
        familyNameLabel.setText("Family Member Name *");
        familyNameLabel.setTextFill(Color.web("#e40000"));
        familyNameLabel.setFont(new Font("Arial Bold", 12));
        familyNameLabel.setId("familyNameLabel" + memberCount);
        newPane.getChildren().add(familyNameLabel);
        Label relationLabel = new Label();
        relationLabel.setLayoutX(26.0);
        relationLabel.setLayoutY(97.0);
        relationLabel.setPrefHeight(43.0);
        relationLabel.setPrefWidth(130.0);
        relationLabel.setWrapText(true);
        relationLabel.setFont(new Font("Arial Bold", 12));
        relationLabel.setText("Select Relation with Suspect");
        relationLabel.setTextFill(Color.web("#2908ab"));
        relationLabel.setId("relationLabel" + memberCount);
        newPane.getChildren().add(relationLabel);

        Label genderLabel = new Label();
        genderLabel.setLayoutX(712.0);
        genderLabel.setLayoutY(90.0); 
        genderLabel.setPrefHeight(25.0);
        genderLabel.setPrefWidth(71.0);
        genderLabel.setFont(new Font("Arial Bold", 12));
        genderLabel.setText("Gender *");
        genderLabel.setTextFill(Color.web("#e40000"));
        genderLabel.setId("genderLabel" + memberCount);
        newPane.getChildren().add(genderLabel);

        Label dobLabel = new Label();
        dobLabel.setLayoutX(385.0);
        dobLabel.setLayoutY(94.0);
        dobLabel.setPrefHeight(25.0);
        dobLabel.setPrefWidth(86.0);
        dobLabel.setFont(new Font("Arial Bold", 12));
        dobLabel.setText("Date of Birth");
        dobLabel.setTextFill(Color.web("#2908ab"));
        dobLabel.setId("dobLabel" + memberCount);
        newPane.getChildren().add(dobLabel);

        Label pobLabel = new Label();
        pobLabel.setLayoutX(699.0);
        pobLabel.setLayoutY(56.0);
        pobLabel.setText("Place of Birth");
        pobLabel.setPrefHeight(25.0);
        pobLabel.setPrefWidth(86.0);
        pobLabel.setFont(new Font("Arial Bold", 12));
        pobLabel.setTextFill(Color.web("#2908ab"));
        pobLabel.setId("pobLabel" + memberCount);
        newPane.getChildren().add(pobLabel);

        Label ageLabel = new Label();
        ageLabel.setLayoutX(434.0);
        ageLabel.setLayoutY(134.0);
        ageLabel.setText("Age");
        ageLabel.setPrefHeight(25.0);
        ageLabel.setPrefWidth(30.0);
        ageLabel.setFont(new Font("Arial Bold", 12));
        ageLabel.setTextFill(Color.web("#2908ab"));
        ageLabel.setId("ageLabel" + memberCount);
        newPane.getChildren().add(ageLabel);
                             
        TextField nameTxt = new TextField();
        nameTxt.setLayoutX(161.0);
        nameTxt.setLayoutY(56.0);
        nameTxt.setPrefHeight(25.0);
        nameTxt.setPrefWidth(184);
        nameTxt.setId("nameTxt" + memberCount);
        newPane.getChildren().add(nameTxt);

        TextField ageTxt = new TextField();
        ageTxt.setLayoutX(472.0);
        ageTxt.setLayoutY(134.0);
        ageTxt.setPrefHeight(25.0);
        ageTxt.setPrefWidth(171);
        ageTxt.setId("ageTxt" + memberCount);
        newPane.getChildren().add(ageTxt);

        TextField pobTxt = new TextField();
        pobTxt.setLayoutX(787.0);
        pobTxt.setLayoutY(56.0);
        pobTxt.setPrefHeight(25.0);
        pobTxt.setPrefWidth(184);
        pobTxt.setId("pobTxt" + memberCount);
        newPane.getChildren().add(pobTxt);
// 
        RadioButton maleRadio = new RadioButton();
        maleRadio.setId("maleRadio" + memberCount);
        maleRadio.setLayoutX(787.0);
        maleRadio.setLayoutY(93.0);
        maleRadio.setMnemonicParsing(false);
        maleRadio.setSelected(true);
        maleRadio.setText("Male");

        RadioButton femaleRadio = new RadioButton();
        femaleRadio.setId("maleRadio" + memberCount);
        femaleRadio.setLayoutX(787.0);
        femaleRadio.setLayoutY(118.0);
        femaleRadio.setMnemonicParsing(false);
        femaleRadio.setText("Female");

        RadioButton otherRadio = new RadioButton();
        otherRadio.setId("otherRadio" + memberCount);
        otherRadio.setLayoutX(787.0);
        otherRadio.setLayoutY(144.0);
        otherRadio.setMnemonicParsing(false);
        otherRadio.setText("Others");

        ToggleGroup genderTg = new ToggleGroup();
        maleRadio.setToggleGroup(genderTg);
        femaleRadio.setToggleGroup(genderTg);
        otherRadio.setToggleGroup(genderTg);

        newPane.getChildren().add(maleRadio);
        newPane.getChildren().add(femaleRadio);
        newPane.getChildren().add(otherRadio);

        DatePicker dobDatePicker = new DatePicker();
        dobDatePicker.setId("dobDatePicker" + memberCount);
        dobDatePicker.setLayoutX(471.0);
        dobDatePicker.setLayoutY(94.0);
        dobDatePicker.setPrefHeight(25.0);
        dobDatePicker.setPrefWidth(171);
        dobDatePicker.setDisable(true);
        newPane.getChildren().add(dobDatePicker);

        ChoiceBox<KeyValuePair> relationChoiceBox = new ChoiceBox();
        relationChoiceBox.setLayoutX(161.0);
        relationChoiceBox.setLayoutY(98.0);
        relationChoiceBox.setPrefHeight(25.0);
        relationChoiceBox.setPrefWidth(184);
        relationChoiceBox.setId("relationChoiceBox" + memberCount);
        relationList.forEach((k) -> {
            relationChoiceBox.getItems().add(k);
        });
        newPane.getChildren().add(relationChoiceBox);

        CheckBox haveDobCheckBox = new CheckBox();
        haveDobCheckBox.setLayoutX(470.0);
        haveDobCheckBox.setLayoutY(61.0);
        haveDobCheckBox.setMnemonicParsing(false);
        haveDobCheckBox.setFont(new Font("Arial Bold", 12));
        haveDobCheckBox.setOnMouseClicked((MouseEvent me) -> {
            onDobCheckBoxClick(me);
        });
        haveDobCheckBox.setId("haveDobCheckBox" + memberCount);
        haveDobCheckBox.setText("Have Date of Birth");
        newPane.getChildren().add(haveDobCheckBox);

//        mainVbox.setPrefHeight(memberCount*180);
        mainVbox.getChildren().add(newPane);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "New Member Added Successfully", ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    private void onRemoveMemberClick(MouseEvent event) {
        int removeMember = memberCount;
        memberCount--;
        if (memberCount < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("No Member Present to remove !");
            alert.showAndWait();
            memberCount = 0;
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove the last member", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            mainVbox.getChildren().remove((AnchorPane) mainVbox.lookup("#anchorPaneMem" + removeMember));
            alert = new Alert(Alert.AlertType.CONFIRMATION, "Last Member deleted Successfully", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void onDobCheckBoxClick(MouseEvent event) {
        String id = ((Control) event.getSource()).getId();
        id = id.replaceAll("haveDobCheckBox", "");
        CheckBox chk = (CheckBox) mainVbox.lookup("#haveDobCheckBox" + id);
        TextField age = (TextField) mainVbox.lookup("#ageTxt" + id);
        DatePicker dob = (DatePicker) mainVbox.lookup("#dobDatePicker" + id);
        if (chk.isSelected()) {
            age.setDisable(true);
            dob.setDisable(false);
        } else {
            age.setDisable(false);
            dob.setDisable(true);
        }
    }
}
