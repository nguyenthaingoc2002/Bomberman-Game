package uet.oop.bomberman.GameInfo;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Exploded;
import uet.oop.bomberman.graphics.PlayerSprite;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.scoreGame;

public class GameInfo {
    Text textLive = new Text();
    Text textTime = new Text();
    Text textScore = new Text();
    Text textHighScore = new Text();
    Text textNumberBomb = new Text();
    Text textSizeBomb = new Text();
    private long timeStart;
    private int highScore;

    public static final int TRANSPARENT_COLOR = 0xff7a7a7a;

    Image imageBomber = PlayerSprite.player_stay1.getFxImage();
//    Image imageClock = imageRemoveBgr(new Image("file:res/clock.png", 100, 100
//            , true, true, true));

    Image imageClock = new Image("file:res/clock.png", 100, 100
            , true, true, true);
    Image imageBackground = new Image("file:res/bgr.png", 1296, 720
            , true, true, true);

    Font font = Font.loadFont("file:res/font/01.ttf", 45);

    private static Image imageRemoveBgr(Image image) {
        if (image.getHeight() != 0 && image.getWidth() != 0) {
            int W = (int) image.getWidth();
            int H = (int) image.getHeight();
            WritableImage wr = new WritableImage(W, H);
            PixelReader pr = image.getPixelReader();
            PixelWriter pw = wr.getPixelWriter();
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    int argb = pr.getArgb(x, y);
                    if (argb != TRANSPARENT_COLOR) {
                        pw.setArgb(x, y, argb);
                    }
                }
            }
            return new ImageView(wr).getImage();
        }
        return image;
    }

    public GameInfo() {

        timeStart = System.currentTimeMillis();
        textLive.setFont(font);
        textLive.setFill(Color.BLACK);
        textLive.setX(40);
        textLive.setY(125);


        textNumberBomb.setFont(font);
        textNumberBomb.setFill(Color.BLACK);
        textNumberBomb.setX(20);
        textNumberBomb.setY(250);

        textSizeBomb.setFont(font);
        textSizeBomb.setFill(Color.BLACK);
        textSizeBomb.setX(20);
        textSizeBomb.setY(500);


        textTime.setFont(font);
        textTime.setFill(Color.BLACK);
        textTime.setX(1060);
        textTime.setY(250);

        textScore.setFont(font);
        textScore.setFill(Color.BLACK);
        textScore.setX(1060);
        textScore.setY(500);

        try {
            File myObj = new File("res/HighScore/HighScore.txt");
            Scanner myReader = new Scanner(myObj);
            highScore = myReader.nextInt();
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        font = Font.loadFont("file:res/font/01.ttf", 22);
        textHighScore.setFont(font);
        textHighScore.setFill(Color.BLACK);
        textHighScore.setX(1060);
        textHighScore.setY(350);
    }

    public void addToGroup(Group root) {
        root.getChildren().add(textLive);
        root.getChildren().add(textNumberBomb);
        root.getChildren().add(textTime);
        root.getChildren().add(textSizeBomb);
        root.getChildren().add(textHighScore);
        root.getChildren().add(textScore);
    }
    public void update() {
        textLive.setText(Bomber.live + "x");
        textNumberBomb.setText("Bomb" + "\n\n " + Bomber.maxBomb);
        textSizeBomb.setText("Size" + "\n\n " + Exploded.size);
        textScore.setText("Score\n\n  " + scoreGame);


        if (highScore < scoreGame) {
            highScore = scoreGame;

            try {
                FileWriter fWriter = new FileWriter(
                        "res/HighScore/HighScore.txt");
                fWriter.write(String.valueOf(highScore));
                fWriter.close();
            }
            catch (IOException e) {
                System.out.print(e.getMessage());
            }
        }
        textHighScore.setText("High Score\n\n    " + highScore);


        int minute = (int)((System.currentTimeMillis() - timeStart) / 60000);
        int second = (int)((System.currentTimeMillis() - timeStart) / 1000);
        StringBuilder time = new StringBuilder();
        if (minute < 10) {
            time.append("0" + minute);
        } else {
            time.append(minute);
        }
        if (second < 60) {
            if (second < 10) {
                time.append(":0" + second);
            } else {
                time.append(":" + second);
            }
        } else {
            second = second % 60;
            if (second < 10) {
                time.append(":0" + second);
            } else {
                time.append(":" + second);
            }
        }
        textTime.setText(time.toString());
    }
    public void render(GraphicsContext gc) {
        gc.drawImage(imageBackground, 0, 0);
        gc.drawImage(imageBomber, 145 , 75);
        imageClock = imageRemoveBgr(imageClock);
        gc.drawImage(imageClock, 1135 , 75);
    }
}
