package ZombieShooter;

import java.awt.Color;
import java.awt.Graphics;

public class Crosshair extends GameObject{
	
	public Crosshair(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.crosshairImage1, x, y, width, height, null);
	}

	void update() {
		
	}
}
