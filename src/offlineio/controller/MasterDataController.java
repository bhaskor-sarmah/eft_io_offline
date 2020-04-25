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
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import offlineio.payload.request.MasterVersionForm;
import offlineio.payload.request.MasterVersionRequest;
import offlineio.payload.request.PasscodeRequest;
import offlineio.payload.response.District;
import offlineio.payload.response.MasterDataResponse;
import offlineio.payload.response.MasterVersion;
import offlineio.payload.response.PassCode;
import offlineio.repository.MasterDataDao;
import offlineio.repository.MasterVersionDao;
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
public class MasterDataController implements Initializable {

    @FXML
    private ProgressBar barProgress;
    @FXML
    private TextArea progressTxt;

    float progress = 0.015F;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (StaticAppData.getMessage() != null) {
//            progressTxt.setTextFill(Color.web("#" + StaticAppData.getColor()));
            progressTxt.appendText(StaticAppData.getMessage() + "\n");
            StaticAppData.setMessage(null);
        }
    }

    @FXML
    private void onChangePwdClick(MouseEvent event) {
        ScreenController screenController = new ScreenController();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(screenController.activate("resetPassword")));
    }

    @FXML
    private void onClickSyncMasterData(MouseEvent event) {
        progressTxt.setText("");
        barProgress.setProgress(0.00F);
        new Thread(() -> {
            try {
                Platform.runLater(() -> {
                    progressTxt.appendText("Fetching MasterVersion\n");
                    barProgress.setProgress(0.10F);
                });

                MasterVersion[] masterVersion = getMasterVersion(StaticAppData.getAuthResponse().getAccessToken());

                if (masterVersion == null) {
                    progressTxt.appendText("Error fetching MasterVersion\n");
                    barProgress.setProgress(0.0F);
                    return;
                }

                List<MasterVersionForm> masterVersionForm = MasterVersionDao.saveMasterVersion(masterVersion);

                Platform.runLater(() -> {
                    progressTxt.appendText("Fetching MasterVersion Completed\n");
                    barProgress.setProgress(0.20F);
                });

                if (masterVersionForm == null || masterVersionForm.isEmpty()) {
                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#FE0000"));
                        progressTxt.appendText("Error saving MasterVersion\n");
                        barProgress.setProgress(0.0F);
                    });
                } else {
                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("MasterVersion fetched Successfully !\n Now fetching Master Data\n");
                        barProgress.setProgress(0.30F);
                    });

                    MasterVersionRequest masterVersionReq = new MasterVersionRequest();
                    masterVersionReq.setDeviceId(AppSettings.DEVICE_ID);
                    masterVersionReq.setMacId(AppSettings.DEVICE_MAC);
                    masterVersionReq.setMasterVersionForm(masterVersionForm);
                    Gson gson = new GsonBuilder().create();
                    MasterDataResponse masterData = gson.fromJson(getAllMasters(masterVersionReq, StaticAppData.getAuthResponse().getAccessToken()), MasterDataResponse.class);

                    if (masterVersionReq == null) {
                        progressTxt.appendText("Error fetching Master Data\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Master Data fetched Successfully !\n Now Saving Address Master\n");
                        barProgress.setProgress(0.60F);
                    });

                    if (!MasterDataDao.saveAddressType(masterData.getAddressTypeList())) {
                        progressTxt.appendText("Error Saving Address Master\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Country Master\n");
                        barProgress.setProgress(0.62F);
                    });

                    if (!MasterDataDao.saveMasterCountry(masterData.getCountryList())) {
                        progressTxt.appendText("Error Saving Country Master\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving State Master\n");
                        barProgress.setProgress(0.66F);
                    });

                    if (!MasterDataDao.saveMasterState(masterData.getStateList())) {
                        progressTxt.appendText("Error Saving State Master\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving District Master\n");
                        barProgress.setProgress(0.70F);
                    });

                    if (!MasterDataDao.saveMasterState(masterData.getStateList())) {
                        progressTxt.appendText("Error Saving District Master\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Thana Master\n");
                        barProgress.setProgress(0.74F);
                    });

                    if (!MasterDataDao.saveMasterThana(masterData.getThanaList())) {
                        progressTxt.appendText("Error Saving Thana Master\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving LAC Master\n");
                        barProgress.setProgress(0.78F);
                    });

                    if (!MasterDataDao.saveMasterLac(masterData.getLacList())) {
                        progressTxt.appendText("Error Saving LAC Master\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Relation Master\n");
                        barProgress.setProgress(0.82F);
                    });

                    if (!MasterDataDao.saveMasterRelation(masterData.getRelationList())) {
                        progressTxt.appendText("Error Saving Relation Master\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Gender Master\n");
                        barProgress.setProgress(0.86F);
                    });

                    if (!MasterDataDao.saveMasterGender(masterData.getGenderList())) {
                        progressTxt.appendText("Error Saving Gender Master\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Master Maritial Status\n");
                        barProgress.setProgress(0.90F);
                    });

                    if (!MasterDataDao.saveMaritalStatus(masterData.getMaritalStatusList())) {
                        progressTxt.appendText("Error Saving Master Maritial Status\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Master Occupation\n");
                        barProgress.setProgress(0.92F);
                    });

                    if (!MasterDataDao.saveMasterOccupation(masterData.getOccupationList())) {
                        progressTxt.appendText("Error Saving Master Occupation\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Master Religion\n");
                        barProgress.setProgress(0.94F);
                    });

                    if (!MasterDataDao.saveMasterReligion(masterData.getReligionList())) {
                        progressTxt.appendText("Error Saving Master Religion\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Master Document\n");
                        barProgress.setProgress(0.96F);
                    });

                    if (!MasterDataDao.saveMasterDocument(masterData.getDocList())) {
                        progressTxt.appendText("Error Saving Master Document\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Master Employee Type\n");
                        barProgress.setProgress(0.98F);
                    });

                    if (!MasterDataDao.saveMasterEmploymentType(masterData.getEmployementTypeList())) {
                        progressTxt.appendText("Error Saving Master Employee Type\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Now Saving Master Route\n");
                        barProgress.setProgress(0.99F);
                    });

                    if (!MasterDataDao.saveMasterRoute(masterData.getRouteList())) {
                        progressTxt.appendText("Error Saving Master Route\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    if (!MasterVersionDao.updateAllOnlineVersion()) {
                        progressTxt.appendText("Error Updating Master Version\n");
                        barProgress.setProgress(0.0F);
                        return;
                    }

                    Platform.runLater(() -> {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                        progressTxt.appendText("Saving Master Data completed\n");
                        barProgress.setProgress(1.00F);
                    });
                }
            } catch (Exception e) {
                progressTxt.appendText("Some Error has ocurred\n");
                System.out.println("Exception: " + e.getMessage());
                barProgress.setProgress(0.00F);
            }
        }).start();

    }

    @FXML
    private void onClickSyncVillageData(MouseEvent event) {
        progressTxt.setText("");
        this.progress = 0.015F;
        new Thread(() -> {
            try {
                List<District> districtList = MasterDataDao.getAllDistrict();
                districtList.forEach((d) -> {
                    this.progress += 0.015F;
                    Platform.runLater(() -> {
                        progressTxt.appendText("Fetching Village Data for District - " + d.getDistrictName() + "\n");
                        barProgress.setProgress(this.progress);
                    });
                    String req = "{\n"
                            + "	\"districtCode\":\"" + d.getDistrictCode() + "\",\n"
                            + "	\"version\":\"" + d.getVersion() + "\"\n"
                            + "}";
                    Gson gson = new GsonBuilder().create();
                    MasterDataResponse masterData = gson.fromJson(getVillage(req, StaticAppData.getAuthResponse().getAccessToken()), MasterDataResponse.class);
                    if (masterData == null) {
                        progressTxt.appendText("Fetching Village Data Error\n");
                        barProgress.setProgress(0.00F);
                        return;
                    }
                    this.progress += 0.015F;
                    Platform.runLater(() -> {
                        progressTxt.appendText("Fetching Village Data for District - " + d.getDistrictName() + " Completed\nNow saving... \n");
                        barProgress.setProgress(this.progress);
                    });

                    if (!MasterDataDao.saveMasterVillage(masterData.getVillageList())) {
                        progressTxt.appendText("Saving Village Data Error\n");
                        barProgress.setProgress(0.00F);
                        return;
                    }
                    this.progress += 0.015F;
                    Platform.runLater(() -> {
                        progressTxt.appendText("Saving Village Data for District - " + d.getDistrictName() + " Completed\n");
                        barProgress.setProgress(this.progress);
                    });
                });
            } catch (Exception e) {
                progressTxt.appendText("Some Error has ocurred\n");
                System.out.println("Exception: " + e.getMessage());
                barProgress.setProgress(0.00F);
            }
        }).start();
    }

    @FXML
    private void onClickViewMasterData(MouseEvent event) {
        try {
            StaticAppData.setAuthResponse(null);
            ScreenController screenController = new ScreenController();
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(screenController.activate("masterVersion")));
        } catch (Exception e) {
//            lblProgress.setTextFill(Color.web("#FE0000"));
            progressTxt.setText("Some Error has Ocurred !\n");
            System.out.println("Exception : " + e.getMessage());
        }  
    }

    @FXML
    private void onClickSyncPasscode(MouseEvent event) {
        try {
            PassCode[] passCode = getPassCodeSync(StaticAppData.getAuthResponse().getAccessToken());
            if (passCode != null) {
                if (PasscodeDao.savePasscodeToDb(passCode)) {
//                    lblProgress.setTextFill(Color.web("#00A600"));
                    progressTxt.appendText("Passcode fetched successfully\n");
                } else {
//                    lblProgress.setTextFill(Color.web("#FE0000"));
                    progressTxt.appendText("Error fetching Passcode\n");
                }
            }
        } catch (Exception e) {
//            lblProgress.setTextFill(Color.web("#FE0000"));
            progressTxt.setText("Error fetching Passcode\n");
            System.out.println("Exception : " + e.getMessage());
        }
    }

    @FXML
    private void onClickAssignPasscode(MouseEvent event) {

    }

    @FXML
    private void onClickBack(MouseEvent event) {
        try {
            StaticAppData.setAuthResponse(null);
            ScreenController screenController = new ScreenController();
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(screenController.activate("login")));
        } catch (Exception e) {
//            lblProgress.setTextFill(Color.web("#FE0000"));
            progressTxt.setText("Some Error has Ocurred !\n");
            System.out.println("Exception : " + e.getMessage());
        }
    }

    @FXML
    private void onLogoutClick(MouseEvent event) {
        try {
            StaticAppData.setAuthResponse(null);
            ScreenController screenController = new ScreenController();
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(screenController.activate("login")));
        } catch (Exception e) {
//            lblProgress.setTextFill(Color.web("#FE0000"));
            progressTxt.setText("Some Error has Ocurred !\n");
            System.out.println("Exception : " + e.getMessage());
        }
    }

    private MasterVersion[] getMasterVersion(String jwt) {
        try {
            CommunicationHttpClient requestApi = new CommunicationHttpClient();
            Gson gson = new GsonBuilder().create();
            String payloadStr = "";
            //System.out.println(payloadStr);
            //Gson gson2 = new Gson();
            //Error expectederr = gson2.fromJson(payloadStr, Error.class);
            CustomHttpResponse httpResponse = requestApi.sendPOST(AppSettings.MASTER_VERSION_URL, payloadStr, jwt);
            if (httpResponse.getCode() == 200) {
                String responseStr = httpResponse.getBody();
                if (!responseStr.equals("")) {
                    try {
                        gson = new GsonBuilder().create();
                        MasterVersion[] masterVersion = gson.fromJson(responseStr, MasterVersion[].class);
                        //System.out.println(gson.toJson(passCode));
                        if (masterVersion[0].getIsActive() != null) {
                            return masterVersion;
                        } else {
                            throw new NullPointerException();
                        }
                    } catch (JsonSyntaxException | NullPointerException e) {
                        System.out.println("Exception : " + e.getMessage());
//                        errUsername.setText("Some error has ocurred !");
                    }
                } else {
//                    errUsername.setText("Some error has ocurred !");
                }
            } else {
                // IF Status code is not 200 from server. Then jwt might has expired redirect to login page.
//                errUsername.setText("Some error has ocurred !");
            }
        } catch (Exception e) {
//            errUsername.setText("Network Error ! Try Sync Passcode Again");
        }
        return null;
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
                    }
                } else {
                }
            } else {
                // IF Status code is not 200 from server. Then jwt might has expired redirect to login page.
            }
        } catch (Exception e) {
        }
        return null;
    }

    private String getAllMasters(MasterVersionRequest masterVersionRequest, String jwt) {
        try {
            CommunicationHttpClient requestApi = new CommunicationHttpClient();
            Gson gson = new GsonBuilder().create();
            String payloadStr = gson.toJson(masterVersionRequest);
            //System.out.println(payloadStr);
            //Gson gson2 = new Gson();
            //Error expectederr = gson2.fromJson(payloadStr, Error.class);
            CustomHttpResponse httpResponse = requestApi.sendPOST(AppSettings.MASTER_DATA_URL, payloadStr, jwt);
            if (httpResponse.getCode() == 200) {
                String responseStr = httpResponse.getBody();
                if (!responseStr.equals("")) {
                    return responseStr;
//                    try {
//                        gson = new GsonBuilder().create();
//                        PassCode[] passCode = gson.fromJson(responseStr, PassCode[].class);
//                        //System.out.println(gson.toJson(passCode));
//                        if (passCode[0].getDevice() != null) {
//                            return passCode;
//                        } else {
//                            throw new NullPointerException();
//                        }
//                    } catch (JsonSyntaxException | NullPointerException e) {
//                        System.out.println("Exception : " + e.getMessage());
//                    }
                } else {
                }
            } else {
                // IF Status code is not 200 from server. Then jwt might has expired redirect to login page.
            }
        } catch (Exception e) {
        }
        return null;
    }

    private String getVillage(String req, String jwt) {
        try {
            CommunicationHttpClient requestApi = new CommunicationHttpClient();
//            Gson gson = new GsonBuilder().create();
            String payloadStr = req;
            //System.out.println(payloadStr);
            //Gson gson2 = new Gson();
            //Error expectederr = gson2.fromJson(payloadStr, Error.class);
            CustomHttpResponse httpResponse = requestApi.sendPOST(AppSettings.VILLAGE_DATA_URL, payloadStr, jwt);
            if (httpResponse.getCode() == 200) {
                String responseStr = httpResponse.getBody();
                if (!responseStr.equals("")) {
                    return responseStr;
                } else {
                }
            } else {
                // IF Status code is not 200 from server. Then jwt might has expired redirect to login page.
            }
        } catch (Exception e) {
        }
        return null;
    }

}
