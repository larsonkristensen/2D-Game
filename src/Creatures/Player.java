package Creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Entities.Entity;
import Graphics.Animation;
import Graphics.Assets;
import gameEngine.Handler;

public class Player extends Creature {
	
	//Animations
	private Animation animDown, animUp, animLeft, animRight,
					animStillDown, animStillUp, animStillLeft, animStillRight;
	
	private Animation animDownAttack, animUpAttack, animLeftAttack, animRightAttack,
		animStillDownAttack, animStillUpAttack, animStillLeftAttack, animStillRightAttack;
	
	//Attack timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	
		bounds.x = 17;
		bounds.y = 30;
		bounds.width = 30;
		bounds.height = 22;
		
		//Animations
		animDown = new Animation(450, Assets.player_down);
		animUp = new Animation(450, Assets.player_up);
		animLeft = new Animation(450, Assets.player_left);
		animRight = new Animation(450, Assets.player_right);
		animStillDown = new Animation(450, Assets.player_still_down);
		animStillUp = new Animation(450, Assets.player_still_up);
		animStillLeft = new Animation(450, Assets.player_still_left);
		animStillRight = new Animation(450, Assets.player_still_right);
		
		animDownAttack = new Animation(450, Assets.player_down_attack);
		animUpAttack = new Animation (450, Assets.player_up_attack);
		animLeftAttack = new Animation (450, Assets.player_left_attack);
		animRightAttack = new Animation (450, Assets.player_right_attack);
		animStillDownAttack = new Animation (450, Assets.player_still_down_attack);
		animStillUpAttack = new Animation (450, Assets.player_still_up_attack);
		animStillLeftAttack = new Animation (450, Assets.player_still_left_attack);
		animStillRightAttack = new Animation (450, Assets.player_still_right_attack);
	}
	
	@Override
	public void die() {
		System.out.print("You Lose");
	}
	
	public void update() {
		//Animations
		animDown.update();
		animUp.update();
		animLeft.update();
		animRight.update();
		animStillDown.update();
		animStillUp.update();
		animStillLeft.update();
		animStillRight.update();
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//Attack
		checkAttacks();
	}
	
	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
			
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle() ;
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().attack) {
			if(yMove < 0 || prevYMove < 0) {
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y - arSize;
			}else if(yMove > 0 || prevYMove > 0) {
				ar.x = cb.x + cb.width / 2 - arSize / 2;
				ar.y = cb.y + cb.height;
			}else if(xMove < 0 || prevYMove < 0) {
				ar.x = cb.x - arSize;
				ar.y = cb.y + cb.height / 2 - arSize /2;
			}else if(xMove > 0 || prevYMove > 0) {
				ar.x = cb.x + cb.width;
				ar.y = cb.y + cb.height / 2 - arSize /2;
			}else {
				return;
			}
			
			attackTimer = 0;
			
			for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
				if(e.equals(this))
					continue;
				if(e.getCollisionBounds(0, 0).intersects(ar)){
					e.hurt(1);
					return;
				}
			}
			
		}
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
			prevYMove = -1;
			lastMoveOnX = false;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
			prevYMove = 1;
			lastMoveOnX = false;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
			prevXMove = 1;
			lastMoveOnX = true;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
			prevXMove = -1;
			lastMoveOnX = true;
		}
		
	}
	
	public void render(Graphics g) {
		g.drawImage(getCurrentMoveAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), 
									(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.red);
		/*g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), 
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				(int) bounds.width,
				(int) bounds.height);		
		*/
	}
	
	private BufferedImage getCurrentMoveAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		}else if(xMove > 0) {
			return animRight.getCurrentFrame();
		}else if (yMove < 0) {
			return animUp.getCurrentFrame();
		}else if (yMove > 0) {
			return animDown.getCurrentFrame();
		}else if (prevXMove < 0 && lastMoveOnX) {
			return animStillLeft.getCurrentFrame();
		}else if (prevXMove > 0 && lastMoveOnX) {
			return animStillRight.getCurrentFrame();
		}else if (prevYMove < 0) {
			return animStillUp.getCurrentFrame();
		}else {
			return animStillDown.getCurrentFrame();
		}
	}
	
/*	private BufferedImage getCurrentAttackAnimationFrame() {
		if(handler.getKeyManager().attack) {
			if(yMove < 0 || prevYMove < 0) { //AttackUp
				 
			}else if(yMove > 0 || prevYMove > 0) { //AttackDown

			}else if(xMove < 0 || prevYMove < 0) { //AttackLeft

			}else if(xMove > 0 || prevYMove > 0) { //AttackRight

			}else {
				return getCurrentMoveAnimationFrame();
		}
	}
	*/
	
}
