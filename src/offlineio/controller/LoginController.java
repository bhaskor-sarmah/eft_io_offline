/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import offlineio.payload.request.LoginRequest;
import offlineio.payload.request.PasscodeRequest;
import offlineio.payload.response.JwtAuthResponse;
import offlineio.payload.response.PassCode;
import offlineio.repository.PasscodeDao;
import offlineio.util.AppSettings;
import offlineio.util.CommunicationHttpClient;
import offlineio.util.CustomHttpResponse;
import offlineio.util.StaticAppData;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtUsername;
    @FXML
    private Label errUsername;
    @FXML
    private Label errPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        errUsername.setText("");
        errPassword.setText("");
        if (StaticAppData.getMessage() != null) {
            errUsername.setText(StaticAppData.getMessage());
            StaticAppData.setMessage(null);
        }
    }

    @FXML
    private void btnLoginClick(ActionEvent event) {

        if (txtUsername.getText().equals("")) {
            errUsername.setText("Enter Username");
            txtUsername.setText("");
            txtPassword.setText("");
        } else if (txtPassword.getText().equals("")) {
            errPassword.setText("Enter Password");
            txtUsername.setText("");
            txtPassword.setText("");
        } else {
            errUsername.setText("");
            errPassword.setText("");
            LoginRequest login = new LoginRequest();
            login.setUsername(txtUsername.getText());
            login.setPassword(txtPassword.getText());
            login.setDeviceId(AppSettings.DEVICE_ID);
            login.setMacId(AppSettings.DEVICE_MAC);
            try {
                CommunicationHttpClient requestApi = new CommunicationHttpClient();
                Gson gson = new GsonBuilder().create();
                String payloadStr = gson.toJson(login);
                //System.out.println(payloadStr);
                //Gson gson2 = new Gson();
                //Error expectederr = gson2.fromJson(payloadStr, Error.class);
                CustomHttpResponse httpResponse = requestApi.sendPOST(AppSettings.LOGIN_URL, payloadStr);
                if (httpResponse.getCode() == 200) {
                    String responseStr = httpResponse.getBody();
                    if (!responseStr.equals("")) {
                        try {
                            gson = new GsonBuilder().create();
                            JwtAuthResponse authResponse = gson.fromJson(responseStr, JwtAuthResponse.class);
                            //System.out.println(gson.toJson(authResponse));
                            if (authResponse.getThana() != null) {
                                StaticAppData.setAuthResponse(authResponse);
                                PassCode[] passCode = getPassCodeSync(authResponse.getAccessToken());
                                if (passCode != null) {
                                    if (PasscodeDao.savePasscodeToDb(passCode)) {
                                        StaticAppData.setMessage("Passcode fetched successfully");
                                        StaticAppData.setColor("00A600");
                                    } else {
                                        StaticAppData.setMessage("Error fetching Passcode");
                                        StaticAppData.setColor("FE0000");
                                    }
                                    ScreenController screenController = new ScreenController();
                                    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    primaryStage.setScene(new Scene(screenController.activate(StaticAppData.getNextWindow())));
                                    primaryStage.centerOnScreen();
                                }
                            } else {
                                throw new NullPointerException();
                            }
                        } catch (JsonSyntaxException | NullPointerException e) {
                            errUsername.setText("Invalid Username or Password");
                        }
                    } else {
                        errUsername.setText("Invalid Username or Password");
                    }
                } else {
                    errUsername.setText("Some error has ocurred !");
                }
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
                errUsername.setText("Error ! Please Try Again.");
            }
        }

    }

    private PassCode[] getPassCodeSync(String jwt) {
        try {
            CommunicationHttpClient requestApi = new CommunicationHttpClient();
            Gson gson = new GsonBuilder().create();
            PasscodeRequest passCodeRequest = new PasscodeRequest();
            passCodeRequest.setDeviceId(AppSettings.DEVICE_ID);
            passCodeRequest.setMacId(AppSettings.DEVICE_MAC);
            passCodeRequest.setThanaCode(StaticAppData.getAuthResponse().getThana().getThanaCode());
            String payloadStr = gson.toJson(passCodeRequest);
            //System.out.println(payloadStr);
            //Gson gson2 = new Gson();
            //Error expectederr = gson2.fromJson(payloadStr, Error.class);
            CustomHttpResponse httpResponse = requestApi.sendPOST(AppSettings.PASSCODE_URL, payloadStr, jwt);
            if (httpResponse.getCode() == 200) {
                String responseStr = httpResponse.getBody();
                if (!responseStr.equals("")) {
                    try {
                        gson = new GsonBuilder().create();
                        PassCode[] passCode = gson.fromJson(responseStr, PassCode[].class);
                        //System.out.println(gson.toJson(passCode));
                        if (passCode[0].getDevice() != null) {
                            return passCode;
                        } else {
                            throw new NullPointerException();
                        }
                    } catch (JsonSyntaxException | NullPointerException e) {
                        System.out.println("Exception : " + e.getMessage());
                        errUsername.setText("Some error has ocurred !");
                    }
                } else {
                    errUsername.setText("Some error has ocurred !");
                }
            } else {
                // IF Status code is not 200 from server. Then jwt might has expired redirect to login page.
                errUsername.setText("Some error has ocurred !");
            }
        } catch (Exception e) {
            errUsername.setText("Network Error ! Try Sync Passcode Again");
        }
        return null;
    }
}
