package net.lolking.lol;

public class PlayedChampion extends Champion {
	
	private int wins;
	private int losses;

	public PlayedChampion(Champion baseChampion, int wins, int losses) {
		super(baseChampion);
		this.wins = wins;
		this.losses = losses;
	}
	
	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

}
