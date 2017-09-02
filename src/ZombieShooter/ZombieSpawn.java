package ZombieShooter;

import java.util.ArrayList;

public class ZombieSpawn {
	ArrayList<NormalZombie> waveOne = new ArrayList<NormalZombie>();

	int currentWave = 0;

	int amountSpawned;

	public ZombieSpawn() {
		setUpWaveOne();
	}

	public ArrayList<NormalZombie> getNextWave() {
		if (currentWave == 0) {
			return waveOne;
		} else {
			return waveOne;
		}
	}

	public void setUpWaveOne() {
		waveOne.add(new NormalZombie(400, 0, 100, 100, 2, 1));
		waveOne.add(new NormalZombie(200, 0, 100, 100, 2, 1));
		waveOne.add(new NormalZombie(50, 0, 100, 100, 2, 1));
	}

}
