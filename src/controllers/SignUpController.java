/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import popups.PopupWindow;
import sys.GameLauncher;
import util.GameConfig;

/**
 * FXML Controller class
 *
 * @author Sondos Alagmawy
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField FullnameSignup;
    @FXML
    private TextField UsernameSignup;
    @FXML
    private TextField EmailSignup;
    @FXML
    private PasswordField PassSignup;
    @FXML
    private PasswordField ConfirmPassSignup;
    @FXML
    private RadioButton femalebtn;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton malebtn;

    private final int viewIndex = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameConfig.setCurrentView(viewIndex);
    }

    @FXML
    private void signup(ActionEvent event) {
        String FnameSignup = FullnameSignup.getText().trim();
        String UnameSignup = UsernameSignup.getText().trim();
        String mailSignup = EmailSignup.getText().trim();
        String PSignup = PassSignup.getText().trim();
        //String ConPSignup = ConfirmPassSignup.getText().trim();
        String genderValue = "";
        if (gender.getSelectedToggle() != null) {
            RadioButton selectedgender = (RadioButton) gender.getSelectedToggle();
            genderValue = selectedgender.getText();
        }
        if(verifyFields()){
            GameLauncher.getGameClient().signUp(FnameSignup, UnameSignup, PSignup, mailSignup, genderValue);
        }else{
            PopupWindow.display("Error. Check your credentials!");
        }
    }

    private boolean verifyFields(){
        if(FullnameSignup.getText().equals("") || UsernameSignup.getText().equals("") ||
                EmailSignup.getText().equals("") ||
                PassSignup.getText().equals("") || ConfirmPassSignup.getText().equals("") ||
                gender.getSelectedToggle() == null ){
            return false;
        }else if(!PassSignup.getText().equals(ConfirmPassSignup.getText())){
            return false;
        }else{
            return true;
        }
    }

}
