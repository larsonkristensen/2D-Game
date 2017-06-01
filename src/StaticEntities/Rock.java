package StaticEntities;

import java.awt.Graphics;

import Tiles.Tile;
import gameEngine.Handler;

public class Rock extends StaticEntity {

	public Rock (Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
	
	}

	public void update() {
		
	}

	public void render(Graphics g) {

	}
	
	public void die() {
		
	}
}
