package ZombieShooter;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class NormalZombie extends GameObject implements ActionListener {
	Timer stampede;

	// int amount;
	int speed = 3;
	int damage = 1;
	double healthWidth = 128;
	int healthX;
	int health = 2;
	int stampedeTimer = 0;

	public NormalZombie(int x, int y) {
		this.x = x;
		this.y = y;
		this.healthX = x;
		// this.amount = amount;

		stampede = new Timer(1000 / 60, this);
	}

	void stampedeStart() {
		stampede.start();
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

	public int getStampedeTime() {
		return stampedeTimer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		stampedeTimer++;
	}
}
