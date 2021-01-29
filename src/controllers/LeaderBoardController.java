/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import sys.GameLauncher;
import util.SwitchSceneTo;
import util.GameConfig;
import util.PopUpScene;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import sys.Online;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class LeaderBoardController implements Initializable {

    @FXML
    private TableView<Online> leaderBoardTable;
    @FXML
    private TableColumn<Online, String> playerNameCol;
    @FXML
    private TableColumn<Online, Integer> pointsCol;
    @FXML
    private TableColumn<Online, ImageView> statusCol;

    //-------------------------------------------------------------------------
    private TableColumn<Online, String> playernamecol;
    private TableColumn<Online, Integer> pointcolumn;
    private TableColumn<Online, ImageView> statuscol;

    private final int gameMode = 2;
    private final int viewIndex = 4;

    //ImageView maleon = new ImageView(new Image("maleoff.png"));
    ImageView iconon = new ImageView("/resources/icons8.png");
    ImageView maleoff = new ImageView("/resources/maleoff.png");
    ImageView maleon = new ImageView("/resources/maleon.png");
    ImageView emojon = new ImageView("/resources/emoj8.png");
    ImageView emojoff = new ImageView("/resources/emoj9.png");


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        pointsCol.setCellValueFactory(new PropertyValueFactory<>("point"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("photo"));
        //leaderBoardTable.setItems(list3);
        GameLauncher.getViewUpdater().setLeaderBoardTable(this.leaderBoardTable);
        GameLauncher.getGameClient().requestUsers();
    }

    @FXML
    private void handleInviteBtnAction(ActionEvent event) {
        //GameConfig.setCurrentView(viewIndex);
        //GameConfig.setGameMode(gameMode);
        //SwitchSceneTo.gameBoardScene(event);
        String opponentName = this.leaderBoardTable.getSelectionModel().getSelectedItem().getName();
        GameLauncher.getGameClient().startGameWithOpponent(opponentName);
    }

    @FXML
    private void handleBackBtnAction(ActionEvent event) {
        GameConfig.setGameMode(0);
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

    /*
    public void addUsers() {

        // ...
        ONorOFF.setCellValueFactory(new PropertyValueFactory<>("active"));

        ONorOFF.setCellFactory(tc -> {
            final Image activeImage = new Image("/resources/emoj8.png");
            final Image passiveImage = new Image("/resources/emoj9.png");
            TableCell<Online, Boolean> cell = new TableCell<Online, Boolean>() {
                private ImageView imageView = new ImageView();

                @Override
                protected void updateItem(Boolean active, boolean empty) {
                    super.updateItem(active, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        if (active) {
                            imageView.setImage(activeImage);
                        } else {
                            imageView.setImage(passiveImage);
                        }
                        setGraphic(imageView);
                    }
                }
            };
            return cell;
        });
    }
     */
}
