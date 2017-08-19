package ZombieShooter;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ZombieShooter {
	JFrame frame;
	GamePanel panel;

	static ImageIcon zombieImage;
	static ImageIcon normalGunImage;
	static ImageIcon firingGunImage;
	static ImageIcon ammo;
	/*
	 * Image image; Image newImg;
	 */

	static final int WIDTH = 800;
	static final int HEIGHT = 1500;

	static BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

	static Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0),
			"blank cursor");

	public ZombieShooter() {
		frame = new JFrame();
		panel = new GamePanel();
		zombieImage = new ImageIcon(this.getClass().getResource("zombie128x.gif"));
		normalGunImage = new ImageIcon(this.getClass().getResource("pistol.png"));
		firingGunImage = new ImageIcon(this.getClass().getResource("pistol_firing.png"));
		ammo = new ImageIcon(this.getClass().getResource("ammo.png"));
		/*
		 * image = zombieImage.getImage(); newImg = image.getScaledInstance(128,
		 * 128, Image.SCALE_SMOOTH); zombieImage = new ImageIcon(newImg);
		 */
		setUI();
	}

	public static void main(String[] args) {
		ZombieShooter shooter = new ZombieShooter();

	}

	void setUI() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.addKeyListener(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();

	}

}
