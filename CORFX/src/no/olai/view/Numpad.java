package no.olai.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import no.olai.cor.Operations;

import java.util.HashMap;
import java.util.Map;

public class Numpad extends GridPane {

    private Button btNumber;
    private String[][] numpad = new String[][]
            {
                    { "7", "8", "9", "+"},
                    { "4", "5", "6", "-" },
                    { "1", "2", "3", "/" },
                    { "CL" , "0", "*", "="},
            };

    private final Map<Operations, String> keymap = new HashMap<>();

    public Numpad() {

        keymap.put(Operations.ADD, "+");
        keymap.put(Operations.SUB, "-");
        keymap.put(Operations.DIV, "/");
        keymap.put(Operations.MULT,"*");
        keymap.put(Operations.CL, "CL");

        this.setAlignment(Pos.CENTER);
        this.setVgap(15);
        this.setHgap(15);

        for (int i = 0; i < numpad.length; i++) {
            for (int j = 0; j < numpad[i].length; j++) {
                btNumber = new Button(numpad[i][j]);
                btNumber.setPrefSize(40,40);
                this.add(btNumber, j, i);
            }
        }
    }

    public Button getBtNumber() {
        return btNumber;
    }

    public String[][] getNumpad() {
        return numpad;
    }

    public Map<Operations, String> getKeymap() {
        return keymap;
    }
}
