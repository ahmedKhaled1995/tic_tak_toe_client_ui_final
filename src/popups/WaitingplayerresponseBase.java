package popups;

import Main.EntryPoint;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WaitingplayerresponseBase extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Text text;
    protected final Text text0;
    protected final Button button;
    protected final InnerShadow innerShadow;

    public WaitingplayerresponseBase() {

        pane = new Pane();
        imageView = new ImageView();
        imageView0 = new ImageView();
        text = new Text();
        text0 = new Text();
        button = new Button();
        innerShadow = new InnerShadow();

        setId("AnchorPane");
        setPrefHeight(300.0);
        setPrefWidth(400.0);
        getStyleClass().add("popupanchor");
        //getStylesheets().add("/popups/../styles/Stye.css");
        pane.getStylesheets().add(String.valueOf(EntryPoint.class.getResource("/styles/Stye.css")));

        pane.setPrefHeight(300.0);
        pane.setPrefWidth(400.0);
        pane.getStyleClass().add("popuppane");
        //pane.getStylesheets().add("/popups/../styles/Stye.css");
        pane.getStylesheets().add(String.valueOf(EntryPoint.class.getResource("/styles/Stye.css")));

        imageView.setFitHeight(189.0);
        imageView.setFitWidth(228.0);
        imageView.setLayoutX(94.0);
        imageView.setLayoutY(-17.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        //imageView.setImage(new Image(getClass().getResource("../resources/images/joysticks1.png").toExternalForm()));
        imageView.setImage(new Image(EntryPoint.class.getResource("/resources/images/joysticks1.png").toExternalForm()));

        imageView0.setFitHeight(67.0);
        imageView0.setFitWidth(75.0);
        imageView0.setLayoutX(166.0);
        imageView0.setLayoutY(160.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        //imageView0.setImage(new Image(getClass().getResource("../resources/images/loading.gif").toExternalForm()));
        imageView0.setImage(new Image(EntryPoint.class.getResource("../resources/images/loading.gif").toExternalForm()));

        text.setLayoutX(57.0);
        text.setLayoutY(58.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(10.0);
        text.setText("sondos");
        text.setWrappingWidth(36.44999694824219);
        text.setFont(new Font("FZ JAZZY 14 3D EX", 42.0));

        text0.setLayoutX(316.0);
        text0.setLayoutY(58.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(10.0);
        text0.setText("sondos");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        text0.setWrappingWidth(36.449992656707764);
        text0.setFont(new Font("FZ JAZZY 14 3D EX", 42.0));

        button.setLayoutX(152.0);
        button.setLayoutY(250.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(25.0);
        button.setPrefWidth(96.0);
        button.getStyleClass().add("cancelbuutton");
        button.setText("Cancel");
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
        pane.getChildren().add(text);
        pane.getChildren().add(text0);
        pane.getChildren().add(button);
        getChildren().add(pane);

    }

    public static void display(){
        Stage window = new Stage();
        window.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(new WaitingplayerresponseBase());
        scene.setFill(Color.TRANSPARENT);
        window.setScene(scene);
        window.show();
    }
}
