package no.olai.state;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MenuPane extends VBox {

    private Button btPlay;
    private Button btPause;
    private Button btReset;
    private Button btTurbo;
    private Label lblStatus;

    public MenuPane() {

        HBox hBox = new HBox();


        btPlay = new Button(">");
        btPause = new Button("||");
        btTurbo = new Button("TURBO!");
        btReset = new Button("Reset");


        lblStatus = new Label();
        lblStatus.setFont(new Font("consolas", 15));

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(4));

        hBox.setSpacing(30);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPlay, btPause, btTurbo, btReset);

        getChildren().addAll(hBox, lblStatus);

    }

    public Button getBtPlay() {
        return btPlay;
    }

    public Button getBtPause() {
        return btPause;
    }

    public Button getBtReset() {
        return btReset;
    }

    public Button getBtTurbo() {
        return btTurbo;
    }

    public void setStatus(String status) {
        this.lblStatus.setText(status);
    }
}
