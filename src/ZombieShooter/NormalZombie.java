package ZombieShooter;

import java.awt.Graphics;

public class NormalZombie extends GameObject{
	//int amount;
	
	public NormalZombie(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		//this.amount = amount;
	}
 	
	void draw(Graphics g) {
		g.drawImage(GamePanel.normalZombie, x, y, width, height, null);
	}
	
	void update() {
		
	}

}
