package no.olai.state;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BallGame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();
        GamePane gamePane = new GamePane();
        MenuPane mc = new MenuPane();



        root.setCenter(gamePane);
        root.setBottom(mc);

        gamePane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT ) {
                gamePane.movePaddleLeft();
            }
            if (e.getCode() == KeyCode.RIGHT) {
                gamePane.movePaddleRight();
            }
        });

        mc.getBtPause().setOnAction(e -> {
            mc.setStatus(gamePane.getState().onPause());
            gamePane.requestFocus();
        } );


        mc.getBtPlay().setOnAction(e -> {
            mc.setStatus(gamePane.getState().onPlay());
            gamePane.requestFocus();
        });

        mc.getBtReset().setOnAction(e -> {
            mc.setStatus(gamePane.getState().onReset());
            gamePane.requestFocus();
        });

        mc.getBtTurbo().setOnAction(e -> {
            mc.setStatus(gamePane.getState().onTurbo());
            gamePane.requestFocus();
        });









        primaryStage.setTitle("Ballgame");
        primaryStage.setScene(new Scene(root, 500, 340));
        primaryStage.show();
        primaryStage.setResizable(false);

        gamePane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
