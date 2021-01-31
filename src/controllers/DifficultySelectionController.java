/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import util.GameConfig;
import util.SwitchSceneTo;

/**
 * FXML Controller class
 *
 * @author Hager
 */
public class DifficultySelectionController implements Initializable {

    @FXML
    private Label xShape;
    @FXML
    private Label oShape;
    @FXML
    private Label titleLetter1;
    @FXML
    private Label titleLetter2;
    @FXML
    private Label titleLetter3;
    @FXML
    private Label titleLetter4;
    @FXML
    private Label titleLetter5;
    @FXML
    private Label titleLetter6;
    @FXML
    private Label titleLetter7;
    @FXML
    private Label titleLetter8;
    @FXML
    private TextField userNameLabel;
    @FXML
    private TextField scoreLabel;
    @FXML
    private Button intermediateBtn;

    //--------------------------------------------------------------------------
    private final int gameMode = 1;
    private final int viewIndex = 3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameConfig.setGameMode(gameMode);
        GameConfig.setCurrentView(viewIndex);
        animateScreen();
        this.intermediateBtn.setDisable(true);
        this.intermediateBtn.setVisible(false);
        //userNameLabel.setText(DummyPlayer.getUserName());
        //scoreLabel.setText(Integer.toString(DummyPlayer.getScore()));
    }

    @FXML
    private void handlEasyBtnAction(ActionEvent event) {
        GameConfig.setGameDifficultyLevel(1);
        SwitchSceneTo.gameBoardScene(event);
    }

    @FXML
    private void handleIntermediateBtnAction(ActionEvent event) {
        GameConfig.setGameDifficultyLevel(2);
        SwitchSceneTo.gameBoardScene(event);
    }

    @FXML
    private void handleHardBtnAction(ActionEvent event) {
        GameConfig.setGameDifficultyLevel(3);
        SwitchSceneTo.gameBoardScene(event);
    }

    @FXML
    private void handlBackBtnAction(ActionEvent event) {
        GameConfig.setGameMode(0);
        SwitchSceneTo.homeScene(event);
    }

    @FXML
    private void exitGameClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            System.out.println("exit Button Working");
            if (exitApplication() == true) {
                //SwitchSceneTo.getStage(event).close();
                System.exit(0);
            }
        }
    }

    @FXML
    private void logOutClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            SwitchSceneTo.logInScene(event);
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
        transition1.setNode(titleLetter1);
        transition1.setToY(20);
        transition1.setAutoReverse(true);
        transition1.setCycleCount(TranslateTransition.INDEFINITE);
        transition1.play();

        transition2.setDuration(Duration.seconds(i));
        transition2.setNode(titleLetter2);
        transition2.setToY(-20);
        transition2.setAutoReverse(true);
        transition2.setCycleCount(TranslateTransition.INDEFINITE);
        transition2.play();

        transition3.setDuration(Duration.seconds(i));
        transition3.setNode(titleLetter3);
        transition1.setToX(20);
        transition3.setToY(20);
        transition3.setAutoReverse(true);
        transition3.setCycleCount(TranslateTransition.INDEFINITE);
        transition3.play();

        Duration duration = Duration.millis(6500);
        RotateTransition rotateTransition = new RotateTransition(duration, titleLetter3);
        rotateTransition.setByAngle(300);
        rotateTransition.setAutoReverse(true);
        rotateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        rotateTransition.play();

        transition4.setDuration(Duration.seconds(i));
        transition4.setNode(titleLetter4);
        transition4.setToY(-20);
        transition4.setAutoReverse(true);
        transition4.setCycleCount(TranslateTransition.INDEFINITE);
        transition4.play();

        transition5.setDuration(Duration.seconds(i));
        transition5.setNode(titleLetter5);
        transition5.setToY(20);
        transition5.setAutoReverse(true);
        transition5.setCycleCount(TranslateTransition.INDEFINITE);
        transition5.play();

        transition6.setDuration(Duration.seconds(i));
        transition6.setNode(titleLetter6);
        transition6.setToX(10);
        transition6.setToY(20);
        transition6.setAutoReverse(true);
        transition6.setCycleCount(TranslateTransition.INDEFINITE);
        transition6.play();

        transition7.setDuration(Duration.seconds(i));
        transition7.setNode(titleLetter7);
        transition7.setToY(-20);
        transition7.setAutoReverse(true);
        transition7.setCycleCount(TranslateTransition.INDEFINITE);
        transition7.play();

        transition8.setDuration(Duration.seconds(i));
        transition8.setNode(titleLetter8);
        transition8.setToY(20);
        transition8.setAutoReverse(true);
        transition8.setCycleCount(TranslateTransition.INDEFINITE);
        transition8.play();

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
}
