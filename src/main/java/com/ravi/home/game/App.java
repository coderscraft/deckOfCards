package com.ravi.home.game;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) throws EmptyDeck {
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
		for(Player p : players) {
			p.showCards();
		}
		// After all cards are distributed, if we try to deal anymore card, we will get exception
		try {
			game.getDeck().dealOneCard();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
