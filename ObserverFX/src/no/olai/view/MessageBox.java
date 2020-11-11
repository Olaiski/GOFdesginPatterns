package no.olai.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MessageBox extends VBox {

    private Text txtName;
    private TextArea taChat;
    private Button btSub;
    private Button btUnsub;
    private Label lblStatus;


    public MessageBox(String name) {

        this.setStyle("-fx-border-color: black");
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(5));

        txtName = new Text(name);
        txtName.setFont(new Font("consolas", 40));

        taChat = new TextArea();
        taChat.setMaxHeight(100);
        taChat.setEditable(false);


        btSub = new Button("Subscribe");
        btUnsub = new Button("Unsubscribe");
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(3));
        hBox.getChildren().addAll(btSub, btUnsub);

        lblStatus = new Label();

        getChildren().addAll(txtName, taChat, hBox, lblStatus);

    }

    public TextArea getTaChat() {
        return taChat;
    }


    public Button getBtSub() {
        return btSub;
    }

    public void setStatus(String s) {
        this.lblStatus.setText(s);
    }

    public Button getBtUnsub() {
        return btUnsub;
    }
}
