package uet.oop.bomberman.Control;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.MainGame;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Exploded;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Quynhbes on 12/9/2021.
 */
public class CongratController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onExit(ActionEvent event) {
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void newGame(ActionEvent event) {

        BombermanGame bombermanGame = new BombermanGame(MainGame.stage);
        bombermanGame.start();
    }


}
