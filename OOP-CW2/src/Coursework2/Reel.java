package Coursework2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Reel extends Thread {
	/*
	 * Creating six symbol objects
	 */
	Symbol seven = new Symbol("C:/Users/DELL/workspace/OOPCW2/OOP-CW2/src/Coursework2/redseven.png", 7);

	Symbol bell = new Symbol("C:/Users/DELL/workspace/OOPCW2/OOP-CW2/src/Coursework2/bell.png", 6);

	Symbol watermelon = new Symbol("C:/Users/DELL/workspace/OOPCW2/OOP-CW2/src/Coursework2/watermelon.png", 5);

	Symbol plum = new Symbol("C:/Users/DELL/workspace/OOPCW2/OOP-CW2/src/Coursework2/plum.png", 4);

	Symbol lemon = new Symbol("C:/Users/DELL/workspace/OOPCW2/OOP-CW2/src/Coursework2/lemon.png", 3);

	Symbol cherry = new Symbol("C:/Users/DELL/workspace/OOPCW2/OOP-CW2/src/Coursework2/cherry.png", 2);

	/*
	 * Creating symbol object array
	 */
	Symbol[] reelArray = { seven, bell, watermelon, plum, lemon, cherry };
	
	

	Symbol reelObj = reelArray[(int) (Math.random() * reelArray.length)];
	Symbol a;

	// Create spin method
	public Symbol[] spin() {
		// Call random function
		Random randomArray = ThreadLocalRandom.current();
		for (int i = reelArray.length - 1; i > 0; i--) {
			int index = randomArray.nextInt(i);
			// swapping
			a = reelArray[index];
			reelArray[index] = reelArray[i];
			reelArray[i] = a;

		}

		reelObj = a;

		return reelArray;

	}

	@Override
	public void run() {

		spin();

	}

}
