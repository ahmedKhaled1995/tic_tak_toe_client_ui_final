package popups;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.GameConfig;
import util.SwitchSceneTo;

public class TiePopUp extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Button button;
    protected final Button button0;
    protected final InnerShadow innerShadow;

    public TiePopUp() {

        pane = new Pane();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
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

        imageView.setFitHeight(389.0);
        imageView.setFitWidth(369.0);
        imageView.setLayoutX(16.0);
        imageView.setLayoutY(-49.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../resources/images/colorful_neon_border.png").toExternalForm()));

        imageView0.setFitHeight(131.0);
        imageView0.setFitWidth(155.0);
        imageView0.setLayoutX(120.0);
        imageView0.setLayoutY(56.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../resources/images/GAMEOVER.png").toExternalForm()));

        imageView1.setFitHeight(73.0);
        imageView1.setFitWidth(133.0);
        imageView1.setLayoutX(134.0);
        imageView1.setLayoutY(222.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../resources/images/oops.gif").toExternalForm()));

        button.setLayoutX(24.0);
        button.setLayoutY(255.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(25.0);
        button.setPrefWidth(96.0);
        button.getStyleClass().add("cancelbuutton");
        button.setText("Replay");

        button0.setLayoutX(282.0);
        button0.setLayoutY(255.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(25.0);
        button0.setPrefWidth(96.0);
        button0.getStyleClass().add("cancelbuutton");
        button0.setText("Leave");
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
        pane.getChildren().add(imageView0);
        pane.getChildren().add(imageView1);
        pane.getChildren().add(button);
        pane.getChildren().add(button0);
        getChildren().add(pane);

    }

    public void display(){
        // button ---> Replay
        // button0 ---> Leave
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.TRANSPARENT);
        button.setOnAction((e)->{
            if(GameConfig.getGameMode() == 1){  // Single player
                SwitchSceneTo.showScene(5);
            }else if(GameConfig.getGameMode() == 2){
                SwitchSceneTo.showScene(3);
            }
            window.close();
        });
        button0.setOnAction((e)->{
            SwitchSceneTo.showScene(1);
            window.close();
        });


        Scene scene = new Scene(this);
        scene.setFill(Color.TRANSPARENT);
        window.setScene(scene);
        window.showAndWait();
    }
}
