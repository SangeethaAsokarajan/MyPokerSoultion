package org.poker.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.poker.card.Card;
import org.poker.card.CardRank;
import org.poker.card.Suit;
import org.poker.mapper.MapRank;

public class Deck {

	// maximum number of cards
	public final int deckLength = 52;
	public List<Card> fullDeck = new ArrayList<>();
	public List<Card> playerDeck = new ArrayList<>();

	public Deck() {

		for (Suit suitValue : Suit.values()) {
			for (CardRank rank : CardRank.values()) {
				Card c = new Card(rank, suitValue);
				this.fullDeck.add(c);

			}
		}
	}

	public Deck(List<String> playDeck) {
		for (String str : playDeck) {
			Card c = new Card(MapRank.mapStringtoCardRank(str.charAt(0)), MapRank.setSuit(str.charAt(1)));
			this.playerDeck.add(c);
		}
		Collections.sort(this.playerDeck, new Card.OrderByRank());
	}

	public List<Card> getDeckofCards() {
		return this.playerDeck;
	}

	public List<Card> shuffle(List<Card> fullDeck) {
		this.fullDeck = fullDeck;
		Collections.shuffle(fullDeck);
		return fullDeck;
	}

	// this was mainly used for testing purposes
	// to ensure shuffling was indeed taking place
	public void showDeck(List<Card> fullDeck) {
		this.fullDeck = fullDeck;
		for (int i = 0; i < deckLength; i++) {
			System.out.printf("%s ", fullDeck.get(i).getSuit() + MapRank.mapActualCardRank(fullDeck.get(i).getRank()));
		}
	}

}
