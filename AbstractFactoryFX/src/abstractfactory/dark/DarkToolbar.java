package abstractfactory.dark;

import abstractfactory.components.Toolbar;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class DarkToolbar extends Toolbar {

    public DarkToolbar() {

        this.setPadding(new Insets(20));
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setStyle("-fx-border-color: white");
        this.setSpacing(20);


        text = new Text("Dark theme toolbar");
        text.setFill(Color.WHITE);
        text.setStyle("-fx-font: 15 consolas");


        getChildren().addAll(text);
    }


}
