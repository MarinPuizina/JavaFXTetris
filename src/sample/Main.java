package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        imageView.setFitHeight(600);
        imageView.setFitWidth(800);


        root.getChildren().addAll(imageView, gameMenu);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private static class MenuButton extends StackPane {

        private Text text;

        public MenuButton(String name) {

            // Menu text
            text = new Text(name);
            text.setFont(text.getFont().font(35));
            text.setFill(Color.GREEN);

            // Menu
            Rectangle bg = new Rectangle(250, 30);
            bg.setOpacity(0.6);
            bg.setFill(Color.BLACK);
            bg.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(bg, text);

            // Mouse hover
            setOnMouseEntered(event -> {
                bg.setTranslateX(10);
                text.setTranslateX(10);
                bg.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            // Mouse exit hover
            setOnMouseExited(event -> {
                bg.setTranslateX(0);
                text.setTranslateX(0);
                bg.setFill(Color.BLACK);
                text.setFill(Color.GREEN);
            });

            // Shadowing when pressing menu options
            DropShadow drop = new DropShadow(50, Color.GREEN);
            drop.setInput(new Glow());
            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));

        }

    }




    public static void main(String[] args) {
        launch(args);
    }
}
