package org.poker.pokergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.poker.constants.PokerConstants;
import org.poker.deck.Deck;
import org.poker.playgame.PlayGame;

public class PokerGame {
	public static void main(String[] args) {

		// variables
		String line;
		String[] cards;
		int noOfHandsPlayer1 = 0, noOfHandsPlayer2 = 0;
		List<String> deckofCards = new ArrayList<String>();
		int startIndex = 0;
		int endIndex = 5;
		Deck player1 = null, player2 = null;

		// read from command line input
		try (Scanner stdin = new Scanner(System.in)) {
			while (stdin.hasNextLine() && !(line = stdin.nextLine()).equals("")) {
				cards = line.split(" ");
				for (int i = 0; i < cards.length; i++)
					deckofCards.add(cards[i]);
			}
		}

		// assign card deck to players and play
		while (endIndex <= deckofCards.size()) {
			player1 = new Deck(deckofCards.subList(startIndex, endIndex));
			player2 = new Deck(deckofCards.subList(startIndex + 5, endIndex + 5));
			PlayGame playGame = new PlayGame(player1, player2);
			switch (playGame.checkWinningHand()) {

			case PokerConstants.PLAYER_1:
				noOfHandsPlayer1 += 1;
				break;
			case PokerConstants.PLAYER_2:
				noOfHandsPlayer2 += 1;
				break;
			}
			startIndex += 10;
			endIndex += 10;
		}

		// print result
		System.out.println("Player1 :" + noOfHandsPlayer1 + " Hands");
		System.out.println("Player2 :" + noOfHandsPlayer2 + " Hands");
	}

}
