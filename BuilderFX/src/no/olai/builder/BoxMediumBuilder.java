package no.olai.builder;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import no.olai.product.BoxMedium;

public class BoxMediumBuilder implements Builder {

    private Label label;
    private Button button;


    @Override
    public void setLabelAndSize(String text, String font, int size) {
        label = new Label(text);
        label.setFont(new Font(font, size));
    }

    @Override
    public void setButtonAndSize(String text, int w, int h) {
        button = new Button(text);
        button.setPrefSize(w, h);
    }


    public BoxMedium build() {
        return new BoxMedium(label, button);
    }
}
