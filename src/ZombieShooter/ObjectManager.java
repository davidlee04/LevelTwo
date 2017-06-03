package ZombieShooter;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> object;
	
	public ObjectManager() {
		object = new ArrayList<GameObject>();
	}
	
    public void addObject(GameObject o) {
    	object.add(o);
    }
    
    public void draw(Graphics g) {
    	for (int i = 0; i < object.size(); i++) {
			object.get(i).draw(g);
		}
    }
    
    public void update() {
    	for (int i = 0; i < object.size(); i++) {
			object.get(i).update();
		}
    }

}
