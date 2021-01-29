package popups;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public abstract class waitingresponseBase extends AnchorPane {

    protected final Label waitingrespose;

    public waitingresponseBase() {

        waitingrespose = new Label();

        setId("AnchorPane");
        setPrefHeight(154.0);
        setPrefWidth(300.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/popups/../styles/waitingresponse.css");

        waitingrespose.setLayoutX(93.0);
        waitingrespose.setLayoutY(69.0);
        waitingrespose.setPrefHeight(17.0);
        waitingrespose.setPrefWidth(115.0);
        waitingrespose.setText("Waiting for respose...");

        getChildren().add(waitingrespose);

    }
}
