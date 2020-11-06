package no.olai;

import javafx.scene.control.TextField;

public class Display extends TextField {

    private String displayText;

    public Display() {

        this.setText("");
        this.setEditable(false);
        setPrefHeight(40);

    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
