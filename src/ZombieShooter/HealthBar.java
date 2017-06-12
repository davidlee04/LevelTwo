package ZombieShooter;

import java.awt.Graphics;

public class HealthBar extends GameObject{
	int amount;
	
	public HealthBar (int x, int y, int width, int height, int amount) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.amount = amount;
	}
	
	void draw(Graphics g) {
		boolean row1 = true;
		int x = 0;
		//System.out.println(amount);
		for (int counter = 0; counter < amount; counter++) {
			if(row1) {
				g.drawImage(GamePanel.hearts, x, y, width, height, null);
			}else {
				g.drawImage(GamePanel.hearts, x, y+50, width, height, null);
			}
			x+=40;
			if(x>=400) {
				x = 0;
				row1 = false;
			}
			//System.out.println("x "+x+ " y "+ y);
		}
	}
	
	void update() {
		// makes hearts go down
		/*if(amount == 20) {
			amount-=10;
			// this ^ determines amount of hearts lost
		}*/
	}

}
