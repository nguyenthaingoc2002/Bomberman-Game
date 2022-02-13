package uet.oop.bomberman.entities.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.graphics.EnemySprite;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by Quynhbes on 11/15/2021.
 */
public class Skull extends Enemy {
    public Skull(int xUnit, int yUnit, Image img, String firstDirection, int way) {
        super(xUnit, yUnit, img, firstDirection, way);
    }

    @Override
    public void update() {
        if (!isDead()) {
            verticalMove();
            setLocationOnMap();
            isEnemyDead();
        } else {
            BombermanGame.entities.remove(this);
            GameMap.countEnemy--;
        }
//        System.out.println("xUnit:" + xUnit + " yUnit:" + yUnit);
//        System.out.println(Level1.Map[yUnit][xUnit]);
    }

    @Override
    public void horizontalMove() {

    }

    @Override
    protected void left() {

    }

    @Override
    protected void right() {

    }

    @Override
    protected void top() {

    }

    @Override
    protected void bottom() {

    }

    @Override
    public void verticalMove() {
        if (moveToBottom && canMove(x, y + step, null)) {
            this.img = Sprite.movingSprite(EnemySprite.skull_forward1, EnemySprite.skull_forward2, EnemySprite.skull_forward3,
                    EnemySprite.skull_forward4, EnemySprite.skull_forward5, EnemySprite.skull_forward6, EnemySprite.skull_forward7, animate).getFxImage();
            animate++;
            moveBottom();
            if (animate > 6) {
                animate = 0;
            }
        } else if (!canMove(x, y + step, null)) {
            moveToBottom = false;
            animate = 0;
        }

        if (!moveToBottom && canMove(x, y - step, null)) {
            this.img = Sprite.movingSprite(EnemySprite.skull_backward1, EnemySprite.skull_backward2, EnemySprite.skull_backward3,
                    EnemySprite.skull_backward4, EnemySprite.skull_backward5, EnemySprite.skull_backward6, EnemySprite.skull_backward7, animate).getFxImage();
            animate++;
            moveTop();
            if (animate > 6) {
                animate = 0;
            }
        } else if (!canMove(x, y - step, null)) {
            moveToBottom = true;
            animate = 0;
        }

    }

    @Override
    public void setLocationOnMap() {
        GameMap.MapEnemy[yUnit][xUnit] = '0';
        setxUnit(x);
        setyUnit(y + 35);
        GameMap.MapEnemy[yUnit][xUnit] = 'e';
    }


}
