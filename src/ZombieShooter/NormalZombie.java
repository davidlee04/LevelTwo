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
		
	}
	
	void update() {
		y++;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

}
