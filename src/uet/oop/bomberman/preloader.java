package uet.oop.bomberman;

import uet.oop.bomberman.Control.PreloaderController;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Quynhbes on 10/29/2021.
 */
public class preloader extends Preloader {

    private Stage preloaderStage;
    private Scene scene;

    public preloader() {

    }

    @Override
    public void init() throws IOException {
        URL url = new File("src/FXML/preLoader.fxml").toURI().toURL();
        Parent root1 = FXMLLoader.load(url);
        scene = new Scene(root1);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.preloaderStage = primaryStage;

        // Set preloader scene and show stage.
        preloaderStage.setScene(scene);
        preloaderStage.initStyle(StageStyle.UNDECORATED);
        preloaderStage.show();



    }

    @Override
    public void handleApplicationNotification(Preloader.PreloaderNotification info) {

        if (info instanceof ProgressNotification) {
            PreloaderController.label.setText("Loading "+(int) (((ProgressNotification) info).getProgress()*100) + "%");
            PreloaderController.statProgressBar.setProgress(((ProgressNotification) info).getProgress());
        }



    }

    @Override
    public void handleStateChangeNotification(Preloader.StateChangeNotification info) {

        StateChangeNotification.Type type = info.getType();
        switch (type) {

            case BEFORE_START:
                // Called after MyApplication#init and before MyApplication#start is called.
                //System.out.println("BEFORE_START");
                preloaderStage.hide();
                break;
        }


    }
}
