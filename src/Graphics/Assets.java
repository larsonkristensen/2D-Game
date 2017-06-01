package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage grass, tree, cliff;
	public static BufferedImage[] player_down, player_up, player_left, player_right, 
								player_still_down, player_still_up, player_still_left, player_still_right;
	public static BufferedImage[] player_down_attack, player_up_attack, player_left_attack, player_right_attack, 
								player_still_down_attack, player_still_up_attack, player_still_left_attack, player_still_right_attack;								
	
	public static BufferedImage[] btn_start;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
	
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width*2, height*4, width*2, height);
		btn_start[1] = sheet.crop(0, height*4, width*2, height);
		
		player_down = new BufferedImage[4];
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		
		player_still_down = new BufferedImage[1];
		player_still_up = new BufferedImage[1];
		player_still_left = new BufferedImage[1];
		player_still_right = new BufferedImage[1];
		
		//Moving Animations
		
		player_down[0] = sheet.crop(0, 0, width, height);
		player_down[1] = sheet.crop(width, 0, width, height);
		player_down[2] = sheet.crop(0, 0, width, height);
		player_down[3] = sheet.crop(width*2, 0, width, height);
		player_up[0] = sheet.crop(width*2, height, width, height);
		player_up[1] = sheet.crop(width*3, height, width, height);
		player_up[2] = sheet.crop(width*2, height, width, height);
		player_up[3] = sheet.crop(0, height*2, width, height);
		player_left[0] = sheet.crop(width*3, 0, width, height);
		player_left[1] = sheet.crop(0, height, width, height);
		player_left[2] = sheet.crop(width*3, 0, width, height);
		player_left[3] = sheet.crop(width, height, width, height);
		player_right[0] = sheet.crop(width, height*2, width, height);
		player_right[1] = sheet.crop(width*2, height*2, width, height);
		player_right[2] = sheet.crop(width, height*2, width, height);
		player_right[3] = sheet.crop(width*3, height*2, width, height);
		
		player_still_down[0] = sheet.crop(0, 0, width, height); 
		player_still_up[0] = sheet.crop(width*2, height, width, height);
		player_still_left[0] = sheet.crop(width*3, 0, width, height); 
		player_still_right[0] = sheet.crop(width, height*2, width, height);  
		
		//Attack Animations
	/*	
		player_down_attack[0] = sheet.crop(0, 0, width, height);
		player_down_attack[1] = sheet.crop(width, 0, width, height);
		player_down_attack[2] = sheet.crop(0, 0, width, height);
		player_down_attack[3] = sheet.crop(width*2, 0, width, height);
		player_up_attack[0] = sheet.crop(width*2, height, width, height);
		player_up_attack[1] = sheet.crop(width*3, height, width, height);
		player_up_attack[2] = sheet.crop(width*2, height, width, height);
		player_up_attack[3] = sheet.crop(0, height*2, width, height);
		player_left_attack[0] = sheet.crop(width*3, 0, width, height);
		player_left_attack[1] = sheet.crop(0, height, width, height);
		player_left_attack[2] = sheet.crop(width*3, 0, width, height);
		player_left_attack[3] = sheet.crop(width, height, width, height);
		player_right_attack[0] = sheet.crop(width, height*2, width, height);
		player_right_attack[1] = sheet.crop(width*2, height*2, width, height);
		player_right_attack[2] = sheet.crop(width, height*2, width, height);
		player_right_attack[3] = sheet.crop(width*3, height*2, width, height);
		
		player_still_down_attack[0] = sheet.crop(width, height*2, width, height);
		player_still_up_attack[0]= sheet.crop(width, height*2, width, height);
		player_still_left_attack[0]= sheet.crop(width, height*2, width, height);
		player_still_right_attack[0] = sheet.crop(width, height*2, width, height);
*/
		grass = sheet.crop(width, height*3, width, height);
		tree = sheet.crop(width*2, height*3, width, height);
		cliff = sheet.crop(width*3, height*3, width, height);
	}
}
