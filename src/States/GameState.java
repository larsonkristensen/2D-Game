package States;

import java.awt.Graphics;

import Creatures.Player;
import Worlds.World;
import gameEngine.Handler;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	public void update() {
		world.update();
	}
	
	public void render(Graphics g) {
		world.render(g);
	}
	
}
