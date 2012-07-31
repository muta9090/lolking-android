package net.lolking.lol;

/**
 * This class stores the basic information (name, iconID, etc.) of each champion, plus can give a great deal of data if parsing is successful.
 * @author Adam
 *
 */
public class Champion {
	
	private Boolean real;			//Will be false if the parser can't connect to the internet, and will tell the ChampInfoLayout that information could not be found for whatever reason (no net access, etc.)
		
	private String champName;		//The official champion name as seen in League of Legends
	private Integer iconAssetID;	//The Android resource id (eg. R.drawable.ahri_square_0)
	
	// Basic information that will be grabbed by parser
	private String tagLine;
	private String[] attributes;
	private short ipCost;
	private short rpCost;	
	private double baseDamageMin;
	private double baseDamageMax;
	private int baseHealthMin;
	private int baseHealthMax;
	private double baseHealthRegenMin;
	private double baseHealthRegenMax;
	private int baseManaMin;
	private int baseManaMax;
	private double baseManaRegenMin;
	private double baseManaRegenMax;
	private double baseArmorMin;
	private double baseArmorMax;
	private double baseMagicResist;
	private int baseMovespeed;
	private byte baseRangeType; // 0 = Melee, 1 = Ranged
	private int baseRange;
	
	/*private ChampionParser parser*/
	
	/*
	 * The parser will eventually take the name of the champion and use LoLKing's champion data
	 * to give detailed info on each champion in an eventual fragment (or return a new Champion() 
	 * if it could not connect to LoLKing). Basically, on the Champion selection grid, selecting a 
	 * champion will open a ChampInfoLayoutFragment with a setChampion(Champion c) method. This 
	 * class will eventually handle all of the data about each champion as found by the parser, 
	 * so that way the ChampInfoLayoutFragment can handle everything it needs to display without 
	 * parsing anything itself. That layout fragment also needs a way to display something like 
	 * "Could not connect to LoLKing" if Champion.isReal() returns false.
	 */
	
	public Champion (String name, Integer iconAsset) {
		this.champName = name;		
		this.iconAssetID = iconAsset;
		this.real = true;
		//parser = new ChampionParser(name);

	}
	
	public Champion () {
		this.real = false;

	}
	
	public Champion (Champion champion) {
		this.champName = champion.getChampName();
		this.iconAssetID = champion.getIconAssetID();
		//parser = new ChampionParser(name);
	}
	
	/**
	 * This method connects to LoLKing and retrieves all of the champion data, storing it in the Champion object.
	 * If successful, the method will return true.
	 */
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

	public String getChampName() {
		return champName;
	}

	public Integer getIconAssetID() {
		return iconAssetID;
	}	
	
	public Boolean isReal() {
		return real;
	}

}
