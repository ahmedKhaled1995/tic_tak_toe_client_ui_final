/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Main.EntryPoint;
import util.SwitchSceneTo;
import util.GameConfig;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import Main.PlayerRow;
import javafx.application.Platform;
import popups.ExitGamePopup;
import util.GameSound;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class LeaderBoardController implements Initializable {

    @FXML
    private TableView<PlayerRow> leaderBoardTable;
    @FXML
    private TableColumn<PlayerRow, String> playerNameCol;
    @FXML
    private TableColumn<PlayerRow, Integer> pointsCol;
    @FXML
    private TableColumn<PlayerRow, ImageView> statusCol;
    @FXML
    private TableColumn<PlayerRow, ImageView> rankCol;

    //-------------------------------------------------------------------------
    private final int gameMode = 2;
    private final int viewIndex = 4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        pointsCol.setCellValueFactory(new PropertyValueFactory<>("point"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("photo"));
        rankCol.setCellValueFactory(new PropertyValueFactory<>("rank"));
        EntryPoint.getViewUpdater().setLeaderBoardTable(this.leaderBoardTable);
        EntryPoint.getGameClient().requestUsers();
    }

    @FXML
    private void handleInviteBtnAction(ActionEvent event) {
        //GameConfig.setCurrentView(viewIndex);
        //GameConfig.setGameMode(gameMode);
        //SwitchSceneTo.gameBoardScene(event);
        GameSound.playClickTrack();
        if(!this.leaderBoardTable.getSelectionModel().isEmpty()){
            String opponentName = this.leaderBoardTable.getSelectionModel().getSelectedItem().getName();
            EntryPoint.getGameClient().startGameWithOpponent(opponentName);
        }

    }

    @FXML
    private void handleBackBtnAction(ActionEvent event) {
        GameSound.playClickTrack();
        GameConfig.setGameMode(0);
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
