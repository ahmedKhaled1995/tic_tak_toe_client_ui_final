/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import util.GameConfig;
import util.SwitchSceneTo;

/**
 * FXML Controller class
 *
 * @author Hager
 */
public class AboutController implements Initializable {
    
    private final int viewIndex = 7;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameConfig.setCurrentView(viewIndex);
    }

    @FXML
    private void handleBackBtnAction(ActionEvent event) {
        SwitchSceneTo.homeScene(event);
    }

    @FXML
    private void exitGameClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (exitApplication() == true) {
                SwitchSceneTo.getStage(event).close();
            }
        }
    }

    private boolean exitApplication() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("System Message");
        alert.setHeaderText("Are you sure that you want to exit?");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        alert.getButtonTypes().setAll(yes, no);

        Boolean exit = null;

        Optional<ButtonType> playerChoice = alert.showAndWait();
        if (playerChoice.get() == yes) {
            exit = true;
        } else if (playerChoice.get() == no) {
            exit = false;
        }

        return exit;
    }
}
