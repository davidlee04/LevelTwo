package ZombieShooter;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> object;
	ArrayList<NormalZombie> zombies;
	Crosshair crosshair;

	public ObjectManager() {
		object = new ArrayList<GameObject>();
		zombies = new ArrayList<NormalZombie>();
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
			if (crosshair.getX() > zombies.get(i).getX() && crosshair.getX() < zombies.get(i).getX() + 64
					&& crosshair.getY() > zombies.get(i).getY() && crosshair.getY() < zombies.get(i).getY() + 64) {
				zombies.get(i).isAlive = false;
				System.out.println("test");
			}
		}
	}

}
