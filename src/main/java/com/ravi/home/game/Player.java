package com.ravi.home.game;

import java.util.ArrayList;
import java.util.List;

import com.ravi.home.deckOfCards.Card;

public class Player {
	
	private List<Card> cards = new ArrayList<>();
	private String name;
	
	public Player(String name) {
		super();
		this.name = name;
	}

	public void dealCard(Card card) {
		if(card != null) {
			cards.add(card);
		}
	}
	
	public void showCards() {
		System.out.println("");
		System.out.println("Name: " + name + " Total Cards: " + cards.size());
		for(Card card : cards) {
			System.out.println(card);
		}
	}
	
	public List<Card> getCards() {
		return cards;
	}

}
