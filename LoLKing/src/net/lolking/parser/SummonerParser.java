package net.lolking.parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SummonerParser extends Parser {
	
	public SummonerParser() {
		connectedSuccessfully = false;
	}

	public Boolean worked() {
		return this.connectedSuccessfully;
	}
	
	/**
	 * Returns the summoner IDs for champions from each region, where 0=NA, 1=EUW, 2=EUNE
	 * @param summonerName Name of the summoner
	 * @return an array of summonerIDs. Returns null if summoner does not exist, returns 0 for certain regions if summoner does not exist in that region
	 */
	public int[] getSummonerIdsFromWeb(String summonerName)
	{
		int[] summonerIds;		
		summonerIds = new int[3];
		
		String cleanSummonerName = cleanName(summonerName);		
		try {
			
			Boolean summonerExists = false;
			URL summonerChoiceUrl = new URL("http://www.lolking.net/search?name=" + cleanSummonerName);
			Document summonerChoicePage = Jsoup.parse(summonerChoiceUrl, 10000);
			
			Element naElement = summonerChoicePage.select("[href^=/summoner/na/]").first();
			Element euwElement = summonerChoicePage.select("[href^=/summoner/euw/]").first();
			Element euneElement = summonerChoicePage.select("[href^=/summoner/eune/]").first();
			
			
			
			if(naElement != null) {				
				summonerIds[0] = getProperId(naElement, 13);
			}			
			else
				summonerIds[0] = 0;
			
			if(euwElement != null) {
				summonerIds[1] = getProperId(euwElement, 14);
			}
			else
				summonerIds[1] = 0; 
	
			if(euneElement != null) {
				summonerIds[2] = getProperId(euneElement, 15);
			}
			else
				summonerIds[2] = 0;
			
			for (int i = 0; i < summonerIds.length; i++) {
				if(summonerIds[i] != 0)
					summonerExists = true;
			}
			
			if(!summonerExists)
				summonerIds = null;
					
		} catch (MalformedURLException e) {
			summonerIds = null;
		} catch (IOException e) {
			summonerIds = null;
		}
		
		return summonerIds;
		
	}
	
	private String cleanName(String summonerName) {
		
		summonerName.trim();
		summonerName.replaceAll("\\W", "");		
		return summonerName;
	}

	private Document getSummonerHtmlFromWeb(String summonerId, String region) throws IOException {
		URL summonerUrl;
		Document doc;
		
		try {
			summonerUrl = new URL("http://www.lolking.net/summoner/" + region + "/" + region);
			doc = Jsoup.parse(summonerUrl, 10000);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			doc = null;
		}
		
		return doc;	
		
	}
	
	private int getProperId(Element ele, int stringCutoff) {
		int properId;
		
		if (!ele.attr("href").endsWith("#stream"))
			properId = Integer.parseInt(ele.attr("href"));
		else
			properId = 0;
		
		return properId;
	}

	@Override
	void parseData() {
		
		
	}
}
