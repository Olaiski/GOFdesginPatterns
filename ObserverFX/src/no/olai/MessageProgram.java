package no.olai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import no.olai.observer.Observer;
import no.olai.observer.Publisher;
import no.olai.observer.Subscriber;
import no.olai.view.MessageBox;
import no.olai.view.MainChat;

public class MessageProgram extends Application {

    private final String OBS_1 = "Obs 1";
    private final String OBS_2 = "Obs 2";
    private final String OBS_3 = "Obs 3";

    private GridPane topPane = new GridPane();
    private MainChat mainChat = new MainChat();


    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        topPane = new GridPane();

        Publisher publisher = new Publisher();

        MessageBox mbox1 = new MessageBox(OBS_1);
        Observer obs1 = new Subscriber(OBS_1);

        MessageBox mbox2 = new MessageBox(OBS_2);
        Observer obs2 = new Subscriber(OBS_2);

        MessageBox mbox3 = new MessageBox(OBS_3);
        Observer obs3 = new Subscriber(OBS_3);


        topPane.add(mbox1,0,0);
        topPane.add(mbox2, 1, 0);
        topPane.add(mbox3, 2, 0);

        /**
         *  MessageBox 1
         */
        mbox1.getBtSub().setOnAction(e -> {
            publisher.subscribe(obs1);
            obs1.setSubject(publisher);
            mbox1.setStatus(OBS_1 + " subscribed to " + publisher.getClass().getSimpleName());
        });

        mbox1.getBtUpdate().setOnAction(e -> {
            if (publisher.isSubscribed(obs1)) {
                mbox1.getTaChat().appendText(obs1.update() + "\n");
                mbox1.setStatus("Force update..");
            }
        });

        mbox1.getBtUnsub().setOnAction(e -> {
            publisher.unsubscribe(obs1);
            mbox1.setStatus(OBS_1 + " unsubscribed to " + publisher.getClass().getSimpleName());
        });


        /**
         *  MessageBox 2
         */
        mbox2.getBtSub().setOnAction(e -> {
            publisher.subscribe(obs2);
            obs2.setSubject(publisher);
            mbox2.setStatus(OBS_2 + " subscribed to " + publisher.getClass().getSimpleName());
        });

        mbox2.getBtUpdate().setOnAction(e -> {
            if (publisher.isSubscribed(obs2)) {
                mbox2.getTaChat().appendText(obs2.update() + "\n");
                mbox2.setStatus("Force update..");
            }
        });

        mbox2.getBtUnsub().setOnAction(e -> {
            publisher.unsubscribe(obs2);
            mbox2.setStatus(OBS_2 + " unsubscribed to " + publisher.getClass().getSimpleName());
        });


        /**
         *  MessageBox 3
         */
        mbox3.getBtSub().setOnAction(e -> {
            publisher.subscribe(obs3);
            obs3.setSubject(publisher);
            mbox3.setStatus(OBS_3 + " subscribed to " + publisher.getClass().getSimpleName());
        });

        mbox3.getBtUpdate().setOnAction(e -> {
            if (publisher.isSubscribed(obs3)) {
                mbox3.getTaChat().appendText(obs3.update() + "\n");
                mbox3.setStatus("Force update..");
            }
        });

        mbox3.getBtUnsub().setOnAction(e -> {
            publisher.unsubscribe(obs3);
            mbox3.setStatus(OBS_3 + " unsubscribed to " + publisher.getClass().getSimpleName());
        });



        mainChat.getBtSend().setOnAction(e -> {

            if (mainChat.getTaChat().getText().length() > 0 && publisher.isSubscribed(obs1)){
                publisher.postMessage(mainChat.getChatText());
                mbox1.getTaChat().appendText(obs1.update() + "\n");
            }

            if (mainChat.getTaChat().getText().length() > 0 && publisher.isSubscribed(obs2)) {
                publisher.postMessage(mainChat.getChatText());
                mbox2.getTaChat().appendText(obs2.update() + "\n");
            }

            if (mainChat.getTaChat().getText().length() > 0 && publisher.isSubscribed(obs3)) {
                publisher.postMessage(mainChat.getChatText());
                mbox3.getTaChat().appendText(obs3.update() + "\n");

            }


        });

        root.setTop(topPane);
        root.setCenter(mainChat);


        primaryStage.setTitle("Message/Observer");
        primaryStage.setScene(new Scene(root, 750, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
