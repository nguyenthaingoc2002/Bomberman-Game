package uet.oop.bomberman.Map;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Enemy.*;
import uet.oop.bomberman.graphics.EnemySprite;
import uet.oop.bomberman.graphics.Sprite;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.entities.Enemy.Enemy.*;


/**
 * Created by Quynhbes on 11/10/2021.
 */
public class GameMap {
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private String _path;

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Entity> getStillObjects() {
        return stillObjects;
    }

    public static char[][] Map;
    public static char[][] MapBrick;
    public static char[][] MapEnemy;
    public static List<Brick> brickList = new ArrayList<>();
    public static List<Exploded> explodedList = new ArrayList<>();

    public static final String URL_MAP_1 = "res/levels/Level1.txt";
    public static final String URL_MAP_2 = "res/levels/Level2.txt";
    public static final String URL_MAP_3 = "res/levels/Level3.txt";
    public static int PortalLocation_x;
    public static int PortalLocation_y;
    public static int countEnemy;
    public static final int SPREAD_X = 5;
    public static final int SPREAD_Y = 1;

    public GameMap(int level) {
        switch (level) {
            case 1:
                _path = URL_MAP_1;
                break;
            case 2:
                _path = URL_MAP_2;
                break;
            case 3:
                _path = URL_MAP_3;
        }
        try {
            loadMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() throws IOException {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(_path);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            int mapLevel = Integer.parseInt(line.substring(0, 1));
            int height = Integer.parseInt(line.substring(2, 4));
            int width = Integer.parseInt(line.substring(5, line.length()));
            Map = new char[height][width];
            MapBrick = new char[height][width];
            MapEnemy = new char[height][width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    MapBrick[y][x] = '0';
                }
            }
            for (int y = 0; y < height; y++) {
                line = bufferedReader.readLine();
                for (int x = 0; x < width; x++) {
                    Entity object;
                    switch (line.charAt(x)) {
                        case '0':
                            object = new Edge(x, y, Sprite.edge1_LeftConer.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '1':
                            object = new Edge(x, y, Sprite.edge2_LeftConer.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '2':
                            object = new Edge(x, y, Sprite.edge_Top1.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '3':
                            object = new Edge(x, y, Sprite.edge_Top2.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '4':
                            object = new Edge(x, y, Sprite.edge_Top3.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '5':
                            object = new Edge(x, y, Sprite.edge_Top4.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '8':
                            object = new Edge(x, y, Sprite.edge_Top5.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '9':
                            object = new Edge(x, y, Sprite.edge_Top6.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '6':
                            object = new Edge(x, y, Sprite.edge2_RightConer.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '7':
                            object = new Edge(x, y, Sprite.edge1_RightConer.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '{':
                            object = new Edge(x, y, Sprite.edge1_Left1.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '[':
                            object = new Edge(x, y, Sprite.edge2_Left1.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '(':
                            object = new Edge(x, y, Sprite.edge1_Left2.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '/':
                            object = new Edge(x, y, Sprite.edge2_Left2.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case ':':
                            object = new Edge(x, y, Sprite.edge1_Left3.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '~':
                            object = new Edge(x, y, Sprite.edge2_Left3.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '@':
                            object = new Edge(x, y, Sprite.edge1_Left4.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '#':
                            object = new Edge(x, y, Sprite.edge2_Left4.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'q':
                            object = new Edge(x, y, Sprite.edge1_Left5.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'w':
                            object = new Edge(x, y, Sprite.edge2_Left5.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'e':
                            object = new Edge(x, y, Sprite.edge1_Left6.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'r':
                            object = new Edge(x, y, Sprite.edge2_Left6.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '}':
                            object = new Edge(x, y, Sprite.edge1_Right1.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case ']':
                            object = new Edge(x, y, Sprite.edge2_Right1.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case ')':
                            object = new Edge(x, y, Sprite.edge1_Right2.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '"':
                            object = new Edge(x, y, Sprite.edge2_Right2.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case ';':
                            object = new Edge(x, y, Sprite.edge1_Right3.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '`':
                            object = new Edge(x, y, Sprite.edge2_Right3.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '%':
                            object = new Edge(x, y, Sprite.edge1_Right4.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '$':
                            object = new Edge(x, y, Sprite.edge2_Right4.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'p':
                            object = new Edge(x, y, Sprite.edge1_Right5.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'o':
                            object = new Edge(x, y, Sprite.edge2_Right5.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'i':
                            object = new Edge(x, y, Sprite.edge1_Right6.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'u':
                            object = new Edge(x, y, Sprite.edge2_Right6.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case '*':
                            object = new Wall(x, y, Sprite.wall.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'b':
                            object = new Brick(x, y, Sprite.brick.getFxImage());
                            entities.add(object);
                            Map[y][x] = '*';
                            MapBrick[y][x] = 'b';
                            brickList.add((Brick) object);
                            break;
//                        case 'x':
//                            object = new Portal(x, y, Sprite.portal.getFxImage());
//                            entities.add(object);
//                            break;
                        case ' ':
                            object = new Grass(x, y, Sprite.floor_1.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = ' ';
                            break;
                        case '-':
                            object = new Grass(x, y, Sprite.floor_2.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '-';
                            break;
                        case '_':
                            object = new Grass(x, y, Sprite.floor_3.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '_';
                            break;
                        case 'x':
                            object = new Grass(x, y, Sprite.edge_bottom.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'y':
                            object = new Grass(x, y, Sprite.edge_bottom2.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'z':
                            object = new Grass(x, y, Sprite.edge_bottom3.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 't':
                            object = new Grass(x, y, Sprite.edge_bottom4.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 's':
                            object = new Grass(x, y, Sprite.edge_bottom1.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'X':
                            object = new Grass(x, y, Sprite.edge_bottom5.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'Y':
                            object = new Grass(x, y, Sprite.edge_bottom6.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'Z':
                            object = new Grass(x, y, Sprite.edge_bottom7.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'T':
                            object = new Grass(x, y, Sprite.edge_bottom10.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'a':
                            object = new Grass(x, y, Sprite.edge_bottom8.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
                        case 'l':
                            object = new Grass(x, y, Sprite.edge_bottom9.getFxImage());
                            stillObjects.add(object);
                            Map[y][x] = '*';
                            break;
//                        case '1':
//                            object = new Balloon(x, y, Sprite.balloom_left1.getFxImage());
//                            stillObjects.add(object);
//                            break;
//                        case 'M':
//                            object = new EnemyMushroom(x, y, Sprite.mushroom_right1.getFxImage());
//                            entities.add(object);
//                            break;
                    }
                }
            }
            line = bufferedReader.readLine();
            PortalLocation_x = getNumber(line.substring(0, 3));
            PortalLocation_y = Integer.parseInt(line.substring(4, line.length()));

            line = bufferedReader.readLine();
            countEnemy = Integer.parseInt(line.substring(0, 1));
            int cnt = countEnemy;
            while(--cnt >= 0) {
                line = bufferedReader.readLine();
                String name = line.substring(0,1);
                int x = getNumber(line.substring(4, 7));
                int y = Integer.parseInt(line.substring(8, line.length()));
                //int y = getNumber(line.substring(9, 12));
                createEnemy(name, x, y);
            }
            /*Entity mushroom = new Mushroom(8, 9, EnemySprite.mushroom_right1.getFxImage(), HORIZONTAL, moveRight);
            Entity skull = new Skull(12, 5, EnemySprite.skull_backward1.getFxImage(), VERTICAL, moveTop);
            entities.add(skull);
            entities.add(mushroom);*/
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }// finally {
//            try {
//                bufferedReader.close();
//                fileInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void createEnemy(String name, int x, int y) {
        switch (name) {
            case "m" : {
                Entity mushroom = new Mushroom(x, y, EnemySprite.mushroom_right1.getFxImage(), VERTICAL, moveTop);
                entities.add(mushroom);
                break;
            }
            case "s" : {
                Entity skull = new Skull(x, y, EnemySprite.skull_backward1.getFxImage(), VERTICAL, moveTop);
                entities.add(skull);
                break;
            }
            case "c":
                Entity crab = new Crab(x, y, EnemySprite.crab_forward1.getFxImage(), HORIZONTAL, moveRight);
                //System.out.println(crab.getX() + " " + crab.getY());
                entities.add(crab);
                break;
            case "g":
                Entity green = new Green(x, y, EnemySprite.green_forward1.getFxImage());
                entities.add(green);
                break;
            case "b":
                Entity boss = new Boss(x, y, EnemySprite.boss1.getFxImage());
                entities.add(boss);
                break;
        }
    }

    private int getNumber(String s) {
        char c = s.charAt(s.length() - 1);
        //System.out.println(s + "/");
        while (c == ' ') {
            s = s.substring(0, s.length() - 1);
            //System.out.println(s + "/");
            c = s.charAt(s.length() - 1);
        }
        //System.out.println(Integer.parseInt(s));
        return Integer.parseInt(s);
    }


}
