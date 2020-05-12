/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import offlineio.payload.request.MasterVersionForm;
import offlineio.payload.response.MasterVersion;
import offlineio.repository.MasterVersionDao;
import offlineio.util.StaticAppData;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class ViewMasterController implements Initializable {

    @FXML
    private TableColumn<MasterVersion, String> colSlNo;
    @FXML
    private TableColumn<MasterVersion, String> colTblName;
    @FXML
    private TableColumn<MasterVersion, String> colCurrStatus;
    @FXML
    private TableColumn<MasterVersion, String> colDeviceVersion;
    @FXML
    private TableColumn<MasterVersion, String> colServerVersion;
    @FXML
    private TableView<MasterVersion> tableView;
    @FXML
    private Label lblMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<MasterVersion> masterVersionList = MasterVersionDao.getAllMasterVersions();
        colSlNo.setCellValueFactory(new PropertyValueFactory<>("versionId"));
        colTblName.setCellValueFactory(new PropertyValueFactory<>("tableName"));
        colCurrStatus.setCellValueFactory(new PropertyValueFactory<>("isActive"));
        colDeviceVersion.setCellValueFactory(new PropertyValueFactory<>("offlineVersion"));
        colServerVersion.setCellValueFactory(new PropertyValueFactory<>("version"));
        tableView.getItems().setAll(masterVersionList);
        lblMessage.setText("Master List");
    }

    @FXML
    private void onClickLogout(MouseEvent event) {
        try {
            StaticAppData.setAuthResponse(null);
            ScreenController screenController = new ScreenController();
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(screenController.activate("login")));
            primaryStage.centerOnScreen();
        } catch (Exception e) {
            lblMessage.setText("Some error has ocurred !");
            System.out.println("Exception : " + e.getMessage());
        }
    }

    @FXML
    private void onClickBack(MouseEvent event) {
        try {
            StaticAppData.setAuthResponse(null);
            ScreenController screenController = new ScreenController();
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(screenController.activate("masterData")));
            primaryStage.centerOnScreen();
        } catch (Exception e) {
            lblMessage.setText("Some error has ocurred !");
            System.out.println("Exception : " + e.getMessage());
        }
    }

}
