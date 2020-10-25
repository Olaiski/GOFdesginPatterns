package abstractfactory.light;

import abstractfactory.components.Center;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LightCenter extends Center {


    public LightCenter() {

        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setStyle("-fx-border-color: black");


        text = new Text("Light theme center");
        text.setFill(Color.BLACK);
        text.setStyle("-fx-font: 15 consolas");
        text.setY(50);
        text.setX(50);

        getChildren().addAll(text);
    }

}
