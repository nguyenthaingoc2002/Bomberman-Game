package uet.oop.bomberman;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

/**
 * Created by Quynhbes on 11/26/2021.
 */
public class MainGame extends Application {
    public static Scene scene;
    public static Stage stage;
    private static final int COUNT_LIMIT = 100;

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/FXML/General.fxml").toURI().toURL();
        Parent root1 = FXMLLoader.load(url);
        scene = new Scene(root1, 1296, 720);
        URL url1 = new File("src/FXML/Style.css").toURI().toURL();
        scene.getStylesheets().add(url1.toExternalForm());
        stage.setScene(scene);
        //stage.setMaximized(true);
        this.stage = stage;
        stage.show();
    }

    @Override
    public void init() throws Exception {
        for (int i = 1; i <= COUNT_LIMIT; i++) {
            double progress =(double) i/100;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
            Thread.sleep(50);
        }
    }

    public static void main(String[] args) {
        LauncherImpl.launchApplication(MainGame.class, preloader.class, args);
    }
}
