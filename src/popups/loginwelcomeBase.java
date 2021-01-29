package popups;

import javafx.geometry.Insets;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class loginwelcomeBase extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Text text;
    protected final InnerShadow innerShadow;

    public loginwelcomeBase() {

        pane = new Pane();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        text = new Text();
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

        imageView.setFitHeight(313.0);
        imageView.setFitWidth(362.0);
        imageView.setLayoutX(26.0);
        imageView.setLayoutY(-35.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../resources/images/neon_border1.png").toExternalForm()));

        imageView0.setFitHeight(48.0);
        imageView0.setFitWidth(201.0);
        imageView0.setLayoutX(100.0);
        imageView0.setLayoutY(83.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../resources/images/tictactoe.gif").toExternalForm()));

        imageView1.setFitHeight(82.0);
        imageView1.setFitWidth(131.0);
        imageView1.setLayoutX(137.0);
        imageView1.setLayoutY(130.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../resources/images/xocubes.gif").toExternalForm()));

        text.setLayoutX(11.0);
        text.setLayoutY(293.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(10.0);
        text.setText("sondos");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(378.4499969482422);
        text.setFont(new Font("FZ JAZZY 14 3D EX", 42.0));
        pane.setOpaqueInsets(new Insets(0.0));

        innerShadow.setBlurType(javafx.scene.effect.BlurType.GAUSSIAN);
        innerShadow.setChoke(0.41);
        innerShadow.setHeight(255.0);
        innerShadow.setOffsetX(10.0);
        innerShadow.setOffsetY(10.0);
        innerShadow.setRadius(127.0);
        innerShadow.setWidth(255.0);
        pane.setEffect(innerShadow);

        pane.getChildren().add(imageView);
        pane.getChildren().add(imageView0);
        pane.getChildren().add(imageView1);
        pane.getChildren().add(text);
        getChildren().add(pane);

    }
}
