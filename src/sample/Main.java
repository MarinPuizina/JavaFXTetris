package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane root = new Pane();
        root.setPrefSize(800, 600);

        Image image = null;
        try (InputStream is = Files.newInputStream(Paths.get("resources/images/menu_background.png"))) {
            image = new Image(is);
        }

        ImageView imageView = new ImageView(image);
        root.getChildren().addAll(imageView);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
