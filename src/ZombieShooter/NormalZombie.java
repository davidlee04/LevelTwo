package ZombieShooter;

import java.awt.Graphics;

public class NormalZombie extends GameObject {
	// int amount;
	int speed;
	int damage;

	public NormalZombie(int x, int y, int width, int height, int speed, int damage) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// this.amount = amount;
		this.speed = speed;
		this.damage = damage;
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

	public int getDamage() {
		return damage;
	}

}
