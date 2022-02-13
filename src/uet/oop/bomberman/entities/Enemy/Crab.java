package uet.oop.bomberman.entities.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.graphics.EnemySprite;
import uet.oop.bomberman.graphics.Sprite;

public class Crab extends Enemy{
    public int firstX;
    public int firstY;
    public Crab(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        firstX = xUnit * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE * 5;
        firstY = yUnit * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
    }

    public Crab(int xUnit, int yUnit, Image img, String firstDirection, int way) {
        super(xUnit, yUnit, img, firstDirection, way);
        y -= 5;
    }

    @Override
    public void update() {
        //System.out.println(bomberman.getX()+ " " + bomberman.getY() + " " + x + " " + y);
        //System.out.println(Map[y/48][x/48]);
        if (!isDead()) {
            //System.out.println(bomberman.getX()+ " " + bomberman.getY() + " " + x + " " + y);
            //bfs();
            horizontalMove();
            setLocationOnMap();
            isEnemyDead();
        } else {
            BombermanGame.entities.remove(this);
            GameMap.countEnemy--;
        }

    }

    @Override
    public void setLocationOnMap() {
        GameMap.MapEnemy[yUnit][xUnit] = '0';
        setxUnit(x);
        setyUnit(y + 5);
        GameMap.MapEnemy[yUnit][xUnit] = 'e';
    }

    @Override
    public void horizontalMove()  {
        if (moveToRight && canMove(x + step, y, null)) {
            this.img = Sprite.movingSprite(EnemySprite.crab_right1, EnemySprite.crab_right2, EnemySprite.crab_right3,
                    EnemySprite.crab_right4, EnemySprite.crab_right5, EnemySprite.crab_right6, EnemySprite.crab_right7, animate).getFxImage();
            ++animate;
            if (animate > 6) animate = 0;
            moveRight();
        } else if (!canMove(x + step, y, null)) {
            moveToRight = false;
            animate = 0;
        }

        if (!moveToRight && canMove(x - step, y, null)) {
            this.img = Sprite.movingSprite(EnemySprite.crab_left1, EnemySprite.crab_left2, EnemySprite.crab_left3,
                    EnemySprite.crab_left4, EnemySprite.crab_left5, EnemySprite.crab_left6, EnemySprite.crab_left7, animate).getFxImage();
            ++animate;
            if (animate > 6) animate = 0;
            moveLeft();
        } else if (!canMove(x - step, y, null)) {
            moveToRight = true;
            animate = 0;
        }

    }

    @Override
    public void verticalMove() {

    }

    @Override
    public void left() {
        this.img = Sprite.movingSprite(EnemySprite.crab_left1, EnemySprite.crab_left2, EnemySprite.crab_left3,
                EnemySprite.crab_left4, EnemySprite.crab_left5, EnemySprite.crab_left6, EnemySprite.crab_left7, animate).getFxImage();
        ++animate;
        if (animate > 6) animate = 0;
        moveLeft();

    }

    @Override
    public void right() {
        this.img = Sprite.movingSprite(EnemySprite.crab_right1, EnemySprite.crab_right2, EnemySprite.crab_right3,
                EnemySprite.crab_right4, EnemySprite.crab_right5, EnemySprite.crab_right6, EnemySprite.crab_right7, animate).getFxImage();
        ++animate;
        if (animate > 6) animate = 0;
        moveRight();

    }

    @Override
    public void top() {
        this.img = Sprite.movingSprite(EnemySprite.crab_backward1,EnemySprite.crab_backward2, EnemySprite.crab_backward3,
                EnemySprite.crab_backward4, EnemySprite.crab_backward5, EnemySprite.crab_backward6, EnemySprite.crab_backward7, animate).getFxImage();
        ++animate;
        if (animate > 6) animate = 0;
        moveTop();

    }

    @Override
    public void bottom() {
        this.img = Sprite.movingSprite(EnemySprite.crab_forward1, EnemySprite.crab_forward2, EnemySprite.crab_forward3,
                EnemySprite.crab_forward4, EnemySprite.crab_forward5, EnemySprite.crab_forward6, EnemySprite.crab_forward7, animate).getFxImage();
        ++animate;
        if (animate > 6) animate = 0;
        moveBottom();

    }

}
