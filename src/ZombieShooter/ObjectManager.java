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
    	
    }
    
    public void update() {
    	
    }

}
