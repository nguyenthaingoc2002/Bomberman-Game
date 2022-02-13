package uet.oop.bomberman.entities.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.graphics.EnemySprite;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by Quynhbes on 11/15/2021.
 */
public class Mushroom extends Enemy {
    public Mushroom(int xUnit, int yUnit, Image img, String firstDirection, int way) {
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
    }

    public void horizontalMove()  {
        if (moveToRight && canMove(x + step, y, null)) {
            this.img = Sprite.movingSprite(EnemySprite.mushroom_right1, EnemySprite.mushroom_right2, EnemySprite.mushroom_right3,
                    EnemySprite.mushroom_right4, EnemySprite.mushroom_right5, EnemySprite.mushroom_right6, EnemySprite.mushroom_right7, animate).getFxImage();
            animate++;
            moveRight();
            if (animate > 6) {
                animate = 0;
            }
        } else if (!canMove(x + step, y, null)) {
            moveToRight = false;
            animate = 0;
        }

        if (!moveToRight && canMove(x - step, y, null)) {
            this.img = Sprite.movingSprite(EnemySprite.mushroom_left1, EnemySprite.mushroom_left2, EnemySprite.mushroom_left3,
                    EnemySprite.mushroom_left4, EnemySprite.mushroom_left5, EnemySprite.mushroom_left6, EnemySprite.mushroom_left7, animate).getFxImage();
            animate++;
            moveLeft();
            if (animate > 6) {
                animate = 0;
            }
        } else if (!canMove(x - step, y, null)) {
            moveToRight = true;
            animate = 0;
        }

    }

    @Override
    public void verticalMove() {
        if (moveToBottom && canMove(x, y + step, null)) {
            this.img = Sprite.movingSprite(EnemySprite.mushroom_forward1, EnemySprite.mushroom_forward2, EnemySprite.mushroom_forward3,
                    EnemySprite.mushroom_forward4, EnemySprite.mushroom_forward5, EnemySprite.mushroom_forward6, EnemySprite.mushroom_forward7, animate).getFxImage();
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
            this.img = Sprite.movingSprite(EnemySprite.mushroom_backward1, EnemySprite.mushroom_backward2, EnemySprite.mushroom_backward3,
                    EnemySprite.mushroom_backward4, EnemySprite.mushroom_backward5, EnemySprite.mushroom_backward6, EnemySprite.mushroom_backward7, animate).getFxImage();
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
    public void setLocationOnMap() {
        GameMap.MapEnemy[yUnit][xUnit] = '0';
        setxUnit(x);
        setyUnit(y + 15);
        GameMap.MapEnemy[yUnit][xUnit] = 'e';
    }
}
