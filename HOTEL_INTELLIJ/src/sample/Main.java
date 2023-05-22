package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage loginStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login_view.fxml"));
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login_view.fxml")));
        Parent root = loader.load();
        Scene scene = new Scene(root, Color.TRANSPARENT);
        loginStage.setTitle("Hotel Junior Coast");
        loginStage.initStyle(StageStyle.TRANSPARENT);

        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            loginStage.setX(event.getScreenX() - xOffset);
            loginStage.setY(event.getScreenY() - yOffset);
        });

        loginStage.setScene(scene);
        loginStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}