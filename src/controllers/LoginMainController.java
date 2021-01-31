/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Main.EntryPoint;
import javafx.stage.StageStyle;
import util.GameConfig;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author Sondos Alagmawy
 */
public class LoginMainController implements Initializable {
//    Connection con=null;   

    @FXML
    private VBox vbox;
    private Parent fxml;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//      stmt = con.createStatement();
//      String queryString= new String("select * from players");
//      ResultSet rs= stmt.executeQuery(queryString);
//      ResultSetMetaData resultSetMetaData = rs.getMetaData();
//      System.out.println(resultSetMetaData.getColumnName(2));
        TranslateTransition t = new TranslateTransition(Duration.seconds(0.1), vbox);
        t.setToX(vbox.getLayoutX() * 15);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("/views/signin.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {

            }

        });

    }

    @FXML
    private void handleSignInBtnAction(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 15);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("/views/signin.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);

            } catch (IOException ex) {

            }
        });
    }

    @FXML
    private void handleSignUpBtnAction(ActionEvent event) {

        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(0);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("/views/signup.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {

            }
        });
    }
}
