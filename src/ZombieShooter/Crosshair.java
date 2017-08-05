package ZombieShooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Crosshair extends GameObject implements MouseMotionListener{
	
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
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX() - 25;
	    y = e.getY() - 25;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	    x = e.getX() - 25;
	    y = e.getY() - 25;
	}
	
}
