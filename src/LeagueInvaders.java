import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;

	GamePanel panel;

	final int WIDTH = 500;
	final int HEIGHT = 800;

	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
		setup();
	}

	public static void main(String[] args) {
		LeagueInvaders invader = new LeagueInvaders();
	}

	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
	}

}
