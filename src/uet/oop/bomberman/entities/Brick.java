package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.graphics.Sprite;


/**
 * Created by Quynhbes on 11/10/2021.
 */
public class Brick extends Entity {
    public boolean isDestroyed = false;


    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if (isDestroyed) {
            img = Sprite.movingSprite(Sprite.brick_destroyed1, Sprite.brick_destroyed2, Sprite.brick_destroyed3, Sprite.brick_destroyed4,
                                        Sprite.brick_destroyed5, Sprite.brick_destroyed6, Sprite.brick_destroyed7, animate).getFxImage();
            animate++;
            if (animate > 6) {
                GameMap.brickList.remove(this);
                GameMap.Map[yUnit][xUnit] = '0';
                BombermanGame.stillObjects.add(this);
                BombermanGame.entities.remove(this);
                //System.out.println("x:" + xUnit + " y: " + yUnit + "\n portal_x: " + Level1.PortalLocation_x  + " portal_y: " + Level1.PortalLocation_y);
                if (xUnit == GameMap.PortalLocation_x && yUnit == GameMap.PortalLocation_y) {
                    BombermanGame.entities.add(new Portal(xUnit, yUnit, Sprite.entrance1.getFxImage()));
                }
                BombermanGame.scoreGame++;
            }

        }
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}
