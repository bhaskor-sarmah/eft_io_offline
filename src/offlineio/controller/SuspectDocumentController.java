/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
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
import offlineio.models.SuspectBasicDetails;
import offlineio.models.SuspectDoc;
import offlineio.models.SuspectDocument;
import offlineio.models.SuspectFamily;
import offlineio.payload.response.DocumentModel;
import offlineio.payload.response.KeyValuePair;
import offlineio.repository.MasterDao;
import offlineio.repository.SuspectRepository;
import offlineio.util.AppSettings;
import offlineio.util.StaticAppData;
import offlineio.util.Validations;

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

    private List<DocumentModel> docList = new ArrayList<>();
    private List<SuspectDocument> suspectDocumentList = new ArrayList<>();
    Map<Integer, String> documentList = new HashMap<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MasterDao dao = new MasterDao();
        docTypeList = dao.getDocTypeList();
        new Thread(() -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    suspectDocumentList = SuspectRepository.getSuspectDocList(StaticAppData.getModifySuspectId());
                    suspectDocumentList.forEach((f) -> {
                        doAddDocClick(f);
                    });
                }
            });
        }).start();
    }

    @FXML
    private void onAddDocClick(MouseEvent event) {
        doAddDocClick(null);
    }

    private void doAddDocClick(SuspectDocument suspectDoc) {
        memberCount++;
        AnchorPane newPane = new AnchorPane();
        newPane.setPrefHeight(200);
        newPane.setPrefWidth(670.0);
//        newPane.setLayoutX((memberCount-1)*180);
        newPane.setLayoutY((memberCount - 1) * 200);
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
        uploadDocLabel.setText("Document Type :");
        uploadDocLabel.setTextFill(Color.web("#3364ff"));
        uploadDocLabel.setId("uploadDocLabel" + memberCount);
        newPane.getChildren().add(uploadDocLabel);
        
        Label selectedDocLabel = new Label();
        selectedDocLabel.setLayoutX(14.0);
        selectedDocLabel.setLayoutY(90.0);
        selectedDocLabel.setPrefHeight(25.0);
        selectedDocLabel.setPrefWidth(122.0);
        selectedDocLabel.setText("Selected Document :");
        selectedDocLabel.setTextFill(Color.web("#3364ff"));
        selectedDocLabel.setId("selectedDocLabel" + memberCount);
        newPane.getChildren().add(selectedDocLabel);
        
        Label selectedDocPathLabel = new Label();
        selectedDocPathLabel.setLayoutX(140.0);
        selectedDocPathLabel.setLayoutY(96.0);
        selectedDocLabel.setPrefHeight(25.0);
        selectedDocLabel.setPrefWidth(497.0);
        selectedDocPathLabel.setText("No Document Selected");
        selectedDocPathLabel.setTextFill(Color.web("#3364ff"));
        selectedDocPathLabel.setId("selectedDocPathLabel" + memberCount);
        newPane.getChildren().add(selectedDocPathLabel);

        Label docTypeLabel = new Label();
        docTypeLabel.setLayoutX(14.0);
        docTypeLabel.setLayoutY(56.0);
        docTypeLabel.setPrefHeight(25.0);
        docTypeLabel.setPrefWidth(122.0);
        docTypeLabel.setText("Upload Document :");
        docTypeLabel.setTextFill(Color.web("#3364ff"));
        docTypeLabel.setId("docTypeLabel" + memberCount);
        newPane.getChildren().add(docTypeLabel);

        Label docDetailsLabel = new Label();
        docDetailsLabel.setLayoutX(14.0);
        docDetailsLabel.setLayoutY(130.0);
        docDetailsLabel.setPrefHeight(25.0);
        docDetailsLabel.setPrefWidth(163.0);
        docDetailsLabel.setText("Document Remarks :");
        docDetailsLabel.setTextFill(Color.web("#3364ff"));
        docDetailsLabel.setId("docDetailsLabel" + memberCount);
        newPane.getChildren().add(docDetailsLabel);

        TextArea docDetailsTextArea = new TextArea();
        docDetailsTextArea.setLayoutX(166.0);
        docDetailsTextArea.setLayoutY(130.0);
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
            Stage primaryStage = (Stage) mainVbox.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPEG Files", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG Files", "*.png"),
                    new FileChooser.ExtensionFilter("PDF Files", "*.pdf")
            );

            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                docList.removeIf(d -> d.getId().equals(id));
                docList.add(new DocumentModel(id, selectedFile));
                Label selectedDoc = (Label) mainVbox.lookup("#selectedDocPathLabel" + id);
                selectedDoc.setText(selectedFile.getAbsolutePath());
            }else{
                Label selectedDoc = (Label) mainVbox.lookup("#selectedDocPathLabel" + id);
                selectedDoc.setText("No Document Selected");
            }
            System.out.println("New ArrayList");
            docList.forEach(d -> System.out.println("Docuemnts - " + d.getId() + "-" + d.getFile().getAbsolutePath()));
        });
        newPane.getChildren().add(buttonFile);
        mainVbox.getChildren().add(newPane);

        if (suspectDoc == null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "New Member Added Successfully", ButtonType.OK);
            alert.showAndWait();
        } else {
            documentList.put(memberCount, suspectDoc.getDoc_id());
            if (suspectDoc.getDoc_details() != null && !suspectDoc.getDoc_details().equals("")) {
                docDetailsTextArea.setText(suspectDoc.getDoc_details());
            }
            if (suspectDoc.getFk_doc_code() != null) {
                ObservableList<KeyValuePair> keyList = docTypeChoiceBox.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(suspectDoc.getFk_doc_code())) {
                        docTypeChoiceBox.getSelectionModel().select(k);
                        break;
                    }
                }
            }
        }
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
            if (documentList.containsKey(removeMember)) {
                SuspectRepository.removeDoc(documentList.get(removeMember));
                documentList.remove(removeMember);
            }
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

    public void removeAllErrorClass() {
        for (int i = 1; i <= memberCount; i++) {
            Button buttonFile = (Button) mainVbox.lookup("#buttonFile" + i);
            TextArea docDetailsTextArea = (TextArea) mainVbox.lookup("#docDetailsTextArea" + i);
            ChoiceBox<KeyValuePair> docTypeChoiceBox = (ChoiceBox) mainVbox.lookup("#docTypeChoiceBox" + i);

            buttonFile.getStyleClass().remove("error");
            docDetailsTextArea.getStyleClass().remove("error");
            docTypeChoiceBox.getStyleClass().remove("error");
        }
    }

    @FXML
    private void onSaveDocClick(MouseEvent event) {
        removeAllErrorClass();
        if (doValidateData()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to submit the form ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                SuspectBasicDetails suspect = SuspectRepository.findSuspectById(StaticAppData.getModifySuspectId());
                List<SuspectDocument> suspectDocList = mapInputToModel(suspect);
                suspect.setFinal_save_document("Y");
                if (saveData(suspect, suspectDocList)) {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Success");
                    alert1.setHeaderText("Suspect Documents saved successfully!");
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
                    alert1.setHeaderText("Failed saving suspect documents");
                    alert1.showAndWait();
                }
            }
        }
    }

    public boolean saveData(SuspectBasicDetails suspect, List<SuspectDocument> suspectDocList) {
        boolean res = true;
        if (!SuspectRepository.updateSuspect(suspect)) {
            res = false;
        }
        for (SuspectDocument doc : suspectDocList) {
            if (!SuspectRepository.updateOrSaveDocument(doc)) {
                res = false;
            }
        }
        return res;
    }

    private boolean doValidateData() {
        boolean res = true;
        String msg = "";
        Validations valid = new Validations();
        for (int i = 1; i <= memberCount; i++) {
            Button buttonFile = (Button) mainVbox.lookup("#buttonFile" + i);
            ChoiceBox<KeyValuePair> docTypeChoiceBox = (ChoiceBox) mainVbox.lookup("#docTypeChoiceBox" + i);

            boolean docSelected = false;
            for (DocumentModel doc : docList) {
                System.out.println(doc.getId());
                if (doc.getId().equals(String.valueOf(i))) {
                    docSelected = true;
                    break;
                }
            }
            if (!docSelected) {
                buttonFile.getStyleClass().add("error");
                msg = "Please select a document for upload";
                buttonFile.requestFocus();
                res = false;
            } else if (docTypeChoiceBox.getValue() == null) {
                docTypeChoiceBox.getStyleClass().add("error");
                msg = "Please select document type";
                docTypeChoiceBox.requestFocus();
                res = false;
            }
        }

        if (!res) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(msg);
            alert.showAndWait();
        }
        return res;
    }

    private List<SuspectDocument> mapInputToModel(SuspectBasicDetails suspect) {
        List<SuspectDocument> suspectDocList = new ArrayList<>();

        MasterDao masterDao = new MasterDao();
        String pinThanaCode = StaticAppData.getPinThanaCode();
        String pinDistrictCode = masterDao.getDistrictCodeByThana(pinThanaCode);
        String pinStateCode = "18";
        Calendar myCalendar = Calendar.getInstance();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmssMs");
        Long slnId = Long.parseLong(ft.format(myCalendar.getTime()));

        for (int i = 1; i <= memberCount; i++) {

            SuspectDocument sd = new SuspectDocument();

            TextArea docDetailsTextArea = (TextArea) mainVbox.lookup("#docDetailsTextArea" + i);
            ChoiceBox<KeyValuePair> docTypeChoiceBox = (ChoiceBox) mainVbox.lookup("#docTypeChoiceBox" + i);

            sd.setFk_suspect_id(suspect.getTemp_id());
            sd.setFk_suspect_state_code(pinStateCode);
            sd.setFk_suspect_district_code(pinDistrictCode);
            sd.setFk_suspect_thana_code(pinThanaCode);
            sd.setCreated_by(StaticAppData.getPinUser());
            if (documentList.containsKey(i)) {
                sd.setDoc_id(documentList.get(i));
            } else {
                sd.setDoc_id(i + "_" + slnId);
            }
            sd.setDoc_details(docDetailsTextArea.getText());
            if (docTypeChoiceBox.getValue() != null) {
                sd.setFk_doc_code(docTypeChoiceBox.getValue().getKey());
            }
            for (DocumentModel docModel : docList) {
                if (docModel.getId().equals(String.valueOf(i))) {
                    sd.setDoc(docModel.getFile());
                    break;
                }
            }
            suspectDocList.add(sd);
        }
        return suspectDocList;
    }
}
