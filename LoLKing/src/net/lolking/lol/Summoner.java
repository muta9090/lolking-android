package net.lolking.lol;

import net.lolking.parser.SummonerParser;

public class Summoner {
	
	private SummonerParser parser;
	
	private String summonerName;
	private byte region; //NA=0, EUW=1, EUNE=2
	private byte summonerLevel;
	//private we'll figure it out summonerIcon;
	
	private short soloQueueElo; //If 0, make sure to implement in layout that it means No Rating
	private short topSoloQueueElo;
	private int soloQueueWins;
	private int soloQueueLosses;
	
	private short teamElo; //If 0, make sure to implement in layout that it means No Rating
	private short topTeamElo;
	private int teamQueueWins;
	private int teamQueueLosses;
	
	private short teamEloThrees;
	private short topTeamEloThrees;
	private int teamThreesQueueWins;
	private int teamThressQueueLosses;
	
	//Ranked Stats
	private int pentaKills;
	private int quadraKills;
	private int tripleKills;
	private int doubleKills;
	private int totalKills;
	private int mostKills;
	private int totalAssists;
	private int goldEarned;
	private int turretsDestroyed;
	private int killingSprees;
	private int largestKillingSpree;
	//Find a way to set in layout that if all of these stats are 0, say "No Ranked History"
	
	//Normal Stats
	private int normalWins;
	private int normalKills;
	private int normalAssists;
	private int normalTurretsDestroyed;
	
	//Only worry about getting me the champname, wins, and losses for the first 5 champs and I'll take care of the rest
	private PlayedChampion[] mostPlayedChampions;
	
	//public Summoner (LKParser parser) {
		//this.summonerName = parser.getSummonerName();
		
	//}
	
	public Boolean getDataFromNet() {
		
		/*parser.parseData();
		if(parser.worked()) {
		    this.tagLine = parser.getTagLine();
		    int numAtts = parser.getAttributes().length;
		    String atts = parser.getAttributes()
		    for (int i = 0; i < numAtts; i++)
			      this.attributes[i] = atts[i];
		    this.ipCost = parser.getIpCost();
		    ...
		    ...
		    dataReceived = true;
		}
		else
		    dataReceived = false;
		*/
		
		
		return false;
		
	}
		

}
