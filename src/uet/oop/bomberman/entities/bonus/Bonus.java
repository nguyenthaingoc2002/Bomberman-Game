package uet.oop.bomberman.entities.bonus;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.concurrent.ThreadLocalRandom;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.Map.GameMap.*;
import static uet.oop.bomberman.entities.Exploded.size;
import static uet.oop.bomberman.entities.Bomber.MOVE_DISTANCE;
import static uet.oop.bomberman.entities.Bomber.live;
import static uet.oop.bomberman.entities.Bomber.maxBomb;

public class Bonus extends Entity {
    private int typeBonus;
    private long timeDie = 0;
    public static long timeStart;

    public Bonus() {
        isDead = true;
        timeStart = System.currentTimeMillis();
    }

    public void loadImg() {
        switch (typeBonus)
        {
            case 1:
            {
                img = Sprite.powerup_bombs.getFxImage();
                break;
            }
            case 2:
            {
                img = Sprite.powerup_speed.getFxImage();
                break;
            }
            case 3:
            {
                img = Sprite.powerup_detonator.getFxImage();
                break;
            }
            case 4:
            {
                img = Sprite.powerup_flames.getFxImage();
                break;
            }
            default:
            {
                break;
            }
        }
    }

    public void init() {
        if (isDead && System.currentTimeMillis() - timeStart - timeDie > 10000 )
        {
            int random , random1 , random2;
            random = 1 + (int)(Math.random() * 4);
            typeBonus = random;
            do
            {
                random1 = ThreadLocalRandom.current().nextInt(0,16);
                random2 = ThreadLocalRandom.current().nextInt(0,12);

            }while ( MapBrick[random2][random1] == 'b' || Map[random2][random1] == '*' );
            yUnit = random2;
            xUnit = random1;

            x = xUnit * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE * 5;
            y = yUnit * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
            isDead = false;
            loadImg();
        }
    }

    public void setTypeBonus(int typeBonus) {
        this.typeBonus = typeBonus;
    }

    public void setTimeDie(long timeDie) {
        this.timeDie = timeDie;
    }

    public void powerup() {
        if (!isDead) {
            switch (typeBonus)
            {
                case 1:
                {
                    maxBomb++;
                    break;
                }
                case 2:
                {
                    MOVE_DISTANCE = MOVE_DISTANCE + 4;
                    break;
                }
                case 3:
                {
                    live++;
                    break;
                }
                case 4:
                {
                    size++;
                    break;
                }
            }
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        if (!isDead) {
            gc.drawImage(img, x, y);
        }
    }
    @Override
    public void update() {
        init();
    }
}
