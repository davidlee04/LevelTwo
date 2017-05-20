import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	GameObject gameObject;
	ObjectManager manager = new ObjectManager();
	Rocketship ship = new Rocketship(250, 700, 50, 50);
	
	public static BufferedImage alienImage;
	public static BufferedImage bulletImage;
	public static BufferedImage rocketImage;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	int currentState = MENU_STATE;

	Timer timer;

	Font titleFont;
	Font startFont;
	Font instructionsFont;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		gameObject = new GameObject();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 24);
		instructionsFont = new Font("Arial", Font.PLAIN, 24);
		manager.addObject(ship);
		
		try {
			alienImage = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImage = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImage = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 200);
		g.setFont(startFont);
		g.drawString("Press ENTER to start", 125, 300);
		g.setFont(instructionsFont);
		g.drawString("Press SPACE for instruction", 100, 400);
	}

	void updateMenuState() {

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		manager.draw(g);
	}

	void updateGameState() {
		if (ship.isAlive == false) {
			currentState = END_STATE;
			manager.reset();
			ship = new Rocketship(250, 700, 50, 50);
			manager.addObject(ship);
		}
		manager.checkCollision();
		manager.getScore();
		manager.manageEnemies();
		manager.update();

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	void updateEndState() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState < END_STATE) {
				currentState++;
			} else if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			ship.x = ship.x - ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ship.x = ship.x + ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ship.y = ship.y - ship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ship.y = ship.y + ship.speed;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addObject(new Projectile(ship.x + 23, ship.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
