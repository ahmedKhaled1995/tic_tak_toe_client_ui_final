package popups;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopupWindow {

    public static void display (String msg){
        final Stage window = new Stage();
        window.setMinWidth(300);
        window.setMinHeight(120);
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.TRANSPARENT);

        VBox dialogVbox = new VBox(5);
        dialogVbox.setPadding(new Insets(10, 0, 0 ,50));
        HBox buttonHBox = new HBox(5);
        buttonHBox.setPadding(new Insets(10, 0, 0 ,70));
        Button okButton = new Button("OK");
        okButton.setOnAction((e)->{
            window.close();
        });
        buttonHBox.getChildren().addAll(okButton);
        dialogVbox.getChildren().addAll(new Text(msg), buttonHBox);
        Scene dialogScene = new Scene(dialogVbox, 250, 100);
        window.setScene(dialogScene);
        
        window.showAndWait();
        //window.focusedProperty();
    }

}
