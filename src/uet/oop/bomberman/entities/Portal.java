package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.graphics.Sprite.*;

/**
 * Created by Quynhbes on 11/10/2021.
 */
public class Portal extends Entity {
    private int animate1 = 0;
    public static boolean canPass = false;

    public Portal(int x, int y, Image image){
        super(x, y, image);
    }

    @Override
    public void update() {
        if (GameMap.countEnemy > 0) {
            img = Sprite.movingSprite(Sprite.entrance1, Sprite.entrance2, Sprite.entrance3, Sprite.entrance4, animate).getFxImage();
            animate++;
            if (animate > 3) {
                animate = 0;
            }
        } else {
            if (animate < 15) {
                img = Sprite.movingSprite(open_portal1, open_portal2, open_portal3, open_portal4,
                        open_portal5, open_portal6, open_portal7, open_portal8, open_portal9,
                        open_portal10, open_portal11, open_portal12, open_portal13, animate).getFxImage();
                if (animate < 13) {
                    animate++;
                } else if (animate == 13) {
                    img = open_portal14.getFxImage();
                    y -= SCALED_SIZE;
                    animate++;
                    //Entity portal = this;
                    BombermanGame.entities.remove(this);
                    BombermanGame.entities.add(0, this);
                } else if (animate == 14) {
                    img = open_portal15.getFxImage();
                    animate++;
                }
            } else {
                canPass = true;
                img = Sprite.movingSprite(portal1, portal2, portal3, portal4, animate1). getFxImage();
                animate1++;
                if (animate1 > 3) {
                    animate1 = 0;
                }
            }
        }
    }
}
