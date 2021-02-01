package popups;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameRequestPopUp extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Text text;
    protected final Button button;
    protected final Button button0;
    protected final InnerShadow innerShadow;

    private boolean answer = false;

    public GameRequestPopUp() {
        pane = new Pane();
        imageView = new ImageView();
        text = new Text();
        button = new Button();
        button0 = new Button();
        innerShadow = new InnerShadow();

        setId("AnchorPane");
        setPrefHeight(300.0);
        setPrefWidth(400.0);
        getStyleClass().add("popupanchor");
        getStylesheets().add("/popups/../styles/Stye.css");

        pane.setPrefHeight(300.0);
        pane.setPrefWidth(400.0);
        pane.getStyleClass().add("popuppane");
        pane.getStylesheets().add("/popups/../styles/Stye.css");

        imageView.setFitHeight(161.0);
        imageView.setFitWidth(328.0);
        imageView.setLayoutX(39.0);
        imageView.setLayoutY(79.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../resources/images/play.gif").toExternalForm()));

        text.setLayoutX(15.0);
        text.setLayoutY(77.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(10.0);
        text.setWrappingWidth(370.4499969482422);
        text.setFont(new Font("Snap ITC", 42.0));

        button.setLayoutX(69.0);
        button.setLayoutY(240.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(25.0);
        button.setPrefWidth(96.0);
        button.getStyleClass().add("cancelbuutton");
        button.setText("Accept");
        button.setDisable(false);

        button0.setLayoutX(247.0);
        button0.setLayoutY(240.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(25.0);
        button0.setPrefWidth(96.0);
        button0.getStyleClass().add("signupbuutton");
        button0.setText("Reject");
        button0.setDisable(false);
        pane.setOpaqueInsets(new Insets(0.0));

        innerShadow.setBlurType(javafx.scene.effect.BlurType.GAUSSIAN);
        innerShadow.setChoke(0.19);
        innerShadow.setHeight(255.0);
        innerShadow.setOffsetX(10.0);
        innerShadow.setOffsetY(10.0);
        innerShadow.setRadius(127.0);
        innerShadow.setWidth(255.0);
        pane.setEffect(innerShadow);

        pane.getChildren().add(imageView);
        pane.getChildren().add(text);
        pane.getChildren().add(button);
        pane.getChildren().add(button0);
        getChildren().add(pane);

    }

    public boolean display(String opponentName){
        // button ---> accept
        // button0 ---> reject
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.TRANSPARENT);
        button.setOnAction((e)->{
            answer = true;
            window.close();
        });
        button0.setOnAction((e)->{
            answer = false;
            window.close();
        });


        text.setText(opponentName + " says:");
        Scene scene = new Scene(this);
        scene.setFill(Color.TRANSPARENT);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
}
