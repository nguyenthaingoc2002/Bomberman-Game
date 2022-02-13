package uet.oop.bomberman.graphics;

import javafx.scene.image.*;
import static uet.oop.bomberman.BombermanGame.level;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Lưu trữ thông tin các pixel của 1 sprite (hình ảnh game)
 */
public class Sprite {

	public static final int DEFAULT_SIZE = 16;
	public static final int SCALED_SIZE = DEFAULT_SIZE * 3;
	protected static final int TRANSPARENT_COLOR = 0xffff00ff;
	protected static final int TRANSPARENT_COLOR2 = 0xff808000;
	protected static final int TRANSPARENT_COLOR3 = 0xff708858;
	protected static final int TRANSPARENT_COLOR4 = 0xff889098;
	private int default_X;
	private int default_y;

	public final int SIZE_WIDTH;
	public final int SIZE_HEIGHT;
	protected int _x, _y;
	public int[] _pixels;
	protected int _realWidth;
	protected int _realHeight;
	protected SpriteSheet _sheet;

	public static int count = 0;

	private static List<Sprite> needReload = new ArrayList<>();

	/*
	|--------------------------------------------------------------------------
	| Powerups
	|--------------------------------------------------------------------------
	 */
	public static Sprite powerup_bombs = new Sprite(DEFAULT_SIZE, 0, 10, SpriteSheet.tiles1, 16, 16);
	public static Sprite powerup_flames = new Sprite(DEFAULT_SIZE, 1, 10, SpriteSheet.tiles1, 16, 16);
	public static Sprite powerup_speed = new Sprite(DEFAULT_SIZE, 2, 10, SpriteSheet.tiles1, 16, 16);
	public static Sprite powerup_wallpass = new Sprite(DEFAULT_SIZE, 3, 10, SpriteSheet.tiles1, 16, 16);
	public static Sprite powerup_detonator = new Sprite(DEFAULT_SIZE, 4, 10, SpriteSheet.tiles1, 16, 16);
	public static Sprite powerup_bombpass = new Sprite(DEFAULT_SIZE, 5, 10, SpriteSheet.tiles1, 16, 16);
	public static Sprite powerup_flamepass = new Sprite(DEFAULT_SIZE, 6, 10, SpriteSheet.tiles1, 16, 16);


	/*
	|--------------------------------------------------------------------------
	| Bomb
	|--------------------------------------------------------------------------
	 */
	public static Sprite Bomb1 = new Sprite(DEFAULT_SIZE, 0, 4, SpriteSheet.tiles, 16, 16, true);
	public static Sprite Bomb2 = new Sprite(DEFAULT_SIZE, 1, 4, SpriteSheet.tiles, 16, 16, true);
	public static Sprite Bomb3 = new Sprite(DEFAULT_SIZE, 2, 4, SpriteSheet.tiles, 16, 16, true);
	public static Sprite Bomb4 = new Sprite(DEFAULT_SIZE, 3, 4, SpriteSheet.tiles, 16, 16, true);

	/*
	|--------------------------------------------------------------------------
	| Exploded
	|--------------------------------------------------------------------------
	 */
	public static Sprite exploded_Center = new Sprite(DEFAULT_SIZE, 6, 4, SpriteSheet.tiles, 16, 16, true);
	public static Sprite exploded_bodyHorizontal = new Sprite(DEFAULT_SIZE, 9, 4, SpriteSheet.tiles, 16, 16, true);
	public static Sprite exploded_bodyVertical = new Sprite(DEFAULT_SIZE, 10, 4, SpriteSheet.tiles, 16, 16, true);
	public static Sprite exploded_headAbove = new Sprite(DEFAULT_SIZE, 4, 4, SpriteSheet.tiles, 16, 16, true);
	public static Sprite exploded_headBeneath = new Sprite(DEFAULT_SIZE, 5, 4, SpriteSheet.tiles, 16, 16, true);
	public static Sprite exploded_headLeft = new Sprite(DEFAULT_SIZE, 7, 4, SpriteSheet.tiles, 16, 16, true);
	public static Sprite exploded_headRight = new Sprite(DEFAULT_SIZE, 8, 4, SpriteSheet.tiles, 16, 16, true);

