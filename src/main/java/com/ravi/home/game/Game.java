package com.ravi.home.game;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ravi.home.deckOfCards.Card;
import com.ravi.home.deckOfCards.Deck;

public class Game {

	private Deck deck;

	public Game() {
		super();
		initializeDeck();
	}
	
	public Deck getDeck() {
		return deck;
	}

	private void initializeDeck() {
		JSONParser parser = new JSONParser();
		List<Card> cards = new ArrayList<>();
		Object obj;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("cards.json").getFile());
			obj = parser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray cardsArray = (JSONArray) jsonObject.get("cards");
			for(int i = 0; i < cardsArray.size(); i++) {
				JSONObject cardObj = (JSONObject) cardsArray.get(i);
				Card card = new Card((String) cardObj.get("type"),(String) cardObj.get("value"));
				cards.add(card);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		deck = new Deck(cards);
	}

	public void start(List<Player> players) throws EmptyDeck {
		deck.showDeck("Original Deck");
		deck.shuffle();
		deck.showDeck("After Shuffle");
		if (players != null && players.size() > 0) {	
			while(deck.hasCard() == true) {
			     for(Player p : players) {
		        	   if(deck.hasCard() == true) {
		        		   p.dealCard(deck.dealOneCard());
		        	   }
		           }
			}
		}	
	}
	

}
