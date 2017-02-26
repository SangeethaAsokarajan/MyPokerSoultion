package org.poker.gameRulesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import org.poker.deck.Deck;
import org.poker.gameRules.PokerRank;
import org.poker.gameRules.PokerRules;

public class PokerRulesTest {

	@Test
	public void getPokerRankHighCard() {
		// arrange
		String[] cards = { "8D", "5S", "7S", "TC", "6D" };
		Deck deck = new Deck(new ArrayList<String>(Arrays.asList(cards)));
		PokerRules rules = new PokerRules(deck);

		// act
		PokerRank rank = rules.getPokerRank();

		// asset
		assertEquals(rank, PokerRank.HIGH_CARD);
	}
	
	@Test
	public void getPokerRankPair() {
		// arrange
		String[] cards = { "8D", "5S", "7S", "TC", "7D" };
		Deck deck = new Deck(new ArrayList<String>(Arrays.asList(cards)));
		PokerRules rules = new PokerRules(deck);

		// act
		PokerRank rank = rules.getPokerRank();

		// asset
		assertEquals(rank, PokerRank.PAIR);
	}
	
	@Test
	public void getPokerRankTwoPair() {
		// arrange
		String[] cards = { "5D", "5S", "7S", "7C", "6D" };
		Deck deck = new Deck(new ArrayList<String>(Arrays.asList(cards)));
		PokerRules rules = new PokerRules(deck);

		// act
		PokerRank rank = rules.getPokerRank();

		// asset
		assertEquals(rank, PokerRank.TWO_PAIRS);
	}
	
	@Test
	public void getPokerRankFlush() {
		// arrange
		String[] cards = { "8D", "5D", "7D", "TD", "6D" };
		Deck deck = new Deck(new ArrayList<String>(Arrays.asList(cards)));
		PokerRules rules = new PokerRules(deck);

		// act
		PokerRank rank = rules.getPokerRank();

		// asset
		assertEquals(rank, PokerRank.FLUSH);
	}
	
	@Test
	public void getPokerRankStraight() {
		// arrange
		String[] cards = { "8S", "9D", "7C", "TH", "6D" };
		Deck deck = new Deck(new ArrayList<String>(Arrays.asList(cards)));
		PokerRules rules = new PokerRules(deck);

		// act
		PokerRank rank = rules.getPokerRank();

		// asset
		assertEquals(rank, PokerRank.STRAIGHT);
	}
	
	@Test
	public void getPokerRankThreeofaKind() {
		// arrange
		String[] cards = { "8S", "8D", "7C", "8H", "6D" };
		Deck deck = new Deck(new ArrayList<String>(Arrays.asList(cards)));
		PokerRules rules = new PokerRules(deck);

		// act
		PokerRank rank = rules.getPokerRank();

		// asset
		assertEquals(rank, PokerRank.THREE_OF_A_KIND);
	}
	
	@Test
	public void getPokerRankFourofaKind() {
		// arrange
		String[] cards = { "8D", "8C", "8S", "8H", "6D" };
		Deck deck = new Deck(new ArrayList<String>(Arrays.asList(cards)));
		PokerRules rules = new PokerRules(deck);

		// act
		PokerRank rank = rules.getPokerRank();

		// asset
		assertEquals(rank, PokerRank.FOUR_OF_A_KIND);
	}
	
	@Test
	public void getPokerRankFullHouse() {
		// arrange
		String[] cards = { "3D", "3S", "7C", "3H", "7D" };
		Deck deck = new Deck(new ArrayList<String>(Arrays.asList(cards)));
		PokerRules rules = new PokerRules(deck);

		// act
		PokerRank rank = rules.getPokerRank();

		// asset
		assertEquals(rank, PokerRank.FULL_HOUSE);
	}
}
