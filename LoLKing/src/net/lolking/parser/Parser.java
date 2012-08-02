package net.lolking.parser;

import org.jsoup.Jsoup;

public abstract class Parser {
	
	protected Boolean connectedSuccessfully;
	
	public Parser() {
		
	}
	
	abstract Boolean worked();
	abstract void parseData();
}
