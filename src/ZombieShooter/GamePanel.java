package ZombieShooter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	GameObject gameObject;
	HealthBar heart = new HealthBar(0, 0, 60, 60, 20);
	ObjectManager manager = new ObjectManager(heart);
	Crosshair crosshair = new Crosshair(400, 750, 50, 50);
	Gun gun = new Gun(410, 590, 500, 500);

	Timer timer;

	public static BufferedImage crosshairImage1;
	public static BufferedImage hearts;
	public static BufferedImage normalZombie;
	public static BufferedImage normalGun;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	int currentState = 0;
	int reloadTime = 300;
	boolean gunFired = false;
	boolean sound = false;
	boolean win = false;

	public GamePanel() {
		addMouseMotionListener(crosshair);
		addMouseListener(this);

		gameObject = new GameObject();
		timer = new Timer(1000 / 60, this);
		manager.addObject(heart);
		manager.addObject(crosshair);
		manager.addObject(gun);

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
		ZombieShooter.title.paintIcon(this, g, 0, 0);
	}

	void updateMenuState() {

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, ZombieShooter.WIDTH, ZombieShooter.HEIGHT);
		for (int i = 0; i < gun.ammo; i++) {
			ZombieShooter.ammo.paintIcon(this, g, 685, i * 50 - 50);
		}
		boolean row1 = true;
		int x = 0;

		for (NormalZombie zombie : manager.spawnZombies()) {
			if (zombie.isAlive) {
				if (zombie instanceof SpeedZombie) {
					ZombieShooter.speedZombie.paintIcon(this, g, zombie.getX(), zombie.getY());
				} else if (zombie instanceof HeavyZombie && zombie.speed == 1) {
					ZombieShooter.heavyZombie.paintIcon(this, g, zombie.getX(), zombie.getY());
				} else if (zombie instanceof HeavyZombie && zombie.speed >= 2) {
					ZombieShooter.heavyZombie6fps.paintIcon(this, g, zombie.getX(), zombie.getY());
				} else {
					ZombieShooter.zombieImage.paintIcon(this, g, zombie.getX(), zombie.getY());
				}
			}
		}

		if (gunFired == true) {
			ZombieShooter.firingGunImage.paintIcon(this, g, gun.getX(), gun.getY());
		} else {
			ZombieShooter.normalGunImage.paintIcon(this, g, gun.getX(), gun.getY());
		}

		for (NormalZombie zombie : manager.spawnZombies()) {
			if (zombie.isAlive) {
				if (zombie.isAlive) {
					g.setColor(Color.green);
					g.drawRect(zombie.getHealthX(), zombie.getY() - 30, 128, 32);
					g.fillRect(zombie.getHealthX(), zombie.getY() - 30, zombie.getHealthWidth(), 32);
					// g.drawImage(ZombieShooter.enemyHealth,
					// zombie.getHealthX(), zombie.getY()-75, (int)
					// zombie.healthWidth, 128, null);
				}
			}
		}

		for (int counter = 0; counter < heart.hearts; counter++) {
			if (row1) {
				g.drawImage(GamePanel.hearts, x, heart.y, heart.width, heart.height, null);
			} else {
				g.drawImage(GamePanel.hearts, x, heart.y + 50, heart.width, heart.height, null);
			}
			x += 40;
			if (x >= 400) {
				x = 0;
				row1 = false;
			}
		}

		for (NormalZombie zombie : manager.spawnZombies()) {
			if (zombie.isAlive && zombie instanceof HeavyZombie) {
				zombie.stampedeStart();
				System.out.println(zombie.getStampedeTime());
				if (zombie.getStampedeTime() >= 200) {
					zombie.speed = 2;
				}
				if (zombie.getStampedeTime() >= 400) {
					zombie.speed = 5;
				}
			}
		}

		manager.draw(g);
		manager.checkZombieHit();
		manager.killZombie();
	}

	void updateGameState() {
		if (currentState == 1 && manager.checkWin() == true) {
			win = true;
			currentState = END_STATE;
		} else if (currentState == 1 && heart.hearts <= 0) {
			win = false;
			currentState = END_STATE;
		} 
		manager.update();
		
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, ZombieShooter.WIDTH, ZombieShooter.HEIGHT);
        if(win) {
        	    ZombieShooter.youwin.paintIcon(this, g, 140, 250);
        }else if (win == false){
        	    ZombieShooter.youdied.paintIcon(this, g, 0, 50);
          	playSound("deathsound.wav");
        }
	}

	void updateEndState() {

	}

	void playSound(String file) {
		if (!sound) {
			try {
				Clip sanic = AudioSystem.getClip();
				AudioInputStream inputStream = AudioSystem
						.getAudioInputStream(GamePanel.class.getResourceAsStream(file));
				sanic.open(inputStream);
				sanic.start();
				sound = true;

			} catch (Exception e) {

			}
		}
	}

	void playGunshot(String file) {
		try {
			Clip shot = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(GamePanel.class.getResourceAsStream(file));
			shot.open(inputStream);
			shot.start();

		} catch (Exception e) {

		}
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

		reloadTime--;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState < 1) {
				currentState++;
			} 
			if (currentState == 1) {
				this.setCursor(ZombieShooter.blankCursor);
			} else if (currentState != 1) {
				this.setCursor(Cursor.getDefaultCursor());
			}
		}
		
		if (reloadTime <= 0 && e.getKeyCode() == KeyEvent.VK_R) {
			playGunshot("reload.wav");
			reloadTime = 300;
			gun.ammo = 10;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (gun.ammo != 0 && currentState == 1) {
			playGunshot("revolver.wav");
			gunFired = true;
			gun.ammo--;
			manager.checkShot();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		gunFired = false;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
