package ZombieShooter;

import javax.swing.JFrame;

public class ZombieShooter {
	JFrame frame;
	GamePanel panel;
	
	static final int WIDTH = 800;
	static final int HEIGHT = 1500;
	
	public ZombieShooter() {
		frame = new JFrame();
		panel = new GamePanel();
		setUI();
	}
	
	public static void main(String[] args){
		ZombieShooter shooter = new ZombieShooter();
		
	}
	
	void setUI(){
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
	}

}
