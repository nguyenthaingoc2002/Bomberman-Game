package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Map.GameMap;
import uet.oop.bomberman.graphics.Sprite;


import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;
import static uet.oop.bomberman.graphics.PlayerSprite.*;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected boolean isDead = false;

    protected int xUnit;
    protected int yUnit;

    protected Image img;

    protected int animate;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.xUnit = xUnit;
        this.yUnit = yUnit;
        this.x = xUnit * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE * 5;
        this.y = yUnit * Sprite.SCALED_SIZE + Sprite.SCALED_SIZE;
        this.img = img;
        animate = 0;
    }

    public Entity() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxUnit() {
        return xUnit;
    }

    public int getyUnit() {
        return yUnit;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setxUnit(int x) {
        this.xUnit = (x - SCALED_SIZE * 5) / SCALED_SIZE;
    }

    public void setyUnit(int y) {
        this.yUnit = (y - SCALED_SIZE) / SCALED_SIZE;
    }


    public Image getImg() {
        return img;
    }

    public boolean canMove(int x, int y, String state) {

        int x1 = (x - SCALED_SIZE * 5) / SCALED_SIZE;
        int x2 = (x + SCALED_PLAYER_WIDTH  - SCALED_SIZE * 5) / SCALED_SIZE;
        int y1 = (y + 10 - SCALED_SIZE) / SCALED_SIZE;
        int y2 = (y + SCALED_PLAYER_HEIGHT - 10 - SCALED_SIZE) / SCALED_SIZE;

        if (GameMap.Map[y1][x1] == '*' || GameMap.Map[y1][x2] == '*'
                || GameMap.Map[y2][x1] == '*' || GameMap.Map[y2][x2] == '*'
                || GameMap.MapBrick[y1][x1] == 'r'
                || GameMap.MapBrick[y1][x2] == 'r'
                || GameMap.MapBrick[y2][x1] == 'r'
                || GameMap.MapBrick[y2][x2] == 'r')
        {
            return false;
        } else {
            return true;
        }
    }


    public void render(GraphicsContext gc) {
            gc.drawImage(img, x, y);
    }
    public abstract void update();
}
