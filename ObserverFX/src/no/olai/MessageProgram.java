package no.olai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import no.olai.observer.Observer;
import no.olai.observer.Publisher;
import no.olai.observer.Subscriber;
import no.olai.view.MainChat;
import no.olai.view.MessageBox;

public class MessageProgram extends Application {

    private final String OBS_1 = "Obs 1";
    private final String OBS_2 = "Obs 2";
    private final String OBS_3 = "Obs 3";

    private final MainChat mainChat = new MainChat();


    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        GridPane topPane = new GridPane();

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


        handleMessageBox(mbox1, obs1, publisher, OBS_1);
        handleMessageBox(mbox2, obs2, publisher, OBS_2);
        handleMessageBox(mbox3, obs3, publisher, OBS_3);
        

        mainChat.getBtSend().setOnAction(e -> {
            postMessage(publisher, obs1, mbox1);
            postMessage(publisher, obs2, mbox2);
            postMessage(publisher, obs3, mbox3);

        });

        root.setTop(topPane);
        root.setCenter(mainChat);

        primaryStage.setTitle("Message/Observer");
        primaryStage.setScene(new Scene(root, 850, 400));
        primaryStage.show();
    }

    private void postMessage(Publisher publisher, Observer obs, MessageBox mbox) {
        String msg = mainChat.getTaChat().getText();
        if (msg.length() > 0 && publisher.isSubscribed(obs)) {
            publisher.postMessage(mainChat.getChatText());
            mbox.getTaChat().appendText(obs.update(msg) + "\n");
        }
    }


    private void handleMessageBox(MessageBox mbox, Observer obs, Publisher publisher, String name) {

        mbox.getBtSub().setOnAction(e -> {
            publisher.subscribe(obs);
            obs.setSubject(publisher);
            mbox.setStatus(name + " subscribed to " + publisher.getClass().getSimpleName());
        });


        mbox.getBtUnsub().setOnAction(e -> {
            publisher.unsubscribe(obs);
            mbox.setStatus(name + " unsubscribed to " + publisher.getClass().getSimpleName());
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
