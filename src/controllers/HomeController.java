/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Main.EntryPoint;
import util.SwitchSceneTo;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import util.GameConfig;
import popups.ExitGamePopup;
import util.GameSound;
/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class HomeController implements Initializable {

    @FXML
    private TextField userNameLabel;
    @FXML
    private TextField scoreLabel;
    @FXML
    private Label xShape;
    @FXML
    private Label oShape;
    @FXML
    private Label gameTitleLetter1;
    @FXML
    private Label gameTitleLetter2;
    @FXML
    private Label gameTitleLetter3;
    @FXML
    private Label gameTitleLetter4;
    @FXML
    private Label gameTitleLetter5;
    @FXML
    private Label gameTitleLetter6;
    @FXML
    private Label gameTitleLetter7;
    @FXML
    private Label gameTitleLetter8;
    @FXML
    private Label gameTitleLetter9;

    //--------------------------------------------------------------------------
    private final int viewIndex = 2;
    private final int gameMode = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(GameConfig.getGameMode());
        animateScreen();
        GameSound.playMainMenuTrack();
        GameConfig.setCurrentView(viewIndex);
        GameConfig.setGameMode(gameMode);
        userNameLabel.setText(EntryPoint.getGameClient().getUserName());
        scoreLabel.setText(String.valueOf(EntryPoint.getGameClient().getScore()));
    }

    @FXML
    private void handleVsComputerBtnAction(ActionEvent event) {
        GameSound.playClickTrack();
        SwitchSceneTo.difficultySelectionScene(event);
    }

    @FXML
    private void handleVsPlayerBtnAction(ActionEvent event) {
        GameSound.playClickTrack();
        SwitchSceneTo.leaderBoardScene(event);
    }

    @FXML
    private void handleSavedGamesBtnAction(ActionEvent event) {
        GameSound.playClickTrack();
        SwitchSceneTo.savedGamesScene(event);
    }

    @FXML
    private void handleAboutBtnAction(ActionEvent event) {
        GameSound.playClickTrack();
        SwitchSceneTo.aboutScene(event);
    }

    @FXML
    private void exitGameClicked(MouseEvent event) {
        GameSound.stopMediaPlayer();
        if (event.getButton() == MouseButton.PRIMARY) {
             Platform.runLater(()->{
           
                ExitGamePopup ExitGamePopup = new ExitGamePopup();
                ExitGamePopup.display();
            });
//            if (exitApplication() == true) {
//                //SwitchSceneTo.getStage(event).close();
//                System.exit(0);
//            }
        }
    }

    @FXML
    private void logOutClicked(MouseEvent event) {
       GameSound.stopMediaPlayer();
        if (event.getButton() == MouseButton.PRIMARY) {
            //SwitchSceneTo.logInScene(event);
            EntryPoint.getGameClient().logOut();
            SwitchSceneTo.showScene(0);
        }

    }
      @FXML
        private void mutesound(MouseEvent event) {
           GameSound.stopMediaPlayer();
        }


