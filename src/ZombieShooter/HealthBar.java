package ZombieShooter;

import java.awt.Graphics;

public class HealthBar extends GameObject {
	int hearts;

	public HealthBar(int x, int y, int width, int height, int hearts) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.hearts = hearts;
	}

	void draw(Graphics g) {

	}

	void update() {
		// makes hearts go down
		/*
		 * if(amount == 20) { amount-=10; // this ^ determines amount of hearts
		 * lost }
		 */
	}

	void removeHeart(int damage) {
		hearts -= damage;
	}

}
