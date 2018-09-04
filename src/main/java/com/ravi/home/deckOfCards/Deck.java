package com.ravi.home.deckOfCards;

import java.util.ArrayList;
import java.util.List;

import com.ravi.home.game.EmptyDeck;

public class Deck {
	
	List<Card> cards = new ArrayList<>();
	private int[] deckOrder = new int[52];
	private int currentDealCard;
	

	public Deck(List<Card> cards) {
		super();
		this.cards = cards;
		init();
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	private void init() {
		for(int i = 0; i < 52; i++) {
			deckOrder[i] = i;
		}
		currentDealCard = -1;
	}

	public void reset() {
		init();
	}
	
	public void shuffle() {
		currentDealCard = -1;
		for(int i = 51; i >=0; i--) {
			// Get random index
			int pos = getRandom(i);
			// Swap card at random index with current card
			swap(pos, i);
		}
	}
	
	private int getRandom(int max) {
		++max;
		return (int)(Math.random() * max);
	}
	
	private void swap(int indx1, int indx2) {
		int temp = deckOrder[indx1];
		deckOrder[indx1] = deckOrder[indx2];
		deckOrder[indx2] = temp;
	}
	
	public Card dealOneCard() throws EmptyDeck {
		++currentDealCard;
		if(currentDealCard < deckOrder.length) {
			return cards.get(deckOrder[currentDealCard]);
		} else {
			throw new EmptyDeck("Deck is Empty");
		}
	}
	
	public void showDeck(String msg) {
		System.out.println("");
		if(msg != null) {
			System.out.println("******************** " + msg + " *******************");	
		}
		for(int i = 0; i < deckOrder.length; i++) {
			System.out.println(cards.get(deckOrder[i]));
		}
	}
	
	public boolean hasCard() {
		return currentDealCard < deckOrder.length - 1;
	}
	
	public List<Card> getShuffleCards() {
		List<Card> sCards = new ArrayList<>();
		for(int i = 0; i < deckOrder.length; i++) {
			sCards.add(cards.get(deckOrder[i]));
		}
		return sCards;
	}
	

}
