/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import popups.ExitGamePopup;
import util.GameConfig;
import util.SwitchSceneTo;
import util.GameSound;

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
        GameSound.stopMediaPlayer();
        GameSound.playAboutTrack();
    }

    @FXML
    private void handleBackBtnAction(ActionEvent event) {
        GameSound.playClickTrack();
        GameSound.stopMediaPlayer();
        SwitchSceneTo.homeScene(event);
    }

    @FXML
    private void exitGameClicked(MouseEvent event) {
        GameSound.playClickTrack();
        Platform.runLater(() -> {

            ExitGamePopup ExitGamePopup = new ExitGamePopup();
            ExitGamePopup.display();
        });
    }

}
