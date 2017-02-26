package org.poker.gameRules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import org.poker.card.Card;
import org.poker.card.CardRank;
import org.poker.deck.Deck;

import java.util.Set;

public class PokerRules {

	PokerRank rank;
	public List<Card> playerDeck = new ArrayList<>();
	Deck cardDeck;
	List<PokerRank> rankList = new ArrayList<PokerRank>();
	HashMap<PokerRank, CardRank> tieBreaker = new HashMap<PokerRank, CardRank>();

	public PokerRules(Deck deck) {
		this.cardDeck = deck;
		this.playerDeck = deck.getDeckofCards();
	}

	public PokerRank getPokerRank() {

		checkPairsandKind();
		checkStraightRoyalFlush();
		int noOfRules = this.rankList.size();
		if (noOfRules == 0)
			rank = PokerRank.HIGH_CARD;
		else {

			Collections.sort(this.rankList);
			rank = this.rankList.get(noOfRules - 1);

		}
		return rank;
	}

	public HashMap<PokerRank, CardRank> getTieBreakerCardDetails() {

		return this.tieBreaker;
	}

	private void checkPairsandKind() {

		HashMap<CardRank, Integer> characterCount = new HashMap<CardRank, Integer>();
		int pairs = 0;
		PokerRank pairsandKindRank = null;
		for (Card card : playerDeck) {
			Integer count = characterCount.get(card.getRank());
			if (count == null)
				characterCount.put(card.getRank(), 1);
			else
				characterCount.put(card.getRank(), ++count);
		}

		Set<Entry<CardRank, Integer>> entrySet = characterCount.entrySet();
		for (Entry<CardRank, Integer> entry : entrySet) {

			if (entry.getValue() == 4) {
				pairsandKindRank = PokerRank.FOUR_OF_A_KIND;
				tieBreaker.put(PokerRank.FOUR_OF_A_KIND, entry.getKey());
			} else if (entry.getValue() == 3) {
				pairsandKindRank = PokerRank.THREE_OF_A_KIND;
				tieBreaker.put(PokerRank.THREE_OF_A_KIND, entry.getKey());
			} else if (entry.getValue() == 2) {
				pairs += 1;
				switch (pairs) {
				case 1:
					tieBreaker.put(PokerRank.PAIR, entry.getKey());
					break;
				case 2:
					tieBreaker.put(PokerRank.TWO_PAIRS, entry.getKey());
					break;
				}
			}
		}

		if (pairs == 1 && pairsandKindRank == PokerRank.THREE_OF_A_KIND) {
			pairsandKindRank = PokerRank.FULL_HOUSE;
		} else if (pairs == 2) {
			pairsandKindRank = PokerRank.TWO_PAIRS;
		} else if (pairs == 1) {
			pairsandKindRank = PokerRank.PAIR;
		}
		if (pairsandKindRank != null)
			this.rankList.add(pairsandKindRank);
	}

	private void checkStraightRoyalFlush() {

		boolean isStraight = this.checkStraight();
		boolean isFlush = this.checkFlush();
		boolean isRoyalCardDeck = this.checkRoyalCardDeck();

		if (isStraight && isFlush && isRoyalCardDeck)
			this.rankList.add(PokerRank.ROYAL_FLUSH);
		else if (isStraight && isFlush && !isRoyalCardDeck)
			this.rankList.add(PokerRank.STRAIGHT_FLUSH);
		else if (isStraight)
			this.rankList.add(PokerRank.STRAIGHT);
		else if (isFlush)
			this.rankList.add(PokerRank.FLUSH);

	}

	private boolean checkStraight() {

		ListIterator<Card> list = playerDeck.listIterator();
		boolean consecutive = false;
		for(int i=0;i<playerDeck.size()-1;i++){
			if(playerDeck.get(i).getRank().getCardRank()==
					playerDeck.get(i+1).getRank().getCardRank()-1) {
				consecutive = true;
			}
			else {
				consecutive = false;
				break;
			}
		}
		return consecutive;
	}

	private boolean checkFlush() {

		boolean flushRank = false;
		Set<String> suit = new HashSet<String>();
		for (Card c : playerDeck) {
			suit.add(c.getSuit());
		}
		if (suit.size() == 1)
			flushRank = true;
		return flushRank;
	}

	private boolean checkRoyalCardDeck() {

		boolean royalDeck = false;
		for (Card c : playerDeck) {
			if (c.getRank().getCardRank() >= 10) {
				royalDeck = true;
			} else {
				royalDeck = false;
				break;
			}
		}
		return royalDeck;
	}
}