	/*
	|--------------------------------------------------------------------------
	| Map tiles.
	|--------------------------------------------------------------------------
	 */
	public static Sprite edge1_LeftConer = new Sprite(DEFAULT_SIZE, 0, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_LeftConer = new Sprite(DEFAULT_SIZE, 1, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Left1 = new Sprite(DEFAULT_SIZE, 0, 1, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Left1 = new Sprite(DEFAULT_SIZE, 1, 1, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Left2 = new Sprite(DEFAULT_SIZE, 0, 2, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Left2 = new Sprite(DEFAULT_SIZE, 1, 2, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Left3 = new Sprite(DEFAULT_SIZE, 5, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Left3 = new Sprite(DEFAULT_SIZE, 6, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Left4 = new Sprite(DEFAULT_SIZE, 5, 6, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Left4 = new Sprite(DEFAULT_SIZE, 6, 6, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Left5 = new Sprite(DEFAULT_SIZE, 9, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Left5 = new Sprite(DEFAULT_SIZE, 10, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Left6 = new Sprite(DEFAULT_SIZE, 9, 1, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Left6 = new Sprite(DEFAULT_SIZE, 10, 1, SpriteSheet.tiles, 16, 16, true);

	public static Sprite edge_Top1 = new Sprite(DEFAULT_SIZE, 2, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_Top2 = new Sprite(DEFAULT_SIZE, 3, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_Top3 = new Sprite(DEFAULT_SIZE, 4, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_Top4 = new Sprite(DEFAULT_SIZE, 5, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_Top5 = new Sprite(DEFAULT_SIZE, 6, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_Top6 = new Sprite(DEFAULT_SIZE, 6, 1, SpriteSheet.tiles, 16, 16, true);

	public static Sprite edge2_RightConer = new Sprite(DEFAULT_SIZE, 7, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_RightConer = new Sprite(DEFAULT_SIZE, 8, 0, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Right1 = new Sprite(DEFAULT_SIZE, 7, 1, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Right1 = new Sprite(DEFAULT_SIZE, 8, 1, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Right2 = new Sprite(DEFAULT_SIZE, 7, 2, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Right2 = new Sprite(DEFAULT_SIZE, 8, 2, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Right3 = new Sprite(DEFAULT_SIZE, 7, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Right3 = new Sprite(DEFAULT_SIZE, 8, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Right4 = new Sprite(DEFAULT_SIZE, 7, 6, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Right4 = new Sprite(DEFAULT_SIZE, 8, 6, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Right5 = new Sprite(DEFAULT_SIZE, 9, 2, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Right5 = new Sprite(DEFAULT_SIZE, 10, 2, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge2_Right6 = new Sprite(DEFAULT_SIZE, 9, 3, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge1_Right6 = new Sprite(DEFAULT_SIZE, 10, 3, SpriteSheet.tiles, 16, 16, true);


	public static Sprite edge_bottom = new Sprite(DEFAULT_SIZE, 0, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom2 = new Sprite(DEFAULT_SIZE, 1, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom3 = new Sprite(DEFAULT_SIZE, 2, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom4 = new Sprite(DEFAULT_SIZE, 3, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom1 = new Sprite(DEFAULT_SIZE, 4, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom5 = new Sprite(DEFAULT_SIZE, 0, 6, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom6 = new Sprite(DEFAULT_SIZE, 1, 6, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom7 = new Sprite(DEFAULT_SIZE, 9, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom8 = new Sprite(DEFAULT_SIZE, 10, 5, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom9 = new Sprite(DEFAULT_SIZE, 9, 6, SpriteSheet.tiles, 16, 16, true);
	public static Sprite edge_bottom10 = new Sprite(DEFAULT_SIZE, 10, 6, SpriteSheet.tiles, 16, 16, true);

	public static Sprite wall = new Sprite(DEFAULT_SIZE, 3, 1, SpriteSheet.tiles, 16, 16, true);
	public static Sprite floor_1 = new Sprite(DEFAULT_SIZE, 4, 2, SpriteSheet.tiles, 16, 16, true);
	public static Sprite floor_2 = new Sprite(DEFAULT_SIZE, 2, 2, SpriteSheet.tiles, 16, 16, true);
	public static Sprite floor_3 = new Sprite(DEFAULT_SIZE, 3, 2, SpriteSheet.tiles, 16, 16, true);
	public static Sprite brick = new Sprite(DEFAULT_SIZE, 1, 3, SpriteSheet.tiles, 16, 16, true);
	public static Sprite brick_destroyed1 = new Sprite(DEFAULT_SIZE, 2, 3, SpriteSheet.tiles, 16, 16, true);
	public static Sprite brick_destroyed2 = new Sprite(DEFAULT_SIZE, 3, 3, SpriteSheet.tiles, 16, 16, true);
	public static Sprite brick_destroyed3 = new Sprite(DEFAULT_SIZE, 4, 3, SpriteSheet.tiles, 16, 16, true);
	public static Sprite brick_destroyed4 = new Sprite(DEFAULT_SIZE, 5, 3, SpriteSheet.tiles, 16, 16, true);
	public static Sprite brick_destroyed5 = new Sprite(DEFAULT_SIZE, 6, 3, SpriteSheet.tiles, 16, 16, true);
	public static Sprite brick_destroyed6 = new Sprite(DEFAULT_SIZE, 7, 3, SpriteSheet.tiles, 16, 16, true);
	public static Sprite brick_destroyed7 = new Sprite(DEFAULT_SIZE, 8, 3, SpriteSheet.tiles, 16, 16, true);
	/*
	|--------------------------------------------------------------------------
	| Entrance
	|--------------------------------------------------------------------------
	 */
	public static Sprite entrance1 = new Sprite(DEFAULT_SIZE, 11, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite entrance2 = new Sprite(DEFAULT_SIZE, 12, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite entrance3 = new Sprite(DEFAULT_SIZE, 12, 1, SpriteSheet.tiles, 16, 16);
	public static Sprite entrance4 = new Sprite(DEFAULT_SIZE, 13, 1, SpriteSheet.tiles, 16, 16);

	/*
	|--------------------------------------------------------------------------
	| Portal
	|--------------------------------------------------------------------------
	 */
	public static Sprite open_portal1 = new Sprite(DEFAULT_SIZE, 11, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal2 = new Sprite(DEFAULT_SIZE, 12, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal3 = new Sprite(DEFAULT_SIZE, 13, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal4 = new Sprite(DEFAULT_SIZE, 14, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal5 = new Sprite(DEFAULT_SIZE, 15, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal6 = new Sprite(DEFAULT_SIZE, 16, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal7 = new Sprite(DEFAULT_SIZE, 17, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal8 = new Sprite(DEFAULT_SIZE, 18, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal9 = new Sprite(DEFAULT_SIZE, 19, 2, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal10 = new Sprite(DEFAULT_SIZE, 11, 3, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal11 = new Sprite(DEFAULT_SIZE, 12, 3, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal12 = new Sprite(DEFAULT_SIZE, 13, 3, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal13 = new Sprite(DEFAULT_SIZE, 14, 3, SpriteSheet.tiles, 16, 16);
	public static Sprite open_portal14 = new Sprite(DEFAULT_SIZE, DEFAULT_SIZE * 2, 20, 1, SpriteSheet.tiles, 16, 32);
	public static Sprite open_portal15 = new Sprite(DEFAULT_SIZE, DEFAULT_SIZE * 2, 21, 1, SpriteSheet.tiles, 16, 32);

	public static Sprite portal1 = new Sprite(DEFAULT_SIZE, DEFAULT_SIZE * 2, 15, 2, SpriteSheet.tiles, 16, 32);
	public static Sprite portal2 = new Sprite(DEFAULT_SIZE, DEFAULT_SIZE * 2, 20, 2, SpriteSheet.tiles, 16, 32);
	public static Sprite portal3 = new Sprite(DEFAULT_SIZE, DEFAULT_SIZE * 2, 15, 3, SpriteSheet.tiles, 16, 32);
	public static Sprite portal4 = new Sprite(DEFAULT_SIZE, DEFAULT_SIZE * 2, 20, 3, SpriteSheet.tiles, 16, 32);


	public Sprite(int size, int x, int y, SpriteSheet sheet, int rw, int rh, boolean needReloaded) {
		SIZE_WIDTH = size;
		SIZE_HEIGHT = size;
		_pixels = new int[SIZE_WIDTH * SIZE_HEIGHT];
		_x = x * SIZE_WIDTH;
		_y = y * SIZE_HEIGHT;
		default_X = _x;
		default_y = _y;
		_sheet = sheet;
		_realWidth = rw;
		_realHeight = rh;
		if (needReloaded) {
			needReload.add(this);
		}
		load();
	}

	public Sprite(int size, int x, int y, SpriteSheet sheet, int rw, int rh) {
		SIZE_WIDTH = size;
		SIZE_HEIGHT = size;
		_pixels = new int[SIZE_WIDTH * SIZE_HEIGHT];
		_x = x * SIZE_WIDTH;
		_y = y * SIZE_HEIGHT;
		_sheet = sheet;
		_realWidth = rw;
		_realHeight = rh;
		load();
	}

	public Sprite (int sizeWidth, int sizeHeight, int x, int y, SpriteSheet sheet, int rw, int rh) {
		SIZE_WIDTH = sizeWidth;
		SIZE_HEIGHT = sizeHeight;
		_pixels = new int[SIZE_WIDTH * SIZE_HEIGHT];
		_x = x * SIZE_WIDTH;
		_y = y * SIZE_HEIGHT;
		_sheet = sheet;
		_realWidth = rw;
		_realHeight = rh;
		load();
	}


	public Sprite(int size, int color) {
		SIZE_WIDTH = size;
		SIZE_HEIGHT = size;
		_pixels = new int[SIZE_WIDTH * SIZE_HEIGHT];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < _pixels.length; i++) {
			_pixels[i] = color;
		}
	}


	protected void load() {
		for (int y = 0; y < SIZE_HEIGHT; y++) {
			for (int x = 0; x < SIZE_WIDTH; x++) {
				_pixels[x + y * SIZE_WIDTH] = _sheet._pixels[(x + _x) + (y + _y) * _sheet.SIZE];
			}
		}
	}

	public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, Sprite x3,
									  Sprite x4, Sprite x5, Sprite x6, int animate) {
//		int calc = animate % time;
//		int diff = time / 3;
//
//		if(calc < diff) {
//			return normal;
//		}
//
//		if(calc < diff * 2) {
//			return x1;
//		}
//
//		return x2;
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

	public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, Sprite x3, Sprite x4, Sprite x5, Sprite x6,
									  Sprite x7, Sprite x8, Sprite x9, Sprite x10, Sprite x11, Sprite x12, int animate) {
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
			case 7:
				return x7;
			case 8:
				return x8;
			case 9:
				return x9;
			case 10:
				return x10;
			case 11:
				return x11;
			case 12:
				return x12;
		}
		return normal;
	}

	public static Sprite movingSprite(Sprite x1, Sprite x2, Sprite x3, Sprite x4, int animate) {
		switch (animate) {
			case 0:
				return x1;
			case 1:
				return x2;
			case 2:
				return x3;
			case 3:
				return x4;
		}
		return x1;
	}

	public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, Sprite x3,
									  Sprite x4, int animate) {
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
		}
		return normal;
	}

	public static Sprite movingSprite(Sprite x1, Sprite x2, int animate, int time) {
		int diff = time / 2;
		return (animate % time > diff) ? x1 : x2;
	}

	public int getSIZE_WIDTH() {
		return SIZE_WIDTH;
	}

	public int getPixel(int i) {
		return _pixels[i];
	}

	public Image getFxImage() {
		WritableImage wr = new WritableImage(SIZE_WIDTH, SIZE_HEIGHT);
		PixelWriter pw = wr.getPixelWriter();
		for (int x = 0; x < SIZE_WIDTH; x++) {
			for (int y = 0; y < SIZE_HEIGHT; y++) {
				if ( _pixels[x + y * SIZE_WIDTH] == TRANSPARENT_COLOR || _pixels[x + y * SIZE_WIDTH] == TRANSPARENT_COLOR2
						|| _pixels[x + y * SIZE_WIDTH] == TRANSPARENT_COLOR3 || _pixels[x + y * SIZE_WIDTH] == TRANSPARENT_COLOR4) {
					pw.setArgb(x, y, 0);
				}
				else {
					pw.setArgb(x, y, _pixels[x + y * SIZE_WIDTH]);
				}
			}
		}
		Image input = new ImageView(wr).getImage();
		if (SIZE_WIDTH > 16) {
			return resample(input, (SCALED_SIZE * 2) / (DEFAULT_SIZE * 3));
		} else {
			return resample(input, SCALED_SIZE / DEFAULT_SIZE);
		}
		//return resample(input, SCALED_SIZE / DEFAULT_SIZE);
	}

	protected Image resample(Image input, int scaleFactor) {
		final int W = (int) input.getWidth();
		final int H = (int) input.getHeight();
		final int S = scaleFactor;

		WritableImage output = new WritableImage(
				W * S,
				H * S
		);

		PixelReader reader = input.getPixelReader();
		PixelWriter writer = output.getPixelWriter();

		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				final int argb = reader.getArgb(x, y);
				for (int dy = 0; dy < S; dy++) {
					for (int dx = 0; dx < S; dx++) {
						writer.setArgb(x * S + dx, y * S + dy, argb);
					}
				}
			}
		}

		return output;
	}

	private void reload() {
		_y = default_y + (level - 1) * 7 * SIZE_WIDTH;
		load();
	}

	public static void reloadSprites() {
		for (Sprite s: needReload) {
			//System.out.println(++count);
			s.reload();
		}
	}

}
