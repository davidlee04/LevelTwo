import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;

	public Rocketship(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 5;

	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImage, x, y, width, height, null);

	}

	void update() {
		super.update();

	}

}
