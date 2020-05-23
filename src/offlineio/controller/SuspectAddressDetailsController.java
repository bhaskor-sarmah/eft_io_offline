/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
import offlineio.util.AppSettings;
import offlineio.util.StaticAppData;
import offlineio.util.Validations;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class SuspectAddressDetailsController implements Initializable {

    @FXML
    private Label lblMessage;
    @FXML
    private ChoiceBox<KeyValuePair> selAddOriginCountry;
    @FXML
    private TextField txtAddOriginState;
    @FXML
    private TextField txtAddOriginDistrict;
    @FXML
    private TextField txtAddOriginVill;
    @FXML
    private TextField txtAddOriginPin;
    @FXML
    private ChoiceBox<KeyValuePair> selAddIndCountry;
    @FXML
    private TextField txtAddIndPo;
    @FXML
    private ChoiceBox<KeyValuePair> selAddIndState;
    @FXML
    private ChoiceBox<KeyValuePair> selAddIndDistrict;
    @FXML
    private ChoiceBox<KeyValuePair> selAddIndPs;
    @FXML
    private ChoiceBox<KeyValuePair> selAddIndVill;
    @FXML
    private TextField txtAddIndRevVill;
    @FXML
    private TextField txtAddIndVillHeadName;
    @FXML
    private TextField txtAddIndVillHeadPh;
    @FXML
    private ChoiceBox<KeyValuePair> selAddRentState;
    @FXML
    private ChoiceBox<KeyValuePair> selAddRentDistrict;
    @FXML
    private ChoiceBox<KeyValuePair> selAddRentPs;
    @FXML
    private TextField txtAddRentPo;
    @FXML
    private ChoiceBox<KeyValuePair> selAddRentVill;
    @FXML
    private TextField txtAddRentPin;
    @FXML
    private TextField txtAddRentMob;
    @FXML
    private TextField txtAddEmpName;
    @FXML
    private ChoiceBox<KeyValuePair> selAddEmpState;
    @FXML
    private ChoiceBox<KeyValuePair> selAddEmpDistrict;
    @FXML
    private ChoiceBox<KeyValuePair> selAddEmpPs;
    @FXML
    private TextField txtAddEmpPo;
    @FXML
    private ChoiceBox<KeyValuePair> selAddEmpVill;
    @FXML
    private TextField txtAddEmpPin;
    @FXML
    private TextField txtOtherCountryName;
    @FXML
    private TextField txtAddIndOtherDist;
    @FXML
    private TextField txtAddIndOtherPs;
    @FXML
    private TextField txtAddIndOtherVill;
    @FXML
    private TextField txtAddRentName;
    @FXML
    private TextField txtAddRentOtherDist;
    @FXML
    private TextField txtAddRentOtherPs;
    @FXML
    private TextField txtAddRentOtherVill;
    @FXML
    private TextField txtAddEmpOtherDist;
    @FXML
    private TextField txtAddEmpOtherPs;
    @FXML
    private TextField txtAddEmpOtherVill;
    @FXML
    private TextField txtAddIndPin;

    private SuspectAddress addressInIndia = null;
    private SuspectAddress addressInOriginCountry = null;
    private SuspectAddress addressOfRentHouse = null;
    private SuspectAddress addressOfEmployer = null;
    @FXML
    private TextField txtAddOriginPs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MasterDao dao = new MasterDao();
        selAddOriginCountry.requestFocus();
        /* **********************************************************
         * *************** Address of Origin ************************
         * *********************************************************/
        KeyValuePair keyBangla = new KeyValuePair("98", "Bangladesh");
        KeyValuePair keyOther = new KeyValuePair("00", "Others");
        selAddOriginCountry.getItems().add(keyBangla);
        selAddOriginCountry.getItems().add(keyOther);
        txtOtherCountryName.setDisable(true);
        // AddressOrigin other country change event
        selAddOriginCountry.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("00")) {
                    txtOtherCountryName.setText("");
                    txtOtherCountryName.setDisable(false);
                } else {
                    txtOtherCountryName.setText("");
                    txtOtherCountryName.setDisable(true);
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });

        /* **********************************************************
         * *************** Address of India ************************
         * *********************************************************/
        txtAddIndOtherDist.setText("");
        txtAddIndOtherDist.setDisable(true);
        txtAddIndOtherPs.setText("");
        txtAddIndOtherPs.setDisable(true);
        txtAddIndOtherVill.setText("");
        txtAddIndOtherVill.setDisable(true);
        KeyValuePair keyIndia = new KeyValuePair("91", "India");
        selAddIndCountry.getItems().add(keyIndia);
        selAddIndCountry.setDisable(true);
        List<KeyValuePair> stateList = dao.getStateList();
        stateList.forEach((k) -> {
            selAddIndState.getItems().add(k);
        });
        selAddIndState.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("18")) {
                    selAddIndDistrict.getSelectionModel().select(null);
                    selAddIndPs.getSelectionModel().select(null);
                    selAddIndVill.getSelectionModel().select(null);
                    selAddIndDistrict.getItems().clear();
                    selAddIndPs.getItems().clear();
                    selAddIndVill.getItems().clear();
                    txtAddIndOtherDist.setText("");
                    txtAddIndOtherDist.setDisable(true);
                    txtAddIndOtherPs.setText("");
                    txtAddIndOtherPs.setDisable(true);
                    txtAddIndOtherVill.setText("");
                    txtAddIndOtherVill.setDisable(true);
                    List<KeyValuePair> distList = dao.getDistrictList(newValue.getKey());
                    distList.forEach((k) -> {
                        selAddIndDistrict.getItems().add(k);
                    });
                } else {
                    selAddIndDistrict.getSelectionModel().select(null);
                    selAddIndPs.getSelectionModel().select(null);
                    selAddIndVill.getSelectionModel().select(null);
                    selAddIndDistrict.getItems().clear();
                    selAddIndPs.getItems().clear();
                    selAddIndVill.getItems().clear();
                    txtAddIndOtherDist.setText("");
                    txtAddIndOtherDist.setDisable(true);
                    txtAddIndOtherPs.setText("");
                    txtAddIndOtherPs.setDisable(true);
                    txtAddIndOtherVill.setText("");
                    txtAddIndOtherVill.setDisable(true);
                    KeyValuePair keyDist = new KeyValuePair("000", "Other");
                    selAddIndDistrict.getItems().add(keyDist);
                    KeyValuePair keyThana = new KeyValuePair("00000000", "Other");
                    selAddIndPs.getItems().add(keyThana);
                    KeyValuePair keyVill = new KeyValuePair("000000", "Other");
                    selAddIndVill.getItems().add(keyVill);
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });
        selAddIndDistrict.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("000")) {
                    txtAddIndOtherDist.setText("");
                    txtAddIndOtherDist.setDisable(false);

                    selAddIndPs.getSelectionModel().select(null);
                    selAddIndPs.getItems().clear();
                    KeyValuePair keyThana = new KeyValuePair("00000000", "Other");
                    selAddIndPs.getItems().add(keyThana);
                } else {
                    txtAddIndOtherDist.setText("");
                    txtAddIndOtherDist.setDisable(true);

                    selAddIndPs.getSelectionModel().select(null);
                    selAddIndPs.getItems().clear();
                    List<KeyValuePair> thanaList = dao.getThanaList(newValue.getKey());
                    thanaList.forEach((k) -> {
                        selAddIndPs.getItems().add(k);
                    });
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });
        selAddIndPs.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("00000000")) {
                    txtAddIndOtherPs.setText("");
                    txtAddIndOtherPs.setDisable(false);

                    selAddIndVill.getSelectionModel().select(null);
                    selAddIndVill.getItems().clear();
                    KeyValuePair keyVill = new KeyValuePair("000000", "Other");
                    selAddIndVill.getItems().add(keyVill);
                } else {
                    txtAddIndOtherPs.setText("");
                    txtAddIndOtherPs.setDisable(true);

                    selAddIndVill.getSelectionModel().select(null);
                    selAddIndVill.getItems().clear();
                    List<KeyValuePair> villList = dao.getVillageList(newValue.getKey());
                    if (villList.size() > 0) {
                        villList.forEach((k) -> {
                            selAddIndVill.getItems().add(k);
                        });
                    } else {
                        KeyValuePair keyVill = new KeyValuePair("000000", "Other");
                        selAddIndVill.getItems().add(keyVill);
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });
        selAddIndVill.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("000000")) {
                    txtAddIndOtherVill.setText("");
                    txtAddIndOtherVill.setDisable(false);
                } else {
                    txtAddIndOtherVill.setText("");
                    txtAddIndOtherVill.setDisable(true);
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });

        /* **********************************************************
         * *************** Address of Rent House ********************
         * *********************************************************/
        txtAddRentOtherDist.setText("");
        txtAddRentOtherDist.setDisable(true);
        txtAddRentOtherPs.setText("");
        txtAddRentOtherPs.setDisable(true);
        txtAddRentOtherVill.setText("");
        txtAddRentOtherVill.setDisable(true);
        stateList.forEach((k) -> {
            selAddRentState.getItems().add(k);
        });
        selAddRentState.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("18")) {
                    selAddRentDistrict.getSelectionModel().select(null);
                    selAddRentPs.getSelectionModel().select(null);
                    selAddRentVill.getSelectionModel().select(null);
                    selAddRentDistrict.getItems().clear();
                    selAddRentPs.getItems().clear();
                    selAddRentVill.getItems().clear();
                    txtAddRentOtherDist.setText("");
                    txtAddRentOtherDist.setDisable(true);
                    txtAddRentOtherPs.setText("");
                    txtAddRentOtherPs.setDisable(true);
                    txtAddRentOtherVill.setText("");
                    txtAddRentOtherVill.setDisable(true);
                    List<KeyValuePair> distList = dao.getDistrictList(newValue.getKey());
                    distList.forEach((k) -> {
                        selAddRentDistrict.getItems().add(k);
                    });
                } else {
                    selAddRentDistrict.getSelectionModel().select(null);
                    selAddRentPs.getSelectionModel().select(null);
                    selAddRentVill.getSelectionModel().select(null);
                    selAddRentDistrict.getItems().clear();
                    selAddRentPs.getItems().clear();
                    selAddRentVill.getItems().clear();
                    txtAddRentOtherDist.setText("");
                    txtAddRentOtherDist.setDisable(true);
                    txtAddRentOtherPs.setText("");
                    txtAddRentOtherPs.setDisable(true);
                    txtAddRentOtherVill.setText("");
                    txtAddRentOtherVill.setDisable(true);
                    KeyValuePair keyDist = new KeyValuePair("000", "Other");
                    selAddRentDistrict.getItems().add(keyDist);
                    KeyValuePair keyThana = new KeyValuePair("00000000", "Other");
                    selAddRentPs.getItems().add(keyThana);
                    KeyValuePair keyVill = new KeyValuePair("000000", "Other");
                    selAddRentVill.getItems().add(keyVill);
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });
        selAddRentDistrict.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("000")) {
                    txtAddRentOtherDist.setText("");
                    txtAddRentOtherDist.setDisable(false);

                    selAddRentPs.getSelectionModel().select(null);
                    selAddRentPs.getItems().clear();
                    KeyValuePair keyThana = new KeyValuePair("00000000", "Other");
                    selAddRentPs.getItems().add(keyThana);
                } else {
                    txtAddRentOtherDist.setText("");
                    txtAddRentOtherDist.setDisable(true);

                    selAddRentPs.getSelectionModel().select(null);
                    selAddRentPs.getItems().clear();
                    List<KeyValuePair> thanaList = dao.getThanaList(newValue.getKey());
                    thanaList.forEach((k) -> {
                        selAddRentPs.getItems().add(k);
                    });
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });
        selAddRentPs.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("00000000")) {
                    txtAddRentOtherPs.setText("");
                    txtAddRentOtherPs.setDisable(false);

                    selAddRentVill.getSelectionModel().select(null);
                    selAddRentVill.getItems().clear();
                    KeyValuePair keyVill = new KeyValuePair("000000", "Other");
                    selAddRentVill.getItems().add(keyVill);
                } else {
                    txtAddRentOtherPs.setText("");
                    txtAddRentOtherPs.setDisable(true);

                    selAddRentVill.getSelectionModel().select(null);
                    selAddRentVill.getItems().clear();
                    List<KeyValuePair> villList = dao.getVillageList(newValue.getKey());
                    if (villList.size() > 0) {
                        villList.forEach((k) -> {
                            selAddRentVill.getItems().add(k);
                        });
                    } else {
                        KeyValuePair keyVill = new KeyValuePair("000000", "Other");
                        selAddRentVill.getItems().add(keyVill);
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });
        selAddRentVill.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("000000")) {
                    txtAddRentOtherVill.setText("");
                    txtAddRentOtherVill.setDisable(false);
                } else {
                    txtAddRentOtherVill.setText("");
                    txtAddRentOtherVill.setDisable(true);
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });

        /* **********************************************************
         * *************** Address of Employee ********************
         * *********************************************************/
        txtAddEmpName.setDisable(true);
        txtAddEmpOtherDist.setText("");
        txtAddEmpOtherDist.setDisable(true);
        txtAddEmpOtherPs.setText("");
        txtAddEmpOtherPs.setDisable(true);
        txtAddEmpOtherVill.setText("");
        txtAddEmpOtherVill.setDisable(true);
        stateList.forEach((k) -> {
            selAddEmpState.getItems().add(k);
        });
        selAddEmpState.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("18")) {
                    selAddEmpDistrict.getSelectionModel().select(null);
                    selAddEmpPs.getSelectionModel().select(null);
                    selAddEmpVill.getSelectionModel().select(null);
                    selAddEmpDistrict.getItems().clear();
                    selAddEmpPs.getItems().clear();
                    selAddEmpVill.getItems().clear();
                    txtAddEmpOtherDist.setText("");
                    txtAddEmpOtherDist.setDisable(true);
                    txtAddEmpOtherPs.setText("");
                    txtAddEmpOtherPs.setDisable(true);
                    txtAddEmpOtherVill.setText("");
                    txtAddEmpOtherVill.setDisable(true);
                    List<KeyValuePair> distList = dao.getDistrictList(newValue.getKey());
                    distList.forEach((k) -> {
                        selAddEmpDistrict.getItems().add(k);
                    });
                } else {
                    selAddEmpDistrict.getSelectionModel().select(null);
                    selAddEmpPs.getSelectionModel().select(null);
                    selAddEmpVill.getSelectionModel().select(null);
                    selAddEmpDistrict.getItems().clear();
                    selAddEmpPs.getItems().clear();
                    selAddEmpVill.getItems().clear();
                    txtAddEmpOtherDist.setText("");
                    txtAddEmpOtherDist.setDisable(true);
                    txtAddEmpOtherPs.setText("");
                    txtAddEmpOtherPs.setDisable(true);
                    txtAddEmpOtherVill.setText("");
                    txtAddEmpOtherVill.setDisable(true);
                    KeyValuePair keyDist = new KeyValuePair("000", "Other");
                    selAddEmpDistrict.getItems().add(keyDist);
                    KeyValuePair keyThana = new KeyValuePair("00000000", "Other");
                    selAddEmpPs.getItems().add(keyThana);
                    KeyValuePair keyVill = new KeyValuePair("000000", "Other");
                    selAddEmpVill.getItems().add(keyVill);
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });
        selAddEmpDistrict.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("000")) {
                    txtAddEmpOtherDist.setText("");
                    txtAddEmpOtherDist.setDisable(false);

                    selAddEmpPs.getSelectionModel().select(null);
                    selAddEmpPs.getItems().clear();
                    KeyValuePair keyThana = new KeyValuePair("00000000", "Other");
                    selAddEmpPs.getItems().add(keyThana);
                } else {
                    txtAddEmpOtherDist.setText("");
                    txtAddEmpOtherDist.setDisable(true);

                    selAddEmpPs.getSelectionModel().select(null);
                    selAddEmpPs.getItems().clear();
                    List<KeyValuePair> thanaList = dao.getThanaList(newValue.getKey());
                    thanaList.forEach((k) -> {
                        selAddEmpPs.getItems().add(k);
                    });
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });
        selAddEmpPs.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("00000000")) {
                    txtAddEmpOtherPs.setText("");
                    txtAddEmpOtherPs.setDisable(false);

                    selAddEmpVill.getSelectionModel().select(null);
                    selAddEmpVill.getItems().clear();
                    KeyValuePair keyVill = new KeyValuePair("000000", "Other");
                    selAddEmpVill.getItems().add(keyVill);
                } else {
                    txtAddEmpOtherPs.setText("");
                    txtAddEmpOtherPs.setDisable(true);

                    selAddEmpVill.getSelectionModel().select(null);
                    selAddEmpVill.getItems().clear();
                    List<KeyValuePair> villList = dao.getVillageList(newValue.getKey());
                    if (villList.size() > 0) {
                        villList.forEach((k) -> {
                            selAddEmpVill.getItems().add(k);
                        });
                    } else {
                        KeyValuePair keyVill = new KeyValuePair("000000", "Other");
                        selAddEmpVill.getItems().add(keyVill);
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });
        selAddEmpVill.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            try {
                if (newValue != null && newValue.getKey().equals("000000")) {
                    txtAddEmpOtherVill.setText("");
                    txtAddEmpOtherVill.setDisable(false);
                } else {
                    txtAddEmpOtherVill.setText("");
                    txtAddEmpOtherVill.setDisable(true);
                }
            } catch (Exception e) {
                System.out.println("Exception :" + e.getMessage());
            }
        });

        new Thread(() -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
//                    KeyValuePair kv = new KeyValuePair("91", "India");
                    selAddIndCountry.getSelectionModel().select(keyIndia);
                    SuspectBasicDetails suspect = SuspectRepository.findSuspectById(StaticAppData.getModifySuspectId());

                    if (null != suspect.getIs_employed() && suspect.getIs_employed().equals("Y")) {
                        txtAddEmpName.setText((null == suspect.getEmployer_name()) ? "" : suspect.getEmployer_name());
                        enableEmployeeDiv();
                        txtAddEmpName.setDisable(true);
                    } else {
                        // Disable all employee input as not employed in suspect basic details
                        disableEmployeeDiv();
                    }

                    Calendar myCalendar = Calendar.getInstance();
                    SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmssMs");
                    Long slnId = Long.parseLong(ft.format(myCalendar.getTime()));

                    List<SuspectAddress> suspectAddressList;
                    suspectAddressList = SuspectRepository.getSuspectAddressList(suspect.getTemp_id());

                    populateData(suspect, suspectAddressList);
                    suspectAddressList.forEach(
                            (address) -> {
                                switch (address.getFk_address_type_code()) {
                                    case AppSettings.ADDRESS_OF_DETECTION:
                                        // Detection Address of suspect
                                        // addressInIndia = new SuspectAddress(address);
                                        break;
                                    case AppSettings.ADDRESS_IN_INDIA:
                                        // Address in india
                                        addressInIndia = new SuspectAddress(address);
                                        break;
                                    case AppSettings.ADDRESS_IN_COUNTRY_ORIGIN:
                                        // Address in the country of Origin
                                        addressInOriginCountry = new SuspectAddress(address);
                                        break;
                                    case AppSettings.ADDRESS_OF_HOUSE_OWNER:
                                        // Address of house owner
                                        addressOfRentHouse = new SuspectAddress(address);
                                        break;
                                    case AppSettings.ADDRESS_OF_EMPLOYER:
                                        // Address in employer or land owner
                                        addressOfEmployer = new SuspectAddress(address);
                                        break;
                                    default:
                                        break;
                                }
                            }
                    );

                    String defaultAddressInIndiaId = "" + AppSettings.ADDRESS_IN_INDIA + "-" + slnId;
                    String defaultCountyOfOriginId = "" + AppSettings.ADDRESS_IN_COUNTRY_ORIGIN + "-" + slnId;
                    String defaultRentHouseId = "" + AppSettings.ADDRESS_OF_HOUSE_OWNER + "-" + slnId;
                    String defaultAddressOfEmployerId = "" + AppSettings.ADDRESS_OF_EMPLOYER + "-" + slnId;

                    MasterDao masterDao = new MasterDao();
                    String pinThanaCode = StaticAppData.getPinThanaCode();
                    String pinDistrictCode = masterDao.getDistrictCodeByThana(pinThanaCode);
                    String pinStateCode = "18";

                    if (addressInIndia
                            == null) {
                        addressInIndia = new SuspectAddress(defaultAddressInIndiaId, suspect.getTemp_id(), AppSettings.ADDRESS_IN_INDIA);
                        addressInIndia.setFk_suspect_state_code(pinStateCode);
                        addressInIndia.setFk_suspect_district_code(pinDistrictCode);
                        addressInIndia.setFk_suspect_thana_code(pinThanaCode);
                        addressInIndia.setDevice_id(AppSettings.DEVICE_ID);
                        addressInIndia.setCreated_by(StaticAppData.getPinUser());
                        addressInIndia.setCaptured_by(StaticAppData.getPinUser());
                    }
                    if (addressInOriginCountry
                            == null) {
                        addressInOriginCountry = new SuspectAddress(defaultCountyOfOriginId, suspect.getTemp_id(), AppSettings.ADDRESS_IN_COUNTRY_ORIGIN);
                        addressInOriginCountry.setFk_suspect_state_code(pinStateCode);
                        addressInOriginCountry.setFk_suspect_district_code(pinDistrictCode);
                        addressInOriginCountry.setFk_suspect_thana_code(pinThanaCode);
                        addressInOriginCountry.setDevice_id(AppSettings.DEVICE_ID);
                        addressInOriginCountry.setCreated_by(StaticAppData.getPinUser());
                        addressInOriginCountry.setCaptured_by(StaticAppData.getPinUser());
                    }
                    if (addressOfRentHouse
                            == null) {
                        addressOfRentHouse = new SuspectAddress(defaultRentHouseId, suspect.getTemp_id(), AppSettings.ADDRESS_OF_HOUSE_OWNER);
                        addressOfRentHouse.setFk_suspect_state_code(pinStateCode);
                        addressOfRentHouse.setFk_suspect_district_code(pinDistrictCode);
                        addressOfRentHouse.setFk_suspect_thana_code(pinThanaCode);
                        addressOfRentHouse.setDevice_id(AppSettings.DEVICE_ID);
                        addressOfRentHouse.setCreated_by(StaticAppData.getPinUser());
                        addressOfRentHouse.setCaptured_by(StaticAppData.getPinUser());
                    }
                    if (addressOfEmployer
                            == null) {
                        addressOfEmployer = new SuspectAddress(defaultAddressOfEmployerId, suspect.getTemp_id(), AppSettings.ADDRESS_OF_EMPLOYER);
                        addressOfEmployer.setFk_suspect_state_code(pinStateCode);
                        addressOfEmployer.setFk_suspect_district_code(pinDistrictCode);
                        addressOfEmployer.setFk_suspect_thana_code(pinThanaCode);
                        addressOfEmployer.setDevice_id(AppSettings.DEVICE_ID);
                        addressOfEmployer.setCreated_by(StaticAppData.getPinUser());
                        addressOfEmployer.setCaptured_by(StaticAppData.getPinUser());
                    }
                }
            });
        }
        ).start();
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
                SuspectBasicDetails suspect = SuspectRepository.findSuspectById(StaticAppData.getModifySuspectId());
                List<SuspectAddress> suspectAddressList = mapInputToModel(suspect);
                suspect.setFinal_save_address("Y");
                if (saveData(suspect, suspectAddressList)) {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Success");
                    alert1.setHeaderText("Addrss data saved successfully!");
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
                    alert1.setHeaderText("Failed saving address data");
                    alert1.showAndWait();
                }
            }
        }
    }

    @FXML
    private void onSaveAsDraftClick(MouseEvent event) {
        removeAllErrorClass();
        if (doValidateData()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to submit the form ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                SuspectBasicDetails suspect = SuspectRepository.findSuspectById(StaticAppData.getModifySuspectId());
                List<SuspectAddress> suspectAddressList = mapInputToModel(suspect);
                suspect.setFinal_save_address("N");
                if (saveData(suspect, suspectAddressList)) {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Success");
                    alert1.setHeaderText("Address Draft data saved successfully!");
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
                    alert1.setHeaderText("Failed saving address draft data");
                    alert1.showAndWait();
                }
            }
        }
    }

    public boolean saveData(SuspectBasicDetails suspect, List<SuspectAddress> suspectAddressList) {
        boolean res = true;
        if (!SuspectRepository.updateSuspect(suspect)) {
            res = false;
        }
        for (SuspectAddress address : suspectAddressList) {
            if (!SuspectRepository.updateOrSaveAddress(address)) {
                res = false;
            }
        }
        return res;
    }

    public void removeAllErrorClass() {
        selAddOriginCountry.getStyleClass().remove("error");
        txtOtherCountryName.getStyleClass().remove("error");
        txtAddOriginState.getStyleClass().remove("error");
        txtAddOriginDistrict.getStyleClass().remove("error");
        txtAddOriginVill.getStyleClass().remove("error");
        txtAddOriginPin.getStyleClass().remove("error");
        selAddIndCountry.getStyleClass().remove("error");
        txtAddIndPo.getStyleClass().remove("error");
        selAddIndState.getStyleClass().remove("error");
        selAddIndDistrict.getStyleClass().remove("error");
        selAddIndPs.getStyleClass().remove("error");
        selAddIndVill.getStyleClass().remove("error");
        txtAddIndRevVill.getStyleClass().remove("error");
        txtAddIndVillHeadName.getStyleClass().remove("error");
        txtAddIndVillHeadPh.getStyleClass().remove("error");
        selAddRentState.getStyleClass().remove("error");
        selAddRentDistrict.getStyleClass().remove("error");
        selAddRentPs.getStyleClass().remove("error");
        txtAddRentPo.getStyleClass().remove("error");
        selAddRentVill.getStyleClass().remove("error");
        txtAddRentPin.getStyleClass().remove("error");
        txtAddRentMob.getStyleClass().remove("error");
        txtAddEmpName.getStyleClass().remove("error");
        selAddEmpState.getStyleClass().remove("error");
        selAddEmpDistrict.getStyleClass().remove("error");
        selAddEmpPs.getStyleClass().remove("error");
        txtAddEmpPo.getStyleClass().remove("error");
        selAddEmpVill.getStyleClass().remove("error");
        txtAddEmpPin.getStyleClass().remove("error");
        txtOtherCountryName.getStyleClass().remove("error");
        txtAddIndOtherDist.getStyleClass().remove("error");
        txtAddIndOtherPs.getStyleClass().remove("error");
        txtAddIndOtherVill.getStyleClass().remove("error");
        txtAddRentName.getStyleClass().remove("error");
        txtAddRentOtherDist.getStyleClass().remove("error");
        txtAddRentOtherPs.getStyleClass().remove("error");
        txtAddRentOtherVill.getStyleClass().remove("error");
        txtAddEmpOtherDist.getStyleClass().remove("error");
        txtAddEmpOtherPs.getStyleClass().remove("error");
        txtAddEmpOtherVill.getStyleClass().remove("error");
        txtAddIndPin.getStyleClass().remove("error");
        txtAddOriginPs.getStyleClass().remove("error");
    }

    private boolean doValidateData() {
        boolean res = true;
        String msg = "";
        Validations valid = new Validations();
        // Address in country of origin
        if (selAddOriginCountry.getValue() == null) {
            selAddOriginCountry.getStyleClass().add("error");
            msg = "Select country of Origin";
            selAddOriginCountry.requestFocus();
            res = false;
        } else if (selAddOriginCountry.getValue().getKey().equals("00") && (txtOtherCountryName.getText().equals("") || txtOtherCountryName.getText().length() < 3)) {
            txtOtherCountryName.getStyleClass().add("error");
            msg = "Enter a valid country name";
            txtOtherCountryName.requestFocus();
            res = false;
        } else if (!txtAddOriginPin.getText().equals("") && !valid.checkPinCode(txtAddOriginPin.getText())) {
            txtAddOriginPin.getStyleClass().add("error");
            msg = "Enter a valid Pin Code";
            txtAddOriginPin.requestFocus();
            res = false;
        } // Address in India
        //        else if (selAddIndState.getValue() == null) { // Address in India state select box
        //            selAddIndState.getStyleClass().add("error");
        //            msg = "Select address in India state";
        //            selAddIndState.requestFocus();
        //            res = false;
        //        } 
        else if (selAddIndDistrict.getValue() != null && selAddIndDistrict.getValue().getKey().equals("00") && (txtAddIndOtherDist.getText().equals("") || txtAddIndOtherDist.getText().length() < 3)) {
            selAddIndDistrict.getStyleClass().add("error");
            msg = "Enter a valid district name";
            selAddIndDistrict.requestFocus();
            res = false;
        } else if (selAddIndPs.getValue() != null && selAddIndPs.getValue().getKey().equals("00") && (txtAddIndOtherPs.getText().equals("") || txtAddIndOtherPs.getText().length() < 3)) {
            txtAddIndOtherPs.getStyleClass().add("error");
            msg = "Enter a valid Thana name";
            txtAddIndOtherPs.requestFocus();
            res = false;
        } else if (selAddIndVill.getValue() != null && selAddIndVill.getValue().getKey().equals("00") && (txtAddIndOtherVill.getText().equals("") || txtAddIndOtherVill.getText().length() < 3)) {
            txtAddIndOtherVill.getStyleClass().add("error");
            msg = "Enter a valid village name";
            txtAddIndOtherVill.requestFocus();
            res = false;
        } else if (!txtAddIndPo.getText().equals("") && txtAddIndPo.getText().length() < 3) {
            txtAddIndPo.getStyleClass().add("error");
            msg = "Enter a valid Post Office";
            txtAddIndPo.requestFocus();
            res = false;
        } else if (!txtAddIndPin.getText().equals("") && !valid.checkPinCode(txtAddIndPin.getText())) {
            txtAddIndPin.getStyleClass().add("error");
            msg = "Enter a valid Pin Code";
            txtAddIndPin.requestFocus();
            res = false;
        } else if (!txtAddIndRevVill.getText().equals("") && txtAddIndRevVill.getText().length() < 3) {
            txtAddIndRevVill.getStyleClass().add("error");
            msg = "Enter a valid Revenue Village";
            txtAddIndRevVill.requestFocus();
            res = false;
        } else if (!txtAddIndVillHeadName.getText().equals("") && txtAddIndVillHeadName.getText().length() < 3) {
            txtAddIndVillHeadName.getStyleClass().add("error");
            msg = "Enter a valid name of the Village Head";
            txtAddIndVillHeadName.requestFocus();
            res = false;
        } else if (!txtAddIndVillHeadPh.getText().equals("") && !valid.checkMobile(txtAddIndVillHeadPh.getText())) {
            txtAddIndVillHeadPh.getStyleClass().add("error");
            msg = "Enter a valid Phone number of the Village Head";
            txtAddIndVillHeadPh.requestFocus();
            res = false;
        } // Address in Rent or House Owner
        else if (selAddRentDistrict.getValue() != null && selAddRentDistrict.getValue().getKey().equals("00") && (txtAddRentOtherDist.getText().equals("") || txtAddRentOtherDist.getText().length() < 3)) {
            selAddRentDistrict.getStyleClass().add("error");
            msg = "Enter a valid district name";
            selAddRentDistrict.requestFocus();
            res = false;
        } else if (selAddRentPs.getValue() != null && selAddRentPs.getValue().getKey().equals("00") && (txtAddRentOtherPs.getText().equals("") || txtAddRentOtherPs.getText().length() < 3)) {
            txtAddRentOtherPs.getStyleClass().add("error");
            msg = "Enter a valid Thana name";
            txtAddRentOtherPs.requestFocus();
            res = false;
        } else if (selAddRentVill.getValue() != null && selAddRentVill.getValue().getKey().equals("00") && (txtAddRentOtherVill.getText().equals("") || txtAddRentOtherVill.getText().length() < 3)) {
            txtAddRentOtherVill.getStyleClass().add("error");
            msg = "Enter a valid village name";
            txtAddRentOtherVill.requestFocus();
            res = false;
        } else if (!txtAddRentPo.getText().equals("") && txtAddRentPo.getText().length() < 3) {
            txtAddRentPo.getStyleClass().add("error");
            msg = "Enter a valid Post Office";
            txtAddRentPo.requestFocus();
            res = false;
        } else if (!txtAddRentPin.getText().equals("") && !valid.checkPinCode(txtAddRentPin.getText())) {
            txtAddRentPin.getStyleClass().add("error");
            msg = "Enter a valid Pin Code";
            txtAddRentPin.requestFocus();
            res = false;
        } else if (!txtAddRentName.getText().equals("") && txtAddRentName.getText().length() < 3) {
            txtAddRentName.getStyleClass().add("error");
            msg = "Enter a valid name of the House Owner";
            txtAddRentName.requestFocus();
            res = false;
        } else if (!txtAddRentMob.getText().equals("") && !valid.checkMobile(txtAddRentMob.getText())) {
            txtAddRentMob.getStyleClass().add("error");
            msg = "Enter a valid Phone number of the House Owner";
            txtAddRentMob.requestFocus();
            res = false;
        } // Addres of the employee
        else if (selAddEmpDistrict.getValue() != null && selAddEmpDistrict.getValue().getKey().equals("00") && (txtAddEmpOtherDist.getText().equals("") || txtAddEmpOtherDist.getText().length() < 3)) {
            selAddEmpDistrict.getStyleClass().add("error");
            msg = "Enter a valid district name";
            selAddEmpDistrict.requestFocus();
            res = false;
        } else if (selAddEmpPs.getValue() != null && selAddEmpPs.getValue().getKey().equals("00") && (txtAddEmpOtherPs.getText().equals("") || txtAddEmpOtherPs.getText().length() < 3)) {
            txtAddEmpOtherPs.getStyleClass().add("error");
            msg = "Enter a valid Thana name";
            txtAddEmpOtherPs.requestFocus();
            res = false;
        } else if (selAddEmpVill.getValue() != null && selAddEmpVill.getValue().getKey().equals("00") && (txtAddEmpOtherVill.getText().equals("") || txtAddEmpOtherVill.getText().length() < 3)) {
            txtAddEmpOtherVill.getStyleClass().add("error");
            msg = "Enter a valid village name";
            txtAddEmpOtherVill.requestFocus();
            res = false;
        } else if (!txtAddEmpPo.getText().equals("") && txtAddEmpPo.getText().length() < 3) {
            txtAddEmpPo.getStyleClass().add("error");
            msg = "Enter a valid Post Office";
            txtAddEmpPo.requestFocus();
            res = false;
        } else if (!txtAddEmpPin.getText().equals("") && !valid.checkPinCode(txtAddEmpPin.getText())) {
            txtAddEmpPin.getStyleClass().add("error");
            msg = "Enter a valid Pin Code";
            txtAddEmpPin.requestFocus();
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

    public void populateData(SuspectBasicDetails suspect, List<SuspectAddress> suspectAddresses) {
        SuspectAddress addIndia = null;
        SuspectAddress addOrigin = null;
        SuspectAddress addEmp = null;
        SuspectAddress addRent = null;
        for (SuspectAddress s : suspectAddresses) {
            switch (s.getFk_address_type_code()) {
                case AppSettings.ADDRESS_IN_COUNTRY_ORIGIN:
                    addOrigin = s;
                    break;
                case AppSettings.ADDRESS_IN_INDIA:
                    addIndia = s;
                    break;
                case AppSettings.ADDRESS_OF_EMPLOYER:
                    addEmp = s;
                    break;
                case AppSettings.ADDRESS_OF_HOUSE_OWNER:
                    addRent = s;
                    break;
                default:
                    break;
            }
        }

        /* **********************************************************
         * *************** Address of Origin ***********************
         * *********************************************************/
        if (null != addOrigin) {
            // Country Selection
            if (addOrigin.getFk_country_code() != null && !addOrigin.getFk_country_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddOriginCountry.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addOrigin.getFk_country_code())) {
                        selAddOriginCountry.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addOrigin.getFk_country_code().equals("00") && (addOrigin.getOther_country() != null && !addOrigin.getOther_country().equals(""))) {
                    txtOtherCountryName.setText(addOrigin.getOther_country());
                }
            }
            if (addOrigin.getOther_state() != null && !addOrigin.getOther_state().equals("")) {
                txtAddOriginState.setText(addOrigin.getOther_state());
            }
            if (addOrigin.getOther_district() != null && !addOrigin.getOther_district().equals("")) {
                txtAddOriginDistrict.setText(addOrigin.getOther_district());
            }
            if (addOrigin.getOther_thana() != null && !addOrigin.getOther_thana().equals("")) {
                txtAddOriginPs.setText(addOrigin.getOther_thana());
            }
            if (addOrigin.getOther_village() != null && !addOrigin.getOther_village().equals("")) {
                txtAddOriginVill.setText(addOrigin.getOther_village());
            }
            if (addOrigin.getPin_code() != null && !addOrigin.getPin_code().equals("")) {
                txtAddOriginPin.setText(addOrigin.getPin_code());
            }
        }

        /* *********************************************************
         * *************** Address of India ************************
         * *********************************************************/
        if (null != addIndia) {
            if (addIndia.getFk_state_code() != null && !addIndia.getFk_state_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddIndState.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addIndia.getFk_state_code())) {
                        selAddIndState.getSelectionModel().select(k);
                        break;
                    }
                }
            }
            
            if (addIndia.getFk_district_code() != null && !addIndia.getFk_district_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddIndDistrict.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addIndia.getFk_district_code())) {
                        selAddIndDistrict.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addIndia.getFk_district_code().equals("000") && (addIndia.getOther_district()!= null && !addIndia.getOther_district().equals(""))) {
                    txtAddIndOtherDist.setText(addIndia.getOther_district());
                }
            }
            
            if (addIndia.getFk_thana_code() != null && !addIndia.getFk_thana_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddIndPs.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addIndia.getFk_thana_code())) {
                        selAddIndPs.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addIndia.getFk_thana_code().equals("00000000") && (addIndia.getOther_thana()!= null && !addIndia.getOther_thana().equals(""))) {
                    txtAddIndOtherPs.setText(addIndia.getOther_thana());
                }
            }
            
            if (addIndia.getFk_village_code() != null && !addIndia.getFk_village_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddIndVill.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addIndia.getFk_village_code())) {
                        selAddIndVill.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addIndia.getFk_village_code().equals("000000") && (addIndia.getOther_village()!= null && !addIndia.getOther_village().equals(""))) {
                    txtAddIndOtherVill.setText(addIndia.getOther_village());
                }
            }
            
            if (addIndia.getPost_office()!= null && !addIndia.getPost_office().equals("")) {
                txtAddIndPo.setText(addIndia.getPost_office());
            }
            if (addIndia.getRevenue_village_name()!= null && !addIndia.getRevenue_village_name().equals("")) {
                txtAddIndRevVill.setText(addIndia.getRevenue_village_name());
            }
            if (addIndia.getPin_code()!= null && !addIndia.getPin_code().equals("")) {
                txtAddIndPin.setText(addIndia.getPin_code());
            }
            if (addIndia.getVillage_head_name()!= null && !addIndia.getVillage_head_name().equals("")) {
                txtAddIndVillHeadName.setText(addIndia.getVillage_head_name());
            }
            if (addIndia.getVillage_head_phone_no()!= null && !addIndia.getVillage_head_phone_no().equals("")) {
                txtAddIndVillHeadPh.setText(addIndia.getVillage_head_phone_no());
            }
            
        }
        
        
        /* *********************************************************
         * *************** Address of Rent ************************
         * *********************************************************/
        if (null != addRent) {
            if (addRent.getHouse_owner_name()!= null && !addRent.getHouse_owner_name().equals("")) {
                txtAddRentName.setText(addRent.getHouse_owner_name());
            }
            if (addRent.getHouse_owner_phone_no()!= null && !addRent.getHouse_owner_phone_no().equals("")) {
                txtAddRentMob.setText(addRent.getHouse_owner_phone_no());
            }
            
            if (addRent.getFk_state_code() != null && !addRent.getFk_state_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddRentState.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addRent.getFk_state_code())) {
                        selAddRentState.getSelectionModel().select(k);
                        break;
                    }
                }
            }
            
            if (addRent.getFk_district_code() != null && !addRent.getFk_district_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddRentDistrict.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addRent.getFk_district_code())) {
                        selAddRentDistrict.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addRent.getFk_district_code().equals("000") && (addRent.getOther_district()!= null && !addRent.getOther_district().equals(""))) {
                    txtAddRentOtherDist.setText(addRent.getOther_district());
                }
            }
            
            if (addRent.getFk_thana_code() != null && !addRent.getFk_thana_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddRentPs.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addRent.getFk_thana_code())) {
                        selAddRentPs.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addRent.getFk_thana_code().equals("00000000") && (addRent.getOther_thana()!= null && !addRent.getOther_thana().equals(""))) {
                    txtAddRentOtherPs.setText(addRent.getOther_thana());
                }
            }
            
            if (addRent.getFk_village_code() != null && !addRent.getFk_village_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddRentVill.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addRent.getFk_village_code())) {
                        selAddRentVill.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addRent.getFk_village_code().equals("000000") && (addRent.getOther_village()!= null && !addRent.getOther_village().equals(""))) {
                    txtAddRentOtherVill.setText(addRent.getOther_village());
                }
            }
            
            if (addRent.getPost_office()!= null && !addRent.getPost_office().equals("")) {
                txtAddRentPo.setText(addRent.getPost_office());
            }
