package no.olai.strategy.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class RightMenu extends VBox {

    private Button btSize, btList;
    private Label lblStatus;

    public RightMenu() {

        this.setPadding(new Insets(10));
        this.setSpacing(5);

        btSize = new Button("Get size");
        btList = new Button("List content");

        lblStatus = new Label("");

        getChildren().addAll(btSize, btList, lblStatus);
    }

    public void setStatus(String msg) {
        lblStatus.setText(msg);
    }

    public Button getBtSize() {
        return btSize;
    }

    public Button getBtList() {
        return btList;
    }
}
