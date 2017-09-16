package ZombieShooter;

import java.awt.Graphics;

public class NormalZombie extends GameObject {
	// int amount;
	int speed = 3;
	int damage = 1;
	double healthWidth = 128;
	int healthX;
	int health = 2;

	public NormalZombie(int x, int y) {
		this.x = x;
		this.y = y;
		this.healthX = x;
		// this.amount = amount;
	}

	void draw(Graphics g) {
	}

	void update() {
		y += speed;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	public int getHealthX() {
		return healthX;
	}

	public int getDamage() {
		return damage;
	}

	public int getHealthWidth() {
		// TODO Auto-generated method stub
		return (int) healthWidth;
	}

}
