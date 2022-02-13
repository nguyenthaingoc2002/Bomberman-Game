package uet.oop.bomberman.Control;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.MainGame;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MenuController {
    public static boolean ok = true;
    @FXML
    public ImageView imageView;

    public void PlayGame(ActionEvent e) {
        BombermanGame bombermanGame = new BombermanGame(MainGame.stage);
        bombermanGame.start();
    }

    public void Music(ActionEvent e) throws MalformedURLException {
        URL url1 = new File("src/FXML/unmute.png").toURI().toURL();
        URL url2 = new File("src/FXML/mute.png").toURI().toURL();
        Image image1 = new Image(String.valueOf(url1));
        Image image2 = new Image(String.valueOf(url2));
        if (ok == true) {
            ok = false;
            imageView.setImage(image2);
        } else {
            ok = true;
            imageView.setImage(image1);
        }
    }

    public void onExit(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void Guide(ActionEvent e) {
        Controller.getInstance().switchTab("GuideTab");
    }
}
