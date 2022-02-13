package uet.oop.bomberman.entities.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.entities.Entity;

/**
 * Created by Quynhbes on 11/11/2021.
 */
public abstract class Enemy extends Entity {
    public static final String HORIZONTAL = "HORIZONTAL";
    public static final String VERTICAL = "VERTICAL";
    public static final int moveRight = 0;
    public static final int moveLeft = 1;
    public static final int moveBottom = 0;
    public static final int moveTop = 1;
    public int firstX;
    public int firstY;


    protected boolean moveToRight;
    protected boolean moveToBottom;
    protected String direction;
    protected final int step = 3;

    public Enemy(int xUnit, int yUnit, Image img, String firstDirection, int way) {
        super(xUnit, yUnit, img);
        x += 5;
        direction = firstDirection;
        switch (firstDirection) {
            case HORIZONTAL:
                if (way == moveRight) {
                    moveToRight = true;
                } else {
                    moveToRight = false;
                }
                break;
            case VERTICAL:
                if (way == moveBottom) {
                    moveToBottom = true;
                } else {
                    moveToBottom = false;
                }
        }
    }

    public Enemy(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {

    }

    public void moveRight() {
        x += step;
    }

    public void moveLeft() {
        x -= step;
    }

    public void moveBottom() {
        y += step;
    }

    public void moveTop() {
        y -= step;
    }

    public abstract void horizontalMove();

    public abstract void verticalMove();

    protected abstract void left();
    protected abstract void right();
    protected abstract void top();
    protected abstract void bottom();

    public boolean isEnemyDead() {
//        setxUnit(x);
//        setyUnit(y + 15);
        if (GameMap.Map[yUnit][xUnit] == 'd') {
            setDead(true);
            GameMap.MapEnemy[yUnit][xUnit] = '0';
            BombermanGame.scoreGame += 2;
            return true;
        } else {
            return false;
        }
    }

    public void setLocationOnMap() {
        GameMap.MapEnemy[yUnit][xUnit] = '0';
        setxUnit(x);
        setyUnit(y);
        GameMap.MapEnemy[yUnit][xUnit] = 'e';
    }

}
