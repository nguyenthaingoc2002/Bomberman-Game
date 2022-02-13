package uet.oop.bomberman.graphics;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 * Created by Quynhbes on 11/13/2021.
 */
public class PlayerSprite extends Sprite {
    public static final int DEFAULT_PLAYERSIZE = 19;
    public static final int DEFAULT_SIZE_HEIGHT = 27;
    public static final int SCALED_PLAYER_WIDTH = DEFAULT_PLAYERSIZE * 2;
    public static final int SCALED_PLAYER_HEIGHT = DEFAULT_SIZE_HEIGHT * 2;

    /*
	|--------------------------------------------------------------------------
	| Player move forward.
	|--------------------------------------------------------------------------
	 */
    public static Sprite player_forward1 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 0, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_forward2 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 1, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_forward3 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 2, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_forward4 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 3, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_forward5 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 4, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_forward6 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 5, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_forward7 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 6, 0, SpriteSheet.player, 20, 30);

    /*
	|--------------------------------------------------------------------------
	| Player move left.
	|--------------------------------------------------------------------------
	 */
    public static Sprite player_left1 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 8, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_left2 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 9, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_left3 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 10, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_left4 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 11, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_left5 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 12, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_left6 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 13, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_left7 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 14, 0, SpriteSheet.player, 20, 30);

    /*
	|--------------------------------------------------------------------------
	| Player move backward.
	|--------------------------------------------------------------------------
	 */
    public static Sprite player_backward1 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 16, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_backward2 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 17, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_backward3 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 18, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_backward4 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 19, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_backward5 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 20, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_backward6 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 21, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_backward7 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 22, 0, SpriteSheet.player, 20, 30);

    /*
	|--------------------------------------------------------------------------
	| Player move right.
	|--------------------------------------------------------------------------
	 */
    public static Sprite player_right1 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 24, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_right2 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 25, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_right3 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 26, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_right4 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 27, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_right5 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 28, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_right6 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 29, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_right7 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 30, 0, SpriteSheet.player, 20, 30);

    public static Sprite player_win1 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 31, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_win2 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 32, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_win3 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 33, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_win4 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 34, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_win5 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 35, 0, SpriteSheet.player, 20, 30);

    /*
	|--------------------------------------------------------------------------
	| Player stay.
	|--------------------------------------------------------------------------
	 */
    public static Sprite player_stay1 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 0, 0, SpriteSheet.player, 20, 30);
    public static Sprite player_stay2 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 1, 2, SpriteSheet.player, 20, 30);
    public static Sprite player_stay3 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 2, 2, SpriteSheet.player, 20, 30);
    public static Sprite player_stay4 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 3, 2, SpriteSheet.player, 20, 30);
    public static Sprite player_stay5 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 4, 2, SpriteSheet.player, 20, 30);

    /*
	|--------------------------------------------------------------------------
	| Player dies.
	|--------------------------------------------------------------------------
	 */
    public static Sprite player_dead1 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 0, 1, SpriteSheet.player, 20, 30 );
    public static Sprite player_dead2 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 1, 1, SpriteSheet.player, 20, 30 );
    public static Sprite player_dead3 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 2, 1, SpriteSheet.player, 20, 30 );
    public static Sprite player_dead4 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 3, 1, SpriteSheet.player, 20, 30 );
    public static Sprite player_dead5 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 4, 1, SpriteSheet.player, 20, 30 );
    public static Sprite player_dead6 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 5, 1, SpriteSheet.player, 20, 30 );
    public static Sprite player_dead7 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 6, 1, SpriteSheet.player, 20, 30 );
    public static Sprite player_dead8 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 7, 1, SpriteSheet.player, 20, 30 );
    public static Sprite player_dead9 = new PlayerSprite(DEFAULT_PLAYERSIZE,DEFAULT_SIZE_HEIGHT, 8, 1, SpriteSheet.player, 20, 30 );


    public PlayerSprite(int sizeWidth,int sizeHeight, int x, int y, SpriteSheet sheet, int rw, int rh) {
        super(sizeWidth,sizeHeight, x, y, sheet, rw, rh);
    }

    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, Sprite x3,
                                      Sprite x4, Sprite x5, Sprite x6, int animate) {
        switch (animate) {
            case 0:
                //System.out.println(animate);
                return normal;
            case 1:
                //System.out.println(animate);
                return x1;
            case 2:
                //System.out.println(animate);
                return x2;
            case 3:
                //System.out.println(animate);
                return x3;
            case 4:
                //System.out.println(animate);
                return x4;
            case 5:
                //System.out.println(animate);
                return x5;
            case 6:
                //System.out.println(animate);
                return x6;
        }
        return normal;
    }

    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, Sprite x3,
                                      Sprite x4, Sprite x5, int animate) {
        switch (animate) {
            case 0:
                //System.out.println(animate);
                return normal;
            case 1:
                //System.out.println(animate);
                return x1;
            case 2:
                //System.out.println(animate);
                return x2;
            case 3:
                //System.out.println(animate);
                return x3;
            case 4:
                //System.out.println(animate);
                return x4;
            case 5:
                return x5;
        }
        return normal;
    }

    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, Sprite x3,
                                      Sprite x4, Sprite x5, Sprite x6, Sprite x7, Sprite x8, int animate) {
        switch (animate) {
            case 0:
                //System.out.println(animate);
                return normal;
            case 1:
                //System.out.println(animate);
                return x1;
            case 2:
                //System.out.println(animate);
                return x2;
            case 3:
                //System.out.println(animate);
                return x3;
            case 4:
                //System.out.println(animate);
                return x4;
            case 5:
                return x5;
            case 6:
                return x6;
            case 7:
                return x7;
            case 8:
                return x8;
        }
        return normal;
    }

}
