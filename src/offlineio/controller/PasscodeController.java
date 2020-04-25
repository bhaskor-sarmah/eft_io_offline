/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import offlineio.repository.PasscodeDao;
import offlineio.util.StaticAppData;

/**
 * FXML Controller class
 *
 * @author Bhaskor
 */
public class PasscodeController implements Initializable {

    @FXML
    private Image btnImage;
    @FXML
    private Label lblPasscode;
    @FXML
    private TextField txtBox1;
    @FXML
    private TextField txtBox2;
    @FXML
    private TextField txtBox3;
    @FXML
    private TextField txtBox4;
    @FXML
    private TextField txtBox5;
    @FXML
    private Button btnTick;
    @FXML
    private Button btnCross;

    private String focus = "";
    @FXML
    private Label lblError;

//    private static String jwt;
//
//    public void initData(String text) {
//        System.out.println(text);
//        this.jwt = text;
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Scene scene = btnTick.getScene();
//        scene.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                if (event.getCode() == KeyCode.ENTER) {
//                    Event.fireEvent(btnTick, new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
//                            0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
//                            true, true, true, true, true, true, null));
//                }
//            }
//        });
        txtBox1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtBox1.setText(newValue.replaceAll("[^\\d]", ""));
                    return;
                }
                if (newValue.length() > 1) {
                    txtBox1.setText(newValue.substring(newValue.length() - 1, newValue.length()));
                }
                if (newValue.length() == 1) {
                    txtBox2.requestFocus();
                }
            }
        });
        txtBox2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtBox2.setText(newValue.replaceAll("[^\\d]", ""));
                    return;
                }
                if (newValue.length() > 1) {
                    txtBox2.setText(newValue.substring(newValue.length() - 1, newValue.length()));
                }
                if (newValue.length() == 1) {
                    txtBox3.requestFocus();
                }
            }
        });
        txtBox3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtBox3.setText(newValue.replaceAll("[^\\d]", ""));
                    return;
                }
                if (newValue.length() > 1) {
                    txtBox3.setText(newValue.substring(newValue.length() - 1, newValue.length()));
                }
                if (newValue.length() == 1) {
                    txtBox4.requestFocus();
                }
            }
        });
        txtBox4.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtBox4.setText(newValue.replaceAll("[^\\d]", ""));
                    return;
                }
                if (newValue.length() > 1) {
                    txtBox4.setText(newValue.substring(newValue.length() - 1, newValue.length()));
                }
                if (newValue.length() == 1) {
                    txtBox5.requestFocus();
                }
            }
        });
        txtBox5.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                if (!newValue.matches("\\d*")) {
                    txtBox5.setText(newValue.replaceAll("[^\\d]", ""));
                    return;
                }
                if (newValue.length() > 1) {
                    txtBox5.setText(newValue.substring(newValue.length() - 1, newValue.length()));
                }
                if (newValue.length() == 1) {
                    btnTick.requestFocus();
                }
            }

        });
        txtBox1.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    focus = "TXT1 FOCUS";
                } else {
                    focus = "TXT1 LOSE FOCUS";
                }
            }
        });
        txtBox2.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    focus = "TXT2 FOCUS";
                } else {
                    focus = "TXT2 LOSE FOCUS";
                }
            }
        });
        txtBox3.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    focus = "TXT3 FOCUS";
                } else {
                    focus = "TXT3 LOSE FOCUS";
                }
            }
        });
        txtBox4.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    focus = "TXT4 FOCUS";
                } else {
                    focus = "TXT4 LOSE FOCUS";
                }
            }
        });
        txtBox5.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    focus = "TXT5 FOCUS";
                } else {
                    focus = "TXT5 LOSE FOCUS";
                }
            }
        });
        //Focus the first Text Box
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                txtBox1.requestFocus();
                lblError.setVisible(false);
                btnTick.setDefaultButton(true);
            }
        });
    }

    @FXML
    private void onClickLogin(MouseEvent event) {
        ScreenController screenController = new ScreenController();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(screenController.activate("login")));
    }

    @FXML
    private void onClickBtn1(MouseEvent event) {
//        System.out.println("Button 1 Pressed");
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("1");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("1");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("1");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("1");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("1");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtn2(MouseEvent event) {
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("2");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("2");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("2");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("2");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("2");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtn3(MouseEvent event) {
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("3");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("3");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("3");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("3");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("3");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtn4(MouseEvent event) {
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("4");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("4");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("4");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("4");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("4");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtn5(MouseEvent event) {
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("5");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("5");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("5");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("5");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("5");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtn6(MouseEvent event) {
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("6");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("6");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("6");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("6");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("6");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtn7(MouseEvent event) {
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("7");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("7");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("7");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("7");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("7");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtn8(MouseEvent event) {
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("8");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("8");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("8");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("8");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("8");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtn9(MouseEvent event) {
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("9");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("9");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("9");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("9");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("9");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtn0(MouseEvent event) {
        switch (focus) {
            case "TXT1 LOSE FOCUS":
                txtBox1.setText("0");
                txtBox2.requestFocus();
                break;
            case "TXT2 LOSE FOCUS":
                txtBox2.setText("0");
                txtBox3.requestFocus();
                break;
            case "TXT3 LOSE FOCUS":
                txtBox3.setText("0");
                txtBox4.requestFocus();
                break;
            case "TXT4 LOSE FOCUS":
                txtBox4.setText("0");
                txtBox5.requestFocus();
                break;
            case "TXT5 LOSE FOCUS":
                txtBox5.setText("0");
                btnTick.requestFocus();
                break;
            default:
                break;
        }
    }

    @FXML
    private void onClickBtnTick(MouseEvent event) {
        boolean res = true;

        ObservableList<String> styleClass1 = txtBox1.getStyleClass();
        ObservableList<String> styleClass2 = txtBox2.getStyleClass();
        ObservableList<String> styleClass3 = txtBox3.getStyleClass();
        ObservableList<String> styleClass4 = txtBox4.getStyleClass();
        ObservableList<String> styleClass5 = txtBox5.getStyleClass();

        styleClass1.removeAll(Collections.singleton("error"));
        styleClass2.removeAll(Collections.singleton("error"));
        styleClass3.removeAll(Collections.singleton("error"));
        styleClass4.removeAll(Collections.singleton("error"));
        styleClass5.removeAll(Collections.singleton("error"));

        lblError.setText("");
        lblError.setVisible(false);

        if (txtBox1.getText().equals("")) {
            if (!styleClass1.contains("error")) {
                styleClass1.add("error");
            }
            txtBox1.requestFocus();
            res = false;
        } else if (txtBox2.getText().equals("")) {
            if (!styleClass2.contains("error")) {
                styleClass2.add("error");
            }
            txtBox2.requestFocus();
            res = false;
        } else if (txtBox3.getText().equals("")) {
            if (!styleClass3.contains("error")) {
                styleClass3.add("error");
            }
            txtBox3.requestFocus();
            res = false;
        } else if (txtBox3.getText().equals("")) {
            if (!styleClass4.contains("error")) {
                styleClass4.add("error");
            }
            txtBox4.requestFocus();
            res = false;
        } else if (txtBox5.getText().equals("")) {
            if (!styleClass5.contains("error")) {
                styleClass5.add("error");
            }
            txtBox5.requestFocus();
            res = false;
        }
        if (res) {
            if (PasscodeDao.verifyPasscode(txtBox1.getText() + txtBox2.getText() + txtBox3.getText() + txtBox4.getText() + txtBox5.getText())) {
                ScreenController screenController = new ScreenController();
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                primaryStage.setScene(new Scene(screenController.activate(StaticAppData.getNextWindow())));
            } else {
                txtBox1.setText("");
                txtBox2.setText("");
                txtBox3.setText("");
                txtBox4.setText("");
                txtBox5.setText("");
                txtBox1.requestFocus();
                lblError.setText("Invalid Pin ! Please try Again");
                lblError.setVisible(true);
            }
        } else {
            lblError.setText("Please enter complete Pin");
            lblError.setVisible(true);
        }
    }

    @FXML
    private void onClickBtnCross(MouseEvent event) {
        if (!txtBox5.getText().equals("")) {
            txtBox5.setText("");
            txtBox4.requestFocus();
        } else if (!txtBox4.getText().equals("")) {
            txtBox4.setText("");
            txtBox3.requestFocus();
        } else if (!txtBox3.getText().equals("")) {
            txtBox3.setText("");
            txtBox2.requestFocus();
        } else if (!txtBox2.getText().equals("")) {
            txtBox2.setText("");
            txtBox1.requestFocus();
        } else if (!txtBox1.getText().equals("")) {
            txtBox1.setText("");
            txtBox1.requestFocus();
        }
    }

    @FXML
    private void doKeyReleaseAll(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            Event.fireEvent(btnTick, new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
                    0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true,
                    true, true, true, true, true, true, null));
        }
    }

}
