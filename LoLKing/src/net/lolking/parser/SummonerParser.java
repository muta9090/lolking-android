package net.lolking.parser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SummonerParser extends Parser {
	
	public SummonerParser() {
		connectedSuccessfully = false;
	}

	public Boolean worked() {
		return this.connectedSuccessfully;
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
}
