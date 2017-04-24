package Coursework2;

/**
 * @author DELL
 *
 */
public class Controller {
	
	//private variables

	private int totalCredits = 10;
	private int betCredits = 0;
	private int betMax = 3;
	private String status;
	private int winCount = 0;
	private int lossCount = 0;
	private int noOfGames = 0;
	private double netCredits = 0;
	
	//Getters setters

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}

	public int getBetCredits() {
		return betCredits;
	}

	public void setBetCredits(int betCredits) {
		this.betCredits = betCredits;
	}

	public int getBetMax() {
		return betMax;
	}

	public void setBetMax(int betMax) {
		this.betMax = betMax;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public int getLossCount() {
		return lossCount;
	}

	public void setLossCount(int lossCount) {
		this.lossCount = lossCount;
	}

	public int getNoOfGames() {
		return noOfGames;
	}

	public void setNoOfGames(int noOfGames) {
		this.noOfGames = noOfGames;
	}

	public double getNetCredits() {
		return netCredits;
	}

	public void setNetCredits(double netCredits) {
		this.netCredits = netCredits;
	}

	// Add Coin
	public void addCoin() {
		totalCredits++;

	}

	// bet one
	public void betOne() {
		if (totalCredits > 0) {
			totalCredits--;
			betCredits++;
		} else {
			totalCredits = 0;
		}
	}

	// bet Max
	public void betMax() {
		if (totalCredits >= 3) {
			totalCredits -= betMax;
			betCredits += betMax;
		}
	}

	// Reset button
	public void resetButton() {
		if (betCredits > 0) {
			totalCredits += betCredits;
			betCredits = 0;

		}

	}
	
	
	//creating reel objects
	Reel reel1 = new Reel();
	Reel reel2 = new Reel();
	Reel reel3 = new Reel();

	/**
	 * This calculate credits method helps to calculate total credits as well as
	 * helps to count no of wins and losses
	 */

	public void calculateCredits() {
		if (betCredits != 0) {
			if ((reel1.reelObj.equalTo(reel2.reelObj)) && (reel2.reelObj.equalTo(reel3.reelObj))) {
				winCount++;
				noOfGames++;
				netCredits += (betCredits * reel1.reelObj.getValue() - betCredits);
				totalCredits += (betCredits * reel1.reelObj.getValue());
				// System.out.println(totalCredits);
				status = "you have earned" + " " + betCredits * reel1.reelObj.getValue() + " " + "credits";
				betCredits = 0;
			} else if ((reel1.reelObj.equalTo(reel2.reelObj)) || (reel2.reelObj.equalTo(reel3.reelObj))
					|| (reel1.reelObj.equalTo(reel3.reelObj))) {
				// System.out.println(totalCredits);
				status = "You have another chance";

			} else {
				lossCount++;
				noOfGames++;
				netCredits += (0 - betCredits);

				// totalCredits-=betCredits;
				status = "You have lost this try";
				betCredits = 0;
			}
		} else {

			status = "Please bet some credits";
		}
	}

}
