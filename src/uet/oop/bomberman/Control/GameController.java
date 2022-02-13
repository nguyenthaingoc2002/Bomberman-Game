package uet.oop.bomberman.Control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import uet.oop.bomberman.graphics.Sprite;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private static GameController instance;
    public static final int WIDTH = 28;
    public static final int HEIGHT = 15;
    @FXML
    public Canvas canvas;

    public static GameController getInstance() {
        return instance;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instance = this;
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
    }
}
