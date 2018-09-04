package com.ravi.home.deckOfCards;

import java.util.ArrayList;
import java.util.List;

import com.ravi.home.game.EmptyDeck;
import com.ravi.home.game.Game;
import com.ravi.home.game.Player;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Test if the shuffle cards contain all cards from original list
	 * @throws EmptyDeck 
	 */
	public void testShuffle() throws EmptyDeck {
		// Initialize game
		Game game = new Game();
		// Create players for Game
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		Player p3 = new Player("Player 3");
		Player p4 = new Player("Player 4");
		List<Player> players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		// Shuffle and Deal cards to all players
		game.start(players);
		List<Card> shCards = game.getDeck().getShuffleCards();
		List<Card> cards = game.getDeck().getCards();
		for(Card card: cards) {
			if(shCards.contains(card) == false) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}
	
	//Test if the deal cards among players contain all cards from original list
	public void testDeals() throws EmptyDeck {
		// Initialize game
		Game game = new Game();
		// Create players for Game
		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");
		Player p3 = new Player("Player 3");
		Player p4 = new Player("Player 4");
		List<Player> players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		// Shuffle and Deal cards to all players
		game.start(players);
		List<Card> playerCards = new ArrayList<>();
		playerCards.addAll(p1.getCards());
		playerCards.addAll(p2.getCards());
		playerCards.addAll(p3.getCards());
		playerCards.addAll(p4.getCards());
		List<Card> cards = game.getDeck().getCards();
		for(Card card: cards) {
			if(playerCards.contains(card) == false) {
				assertTrue(false);
			}
		}
		assertTrue(true);
	}
}
