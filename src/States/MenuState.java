package States;

import java.awt.Graphics;

import Graphics.Assets;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import gameEngine.Handler;

public class MenuState extends State {

	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(260, 140, 128, 64, Assets.btn_start, new ClickListener(){

			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
			}));
	}
	
	
	public void update() {
		uiManager.update();
	}


	public void render(Graphics g) {
		uiManager.render(g);
	}
}
