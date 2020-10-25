package no.olai.product;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BoxSmall extends VBox {

   private Label label;
   private Button button;

    public BoxSmall(Label label, Button button) {
        this.label = label;
        this.button = button;

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setStyle("-fx-border-color: black");
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);

        getChildren().addAll(label, button);
    }
}
