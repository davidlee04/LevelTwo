package ZombieShooter;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ZombieSpawn spawner = new ZombieSpawn();

	ArrayList<GameObject> object;
	ArrayList<NormalZombie> zombies;
	Crosshair crosshair;
	HealthBar heart;

	public ObjectManager(HealthBar heart) {
		this.heart = heart;
		object = new ArrayList<GameObject>();
		zombies = spawner.getNextWave();
	}

	public void addObject(GameObject o) {
		object.add(o);
	}

	public void addObject(NormalZombie z) {
		zombies.add(z);
	}

	public void addObject(Crosshair c) {
		crosshair = c;
	}

	public void draw(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			object.get(i).draw(g);
		}
		for (int i = 0; i < zombies.size(); i++) {
			zombies.get(i).draw(g);
		}
		crosshair.draw(g);
	}

	public void update() {
		for (int i = 0; i < object.size(); i++) {
			object.get(i).update();
		}
		for (int i = 0; i < zombies.size(); i++) {
			zombies.get(i).update();
		}
		crosshair.update();
	}

	public void checkShot() {
		for (int i = 0; i < zombies.size(); i++) {
			if (crosshair.getX() > zombies.get(i).getX() + 10 && crosshair.getX() < zombies.get(i).getX() + 68
					&& crosshair.getY() > zombies.get(i).getY() - 10 && crosshair.getY() < zombies.get(i).getY() + 95) {
				zombies.get(i).isAlive = false;
			}
		}
	}

	public void killZombie() {
		if (zombies.size() == 0) {
			spawner.getNextWave();
		}
		for (int i = zombies.size() - 1; i >= 0; i--) {
			if (zombies.get(i).isAlive == false) {
				zombies.remove(i);
			}
		}
	}

	public void checkZombieHit() {
		System.out.println(zombies.size());
		for (int i = zombies.size() - 1; i >= 0; i--) {
			if (zombies.get(i).getY() >= ZombieShooter.HEIGHT / 2 + 270) {
				heart.removeHeart(zombies.get(i).getDamage());
				zombies.get(i).isAlive = false;
				System.out.println(zombies.get(i).getDamage() + "DAMAGE DEALT");
			}
		}
	}

	/*
	 * public ArrayList<NormalZombie> getZombies() { return zombies; }
	 */

	public ArrayList<NormalZombie> spawnZombies() {
		return zombies;
	}

}
