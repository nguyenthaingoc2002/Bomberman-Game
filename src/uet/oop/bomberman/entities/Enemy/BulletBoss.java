package uet.oop.bomberman.entities.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.EnemySprite;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.HEIGHT;


public class BulletBoss extends Entity {
    private final int DISTANCE = 8;
    public BulletBoss(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public void setLocationOnMap() {
        GameMap.MapEnemy[yUnit][xUnit] = '0';
        setxUnit(x);
        setyUnit(y + 40);
        GameMap.MapEnemy[yUnit][xUnit] = 'e';
    }

    @Override
    public void update() {
        if (y < Sprite.SCALED_SIZE * HEIGHT - Sprite.SCALED_SIZE * 3) {
            y += DISTANCE;
            setLocationOnMap();
            img = Sprite.movingSprite(EnemySprite.bullet1, EnemySprite.bullet2, EnemySprite.bullet3, EnemySprite.bullet2, animate).getFxImage();
            animate++;
            if (animate > 3) {
                animate = 0;
            }
        } else {
            GameMap.MapEnemy[yUnit][xUnit] = '0';
            BombermanGame.entities.remove(this);
        }
    }
}
