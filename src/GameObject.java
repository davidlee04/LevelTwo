import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	Rectangle collisionBox;
	
	boolean isAlive = true;
	
	int x = 10;
	int y = 10;
	int width;
	int height;

	
	public GameObject() {
		collisionBox = new Rectangle(x, y, width, height);
	}

	void draw(Graphics g) {

	}

	void update() {
		collisionBox.setBounds(x, y, width, height);

	}

}
