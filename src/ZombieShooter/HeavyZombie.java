package ZombieShooter;

public class HeavyZombie extends NormalZombie {
	// Timer stampede;

	// int stampedeTimer = 0;

	public HeavyZombie(int x, int y) {
		super(x, y);

		speed = 1;
		damage = 3;
		health = 4;

		// stampede = new Timer(1000 / 60, this);
	}

	/*
	 * void stampede() { if (stampedeTimer >= 180) { speed = 5; } if
	 * (stampedeTimer >= 300) { speed = 10; } }
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { // TODO
	 * Auto-generated method stub stampedeTimer++; }
	 */

}
