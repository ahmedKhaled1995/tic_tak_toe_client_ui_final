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
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.GameConfig;
import util.SwitchSceneTo;

public class ExitGamePopup extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final Text text;
    protected final Button button;
    protected final Button button0;
    protected final ImageView imageView0;
    protected final Text text0;
    protected final Text text1;
    protected final InnerShadow innerShadow;

    public ExitGamePopup() {

        pane = new Pane();
        imageView = new ImageView();
        text = new Text();
        button = new Button();
        button0 = new Button();
        imageView0 = new ImageView();
        text0 = new Text();
        text1 = new Text();
        innerShadow = new InnerShadow();

        setId("AnchorPane");
        setPrefHeight(300.0);
        setPrefWidth(400.0);
//        setStyle("-fx-background-color:transparent;-fx-background-radius: 20px;");
        getStyleClass().add("popupanchor");
        getStylesheets().add("/popups/../styles/Stye.css");

        pane.setPrefHeight(300.0);
        pane.setPrefWidth(400.0);
        pane.getStyleClass().add("popuppane");
        pane.getStylesheets().add("/popups/../styles/Stye.css");

        imageView.setFitHeight(401.0);
        imageView.setFitWidth(511.0);
        imageView.setLayoutY(-55.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../resources/images/exit.gif").toExternalForm()));

        text.setLayoutX(69.0);
        text.setLayoutY(121.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(10.0);
        text.getStyleClass().add("exittext");
        text.setStyle("-fx-stroke-width: 1; -fx-stroke: black;");
        text.setText("Are You Sure That");
       
        
        text.setWrappingWidth(330.4499969482422);
        text.setFont(new Font("Snap ITC", 24.0));

        button.setLayoutX(109.0);
        button.setLayoutY(177.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(24.0);
        button.setPrefWidth(63.0);
        button.setStyle("-fx-background-color: blue;");
        button.getStyleClass().add("cancelbuutton");
        button.setText("Yes");

        button0.setLayoutX(222.0);
        button0.setLayoutY(177.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(24.0);
        button0.setPrefWidth(63.0);
        button0.setStyle("-fx-background-color: blue;");
        button0.getStyleClass().add("signupbuutton");
        button0.setText("No");

        imageView0.setFitHeight(65.0);
        imageView0.setFitWidth(169.0);
        imageView0.setLayoutX(323.0);
        imageView0.setLayoutY(221.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../resources/images/byebye.gif").toExternalForm()));

        text0.setLayoutX(117.0);
        text0.setLayoutY(65.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Exit Game");
        text0.setId("headertxt");
        text0.setFont(new Font("Algerian", 32.0));

        text1.setLayoutX(69.0);
        text1.setLayoutY(154.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(10.0);
        text1.getStyleClass().add("exittext");
        text1.setStyle("-fx-stroke-width: 1; -fx-stroke: black;");
        text1.setText("You Want To Exit ?");
        text1.setWrappingWidth(330.4499969482422);
        text1.setFont(new Font("Snap ITC", 24.0));
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
        pane.getChildren().add(imageView0);
        pane.getChildren().add(text0);
        pane.getChildren().add(text1);
        getChildren().add(pane);

    }
    
    
     public void display(){
        // button ---> Yes
        // button0 ---> No
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.TRANSPARENT);
        button.setOnAction((e)->{
            System.exit(0);
            window.close();
        });
        button0.setOnAction((e)->{
            window.close();
        });


        Scene scene = new Scene(this);
        scene.setFill(Color.TRANSPARENT);
        window.setScene(scene);
        window.showAndWait();
    }
}
