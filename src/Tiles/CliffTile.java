package Tiles;

import Graphics.Assets;

public class CliffTile extends Tile {

	public CliffTile(int id) {
		super(Assets.cliff, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}
