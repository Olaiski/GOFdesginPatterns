package no.olai;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import no.olai.cor.*;
import no.olai.view.Display;
import no.olai.view.Numpad;

import java.util.Map;

public class Calculator extends Application {

    private final Display display = new Display();
    private final Numpad numpad = new Numpad();
    private double n1 = 0;
    private double n2 = 0;
    private Operations op;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();

        BorderPane.setMargin(display, new Insets(5));
        root.setTop(display);
        root.setCenter(numpad);


        numpad.getChildren().forEach(item -> {
            item.setOnMouseClicked(e -> {

                if (item instanceof Button) {

                    if (((Button) item).getText().matches("[0-9]")) {
                        display.appendText(((Button) item).getText());
                    }

                    if (n1 <= 0) {
                        for (Map.Entry<Operations, String> entry : numpad.getKeymap().entrySet()) {
                            if (((Button) item).getText().equals(entry.getValue())) {
                                n1 = Double.parseDouble(display.getText());
                                op = entry.getKey();

                                display.setText("");
                            }
                        }
                    }


                    if (n1 > 0 && ((Button) item).getText().equals("=")) {

                        n2 = Double.parseDouble(display.getText());
                        Numbers request = new Numbers(n1, n2, op);


                        Chain calc1 = new AddNumbers();
                        Chain calc2 = new SubtractNumbers();
                        Chain calc3 = new MultNumbers();
                        Chain calc4 = new DivNumbers();

                        calc1.setNextChain(calc2);
                        calc2.setNextChain(calc3);
                        calc3.setNextChain(calc4);


                        double returnVal = calc1.calculate(request);


                        display.setText("" + returnVal);
                        System.out.println(n1 + " " + op + " " + n2 + " = " + returnVal);

                    }

                    if (((Button) item).getText().equals("CL")) {
                        display.setText("");
                        n1 = 0;
                        n2 = 0;
                    }
                }


            });
        });


        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
