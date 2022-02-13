package uet.oop.bomberman.entities;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import uet.oop.bomberman.BombermanGame;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.bonus;
import static uet.oop.bomberman.Map.GameMap.*;

import uet.oop.bomberman.Control.MenuController;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.entities.Enemy.Boss;
import uet.oop.bomberman.entities.bonus.Bonus;
import uet.oop.bomberman.graphics.PlayerSprite;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;

import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;
import static uet.oop.bomberman.Map.GameMap.*;
import static uet.oop.bomberman.graphics.PlayerSprite.*;

import static javafx.scene.input.KeyCode.*;

public class Bomber extends Entity{
    public static final String GO_LEFT = "LEFT";
    public static final String GO_RIGHT = "RIGHT";
    public static final String GO_FORWARD = "FORWARD";
    public static final String GO_BACKWARD = "BACKWARD";

    private long dead_time_start;
    private long dead_time_end;
    private String moveState;
    public static int MOVE_DISTANCE = 8;
    public static int live = 3;
    public static int maxBomb = 1;
    public static int currentBomb = 0;

    private int curBomb_X;
    private int curBomb_Y;
    public static boolean isInBombSquare = false;

    private final Media soundFire = new Media(new File("res/sound/fire.wav").toURI().toString());

    private final Media soundBonus = new Media(new File("res/sound/bonus.wav").toURI().toString());

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }


    @Override
    public void update() {
        if (!isDead) {
            isPlayerDead();
            if (isInBombSquare) {
                isInBombSquare();
            }
            if (isPassed()) {
                BombermanGame.levelCompleted = true;
            }
        } else {
            if (animate == 9) {
                long dead_time_current = System.currentTimeMillis();
                //System.out.println(dead_time_current + "        " + dead_time_end);
                if (dead_time_current > dead_time_end) {
                    isDead = false;
                    setDefaultPosition();
                    animate = 0;
                }
            } else {
                //System.out.println(animate);
                img = PlayerSprite.movingSprite(PlayerSprite.player_dead1, PlayerSprite.player_dead2, PlayerSprite.player_dead3,
                        PlayerSprite.player_dead4, PlayerSprite.player_dead5, PlayerSprite.player_dead6,
                        PlayerSprite.player_dead7, PlayerSprite.player_dead8, PlayerSprite.player_dead9, animate).getFxImage();
                if (animate < 9) {
                    animate++;

                }
                if (animate == 9) {
                    live--;
                    img = null;
                }
            }
        }
    }

    public boolean isPlayerDead() {
        setxUnit(x);
        setyUnit(y + 15);
        int xUnit1 = (x + SCALED_PLAYER_WIDTH - SCALED_SIZE * 5 - 20) / SCALED_SIZE;
        int yUnit1 = (y + SCALED_PLAYER_HEIGHT - SCALED_SIZE - 15) / SCALED_SIZE;
        int xUnit2 = (x + SCALED_PLAYER_WIDTH - 20 - SCALED_SIZE * 5) / SCALED_SIZE;
        int yUnit2 = (y + SCALED_PLAYER_HEIGHT - 27 - SCALED_SIZE) / SCALED_SIZE;
        //System.out.println(Level1.Map[yUnit][xUnit]);
        if ((xUnit2 == bonus.getxUnit() && yUnit2 == bonus.getyUnit()) && !bonus.isDead) {
            if (MenuController.ok) {
                MediaPlayer mediaBonus = new MediaPlayer(soundBonus);
                mediaBonus.play();
            }
            bonus.powerup();
            bonus.isDead = true;
            bonus.setTimeDie(System.currentTimeMillis() - Bonus.timeStart);
        }

        if (crashWithBoss()) {
            setDead(true);
            dead_time_start = System.currentTimeMillis();
            dead_time_end = dead_time_start + 5000;
            return true;
        }

        if (Map[yUnit][xUnit] == 'd' || Map[yUnit1][xUnit1] == 'd' ||
                MapEnemy[yUnit][xUnit] == 'e' || MapEnemy[yUnit1][xUnit1] == 'e') {
            animate = 0;
            setDead(true);
            dead_time_start = System.currentTimeMillis();
            dead_time_end = dead_time_start + 5000;
            return true;
        }
        return false;
    }

    private boolean crashWithBoss() {
        if (y < Boss.y_Boss + Sprite.SCALED_SIZE * 4) {
            if (y < Boss.y_Boss + Sprite.SCALED_SIZE * 2) {
                if ((x < Boss.x_Boss && x + Sprite.SCALED_SIZE > Boss.x_Boss)
                        || (x > Boss.x_Boss && x < Boss.x_Boss + 224)){
                    return true;
                }
            } else {
                int left1 = Boss.x_Boss + 26;
                int right1 = left1 + Sprite.SCALED_SIZE;
                int left2 = Boss.x_Boss + Sprite.SCALED_SIZE * 3 + 16;
                int right2 = left2 + Sprite.SCALED_SIZE;
                if (((x < left1 && x + Sprite.SCALED_SIZE > left1) || (x < right1 && x + Sprite.SCALED_SIZE > right1))
                        || ((x < left2 && x + Sprite.SCALED_SIZE > left2) || (x < right2 && x + Sprite.SCALED_SIZE > right2))) {
                    return true;
                } else if (x > right1 && x + Sprite.SCALED_SIZE < left2 && y <Boss.y_Boss + Sprite.SCALED_SIZE * 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPassed() {
        return Portal.canPass && ((this.xUnit == PortalLocation_x && this.yUnit == PortalLocation_y - 1));
    }


    public void handleKeyevent(Scene scene) {
        handleKeypressed(scene);
        handleKeyReleased(scene);
    }


    public void handleKeypressed(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (isDead) {
                    event = null;
                } else {
                    switch (event.getCode()) {
                        case UP: {
                            moveState = GO_BACKWARD;
                            if (canMove(x, y - MOVE_DISTANCE, moveState)) {
                                y = y - MOVE_DISTANCE;

                            }
                            sprite_MovingBackward();
                            break;
                        }
                        case DOWN: {
                            moveState = GO_FORWARD;
                            if (canMove(x, y + MOVE_DISTANCE, moveState)) {
                                y = y + MOVE_DISTANCE;
                                x = ((x + SCALED_SIZE / 2) / SCALED_SIZE) * SCALED_SIZE;
                            }
                            sprite_MovingForward();
                            break;
                        }
                        case LEFT: {
                            moveState = GO_LEFT;
                            if (canMove(x - MOVE_DISTANCE, y, moveState)) {
                                x = x - MOVE_DISTANCE;
                            }
                            sprite_MovingLeft();
                            break;
                        }
                        case RIGHT: {
                            moveState = GO_RIGHT;
                            if (canMove(x + MOVE_DISTANCE, y, moveState)) {
                                x = x + MOVE_DISTANCE;
                            }
                            sprite_MovingRight();
                            break;
                        }
                        case SPACE: {
                            break;
                        }

                    }
                }
            }
        });
    }

    public void handleKeyReleased(Scene scene) {
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (isDead) {
                    event = null;
                } else {
                    switch (event.getCode()) {
                        case UP:
                            img = PlayerSprite.player_backward1.getFxImage();
                            break;
                        case DOWN:
                            img = PlayerSprite.player_forward1.getFxImage();
                            break;
                        case LEFT:
                            img = PlayerSprite.player_left1.getFxImage();
                            break;
                        case RIGHT:
                            img = PlayerSprite.player_right1.getFxImage();
                            break;
                        case SPACE:
                            if (currentBomb < maxBomb) {
                                Entity bomb = new Bomb((x + Sprite.SCALED_SIZE / 2 - SCALED_SIZE * 5) / Sprite.SCALED_SIZE,
                                        (y + Sprite.SCALED_SIZE / 2 - SCALED_SIZE) / Sprite.SCALED_SIZE, Sprite.Bomb1.getFxImage());
                                BombermanGame.entities.add(bomb);
                                currentBomb++;
                                if (MenuController.ok) {
                                    MediaPlayer mediaFire = new MediaPlayer(soundFire);
                                    mediaFire.play();
                                }
                                curBomb_X = ((x + Sprite.SCALED_SIZE / 2 - SCALED_SIZE * 5) / Sprite.SCALED_SIZE) * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE * 5;
                                curBomb_Y = ((y + Sprite.SCALED_SIZE / 2 - SCALED_SIZE) / Sprite.SCALED_SIZE) * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
                                MapBrick[(curBomb_Y - SCALED_SIZE) / SCALED_SIZE][(curBomb_X - SCALED_SIZE * 5) / SCALED_SIZE] = 'r';
                                isInBombSquare = true;
                            }
                            break;
                        case ESCAPE: {
                            BombermanGame.stop = !BombermanGame.stop;
                        }

                    }
                }
            }
        });
    }

    private void sprite_MovingBackward() {
        this.img = PlayerSprite.movingSprite(PlayerSprite.player_backward1, PlayerSprite.player_backward2,
                PlayerSprite.player_backward3, PlayerSprite.player_backward4, PlayerSprite.player_backward5,
                PlayerSprite.player_backward6, PlayerSprite.player_backward7, animate).getFxImage();
        animate++;
        if (animate > 6) {
            animate = 0;
        }
    }

    private void sprite_MovingForward() {
        this.img = PlayerSprite.movingSprite(PlayerSprite.player_forward1, PlayerSprite.player_forward2,
                PlayerSprite.player_forward3, PlayerSprite.player_forward4, PlayerSprite.player_forward5,
                PlayerSprite.player_forward6, PlayerSprite.player_forward7, animate).getFxImage();
        animate++;
        if (animate > 6) {
            animate = 0;
        }
    }

    private void sprite_MovingLeft() {
        this.img = PlayerSprite.movingSprite(PlayerSprite.player_left1, PlayerSprite.player_left2,
                PlayerSprite.player_left3, PlayerSprite.player_left4, PlayerSprite.player_left5,
                PlayerSprite.player_left6, PlayerSprite.player_left7, animate).getFxImage();
        animate++;
        if (animate > 6) {
            animate = 0;
        }
    }

    private void sprite_MovingRight() {
        this.img = PlayerSprite.movingSprite(PlayerSprite.player_right1, PlayerSprite.player_right2,
                PlayerSprite.player_right3, PlayerSprite.player_right4, PlayerSprite.player_right5,
                PlayerSprite.player_right6, PlayerSprite.player_right7, animate).getFxImage();
        animate++;
        if (animate > 6) {
            animate = 0;
        }
    }

    public void setDefaultPosition() {
        if (BombermanGame.level < 3) {
            x = SCALED_SIZE * 7;
            y = SCALED_SIZE * 2;
            setxUnit(x);
            setyUnit(y);
            img = PlayerSprite.player_forward1.getFxImage();
        } else {
            x = SCALED_SIZE * 19;
            y = SCALED_SIZE * 12 - 10;
            setxUnit(x);
            setyUnit(y);
            img = PlayerSprite.player_backward1.getFxImage();
        }
    }

    protected void isInBombSquare() {
        if ((Math.abs(x - curBomb_X) > SCALED_SIZE) || (Math.abs(y - curBomb_Y) > SCALED_SIZE)) {
            Map[(curBomb_Y - SCALED_SIZE) / SCALED_SIZE][(curBomb_X - SCALED_SIZE * 5) / SCALED_SIZE] = '*';
            isInBombSquare = false;
        }
    }

    public boolean canMove(int x, int y, String state) {

        int x1 = (x - SCALED_SIZE * 5) / SCALED_SIZE;
        int x2 = (x + SCALED_PLAYER_WIDTH  - SCALED_SIZE * 5) / SCALED_SIZE;
        int y1 = (y + 10 - SCALED_SIZE) / SCALED_SIZE;
        int y2 = (y + SCALED_PLAYER_HEIGHT - 10 - SCALED_SIZE) / SCALED_SIZE;

        if (GameMap.Map[y1][x1] == '*' || GameMap.Map[y1][x2] == '*'
                || GameMap.Map[y2][x1] == '*' || GameMap.Map[y2][x2] == '*')
        {
            return false;
        } else {
            return true;
        }
    }
}
