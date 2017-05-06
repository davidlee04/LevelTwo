import java.awt.Graphics;

public class GameObject {
	int x = 10;
	int y = 10;
	int width;
	int height;

	public GameObject() {

	}

	void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}

	void update() {
		x++;
		y++;
	}

}
