package uet.oop.bomberman.entities.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.EnemySprite;
import uet.oop.bomberman.graphics.Sprite;

/**
 * Created by Quynhbes on 12/6/2021.
 */
public class Boss extends Enemy {

    public static int x_Boss;
    public static int y_Boss;

    private int hp = 15;

    public Boss(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        moveToRight = true;
        y_Boss = y;
    }

    @Override
    public void update() {
        if (!isDead) {
            horizontalMove();
            //setLocationOnMap();
            if ((x + 32) % Sprite.SCALED_SIZE == 0
                    && (x + 32) / Sprite.SCALED_SIZE % 2 == 1) {
                Entity bulletBoss = new BulletBoss((x + 32 - Sprite.SCALED_SIZE * 5) / Sprite.SCALED_SIZE
                        , (y + Sprite.SCALED_SIZE * 3) / Sprite.SCALED_SIZE, EnemySprite.bullet1.getFxImage());
                BombermanGame.entities.add(bulletBoss);
            }
            if ((x + Sprite.SCALED_SIZE * 3 + 16) % Sprite.SCALED_SIZE == 0
                    && (x + Sprite.SCALED_SIZE * 3 + 16) / Sprite.SCALED_SIZE % 2 == 1) {
                Entity bulletBoss = new BulletBoss((x + Sprite.SCALED_SIZE * 3 + 16 - Sprite.SCALED_SIZE * 5) / Sprite.SCALED_SIZE
                        , (y + Sprite.SCALED_SIZE * 3) / Sprite.SCALED_SIZE, EnemySprite.bullet1.getFxImage());
                BombermanGame.entities.add(bulletBoss);
            }
            isEnemyDead();
        } else {
            BombermanGame.isWin = true;
            BombermanGame.entities.remove(this);
        }
    }

    @Override
    public void horizontalMove() {
        if (moveToRight && x + 224 < Sprite.SCALED_SIZE * 21) {
            moveRight();
            x_Boss = x;

        } else if (x + 224 >= Sprite.SCALED_SIZE * 21) {
            moveToRight = false;
        }

        if (!moveToRight && x > Sprite.SCALED_SIZE * 6) {
            moveLeft();
            x_Boss = x;
        } else if (x <= Sprite.SCALED_SIZE * 17) {
            moveToRight = true;
        }
    }
//!(i == yUnit + 3 && j == xUnit + 2) &&
    @Override
    public boolean isEnemyDead() {
        //System.out.println(hp);
        if (hp != 0) {
            setxUnit(x);
            setyUnit(y);
            for (int i = 1; i < yUnit + 4; i++) {
                for (int j = 0; j < xUnit + 5; j++) {
                    if (!(i == yUnit + 3 && j == xUnit + 2) && GameMap.Map[i][j] == 'd') {
                        hp--;
                        return true;
                    }
                }
            }
        } else {
            BombermanGame.scoreGame += 10;
            setDead(true);
            return true;
        }
        return false;
    }

    @Override
    public void verticalMove() {

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
    public void moveRight() {
        x += 4;
    }

    @Override
    public void moveLeft() {
        x -= 4;
    }


}
