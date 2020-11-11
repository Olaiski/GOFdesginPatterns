package no.olai.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainChat extends VBox {

    private Button btSend;
    private TextArea taChat;

    public MainChat() {

        this.setPadding(new Insets(5));
        this.setSpacing(10);

        Text txtName = new Text("Publisher ");
        txtName.setFont(new Font("consolas", 40));

        btSend = new Button("Send");
        btSend.setPrefSize(60,60);
        btSend.setMaxWidth(200);
        btSend.setMaxHeight(200);
        taChat = new TextArea();

        VBox vBox = new VBox();
        vBox.setSpacing(10);


        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(taChat, btSend);

        getChildren().addAll(txtName, vBox);

    }

    public Button getBtSend() {
        return btSend;
    }

    public String getChatText() {
        return taChat.getText();
    }

    public TextArea getTaChat() {
        return taChat;
    }
}
