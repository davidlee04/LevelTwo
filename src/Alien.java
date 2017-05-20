import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	int speed = 1;
	int counter = 0;

	public Alien(int x, int y, int height, int width) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;

	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImage, x, y, width, height, null);

	}

	void update() {
		super.update();
		y += 2;
		x += speed;
		counter++;
		if (counter >= 100) {
			x -= speed;
		}
		if (counter >= 200) {
			x += speed;
		}
		if (counter >= 275) {
			x -= speed;
		}

	}

}
