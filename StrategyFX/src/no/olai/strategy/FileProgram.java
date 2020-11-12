package no.olai.strategy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.olai.strategy.util.Util;
import no.olai.strategy.view.RightMenu;
import no.olai.strategy.view.TopMenu;

import java.io.File;

public class FileProgram extends Application {

    private final TopMenu topMenu = new TopMenu();
    private final RightMenu rightMenu = new RightMenu();
    private final FileHandler fileHandler = new FileHandler();

    private File file;
    private FileStrategy fileStrategy;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        TextArea center = new TextArea();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Directory");



        topMenu.getBtChooser().setOnAction(e -> {


            if (topMenu.getRbDirectory().isSelected())
                file = directoryChooser.showDialog(primaryStage);
            else
                file = fileChooser.showOpenDialog(primaryStage);


            if (file != null) {
                String ex = "";
                int i = file.getName().lastIndexOf(".");
                if (i > 0)
                    ex = file.getName().substring(i+1);



                switch (ex) {
                    case "txt":
                        fileStrategy = new TextFile(file);
                        topMenu.setStatus("Text file @ " + file.getPath());
                        break;
                    case "zip":
                        fileStrategy = new ZIPFile(file);
                        topMenu.setStatus("ZIP file @ " + file.getPath());
                        break;
                    case "":
                        fileStrategy = new DirFile(file);
                        topMenu.setStatus("Dir @ " + file.getPath());
                        break;
                    default:
                        topMenu.setStatus("Not supported format");
                }

                fileHandler.processFile(fileStrategy);

            }
        });


        rightMenu.getBtSize().setOnAction(e ->
                rightMenu.setStatus("Size: \n" + Util.readableFormat(fileStrategy.getSize()))
        );


        rightMenu.getBtList().setOnAction(e ->
                center.setText(fileStrategy.display())
        );


        root.setTop(topMenu);
        root.setCenter(center);
        root.setRight(rightMenu);




        primaryStage.setTitle("File Reader");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
