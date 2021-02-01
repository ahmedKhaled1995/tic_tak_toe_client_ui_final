/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Main.EntryPoint;
import Main.GameClient;
import Main.GameRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import util.GameConfig;
import util.GameSound;
import util.SwitchSceneTo;

/**
 * FXML Controller class
 *
 * @author Hager
 */
public class SavedGamesController implements Initializable {

    @FXML
    private TableView<GameRow> savedGamesTable;
    @FXML
    private TableColumn<GameRow, Integer> gameIdCol;
    @FXML
    private TableColumn<GameRow, String> opponentCol;
    @FXML
    private TableColumn<GameRow, ImageView> gameResultCol;
    //------------------------------------------------------------------------
    private final int viewIndex = 5;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameConfig.setCurrentView(viewIndex);

        gameIdCol.setCellValueFactory(new PropertyValueFactory<>("GameNumber"));
        gameResultCol.setCellValueFactory(new PropertyValueFactory<>("PlayerOneName"));
        opponentCol.setCellValueFactory(new PropertyValueFactory<>("PlayerTwoName"));
        EntryPoint.getViewUpdater().setSavedGamesTable(this.savedGamesTable);
        EntryPoint.getGameClient().getUserGames();

    }

    @FXML
    private void handleWatchBtnAction(ActionEvent event) {
        int gameId = this.savedGamesTable.getSelectionModel().getSelectedItem().getGameNumber();
        EntryPoint.getGameClient().getSavedGame(gameId);
        GameSound.playTileClickTrack();
    }

    @FXML
    private void handleBackBtnAction(ActionEvent event) {
        GameSound.playClickTrack();
        SwitchSceneTo.homeScene(event);
    }

    @FXML
    private void exitGameClicked(MouseEvent event) {

        Platform.runLater(() -> {

            ExitGamePopup ExitGamePopup = new ExitGamePopup();
            ExitGamePopup.display();
        });
    }

}
