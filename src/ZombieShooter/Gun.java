package ZombieShooter;

import java.awt.Graphics;

public class Gun extends GameObject{
	int ammo;
	public Gun(int x, int y, int width, int height) {
		this.ammo = 10;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void draw(Graphics g) {
		
	}
	
	void update() {
		
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}

}
