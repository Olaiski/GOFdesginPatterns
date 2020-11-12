package no.olai.strategy.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class TopMenu extends HBox {

    private Label lblStatus;
    private Button btChooser;
    private RadioButton rbFile, rbDirectory;

    public TopMenu() {

        this.setPadding(new Insets(10));
        this.setSpacing(20);

        ToggleGroup tg = new ToggleGroup();

        rbFile = new RadioButton("File");
        rbDirectory = new RadioButton("Directory");

        rbFile.setToggleGroup(tg);
        rbFile.setSelected(true);
        rbDirectory.setToggleGroup(tg);


        btChooser = new Button("Choose file/dir");


        lblStatus = new Label("");

        getChildren().addAll(rbFile, rbDirectory, btChooser, lblStatus);
    }


    public Button getBtChooser() {
        return btChooser;
    }

    public void setStatus(String msg) {
        lblStatus.setText(msg);
    }

    public RadioButton getRbFile() {
        return rbFile;
    }

    public RadioButton getRbDirectory() {
        return rbDirectory;
    }
}


