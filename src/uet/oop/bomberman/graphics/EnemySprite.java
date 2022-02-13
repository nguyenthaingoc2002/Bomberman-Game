package uet.oop.bomberman.graphics;

/**
 * Created by Quynhbes on 11/17/2021.
 */
public class EnemySprite extends Sprite {
    public static final int DEFAULT_SIZE_WIDTH = 19;
    public static final int DEFAULT_SIZE_HEIGHT = 22;

    public static final int DEFAULT_CRAB_SIZE_W = 24;
    public static final int DEFAULT_CRAB_SIZE_H = 27;

    public static final int DEFAULT_SKULL_SIZE_HEIGHT = 29;



    public static Sprite mushroom_right1 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 0, 1, SpriteSheet.enemy, 32, 32);
    public static Sprite mushroom_right2 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 1, 1, SpriteSheet.enemy, 32, 32);
    public static Sprite mushroom_right3 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 2, 1, SpriteSheet.enemy, 32, 32);
    public static Sprite mushroom_right4 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 3, 1, SpriteSheet.enemy, 32, 32);
    public static Sprite mushroom_right5 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 4, 1, SpriteSheet.enemy, 32, 32);
    public static Sprite mushroom_right6 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 5, 1, SpriteSheet.enemy, 32, 32);
    public static Sprite mushroom_right7 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 6, 1, SpriteSheet.enemy, 32, 32);

    /*
    |--------------------------------------------------------------------------
    | Mushroom left
    |--------------------------------------------------------------------------
     */
    public static Sprite mushroom_left1 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 0, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_left2 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 1, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_left3 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 2, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_left4 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 3, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_left5 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 4, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_left6 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 5, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_left7 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 6, 3, SpriteSheet.enemy, 16, 16);

    /*
   |--------------------------------------------------------------------------
   | Mushroom forward.
   |--------------------------------------------------------------------------
    */
    public static Sprite mushroom_forward1 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 0, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_forward2 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 1, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_forward3 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 2, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_forward4 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 3, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_forward5 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 4, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_forward6 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 5, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_forward7 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 6, 2, SpriteSheet.enemy, 16, 16);

    /*
   |--------------------------------------------------------------------------
   | Mushroom backward.
   |--------------------------------------------------------------------------
    */
    public static Sprite mushroom_backward1 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 0, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_backward2 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 1, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_backward3 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 2, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_backward4 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 3, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_backward5 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 4, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_backward6 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 5, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite mushroom_backward7 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SIZE_HEIGHT, 6, 0, SpriteSheet.enemy, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Skull backward.
    |--------------------------------------------------------------------------
     */
    public static Sprite skull_backward1 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 7, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_backward2 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 8, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_backward3 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 9, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_backward4 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 10, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_backward5 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 11, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_backward6 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 12, 0, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_backward7 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 13, 0, SpriteSheet.enemy, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Skull forward
    |--------------------------------------------------------------------------
     */
    public static Sprite skull_forward1 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 7, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_forward2 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 8, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_forward3 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 9, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_forward4 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 10, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_forward5 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 11, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_forward6 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 12, 2, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_forward7 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 13, 2, SpriteSheet.enemy, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Skull right.
    |--------------------------------------------------------------------------
     */
    public static Sprite skull_right1 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 7, 1, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_right2 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 8, 1, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_right3 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 9, 1, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_right4 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 10, 1, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_right5 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 11, 1, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_right6 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 12, 1, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_right7 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 13, 1, SpriteSheet.enemy, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Skull left.
    |--------------------------------------------------------------------------
     */
    public static Sprite skull_left1 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 7, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_left2 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 8, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_left3 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 9, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_left4 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 10, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_left5 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 11, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_left6 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 12, 3, SpriteSheet.enemy, 16, 16);
    public static Sprite skull_left7 = new EnemySprite(DEFAULT_SIZE_WIDTH, DEFAULT_SKULL_SIZE_HEIGHT, 13, 3, SpriteSheet.enemy, 16, 16);

    /*
    |--------------------------------------------------------------------------
    | Crab backward.
    |--------------------------------------------------------------------------
     */
    public static Sprite crab_backward1 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 12, 0, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_backward2 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 13, 0, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_backward3 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 14, 0, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_backward4 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 15, 0, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_backward5 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 16, 0, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_backward6 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 17, 0, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_backward7 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 18, 0, SpriteSheet.enemy, 24, 27);

    /*
    |--------------------------------------------------------------------------
    | Crab right.
    |--------------------------------------------------------------------------
     */
    public static Sprite crab_right1 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 12, 1, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_right2 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 13, 1, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_right3 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 14, 1, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_right4 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 15, 1, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_right5 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 16, 1, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_right6 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 17, 1, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_right7 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 18, 1, SpriteSheet.enemy, 24, 27);

    /*
   |--------------------------------------------------------------------------
   | Crab forward.
   |--------------------------------------------------------------------------
    */
    public static Sprite crab_forward1 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 12, 2, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_forward2 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 13, 2, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_forward3 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 14, 2, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_forward4 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 15, 2, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_forward5 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 16, 2, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_forward6 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 17, 2, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_forward7 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 18, 2, SpriteSheet.enemy, 24, 27);

    /*
  |--------------------------------------------------------------------------
  | Crab left.
  |--------------------------------------------------------------------------
   */
    public static Sprite crab_left1 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 12, 3, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_left2 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 13, 3, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_left3 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 14, 3, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_left4 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 15, 3, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_left5 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 16, 3, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_left6 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 17, 3, SpriteSheet.enemy, 24, 27);
    public static Sprite crab_left7 = new EnemySprite(DEFAULT_CRAB_SIZE_W, DEFAULT_CRAB_SIZE_H, 18, 3, SpriteSheet.enemy, 24, 27);

    /*
    |--------------------------------------------------------------------------
    | Green left.
    |--------------------------------------------------------------------------
    */
    public static Sprite green_left1 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 0, 6, SpriteSheet.enemy, 24, 27);
    public static Sprite green_left2 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 1, 6, SpriteSheet.enemy, 24, 27);
    public static Sprite green_left3 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 2, 6, SpriteSheet.enemy, 24, 27);
    public static Sprite green_left4 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 3, 6, SpriteSheet.enemy, 24, 27);
    public static Sprite green_left5 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 4, 6, SpriteSheet.enemy, 24, 27);

    /*
    |--------------------------------------------------------------------------
    | Green forward.
    |--------------------------------------------------------------------------
    */
    public static Sprite green_forward1 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 0, 7, SpriteSheet.enemy, 24, 27);
    public static Sprite green_forward2 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 1, 7, SpriteSheet.enemy, 24, 27);
    public static Sprite green_forward3 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 2, 7, SpriteSheet.enemy, 24, 27);
    public static Sprite green_forward4 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 3, 7, SpriteSheet.enemy, 24, 27);
    public static Sprite green_forward5 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 4, 7, SpriteSheet.enemy, 24, 27);

    /*
    |--------------------------------------------------------------------------
    | Green right.
    |--------------------------------------------------------------------------
    */
    public static Sprite green_right1 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 0, 8, SpriteSheet.enemy, 24, 27);
    public static Sprite green_right2 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 1, 8, SpriteSheet.enemy, 24, 27);
    public static Sprite green_right3 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 2, 8, SpriteSheet.enemy, 24, 27);
    public static Sprite green_right4 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 3, 8, SpriteSheet.enemy, 24, 27);
    public static Sprite green_right5 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 4, 8, SpriteSheet.enemy, 24, 27);

    /*
    |--------------------------------------------------------------------------
    | Green backward.
    |--------------------------------------------------------------------------
    */
    public static Sprite green_backward1 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 0, 9, SpriteSheet.enemy, 24, 27);
    public static Sprite green_backward2 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 1, 9, SpriteSheet.enemy, 24, 27);
    public static Sprite green_backward3 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 2, 9, SpriteSheet.enemy, 24, 27);
    public static Sprite green_backward4 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 3, 9, SpriteSheet.enemy, 24, 27);
    public static Sprite green_backward5 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 4, 9, SpriteSheet.enemy, 24, 27);

    public static Sprite boss1 = new EnemySprite(112, 96, 0, 0, SpriteSheet.boss, 24, 27);

    public static Sprite bullet1 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 7, 0, SpriteSheet.boss, 24, 27);
    public static Sprite bullet2 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 7, 2, SpriteSheet.boss, 24, 27);
    public static Sprite bullet3 = new EnemySprite(DEFAULT_SIZE, DEFAULT_SIZE, 7, 1, SpriteSheet.boss, 24, 27);


    public EnemySprite(int sizeWidth, int sizeHeight, int x, int y, SpriteSheet sheet, int rw, int rh) {
        super(sizeWidth, sizeHeight, x, y, sheet, rw, rh);
    }


}
