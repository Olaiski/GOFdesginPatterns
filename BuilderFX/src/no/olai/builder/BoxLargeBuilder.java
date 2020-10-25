package no.olai.builder;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import no.olai.product.BoxLarge;

public class BoxLargeBuilder implements Builder {

    private Label label;
    private Button button;

    @Override
    public void setLabelAndSize(String text, String font, int size) {
        label = new Label(text);
        label.setFont(new Font(font, size));
        label.setTextFill(Color.WHITE);
    }

    @Override
    public void setButtonAndSize(String text, int w, int h) {
        button = new Button(text);
        button.setPrefSize(w, h);
    }



    public BoxLarge build() {
        return new BoxLarge(label, button);
    }
}
