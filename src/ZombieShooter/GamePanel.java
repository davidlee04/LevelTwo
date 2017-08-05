package ZombieShooter;

import java.awt.Color;
import java.awt.Cursor;
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



public class GamePanel extends JPanel implements ActionListener, KeyListener{
	GameObject gameObject;
	ObjectManager manager = new ObjectManager();
    Crosshair crosshair = new Crosshair(400, 750, 50, 50);
    HealthBar heart1 = new HealthBar(0, 0, 60, 60, 20);
    NormalZombie zombie = new NormalZombie(100, 100, 150, 150);
    Bow bow = new Bow(450, 580, 500, 500);
    
	Timer timer;
	
	public static BufferedImage crosshairImage1;
	public static BufferedImage hearts;
	public static BufferedImage normalZombie;
	public static BufferedImage normalBow;
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	
	int currentState = 0;
	
	public GamePanel() {
		addMouseMotionListener(crosshair);
		
		gameObject = new GameObject();
		timer = new Timer(1000/60, this);
		manager.addObject(heart1);
		manager.addObject(zombie);
		manager.addObject(crosshair);
		manager.addObject(bow);
		
		try {
			crosshairImage1 = ImageIO.read(this.getClass().getResourceAsStream("CrosshairOpt1.png"));
			hearts = ImageIO.read(this.getClass().getResourceAsStream("heart.png"));
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, ZombieShooter.WIDTH, ZombieShooter.HEIGHT);
	}
	
	void updateMenuState() {
		
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, ZombieShooter.WIDTH, ZombieShooter.HEIGHT);
		ZombieShooter.zombieImage.paintIcon(this, g, zombie.getX(), zombie.getY());
		ZombieShooter.normalBowImage.paintIcon(this, g, bow.getX(), bow.getY());
		manager.draw(g);
	}
	
	void updateGameState() {
		manager.update();
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, ZombieShooter.WIDTH, ZombieShooter.HEIGHT);
		
	}
	
	void updateEndState() {
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState == MENU_STATE) {
			updateMenuState();
		}else if(currentState == GAME_STATE) {
			updateGameState();
		}else if(currentState == END_STATE) {
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
			if (currentState == 1) {
				this.setCursor(ZombieShooter.blankCursor);
			}else if (currentState != 1) {
				this.setCursor(Cursor.getDefaultCursor());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
