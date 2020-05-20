/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import offlineio.payload.response.DocumentModel;
import offlineio.payload.response.KeyValuePair;
import offlineio.repository.MasterDao;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class SuspectDocumentController implements Initializable {

    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane mainVbox;

    private List<KeyValuePair> docTypeList = new ArrayList<>();

    private int memberCount = 0;

    private List<DocumentModel> docList = new ArrayList<DocumentModel>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MasterDao dao = new MasterDao();
        docTypeList = dao.getDocTypeList();
    }

    @FXML
    private void onAddDocClick(MouseEvent event) {
        memberCount++;
        AnchorPane newPane = new AnchorPane();
        newPane.setPrefHeight(180);
        newPane.setPrefWidth(670.0);
//        newPane.setLayoutX((memberCount-1)*180);
        newPane.setLayoutY((memberCount - 1) * 180);
        newPane.setStyle("-fx-border-color: #3364FF; -fx-border-radius: 10 10 10 10;");
        newPane.setId("anchorPaneDoc" + memberCount);

        AnchorPane heading = new AnchorPane();
        heading.setLayoutX(3.0);
        heading.setLayoutY(2.0);
        heading.setPrefHeight(30.0);
        heading.setPrefWidth(670.0);
        heading.setStyle("-fx-background-color: #595959; -fx-background-radius: 10 10 10 10; -fx-border-radius: 10 10 10 10;");

        Label headingLabel = new Label();
        headingLabel.setAlignment(Pos.CENTER);
        headingLabel.setLayoutY(0.0);
        headingLabel.setPrefHeight(30.0);
        headingLabel.setPrefWidth(665.0);
        headingLabel.setFont(new Font("Arial Bold", 16));
        headingLabel.setText("Document Number - " + memberCount);
        headingLabel.setTextAlignment(TextAlignment.CENTER);
        headingLabel.setTextFill(Color.web("#FFFFFF"));
        headingLabel.setId("headingLabel" + memberCount);
        heading.getChildren().add(headingLabel);

        newPane.getChildren().add(heading);

        Label uploadDocLabel = new Label();
        uploadDocLabel.setLayoutX(349.0);
        uploadDocLabel.setLayoutY(56.0);
        uploadDocLabel.setPrefHeight(25.0);
        uploadDocLabel.setPrefWidth(140.0);
        uploadDocLabel.setText("Upload Document :");
        uploadDocLabel.setTextFill(Color.web("#3364ff"));
        uploadDocLabel.setId("uploadDocLabel" + memberCount);
        newPane.getChildren().add(uploadDocLabel);

        Label docTypeLabel = new Label();
        docTypeLabel.setLayoutX(14.0);
        docTypeLabel.setLayoutY(56.0);
        docTypeLabel.setPrefHeight(25.0);
        docTypeLabel.setPrefWidth(122.0);
        docTypeLabel.setText("Document Type :");
        docTypeLabel.setTextFill(Color.web("#3364ff"));
        docTypeLabel.setId("docTypeLabel" + memberCount);
        newPane.getChildren().add(docTypeLabel);

        Label docDetailsLabel = new Label();
        docDetailsLabel.setLayoutX(14.0);
        docDetailsLabel.setLayoutY(96.0);
        docDetailsLabel.setPrefHeight(25.0);
        docDetailsLabel.setPrefWidth(163.0);
        docDetailsLabel.setText("Document Remarks :");
        docDetailsLabel.setTextFill(Color.web("#3364ff"));
        docDetailsLabel.setId("docDetailsLabel" + memberCount);
        newPane.getChildren().add(docDetailsLabel);

        TextArea docDetailsTextArea = new TextArea();
        docDetailsTextArea.setLayoutX(166.0);
        docDetailsTextArea.setLayoutY(96.0);
        docDetailsTextArea.setPrefHeight(59.0);
        docDetailsTextArea.setPrefWidth(497.0);
        docDetailsTextArea.setId("docDetailsTextArea" + memberCount);
        newPane.getChildren().add(docDetailsTextArea);

        ChoiceBox<KeyValuePair> docTypeChoiceBox = new ChoiceBox();
        docTypeChoiceBox.setLayoutX(464.0);
        docTypeChoiceBox.setLayoutY(56.0);
        docTypeChoiceBox.setPrefHeight(25.0);
        docTypeChoiceBox.setPrefWidth(169);
        docTypeChoiceBox.setId("docTypeChoiceBox" + memberCount);
        docTypeList.forEach((k) -> {
            docTypeChoiceBox.getItems().add(k);
        });
        newPane.getChildren().add(docTypeChoiceBox);

        Button buttonFile = new Button();
        buttonFile.setLayoutX(123.0);
        buttonFile.setLayoutY(54.0);
        buttonFile.setPrefHeight(25.0);
        buttonFile.setPrefWidth(163);
        buttonFile.setStyle("-fx-background-color: #38BFF0;");
        buttonFile.setMnemonicParsing(false);
        buttonFile.setText("Browse Files");
        buttonFile.setTextFill(Color.web("#FFFFFF"));
        buttonFile.setFont(new Font("System Bold", 13));
        buttonFile.setId("buttonFile" + memberCount);
        buttonFile.setOnAction(e -> {
            final String id = ((Control) e.getSource()).getId().replaceAll("buttonFile", "");
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.jpg"),
                    new FileChooser.ExtensionFilter("PDF Files", "*.pdf")
            );

            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                docList.removeIf(d -> d.getId().equals(id));
                docList.add(new DocumentModel(id, selectedFile));
            }
            System.out.println("New ArrayList");
            docList.forEach(d -> System.out.println("Docuemnts - " + d.getId() + "-" + d.getFile().getAbsolutePath()));
        });
        newPane.getChildren().add(buttonFile);
        mainVbox.getChildren().add(newPane);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "New Member Added Successfully", ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    private void onRemoveDocClick(MouseEvent event) {
        int removeMember = memberCount;
        memberCount--;
        if (memberCount < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setHeaderText("No Document Present to remove !");
            alert.showAndWait();
            memberCount = 0;
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove the last document", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            final String id = String.valueOf(removeMember);
            docList.removeIf(d -> d.getId().equals(id));
            System.out.println("New ArrayList");
            docList.forEach(d -> System.out.println("Docuemnts - " + d.getId() + "-" + d.getFile().getAbsolutePath()));
            mainVbox.getChildren().remove((AnchorPane) mainVbox.lookup("#anchorPaneDoc" + removeMember));
            alert = new Alert(Alert.AlertType.CONFIRMATION, "Last Document deleted Successfully", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void onSaveDocClick(MouseEvent event) {
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
