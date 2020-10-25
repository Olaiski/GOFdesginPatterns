package abstractfactory.dark;

import abstractfactory.components.Center;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class DarkCenter extends Center {

    public DarkCenter() {
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setStyle("-fx-border-color: white");


        text = new Text("Dark theme center");
        text.setFill(Color.WHITE);
        text.setStyle("-fx-font: 15 consolas");

        text.setY(50);
        text.setX(50);

        getChildren().addAll(text);
    }
}
