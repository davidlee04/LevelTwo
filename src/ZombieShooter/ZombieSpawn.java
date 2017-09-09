package ZombieShooter;

import java.util.ArrayList;

public class ZombieSpawn {
	ArrayList<NormalZombie> waveOne = new ArrayList<NormalZombie>();
	ArrayList<NormalZombie> waveTwo = new ArrayList<NormalZombie>();

	int currentWave = 0;

	int amountSpawned;

	public ZombieSpawn() {
		setUpWaveOne();
		setUpWaveTwo();
	}

	public ArrayList<NormalZombie> getNextWave() {
		if (currentWave == 0) {
			currentWave++;
			return waveOne;
		} else if(currentWave == 1){
			currentWave++;
			System.out.println("TEST-------------");
			return waveTwo;
		} else {
			//currentWave++;
			return waveOne;
		}
	}

	public void setUpWaveOne() {
		waveOne.add(new NormalZombie(400, 0));
		waveOne.add(new NormalZombie(200, 0));
		waveOne.add(new NormalZombie(50, 0));
	}
	
	public void setUpWaveTwo() {
		waveTwo.add(new NormalZombie(500, 0));
		waveTwo.add(new NormalZombie(100, 0));
		waveTwo.add(new SpeedZombie(300, 0));
	}

}