//            if (addRent.getRevenue_village_name()!= null && !addRent.getRevenue_village_name().equals("")) {
//                txtAddIndRevVill.setText(addRent.getRevenue_village_name());
//            }
            if (addRent.getPin_code()!= null && !addRent.getPin_code().equals("")) {
                txtAddRentPin.setText(addRent.getPin_code());
            }
            
            
        }
        
         /* *********************************************************
         * *************** Address of Employment ************************
         * *********************************************************/
        if (null != addEmp) {
            
            if (addEmp.getFk_state_code() != null && !addEmp.getFk_state_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddEmpState.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addEmp.getFk_state_code())) {
                        selAddEmpState.getSelectionModel().select(k);
                        break;
                    }
                }
            }
            
            if (addEmp.getFk_district_code() != null && !addEmp.getFk_district_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddEmpDistrict.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addEmp.getFk_district_code())) {
                        selAddEmpDistrict.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addEmp.getFk_district_code().equals("000") && (addEmp.getOther_district()!= null && !addEmp.getOther_district().equals(""))) {
                    txtAddEmpOtherDist.setText(addEmp.getOther_district());
                }
            }
            
            if (addEmp.getFk_thana_code() != null && !addEmp.getFk_thana_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddEmpPs.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addEmp.getFk_thana_code())) {
                        selAddEmpPs.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addEmp.getFk_thana_code().equals("00000000") && (addEmp.getOther_thana()!= null && !addEmp.getOther_thana().equals(""))) {
                    txtAddEmpOtherPs.setText(addEmp.getOther_thana());
                }
            }
            
            if (addEmp.getFk_village_code() != null && !addEmp.getFk_village_code().equals("")) {
                ObservableList<KeyValuePair> keyList = selAddEmpVill.getItems();
                for (KeyValuePair k : keyList) {
                    if (k.getKey().equals(addEmp.getFk_village_code())) {
                        selAddEmpVill.getSelectionModel().select(k);
                        break;
                    }
                }
                if (addEmp.getFk_village_code().equals("000000") && (addEmp.getOther_village()!= null && !addEmp.getOther_village().equals(""))) {
                    txtAddEmpOtherVill.setText(addEmp.getOther_village());
                }
            }
            
            if (addEmp.getPost_office()!= null && !addEmp.getPost_office().equals("")) {
                txtAddEmpPo.setText(addEmp.getPost_office());
            }
            if (addEmp.getPin_code()!= null && !addEmp.getPin_code().equals("")) {
                txtAddEmpPin.setText(addEmp.getPin_code());
            }
            
            
        }
    }

    private List<SuspectAddress> mapInputToModel(SuspectBasicDetails suspect) {
        List<SuspectAddress> suspectAddressList = new ArrayList<>();

        /* **********************************************************
         * *************** Address of Origin ********************
         * *********************************************************/
        if (null != selAddOriginCountry.getValue()) {
            addressInOriginCountry.setFk_country_code(selAddOriginCountry.getValue().getKey());
            if (selAddOriginCountry.getValue().getKey().equals("00")) {
                addressInOriginCountry.setOther_country(txtOtherCountryName.getText());
            }
        }
        addressInOriginCountry.setOther_state(txtAddOriginState.getText());
        addressInOriginCountry.setOther_district(txtAddOriginDistrict.getText());
        addressInOriginCountry.setOther_thana(txtAddOriginPs.getText());
        addressInOriginCountry.setOther_village(txtAddOriginVill.getText());
        addressInOriginCountry.setPin_code(txtAddOriginPin.getText());
        suspectAddressList.add(addressInOriginCountry);

        /* **********************************************************
         * *************** Address of India ************************
         * *********************************************************/
        if (null != selAddIndCountry.getValue()) {
            addressInIndia.setFk_country_code(selAddIndCountry.getValue().getKey());
        }
        if (null != selAddIndState.getValue()) {
            addressInIndia.setFk_state_code(selAddIndState.getValue().getKey());
        }
        if (null != selAddIndDistrict.getValue()) {
            addressInIndia.setFk_district_code(selAddIndDistrict.getValue().getKey());
            if (selAddIndDistrict.getValue().getKey().equals("000")) {
                addressInIndia.setOther_district(txtAddIndOtherDist.getText());
            }
        }
        if (null != selAddIndPs.getValue()) {
            addressInIndia.setFk_thana_code(selAddIndPs.getValue().getKey());
            if (selAddIndPs.getValue().getKey().equals("00000000")) {
                addressInIndia.setOther_thana(txtAddIndOtherPs.getText());
            }
        }
        if (null != selAddIndVill.getValue()) {
            addressInIndia.setFk_village_code(selAddIndVill.getValue().getKey());
            if (selAddIndVill.getValue().getKey().equals("000000")) {
                addressInIndia.setOther_village(txtAddIndOtherVill.getText());
            }
        }
        addressInIndia.setPost_office(txtAddIndPo.getText());
        addressInIndia.setRevenue_village_name(txtAddIndRevVill.getText());
        addressInIndia.setPin_code(txtAddIndPin.getText());
        addressInIndia.setVillage_head_name(txtAddIndVillHeadName.getText());
        addressInIndia.setVillage_head_phone_no(txtAddIndVillHeadPh.getText());
        suspectAddressList.add(addressInIndia);

        /* **********************************************************
         * *************** Address of Rent ************************
         * *********************************************************/
//        addressOfRentHouse.setFk_country_code(selAddRentCountry.getValue().getKey());
        if (null != selAddRentState.getValue()) {
            addressOfRentHouse.setFk_state_code(selAddRentState.getValue().getKey());
        }
        if (null != selAddRentDistrict.getValue()) {
            addressOfRentHouse.setFk_district_code(selAddRentDistrict.getValue().getKey());
            if (selAddRentDistrict.getValue().getKey().equals("000")) {
                addressOfRentHouse.setOther_district(txtAddRentOtherDist.getText());
            }
        }
        if (null != selAddRentPs.getValue()) {
            addressOfRentHouse.setFk_thana_code(selAddRentPs.getValue().getKey());
            if (selAddRentPs.getValue().getKey().equals("00000000")) {
                addressOfRentHouse.setOther_thana(txtAddRentOtherPs.getText());
            }
        }
        if (null != selAddRentVill.getValue()) {
            addressOfRentHouse.setFk_village_code(selAddRentVill.getValue().getKey());
            if (selAddRentVill.getValue().getKey().equals("000000")) {
                addressOfRentHouse.setOther_village(txtAddRentOtherVill.getText());
            }
        }
        addressOfRentHouse.setPost_office(txtAddRentPo.getText());
//        addressOfRentHouse.setRevenue_village_name(txtAddRentRevVill.getText());
        addressOfRentHouse.setPin_code(txtAddRentPin.getText());
        addressOfRentHouse.setHouse_owner_name(txtAddRentName.getText());
        addressOfRentHouse.setHouse_owner_phone_no(txtAddRentMob.getText());
        suspectAddressList.add(addressOfRentHouse);

        /* **********************************************************
         * *************** Address of Rent ************************
         * *********************************************************/
//        addressOfEmployer.setFk_country_code(selAddEmpCountry.getValue().getKey());
        if (null != suspect.getIs_employed() && suspect.getIs_employed().equals("Y")) { // If suspect employed
            if (null != selAddEmpState.getValue()) {
                addressOfEmployer.setFk_state_code(selAddEmpState.getValue().getKey());
            }
            if (null != selAddEmpDistrict.getValue()) {
                addressOfEmployer.setFk_district_code(selAddEmpDistrict.getValue().getKey());
                if (selAddEmpDistrict.getValue().getKey().equals("000")) {
                    addressOfEmployer.setOther_district(txtAddEmpOtherDist.getText());
                }
            }
            if (null != selAddEmpPs.getValue()) {
                addressOfEmployer.setFk_thana_code(selAddEmpPs.getValue().getKey());
                if (selAddEmpPs.getValue().getKey().equals("00000000")) {
                    addressOfEmployer.setOther_thana(txtAddEmpOtherPs.getText());
                }
            }
            if (null != selAddEmpVill.getValue()) {
                addressOfEmployer.setFk_village_code(selAddEmpVill.getValue().getKey());
                if (selAddEmpVill.getValue().getKey().equals("000000")) {
                    addressOfEmployer.setOther_village(txtAddEmpOtherVill.getText());
                }
            }
            addressOfEmployer.setPost_office(txtAddEmpPo.getText());
            addressOfEmployer.setPin_code(txtAddEmpPin.getText());
            suspectAddressList.add(addressOfEmployer);
        }

        return suspectAddressList;
    }

    private void disableEmployeeDiv() {
        txtAddEmpName.setDisable(true);
        selAddEmpState.setDisable(true);
        selAddEmpDistrict.setDisable(true);
        selAddEmpPs.setDisable(true);
        txtAddEmpPo.setDisable(true);
        selAddEmpVill.setDisable(true);
        txtAddEmpPin.setDisable(true);
    }

    private void enableEmployeeDiv() {
        txtAddEmpName.setDisable(false);
        selAddEmpState.setDisable(false);
        selAddEmpDistrict.setDisable(false);
        selAddEmpPs.setDisable(false);
        txtAddEmpPo.setDisable(false);
        selAddEmpVill.setDisable(false);
        txtAddEmpPin.setDisable(false);
    }

}