//    private boolean exitApplication() {
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("System Message");
//        alert.setHeaderText("Are you sure that you want to exit?");
//
//        ButtonType yes = new ButtonType("Yes");
//        ButtonType no = new ButtonType("No");
//
//        alert.getButtonTypes().setAll(yes, no);
//
//        Boolean exit = null;
//
//        Optional<ButtonType> playerChoice = alert.showAndWait();
//        if (playerChoice.get() == yes) {
//            exit = true;
//        } else if (playerChoice.get() == no) {
//            exit = false;
//        }
//
//        return exit;
//    }

    private void animateScreen() {
        TranslateTransition transition1 = new TranslateTransition();
        TranslateTransition transition2 = new TranslateTransition();
        TranslateTransition transition3 = new TranslateTransition();

        TranslateTransition transition4 = new TranslateTransition();
        TranslateTransition transition5 = new TranslateTransition();
        TranslateTransition transition6 = new TranslateTransition();

        TranslateTransition transition7 = new TranslateTransition();
        TranslateTransition transition8 = new TranslateTransition();
        TranslateTransition transition9 = new TranslateTransition();

        double i = 0.3;

        transition1.setDuration(Duration.seconds(i));
        transition1.setNode(gameTitleLetter1);
        transition1.setToY(20);
        transition1.setAutoReverse(true);
        transition1.setCycleCount(TranslateTransition.INDEFINITE);
        transition1.play();

        transition2.setDuration(Duration.seconds(i));
        transition2.setNode(gameTitleLetter2);
        transition2.setToY(-20);
        transition2.setAutoReverse(true);
        transition2.setCycleCount(TranslateTransition.INDEFINITE);
        transition2.play();

        transition3.setDuration(Duration.seconds(i));
        transition3.setNode(gameTitleLetter3);
        transition1.setToX(20);
        transition3.setToY(20);
        transition3.setAutoReverse(true);
        transition3.setCycleCount(TranslateTransition.INDEFINITE);
        transition3.play();

        Duration duration = Duration.millis(6500);
        RotateTransition rotateTransition = new RotateTransition(duration, gameTitleLetter3);
        rotateTransition.setByAngle(300);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        rotateTransition.play();

        transition4.setDuration(Duration.seconds(i));
        transition4.setNode(gameTitleLetter4);
        transition4.setToY(-20);
        transition4.setAutoReverse(true);
        transition4.setCycleCount(TranslateTransition.INDEFINITE);
        transition4.play();

        transition5.setDuration(Duration.seconds(i));
        transition5.setNode(gameTitleLetter5);
        transition5.setToY(20);
        transition5.setAutoReverse(true);
        transition5.setCycleCount(TranslateTransition.INDEFINITE);
        transition5.play();

        transition6.setDuration(Duration.seconds(i));
        transition6.setNode(gameTitleLetter6);
        transition6.setToX(10);
        transition6.setToY(20);
        transition6.setAutoReverse(true);
        transition6.setCycleCount(TranslateTransition.INDEFINITE);
        transition6.play();

        transition7.setDuration(Duration.seconds(i));
        transition7.setNode(gameTitleLetter7);
        transition7.setToY(-20);
        transition7.setAutoReverse(true);
        transition7.setCycleCount(TranslateTransition.INDEFINITE);
        transition7.play();

        transition8.setDuration(Duration.seconds(i));
        transition8.setNode(gameTitleLetter8);
        transition8.setToY(20);
        transition8.setAutoReverse(true);
        transition8.setCycleCount(TranslateTransition.INDEFINITE);
        transition8.play();

        transition9.setDuration(Duration.seconds(i));
        transition9.setNode(gameTitleLetter9);
        transition9.setToY(-18);
        transition9.setAutoReverse(true);
        transition9.setCycleCount(TranslateTransition.INDEFINITE);
        transition9.play();

        Duration duration2 = Duration.millis(2500);
        RotateTransition rotateTransition2 = new RotateTransition(duration2, gameTitleLetter9);
        rotateTransition2.setCycleCount(TranslateTransition.INDEFINITE);
        rotateTransition2.setByAngle(300);
        rotateTransition2.play();

        FadeTransition fadeInTransition1 = new FadeTransition(Duration.millis(7500), oShape);
        fadeInTransition1.setFromValue(1.0);
        fadeInTransition1.setToValue(0.1);
        fadeInTransition1.setCycleCount(100);
        fadeInTransition1.play();
        fadeInTransition1.setDelay(Duration.seconds(20));

        FadeTransition fadeInTransition2 = new FadeTransition(Duration.millis(7500), xShape);
        fadeInTransition2.setFromValue(0.1);
        fadeInTransition2.setToValue(1.0);
        fadeInTransition2.setCycleCount(100);
        fadeInTransition2.play();
        fadeInTransition2.setDelay(Duration.seconds(20));
    }

    /*
    //Will be used in multiple scenese, need to find a way to do some clean coding
    private void handleConfigImgMouseClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            System.out.println("Config Button Working");
        }
    }

    private void handleConfigBtnAction(ActionEvent event) {
        System.out.println("Moving Config Button Working");
    }
     */
}
