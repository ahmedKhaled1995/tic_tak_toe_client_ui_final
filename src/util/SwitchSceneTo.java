/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Main.EntryPoint;
import javafx.stage.StageStyle;

/**
 *
 * @author LENOVO
 */
public class SwitchSceneTo {
    
    private static double xOffset = 0;
    private static double yOffset = 0;

    //List of game views
    private static final ArrayList<String> viewsList = new ArrayList<String>() {
        {
            add("loginmain");                 // viewIndex 0 -> loginmain.fxml 
            add("home");                      // viewIndex 1 -> home.fxml
            add("difficultyselection");       // viewIndex 2 -> difficultyselection.fxml   (Single Player Mode)
            add("leaderboard");               // viewIndex 3 -> leaderboard.fxml           (Multiplayer Moder)
            add("savedgames");                // viewIndex 4 -> savedgames.fxml             
            add("gameboard");                 // viewIndex 5 -> gameboard.fxml
            add("about");                     // viewIndex 6 -> about.fxml
        }
    };

    public static void showScene(Event event, int viewIndex) {
        try {
            Parent newView = FXMLLoader.load(SwitchSceneTo.class.getResource("../views/" + viewsList.get(viewIndex) + ".fxml"));
            makeMeMobile(newView);
            getStage(event).setScene(new Scene(newView));
        } catch (NullPointerException ex) {
            Logger.getLogger(SwitchSceneTo.class.getName()).log(Level.SEVERE, null, ex);
            String errorMessage = "Error: " + viewsList.get(viewIndex) + ".fxml was not found. Reinstalling the application may fix the problem";
            System.out.println(errorMessage);
            showErrorDiag(errorMessage);
        } catch (IOException ex) {
            Logger.getLogger(SwitchSceneTo.class.getName()).log(Level.SEVERE, null, ex);
            String errorMessage = "Error: " + viewsList.get(viewIndex) + ".fxml is either damaged or corrupted. Reinstalling the application may fix the problem";
            System.out.println(errorMessage);
            showErrorDiag(errorMessage);
        } finally {
            //closeCurrentStage(event);
        }
    }

    public static void showScene(int viewIndex) {
        try {
            Parent newView = FXMLLoader.load(SwitchSceneTo.class.getResource("../views/" + viewsList.get(viewIndex) + ".fxml"));
            makeMeMobile(newView);
            Stage newStage = EntryPoint.getStage();
            newStage.setScene(new Scene(newView));
            newStage.show();
        } catch (NullPointerException ex) {
            Logger.getLogger(SwitchSceneTo.class.getName()).log(Level.SEVERE, null, ex);
            String errorMessage = "Error: " + viewsList.get(viewIndex) + ".fxml was not found. Reinstalling the application may fix the problem";
            System.out.println(errorMessage);
            showErrorDiag(errorMessage);
        } catch (IOException ex) {
            Logger.getLogger(SwitchSceneTo.class.getName()).log(Level.SEVERE, null, ex);
            String errorMessage = "Error: " + viewsList.get(viewIndex) + ".fxml is either damaged or corrupted. Reinstalling the application may fix the problem";
            System.out.println(errorMessage);
            showErrorDiag(errorMessage);
        } finally {
            //closeCurrentStage(event);
        }
    }
    
    public static void logInScene(Event event) {
        showScene(event, 0);
    }

    public static void homeScene(Event event) {
        showScene(event, 1);
    }

    public static void difficultySelectionScene(Event event) {
        showScene(event, 2);
    }

    public static void leaderBoardScene(Event event) {
        showScene(event, 3);
    }

    public static void savedGamesScene(Event event) {
        showScene(event, 4);
    }

    public static void gameBoardScene(Event event) {
        showScene(event, 5);
    }

    public static void aboutScene(Event event) {
        showScene(event, 6);
    }

    public static void closeCurrentStage(Event event) {
        getStage(event).close();
    }

    public static Stage getStage(Event event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    private static void showErrorDiag(String errorMessage) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("System Error");
        errorAlert.setHeaderText("");
        errorAlert.setContentText(errorMessage);
        errorAlert.showAndWait();
    }
    
    public static void makeMeMobile(Parent root) {
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            getStage(event).setX(event.getScreenX() - xOffset);
            getStage(event).setY(event.getScreenY() - yOffset);
        });
    }
}
