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
import util.GameConfig;
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

    //Dummy Data
    ImageView iconon = new ImageView("/resources/icons8.png");
    ImageView maleoff = new ImageView("/resources/maleoff.png");
    ImageView maleon = new ImageView("/resources/maleon.png");
    ImageView emojon = new ImageView("/resources/emoj8.png");
    ImageView emojoff = new ImageView("/resources/emoj9.png");

    /*ObservableList<PlayerRow> list3 = FXCollections.observableArrayList(
            new PlayerRow("player1", 100, maleon),
            new PlayerRow("player2", 100, emojoff),
            new PlayerRow("player3", 100, maleoff),
            new PlayerRow("player4", 100, emojon)
    );*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameConfig.setCurrentView(viewIndex);

        gameIdCol.setCellValueFactory(new PropertyValueFactory<>("GameNumber"));
        gameResultCol.setCellValueFactory(new PropertyValueFactory<>("PlayerOneName"));
        opponentCol.setCellValueFactory(new PropertyValueFactory<>("PlayerTwoName"));
        //savedGamesTable.setItems(list3);
        EntryPoint.getViewUpdater().setSavedGamesTable(this.savedGamesTable);
        EntryPoint.getGameClient().getUserGames();

    }

    @FXML
    private void handleWatchBtnAction(ActionEvent event) {
        int gameId = this.savedGamesTable.getSelectionModel().getSelectedItem().getGameNumber();
        SwitchSceneTo.gameBoardScene(event);
    }

    @FXML
    private void handleBackBtnAction(ActionEvent event) {
        SwitchSceneTo.homeScene(event);
    }

    @FXML
    private void exitGameClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (exitApplication() == true) {
                //SwitchSceneTo.getStage(event).close();
                System.exit(0);
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
