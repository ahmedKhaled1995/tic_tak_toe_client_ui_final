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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import static util.SwitchSceneTo.getStage;
import static util.SwitchSceneTo.showScene;

/**
 *
 * @author Hager
 */
public class PopUpScene {
     //List of game views
    private static final ArrayList<String> alertList = new ArrayList<String>() {
        {
            add("waitingresponse");
            add("asklogout");
        }
    };
     public static void addScene(Event event, int alertIndex) {
        try {
            Parent newView1 = FXMLLoader.load(SwitchSceneTo.class.getResource("../views/" + alertList.get(alertIndex) + ".fxml"));
            Stage newStage1 = new Stage();
            newStage1.setScene(new Scene(newView1));
            newStage1.setResizable(false);
            newStage1.show();
        } catch (NullPointerException ex) {
            Logger.getLogger(SwitchSceneTo.class.getName()).log(Level.SEVERE, null, ex);

            String errorMessage = "Error: " + alertList.get(alertIndex) + ".fxml was not found. Reinstalling the application may fix the problem";
            System.out.println(errorMessage);
            showErrorDiag(errorMessage);
        } catch (IOException ex) {
            Logger.getLogger(SwitchSceneTo.class.getName()).log(Level.SEVERE, null, ex);

            String errorMessage = "Error: " + alertList.get(alertIndex) + ".fxml is either damaged or corrupted. Reinstalling the application may fix the problem";
            System.out.println(errorMessage);
            showErrorDiag(errorMessage);}
     }
      public static void waitingresponseScene(Event event) {
        addScene(event, 0);
    }
       public static void asklogoutScene(Event event) {
        addScene(event, 1);
    }
      
      public static void closeCurrentStage(Event event) {
        getStage(event).close();
    }
         private static void showErrorDiag(String errorMessage) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("System Error");
        errorAlert.setHeaderText("");
        errorAlert.setContentText(errorMessage);
        errorAlert.showAndWait();
    }

    
}
