package uet.oop.bomberman.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Tất cả sprite (hình ảnh game) được lưu trữ vào một ảnh duy nhất
 * Class này giúp lấy ra các sprite riêng từ 1 ảnh chung duy nhất đó
 */
public class SpriteSheet {

	private String _path;
	public final int SIZE;
	public int HEIGHT;
	public int[] _pixels;
	public BufferedImage image;

	public static SpriteSheet tiles1 = new SpriteSheet("/textures/classic.png", 256);
	public static SpriteSheet player = new SpriteSheet("/textures/Bomber.png", 707, 138);
	public static SpriteSheet enemy = new SpriteSheet("/textures/Enemies.png", 512, 175);
	public static SpriteSheet tiles = new SpriteSheet("/textures/tiles.png", 362, 342);
	public static SpriteSheet boss = new SpriteSheet("/textures/boss.png", 128, 96);
	
	public SpriteSheet(String path, int size) {
		_path = path;
		SIZE = size;
		_pixels = new int[SIZE * SIZE];
		load();
	}

	public SpriteSheet(String path, int size, int height) {
		_path = path;
		SIZE = size;
		HEIGHT = height;
		_pixels = new int[SIZE * HEIGHT];
		load();
	}
	
	private void load() {
		try {
			URL a = SpriteSheet.class.getResource(_path);
			image = ImageIO.read(a);
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, _pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
