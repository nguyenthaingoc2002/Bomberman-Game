package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Control.MenuController;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;

import static uet.oop.bomberman.entities.Bomber.currentBomb;
/**
 * Created by Quynhbes on 11/14/2021.
 */
public class Bomb extends Entity {
    private int countCircle = 0;
    private Media soundExplosion = new Media(new File("res/sound/explosion.wav").toURI().toString());
    private MediaPlayer mediaExplosion = new MediaPlayer(soundExplosion);

    public Bomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public void update() {
        this.img = Sprite.movingSprite(Sprite.Bomb1, Sprite.Bomb2, Sprite.Bomb3, Sprite.Bomb4, animate).getFxImage();
        animate++;
        if (animate > 3) {
            countCircle++;
            animate = 0;
        }
        if (countCircle == 12) {
            GameMap.Map[yUnit][xUnit] = '0';
            GameMap.MapBrick[yUnit][xUnit] = '0';
            Bomber.isInBombSquare = false;
            BombermanGame.entities.add(new Exploded((x- SCALED_SIZE * 5) / SCALED_SIZE,
                    (y - SCALED_SIZE) / SCALED_SIZE, Sprite.exploded_Center.getFxImage()));
            BombermanGame.entities.remove(this);
            currentBomb--;
            if (MenuController.ok) {
                mediaExplosion.play();
            }
        }
    }

}
