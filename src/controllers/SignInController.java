/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import popups.PopupWindow;
import util.GameConfig;
import Main.EntryPoint;
import javafx.scene.input.KeyEvent;
import util.GameSound;

/**
 * FXML Controller class
 *
 * @author Sondos Alagmawy
 */
public class SignInController implements Initializable {

    @FXML
    private TextField emailSignin;
    @FXML
    private TextField passSignin;

    private final int viewIndex = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameConfig.setCurrentView(viewIndex);
    } 
    @FXML
    private void signin(ActionEvent event) {
        GameSound.playTileClickTrack();
        String username = emailSignin.getText();
        String password = passSignin.getText();
        if(verifyFields()){
            EntryPoint.getGameClient().login(username, password);
        }else{
            PopupWindow.display("Error. Check your credentials!");
        }
    }

    private boolean verifyFields(){
        if(emailSignin.getText().equals("") || passSignin.getText().equals("")){
            return false;
        }else{
            return true;
        }
    }

    @FXML
    private void addSoundEffect(KeyEvent event) {
        GameSound.playTypingTrack();
    }
    
}
