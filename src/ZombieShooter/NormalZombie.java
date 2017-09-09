package ZombieShooter;

import java.awt.Graphics;

public class NormalZombie extends GameObject {
	// int amount;
	int speed = 2;
	int damage = 1;

	public NormalZombie(int x, int y) {
		this.x = x;
		this.y = y;
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

	public int getDamage() {
		return damage;
	}

}
