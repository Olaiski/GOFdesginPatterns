package no.olai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.olai.builder.BoxLargeBuilder;
import no.olai.builder.BoxMediumBuilder;
import no.olai.builder.BoxSmallBuilder;
import no.olai.director.Director;
import no.olai.product.BoxLarge;
import no.olai.product.BoxMedium;
import no.olai.product.BoxSmall;

public class BuilderMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        Director director = new Director();

        BoxSmallBuilder bsb = new BoxSmallBuilder();
        director.createBoxSmall(bsb);
        BoxSmall bs = bsb.build();

        BoxMediumBuilder bmb = new BoxMediumBuilder();
        director.createMediumBox(bmb);
        BoxMedium bm = bmb.build();

        BoxLargeBuilder blb = new BoxLargeBuilder();
        director.createLargeBox(blb);
        BoxLarge bl = blb.build();

        VBox vCenter = new VBox();
        root.setCenter(vCenter);

        vCenter.getChildren().addAll(bs, bm, bl);


        primaryStage.setTitle("BuilderFX");
        primaryStage.setScene(new Scene(root, 400, 375));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
