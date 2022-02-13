package uet.oop.bomberman.entities.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.graphics.EnemySprite;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.Map.GameMap.Map;
import static uet.oop.bomberman.Map.GameMap.MapBrick;
import static uet.oop.bomberman.Map.GameMap.brickList;

/**
 * Created by Quynhbes on 12/2/2021.
 */
public class Green extends Enemy {

    private String lastMove;
    private final String TOP = "TOP";
    private final String BOTTOM = "BOTTOM";
    private final String RIGHT = "RIGHT";
    private final String LEFT = "LEFT";

    public Green(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        firstX = xUnit * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE * 5;
        firstY = yUnit * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
    }

    @Override
    public void update() {
        if (!isDead()) {
            //System.out.println(bomberman.getxUnit() + " " + bomberman.getyUnit() + " " + xUnit + " " + yUnit);
            bfs();
            setLocationOnMap();
            isEnemyDead();
        } else {
            BombermanGame.entities.remove(this);
            GameMap.countEnemy--;
        }
    }

    @Override
    public void horizontalMove() {

    }

    @Override
    public void verticalMove() {

    }

    @Override
    protected void left() {
        if (y % Sprite.SCALED_SIZE != 0) {
            continueLastMove();
        } else {
            this.img = Sprite.movingSprite(EnemySprite.green_left1, EnemySprite.green_left2, EnemySprite.green_left3,
                    EnemySprite.green_left4, EnemySprite.green_left5, animate).getFxImage();
            animate++;
            moveLeft();
            lastMove = LEFT;
            if (animate > 4) {
                animate = 0;
            }
        }
    }

    @Override
    protected void right() {
        if (y % Sprite.SCALED_SIZE != 0) {
            continueLastMove();
        } else {
            this.img = Sprite.movingSprite(EnemySprite.green_right1, EnemySprite.green_right2, EnemySprite.green_right3,
                    EnemySprite.green_right4, EnemySprite.green_right5, animate).getFxImage();
            animate++;
            moveRight();
            lastMove = RIGHT;
            if (animate > 4) {
                animate = 0;
            }
        }
    }

    @Override
    protected void top() {
        if (x % Sprite.SCALED_SIZE != 0) {
            continueLastMove();
        } else {
            this.img = Sprite.movingSprite(EnemySprite.green_backward1, EnemySprite.green_backward2, EnemySprite.green_backward3,
                    EnemySprite.green_backward4, EnemySprite.green_backward5, animate).getFxImage();
            animate++;
            moveTop();
            lastMove = TOP;
            if (animate > 4) {
                animate = 0;
            }
        }
    }

    @Override
    protected void bottom() {
        if (x % Sprite.SCALED_SIZE != 0) {
            continueLastMove();
        } else {
            this.img = Sprite.movingSprite(EnemySprite.green_forward1, EnemySprite.green_forward2, EnemySprite.green_forward3,
                    EnemySprite.green_forward4, EnemySprite.green_forward5, animate).getFxImage();
            animate++;
            moveBottom();
            lastMove = BOTTOM;
            if (animate > 4) {
                animate = 0;
            }
        }
    }
    public boolean check(int i, int j) {
        if (i >= 0 && i < 17 && j >= 0 && j < 13 &&
                ((Map[j][i] == '-' || Map[j][i] == '_' || Map[j][i] == ' ' || Map[j][i] == '0' || MapBrick[j][i] == 'r'))) return true;
        return false;
    }

    public void bfs() {
        if (Math.abs(bomberman.getX() - x) < 3 && Math.abs(bomberman.getY() - y) < 3) {
            x = firstX ;
            y = firstY ;
            return;
        }
        int[] dh = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        int[] q = new int[400];
        int[] color = new int[400];
        int[] pr = new int[400];
        int i = (bomberman.getX() - 5 * Sprite.SCALED_SIZE)/ 48;
        int j = (bomberman.getY() - Sprite.SCALED_SIZE)/ 48;
        int r = 0, l = 1;
        q[++r] = i * 17 + j;
        color[q[r]] = 1;
        boolean ok = false;
        while(l <= r) {
            int u = q[l++];
            i = u / 17;
            j = u % 17;
            for (int k = 0; k < 4; ++k) {
                int i1 = i + dc[k];
                int j1 = j + dh[k];
                int v = i1 * 17 + j1;
                if (check(i1, j1) && color[v] == 0) {
                    color[v] = 1;
                    pr[v] = u;
                    q[++r] = v;
                    if (i1 == (x - 5 * Sprite.SCALED_SIZE) / 48 && j1 == (y - Sprite.SCALED_SIZE) / 48) {
                        ok = true;
                        break;
                    }
                }
            }
            if (ok) break;
        }
        i = (x - 5 * Sprite.SCALED_SIZE)/ 48;
        j = (y - Sprite.SCALED_SIZE)/ 48;
        if (ok == false && color[i * 17 + j] == 1) ok = true;
        if (ok == false) {
            return;
        }
        int pos = -1;
        for (int k = 0; k < 4; ++k) {
            //System.out.println(k);
            int u = (x - 5 * Sprite.SCALED_SIZE) / 48 * 17 + (y - Sprite.SCALED_SIZE) / 48;
            int v = u + dc[k] * 17 + dh[k];
            if (pr[u] == v) {
                pos = k;
                break;
            }
        }
        if (pos == -1) pos = 4;
        //System.out.println(pos);
        if (x / 48 == bomberman.getX() / 48 && Math.abs(x - bomberman.getX()) >= 3) {
            if (x < bomberman.getX() && (pos == 2 || pos == 4)) {
                right();
                return;
            } else if (pos == 0 || pos == 4){
                left();
                return;
            }
        }

        if (y / 48 == bomberman.getY() / 48 && Math.abs(y - bomberman.getY()) >= 3) {
            if (y < bomberman.getY() && (pos == 3 || pos == 4)) {
                bottom();
                return;
            } else if (pos == 1 || pos == 4){
                top();
                return;
            }
        }

        if (pos == 0) {
            left();
            return;
        }
        if (pos == 1) {
            top();
            return;
        }
        if (pos == 2) {
            right();
            return;
        }
        if (pos == 3) {
            bottom();
            return;
        }
    }

    private void continueLastMove() {
        switch (lastMove) {
            case TOP:
                top();
                break;
            case BOTTOM:
                bottom();
                break;
            case RIGHT:
                right();
                break;
            case LEFT:
                left();
                break;
        }
    }



    @Override
    public boolean isEnemyDead() {
        if (GameMap.Map[yUnit][xUnit] == 'd') {
            setDead(true);
            GameMap.MapEnemy[yUnit][xUnit] = '0';
            BombermanGame.scoreGame += 3;
            return true;
        } else {
            return false;
        }
    }
}
