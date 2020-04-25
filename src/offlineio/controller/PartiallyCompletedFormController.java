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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class PartiallyCompletedFormController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VBox vbox = new VBox();
        vbox.setPrefHeight(990);
        vbox.setPrefWidth(562);
        for (int i = 0; i < 5; i++) {
            Pane newPane = new Pane();
            newPane.setPrefHeight(198);
            newPane.setPrefWidth(562);
            newPane.setStyle("-fx-border-color: #3364FF; -fx-border-width: 2; -fx-background-color: #FFFFFF; -fx-border-radius: 10 10 10 10;");
            final int j = i;

            //MODIFY BUTTON
            Button btnModify = new Button();
            btnModify.setLayoutX(304.0);
            btnModify.setLayoutY(150.0);
            btnModify.setOnMousePressed(event -> {
                onModifyClick(event, j);
            });
            btnModify.setFont(new Font("System Bold", 12));
            btnModify.setPrefHeight(34);
            btnModify.setPrefWidth(115);
            btnModify.setStyle("-fx-background-color: #3364FF;-fx-text-fill: white");
            btnModify.setText("Modify Record");
            btnModify.setMnemonicParsing(false);
            newPane.getChildren().add(btnModify);

            //DELETE BUTTON
            Button btnDelete = new Button();
            btnDelete.setLayoutX(137.0);
            btnDelete.setLayoutY(150.0);
            btnDelete.setOnMousePressed(event -> {
                onDeleteClick(event, j);
            });
            btnDelete.setFont(new Font("System Bold", 12));
            btnDelete.setPrefHeight(34);
            btnDelete.setPrefWidth(115);
            btnDelete.setStyle("-fx-background-color: #FF0404;-fx-text-fill: white");
            btnDelete.setText("Delete Record");
            btnDelete.setMnemonicParsing(false);
            newPane.getChildren().add(btnDelete);

            // LABEL OFFLINE ID
            Label offlineId = new Label();
            offlineId.setLayoutX(46.0);
            offlineId.setLayoutY(15.0);
            offlineId.setFont(new Font("Arial Bold", 13));
            offlineId.setText("Offline Id :");
            newPane.getChildren().add(offlineId);

            // LABEL SUSPECT NAME
            Label suspectName = new Label();
            suspectName.setLayoutX(297.0);
            suspectName.setLayoutY(14.0);
            suspectName.setFont(new Font("Arial Bold", 13));
            suspectName.setText("Suspect Name :");
            newPane.getChildren().add(suspectName);

            // LABEL FATHER'S NAME
            Label fatherName = new Label();
            fatherName.setLayoutX(14.0);
            fatherName.setLayoutY(43.0);
            fatherName.setFont(new Font("Arial Bold", 13));
            fatherName.setText("Father's Name :");
            newPane.getChildren().add(fatherName);

            // LABEL REGISTERED DATE
            Label registerDate = new Label();
            registerDate.setLayoutX(289.0);
            registerDate.setLayoutY(43.0);
            registerDate.setFont(new Font("Arial Bold", 13));
            registerDate.setText("Registered Date :");
            newPane.getChildren().add(registerDate);

            // LABEL CAPTURED BY 
            Label capturedBy = new Label();
            capturedBy.setLayoutX(25.0);
            capturedBy.setLayoutY(71.0);
            capturedBy.setFont(new Font("Arial Bold", 13));
            capturedBy.setText("Captured By :");
            newPane.getChildren().add(capturedBy);

            // DYNAMIC DATA LABEL
            Label dOfflineId = new Label();
            dOfflineId.setId("dOfflineId");
            dOfflineId.setLayoutX(115.0);
            dOfflineId.setLayoutY(15.0);
            dOfflineId.setFont(new Font("Arial Bold", 13));
            dOfflineId.setPrefHeight(16);
            dOfflineId.setPrefWidth(163);
            dOfflineId.setStyle("-fx-text-fill: #807e7e");
            dOfflineId.setWrapText(true);
            dOfflineId.setText("ID-5034");
            newPane.getChildren().add(dOfflineId);
            
            Label dFatherName = new Label();
            dFatherName.setId("dFatherName");
            dFatherName.setLayoutX(115.0);
            dFatherName.setLayoutY(43.0);
            dFatherName.setFont(new Font("Arial Bold", 13));
            dFatherName.setPrefHeight(16);
            dFatherName.setPrefWidth(163);
            dFatherName.setStyle("-fx-text-fill: #807e7e");
            dFatherName.setWrapText(true);
            dFatherName.setText("S. K. SARMAH");
            newPane.getChildren().add(dFatherName);
            
            Label dCapturedBy = new Label();
            dCapturedBy.setId("dFatherName");
            dCapturedBy.setLayoutX(115.0);
            dCapturedBy.setLayoutY(71.0);
            dCapturedBy.setFont(new Font("Arial Bold", 13));
            dCapturedBy.setPrefHeight(16);
            dCapturedBy.setPrefWidth(163);
            dCapturedBy.setStyle("-fx-text-fill: #807e7e");
            dCapturedBy.setWrapText(true);
            dCapturedBy.setText("S. K. SARMAH");
            newPane.getChildren().add(dCapturedBy);
            
            Label dSuspectName = new Label();
            dSuspectName.setId("dSuspectName");
            dSuspectName.setLayoutX(399.0);
            dSuspectName.setLayoutY(15.0);
            dSuspectName.setFont(new Font("Arial Bold", 13));
            dSuspectName.setPrefHeight(16);
            dSuspectName.setPrefWidth(157);
            dSuspectName.setStyle("-fx-text-fill: #807e7e");
            dSuspectName.setWrapText(true);
            dSuspectName.setText("BHASKOR JYOTI SARMAH");
            newPane.getChildren().add(dSuspectName);
            
            Label dRegisterDate = new Label();
            dRegisterDate.setId("dSuspectName");
            dRegisterDate.setLayoutX(399.0);
            dRegisterDate.setLayoutY(43.0);
            dRegisterDate.setFont(new Font("Arial Bold", 13));
            dRegisterDate.setPrefHeight(16);
            dRegisterDate.setPrefWidth(157);
            dRegisterDate.setStyle("-fx-text-fill: #807e7e");
            dRegisterDate.setWrapText(true);
            dRegisterDate.setText("02-04-2020");
            newPane.getChildren().add(dRegisterDate);
            
            // DYNAMIC IMAGES
            ImageView img1 = new ImageView();
            img1.setId("dImg1");
            img1.setFitHeight(43);
            img1.setFitWidth(72);
            img1.setLayoutX(80.0);
            img1.setLayoutY(99.0);
            img1.setPickOnBounds(true);
            img1.setPreserveRatio(true);
            img1.setImage(new Image(getClass().getResourceAsStream("../resources/icon_done/icons_person.png")));
            newPane.getChildren().add(img1);
            
            ImageView img2 = new ImageView();
            img2.setId("dImg2");
            img2.setFitHeight(43);
            img2.setFitWidth(72);
            img2.setLayoutX(140.0);
            img2.setLayoutY(99.0);
            img2.setPickOnBounds(true);
            img2.setPreserveRatio(true);
            img2.setImage(new Image(getClass().getResourceAsStream("../resources/icon_done/icons_home_address.png")));
            newPane.getChildren().add(img2);
            
            ImageView img3 = new ImageView();
            img3.setId("dImg3");
            img3.setFitHeight(43);
            img3.setFitWidth(72);
            img3.setLayoutX(200.0);
            img3.setLayoutY(99.0);
            img3.setPickOnBounds(true);
            img3.setPreserveRatio(true);
            img3.setImage(new Image(getClass().getResourceAsStream("../resources/icon_done/icons_family.png")));
            newPane.getChildren().add(img3);
            
            ImageView img4 = new ImageView();
            img4.setId("dImg4");
            img4.setFitHeight(43);
            img4.setFitWidth(72);
            img4.setLayoutX(260.0);
            img4.setLayoutY(99.0);
            img4.setPickOnBounds(true);
            img4.setPreserveRatio(true);
            img4.setImage(new Image(getClass().getResourceAsStream("../resources/icon_done/icons_fingerprint.png")));
            newPane.getChildren().add(img4);
            
            ImageView img5 = new ImageView();
            img5.setId("dImg5");
            img5.setFitHeight(43);
            img5.setFitWidth(72);
            img5.setLayoutX(320.0);
            img5.setLayoutY(99.0);
            img5.setPickOnBounds(true);
            img5.setPreserveRatio(true);
            img5.setImage(new Image(getClass().getResourceAsStream("../resources/icon_done/icons_upload_document.png")));
            newPane.getChildren().add(img5);
            
            ImageView img6 = new ImageView();
            img6.setId("dImg6");
            img6.setFitHeight(43);
            img6.setFitWidth(72);
            img6.setLayoutX(380.0);
            img6.setLayoutY(99.0);
            img6.setPickOnBounds(true);
            img6.setPreserveRatio(true);
            img6.setImage(new Image(getClass().getResourceAsStream("../resources/icon_done/icons_user_location.png")));
            newPane.getChildren().add(img6);
            
            ImageView img7 = new ImageView();
            img7.setId("dImg7");
            img7.setFitHeight(43);
            img7.setFitWidth(72);
            img7.setLayoutX(440.0);
            img7.setLayoutY(99.0);
            img7.setPickOnBounds(true);
            img7.setPreserveRatio(true);
            img7.setImage(new Image(getClass().getResourceAsStream("../resources/icon_done/icons_preview.png")));
            newPane.getChildren().add(img7);
            
            // ADDING PANE TO VBOX
            vbox.getChildren().add(newPane);
        }
        
        // SCROLLPANE VIEW
        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setLayoutY(67);
        scrollPane.setPrefHeight(517);
        scrollPane.setPrefWidth(573);
        scrollPane.setStyle("-fx-background-color: #DCDCDC; -fx-padding: 5;");
        anchorPane.getChildren().add(scrollPane);
    }

    @FXML
    private void onBackClick(MouseEvent event) {
    }

    @FXML
    private void onLogoutClick(MouseEvent event) {
    }

    private void onModifyClick(MouseEvent event, int data) {
        System.out.println("Modify Clicked : " + data + " pressed");
//        ScreenController screenController = new ScreenController();
//        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        primaryStage.setScene(new Scene(screenController.activate("login")));
    }

    private void onDeleteClick(MouseEvent event, int data) {
        System.out.println("Delete Clicked : " + data + " pressed");
//        ScreenController screenController = new ScreenController();
//        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        primaryStage.setScene(new Scene(screenController.activate("login")));
    }
}
