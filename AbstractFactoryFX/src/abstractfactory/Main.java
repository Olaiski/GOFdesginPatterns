package abstractfactory;

import abstractfactory.components.Center;
import abstractfactory.components.Toolbar;
import abstractfactory.dark.DarkThemeFactory;
import abstractfactory.factory.ThemeFactory;
import abstractfactory.light.LightThemeFactory;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * https://medium.com/@hitherejoe/design-patterns-abstract-factory-39a22985bdbf
 */

public class Main extends Application {

    static class App {

        private Toolbar toolbar;
        private Center center;

        public App() {
        }

        public App(ThemeFactory factory) {
            toolbar = factory.createToolbar();
            center = factory.createCenter();
        }

        public Toolbar getToolbar() {
            return toolbar;
        }

        public Center getCenter() {
            return center;
        }
    }

    private ThemeFactory factory;
    private App app;
    private Button btn;

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();
        btn = new Button("Set dark");
        btn.setAlignment(Pos.CENTER);
        root.setBottom(btn);

        factory = new LightThemeFactory();
        app = new App(factory);
        root.setTop(app.getToolbar());
        root.setCenter(app.getCenter());



        btn.setOnAction(e -> {
            if (factory instanceof DarkThemeFactory) {
                factory = new LightThemeFactory();
                app = new App(factory);
                btn.setText("Set dark");
            }
            else if (factory instanceof LightThemeFactory){
                factory = new DarkThemeFactory();
                app = new App(factory);
                btn.setText("Set light");
            }
            root.setCenter(app.getCenter());
            root.setTop(app.getToolbar());
        });


        primaryStage.setTitle("Abstract Factory");
        primaryStage.setScene(new Scene(root, 400, 375));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}


