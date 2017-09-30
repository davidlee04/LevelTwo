package ZombieShooter;

import java.util.ArrayList;

public class ZombieSpawn {
	ArrayList<NormalZombie> waveOne = new ArrayList<NormalZombie>();
	ArrayList<NormalZombie> waveTwo = new ArrayList<NormalZombie>();
	ArrayList<NormalZombie> waveThree = new ArrayList<NormalZombie>();
	ArrayList<NormalZombie> waveFour = new ArrayList<NormalZombie>();
	ArrayList<NormalZombie> waveFive = new ArrayList<NormalZombie>();
	ArrayList<NormalZombie> waveSix = new ArrayList<NormalZombie>();
	ArrayList<NormalZombie> waveSeven = new ArrayList<NormalZombie>();

	int currentWave = 0;

	int amountSpawned;

	public ZombieSpawn() {
		setUpWaveOne();
		setUpWaveTwo();
		setUpWaveThree();
		setUpWaveFour();
		setUpWaveFive();
		setUpWaveSix();
	}

	public ArrayList<NormalZombie> getNextWave() {
		if (currentWave == 0) {
			currentWave++;
			return waveOne;
		} else if (currentWave == 1) {
			currentWave++;
			System.out.println("TEST-------------");
			return waveTwo;
		} else if (currentWave == 2) {
			currentWave++;
			return waveThree;
		} else if (currentWave == 3) {
			currentWave++;
			return waveFour;
		} else if (currentWave == 4) {
			currentWave++;
			return waveFive;
		} else if (currentWave == 5) {
			currentWave++;
			return waveSix;
		} else {
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

	public void setUpWaveThree() {
		waveThree.add(new NormalZombie(300, 0));
		waveThree.add(new NormalZombie(500, 0));
		waveThree.add(new HeavyZombie(600, 100));
	}

	public void setUpWaveFour() {
		waveFour.add(new NormalZombie(200, 0));
		waveFour.add(new NormalZombie(400, 0));
		waveFour.add(new SpeedZombie(500, 0));
		waveFour.add(new HeavyZombie(450, 30));
	}

	public void setUpWaveFive() {
		waveFive.add(new SpeedZombie(400, 0));
	}

	public void setUpWaveSix() {
		waveSix.add(new SpeedZombie(100, 0));
		waveSix.add(new SpeedZombie(300, 0));
		waveSix.add(new SpeedZombie(500, 0));
		waveSix.add(new SpeedZombie(450, 75));
		waveSix.add(new SpeedZombie(600, 50));
	}

	public void setUpWaveSeven() {
		waveSeven.add(new HeavyZombie(400, 30));
		waveSeven.add(new HeavyZombie(600, 80));
		waveSeven.add(new HeavyZombie(200, 30));
		waveSeven.add(new SpeedZombie(200, 0));
		waveSeven.add(new SpeedZombie(500, 0));
	}

}
