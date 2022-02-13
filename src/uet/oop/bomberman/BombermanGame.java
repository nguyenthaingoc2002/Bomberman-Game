package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uet.oop.bomberman.Control.MenuController;
import uet.oop.bomberman.GameInfo.GameInfo;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.bonus.Bonus;
import uet.oop.bomberman.graphics.PlayerSprite;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.entities.Bomber.*;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame {

    public static final int WIDTH = 27;
    public static final int HEIGHT = 15;

    public Stage stage;
    private GraphicsContext gc;
    private Canvas canvas;
    private Media soundGameStart = new Media(new File("res/sound/gamestart.wav").toURI().toString());
    private Media soundGameEnd = new Media(new File("res/sound/gameover.wav").toURI().toString());

    private MediaPlayer mediaGameStart = new MediaPlayer(soundGameStart);
    private MediaPlayer mediaGameEnd = new MediaPlayer(soundGameEnd);

    public static List<Entity> entities = new ArrayList<>();
    public static List<Entity> stillObjects = new ArrayList<>();
    public static Bomber bomberman = new Bomber(2, 1, PlayerSprite.player_stay1.getFxImage());
    public static Bonus bonus = new Bonus();


    private GameInfo gameInfo = new GameInfo();
    public static boolean levelCompleted = false;
    public static int level = 1;
    public static int scoreGame = 0;
    public static boolean stop = false;
    public static boolean isWin = false;
    public GameMap map;
    public BorderPane victory_bPane = new BorderPane();

    public BombermanGame(Stage stage) {
        this.stage = stage;
        maxBomb = 1;
        live = 3;
        MOVE_DISTANCE = 4;
        Exploded.size = 1;
        scoreGame = 0;
        level = 1;
        Sprite.reloadSprites();
        map  = new GameMap(level);
        isWin = false;
    }


    public void start() {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        victory_bPane.setCenter(null);
        root.getChildren().addAll(canvas, victory_bPane);
        gameInfo.addToGroup(root);
        // Tao scene
        Scene scene = new Scene(root);
        // Them scene vao stage
        stage.setScene(scene);
        stage.show();
        entities = map.getEntities();
        stillObjects = map.getStillObjects();
        bomberman.setDefaultPosition();
        entities.add(bomberman);

        entities.add(bonus);
        if (MenuController.ok) {
            mediaGameStart.play();
        }
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (!isWin) {
                    if (stop) {
                        setstop(scene);
                    } else {
                        if (!bomberman.isDead()) {
                            bomberman.handleKeyevent(scene);
                        } else {
                            if (live == 0) {
                                this.stop();
                                if (MenuController.ok) {
                                    mediaGameEnd.play();
                                }
                                try {
                                    Thread.sleep(3000);
                                    backToMenu();
                                } catch (Exception exception) {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        if (levelCompleted) {
                            loadNewLevel(++level);
                        }
                        update();
                        render();
                        try {
                            Thread.sleep(75);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        gameVictory();
                        this.stop();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        timer.start();
    }

    public void update() {
        for (int i = entities.size() - 1; i >= 0; i--) {
            entities.get(i).update();
        }
        gameInfo.update();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //gc.setFill(Color.BLACK);
        //gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gameInfo.render(gc);
        stillObjects.forEach(g -> g.render(gc));
        for (int i = entities.size() - 1; i >= 0; i--) {
            entities.get(i).render(gc);
        }

    }

    public void loadNewLevel(int level) {
        map = null;
        Sprite.reloadSprites();
        map = new GameMap(level);
        entities = map.getEntities();
        stillObjects = map.getStillObjects();
        levelCompleted = false;
        Portal.canPass = false;
        bomberman.setDefaultPosition();
        entities.add(bomberman);
    }


    public void setstop(Scene scene) {
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {
                    stop = (!stop);
                }
            }
        });
    }

    public void backToMenu() throws Exception {
        URL url = new File("src/FXML/General.fxml").toURI().toURL();
        Parent root1 = FXMLLoader.load(url);
        MainGame.scene = new Scene(root1, 1296, 720);
        URL url1 = new File("src/FXML/Style.css").toURI().toURL();
        MainGame.scene.getStylesheets().add(url1.toExternalForm());
        stage.setScene(MainGame.scene);
        //stage.setMaximized(true);
        stage.show();
    }

    public void gameVictory() throws IOException {
        URL url = new File("src/FXML/Congrat.fxml").toURI().toURL();
        AnchorPane Apane = FXMLLoader.load(url);
        victory_bPane.setCenter(Apane);
    }
}
