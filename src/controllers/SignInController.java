/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import sys.DummyPlayer;
import sys.GameLauncher;
import util.GameConfig;
import util.SwitchSceneTo;

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
        String username = emailSignin.getText();
        String password = passSignin.getText();
        GameLauncher.getGameClient().login(username, password);
    }
    
}
