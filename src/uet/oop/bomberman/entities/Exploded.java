package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.Map.GameMap.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quynhbes on 11/14/2021.
 */
public class Exploded extends Entity{
    public static int size = 2;
    private int exploded_time = 1;
    private int exploded_Left = 0;
    private int exploded_Right = 0;
    private int exploded_Top = 0;
    private int exploded_Bottom = 0;
    //private int xUnit = x;
    //private int yUnit = y;
    private List<Exploded> explodedList = new ArrayList<>();

    private boolean is_Wall_Left;
    private boolean is_Wall_Right;
    private boolean is_Wall_Top;
    private boolean is_Wall_Bottom;

    public Exploded(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        Map[this.yUnit][this.xUnit] = 'd';
        destroyBrick(this.x, this.y);
        if (!getIs_Wall_Bottom(exploded_time)) {
            exploded_Bottom++;
        }
        if (!getIs_Wall_Top(exploded_time)) {
            exploded_Top++;
        }
        if (!getIs_Wall_Left(exploded_time)) {
            exploded_Left++;
        }
        if (!getIs_Wall_Right(exploded_time)) {
            exploded_Right++;
        }
    }



    @Override
    public void update() {
        if (exploded_time < size) {
            if (!is_Wall_Left) {
                explodedList.add(new Exploded(xUnit - exploded_Left, yUnit, Sprite.exploded_bodyHorizontal.getFxImage()));
                //Map[yUnit][xUnit - exploded_Left] = 'd';
                //destroyBrick(xUnit - exploded_Left, yUnit);
                if (!getIs_Wall_Left(exploded_Left + 1)) {
                    exploded_Left++;
                }
            } else {
                if (exploded_Left != 0) {
                    explodedList.add(new Exploded(xUnit - exploded_Left, yUnit, Sprite.exploded_bodyHorizontal.getFxImage()));
                } else {
                    explodedList.add(new Exploded(xUnit - exploded_Left, yUnit, null));
                }
            }

            if (!is_Wall_Top) {
                explodedList.add(new Exploded(xUnit, yUnit - exploded_Top, Sprite.exploded_bodyVertical.getFxImage()));
                //Map[yUnit - exploded_Top][xUnit] = 'd';
                //destroyBrick(xUnit, yUnit - exploded_Top);
                if (!getIs_Wall_Top(exploded_Top + 1)) {
                    exploded_Top++;
                }
            } else {
                if (exploded_Top != 0) {
                    explodedList.add(new Exploded(xUnit, yUnit - exploded_Top, Sprite.exploded_bodyVertical.getFxImage()));
                } else {
                    explodedList.add(new Exploded(xUnit, yUnit - exploded_Top, null));
                }
            }

            if (!is_Wall_Right) {
                explodedList.add(new Exploded(xUnit + exploded_Right, yUnit, Sprite.exploded_bodyHorizontal.getFxImage()));
                //Map[yUnit][xUnit + exploded_Right] = 'd';
                //destroyBrick(xUnit + exploded_Right, yUnit);
                if (!getIs_Wall_Right(exploded_Right + 1)) {
                    exploded_Right++;
                }
            } else {
                if (exploded_Right != 0) {
                    explodedList.add(new Exploded(xUnit + exploded_Right, yUnit, Sprite.exploded_bodyHorizontal.getFxImage()));
                    //destroyBrick(xUnit + exploded_Right, yUnit);
                } else {
                    explodedList.add(new Exploded(xUnit + exploded_Right, yUnit, null));
                }
            }

            if (!is_Wall_Bottom) {
                explodedList.add(new Exploded(xUnit, yUnit + exploded_Bottom, Sprite.exploded_bodyVertical.getFxImage()));
                //Map[yUnit + exploded_Bottom][xUnit] = 'd';
                //destroyBrick(xUnit, yUnit + exploded_Bottom);
                if (!getIs_Wall_Bottom(exploded_Bottom + 1)) {
                    exploded_Bottom++;
                }
            } else {
                if (exploded_Bottom != 0) {
                    explodedList.add(new Exploded(xUnit, yUnit + exploded_Bottom, Sprite.exploded_bodyVertical.getFxImage()));
                } else {
                    explodedList.add(new Exploded(xUnit, yUnit + exploded_Bottom, null));
                }
            }

            exploded_time++;
        }else if (exploded_time == size){
            if (!is_Wall_Left) {
                explodedList.add(new Exploded(xUnit - exploded_Left, yUnit, Sprite.exploded_headLeft.getFxImage()));
                Map[yUnit][xUnit - exploded_Left] = 'd';
            } else {
                if (exploded_Left != 0) {
                    explodedList.add(new Exploded(xUnit - exploded_Left, yUnit, Sprite.exploded_bodyHorizontal.getFxImage()));
                } else {
                    explodedList.add(new Exploded(xUnit - exploded_Left, yUnit, null));
                }
            }

            if (!is_Wall_Right) {
                explodedList.add(new Exploded(xUnit + exploded_Right, yUnit, Sprite.exploded_headRight.getFxImage()));
                Map[yUnit][xUnit + exploded_Right] = 'd';
            } else {
                if (exploded_Right != 0) {
                    explodedList.add(new Exploded(xUnit + exploded_Right, yUnit, Sprite.exploded_bodyHorizontal.getFxImage()));
                } else {
                    explodedList.add(new Exploded(xUnit + exploded_Right, yUnit, null));
                }
            }

            if (!is_Wall_Top) {
                explodedList.add(new Exploded(xUnit, yUnit - exploded_Top, Sprite.exploded_headAbove.getFxImage()));
                Map[yUnit - exploded_Top][xUnit] = 'd';
            } else {
                if (exploded_Top != 0) {
                    explodedList.add(new Exploded(xUnit, yUnit - exploded_Top, Sprite.exploded_bodyVertical.getFxImage()));
                } else {
                    explodedList.add(new Exploded(xUnit, yUnit - exploded_Top, null));
                }
            }

            if (!is_Wall_Bottom) {
                explodedList.add(new Exploded(xUnit, yUnit + exploded_Bottom, Sprite.exploded_headBeneath.getFxImage()));
                Map[yUnit + exploded_Bottom][xUnit] = 'd';
            } else {
                if (exploded_Bottom != 0) {
                    explodedList.add(new Exploded(xUnit, yUnit + exploded_Bottom, Sprite.exploded_bodyVertical.getFxImage()));
                } else {
                    explodedList.add(new Exploded(xUnit, yUnit + exploded_Bottom, null));
                }
            }

            exploded_time++;
        } else {
            for (int i = 0; i < 4; i++) {
                Map[explodedList.get(explodedList.size() - 1).getyUnit()][explodedList.get(explodedList.size() - 1).getxUnit()] = '0';
                explodedList.remove(explodedList.size() - 1);

            }
            if (explodedList.isEmpty()) {
                Map[yUnit][xUnit] = '0';
                BombermanGame.entities.remove(this);
            }
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        //System.out.println("hihi");
        gc.drawImage(img, x, y);
        //System.out.println(explodedList.size());
        for(Entity exploded: explodedList) {
            gc.drawImage(exploded.getImg(), exploded.getX(), exploded.getY());
        }
    }

    private void destroyBrick(int x, int y) {
        for (Brick brick: brickList) {
            if ((x == brick.getX()) && (y == brick.getY())) {
                //System.out.println("x: " + x + " y: " + y + " brick.x: " + brick.getX() + " brick.y: " + brick.getY());
                brick.setDestroyed(true);

            }
        }
    }

    public boolean getIs_Wall_Top(int i) {
        is_Wall_Top = Map[yUnit - i][xUnit] == '*' && MapBrick[yUnit - i][xUnit] != 'b';
        return is_Wall_Top;
    }

    public boolean getIs_Wall_Bottom(int i) {
        is_Wall_Bottom = Map[yUnit + i][xUnit] == '*' && MapBrick[yUnit + i][xUnit] != 'b';
        return is_Wall_Bottom;
    }

    public boolean getIs_Wall_Left(int i) {
        is_Wall_Left = Map[yUnit][xUnit - i] == '*' && MapBrick[yUnit][xUnit - i] != 'b';
        return is_Wall_Left;
    }

    public boolean getIs_Wall_Right(int i) {
        is_Wall_Right = Map[yUnit][xUnit + i] == '*' && MapBrick[yUnit][xUnit + i] != 'b';
        //System.out.println(MapBrick[yUnit][xUnit + i]);
        return is_Wall_Right;
    }
}
