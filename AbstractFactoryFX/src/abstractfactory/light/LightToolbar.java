package abstractfactory.light;

import abstractfactory.components.Toolbar;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LightToolbar extends Toolbar {

    public LightToolbar() {

        this.setPadding(new Insets(20));
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setStyle("-fx-border-color: black");
        this.setSpacing(20);

        text = new Text("Light theme toolbar");
        text.setStyle("-fx-font: 15 consolas");

        getChildren().addAll(text);
    }

}
