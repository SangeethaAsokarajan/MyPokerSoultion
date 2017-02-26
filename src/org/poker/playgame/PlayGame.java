package org.poker.playgame;

import org.poker.constants.PokerConstants;
import org.poker.deck.Deck;
import org.poker.gameRules.PokerRank;
import org.poker.gameRules.PokerRules;

public class PlayGame {

	Deck deck1, deck2;
	PokerRules player1, player2;

	public PlayGame(Deck deck1, Deck deck2) {

		this.deck1 = deck1;
		this.deck2 = deck2;
	}

	
	/**
	 * Determine the winner from the player decks
	 * @return winner player
	 */
	public String checkWinningHand() {

		player1 = new PokerRules(deck1);
		player2 = new PokerRules(deck2);

		if (player1.getPokerRank().getPokerRankCode() > player2.getPokerRank().getPokerRankCode()) {
			return PokerConstants.PLAYER_1;
		} else if (player1.getPokerRank().getPokerRankCode() < player2.getPokerRank().getPokerRankCode()) {
			return PokerConstants.PLAYER_2;
		} else if (player1.getPokerRank().getPokerRankCode() == player2.getPokerRank().getPokerRankCode()) {
			int highRank;
			if (!player1.getPokerRank().equals(PokerRank.HIGH_CARD)) {
				highRank = getTieBreakerWinningPlayerDetails(player1.getPokerRank());
				if (highRank == PokerConstants.PLAYERS_EQUALRANK) {
					highRank = getHighCardRank();
				}
			} else {
				highRank = getHighCardRank();
			}
			switch (highRank) {

			case PokerConstants.PLAYER1_HIGHCARDRANK: {
				return PokerConstants.PLAYER_1;
			}
			case PokerConstants.PLAYER2_HIGHCARDRANK: {
				return PokerConstants.PLAYER_2;
			}
			}
		}

		return PokerConstants.WINNER_UNDETERMINED;
	}

	private int getTieBreakerWinningPlayerDetails(PokerRank pokerRank) {

		if (player1.getTieBreakerCardDetails().containsKey(PokerRank.THREE_OF_A_KIND)
				&& player1.getTieBreakerCardDetails().containsKey(PokerRank.PAIR)) {

			int winningPlayer = decideWinningPlayer(PokerRank.THREE_OF_A_KIND);
			if (winningPlayer == PokerConstants.PLAYERS_EQUALRANK)
				return decideWinningPlayer(PokerRank.PAIR);
			else
				return winningPlayer;
		} else if (player1.getTieBreakerCardDetails().containsKey(PokerRank.TWO_PAIRS)
				&& player1.getTieBreakerCardDetails().containsKey(PokerRank.PAIR)) {

			int winningPlayer = decideWinningPlayer(PokerRank.TWO_PAIRS);
			if (winningPlayer == PokerConstants.PLAYERS_EQUALRANK)
				return decideWinningPlayer(PokerRank.PAIR);
			else
				return winningPlayer;

		} else
			return decideWinningPlayer(pokerRank);
	}

	private int decideWinningPlayer(PokerRank pokerRank) {

		int player1CardRank = player1.getTieBreakerCardDetails().get(pokerRank).getCardRank();
		int player2CardRank = player2.getTieBreakerCardDetails().get(pokerRank).getCardRank();
		if (player1CardRank > player2CardRank)
			return PokerConstants.PLAYER1_HIGHCARDRANK;
		else if (player1CardRank < player2CardRank)
			return PokerConstants.PLAYER2_HIGHCARDRANK;
		else
			return PokerConstants.PLAYERS_EQUALRANK;

	}

	private int getHighCardRank() {

		int highCardIndex = PokerConstants.PLAYER_DECK_SIZE - 1;
		int player1HighCard, player2HighCard;

		while (highCardIndex >= 0) {
			player1HighCard = deck1.getDeckofCards().get(highCardIndex).getRank().getCardRank();
			player2HighCard = deck2.getDeckofCards().get(highCardIndex).getRank().getCardRank();
			if (player1HighCard > player2HighCard)
				return PokerConstants.PLAYER1_HIGHCARDRANK;
			else if (player1HighCard < player2HighCard)
				return PokerConstants.PLAYER2_HIGHCARDRANK;
			else {
				--highCardIndex;
			}
		}
		return PokerConstants.PLAYERS_EQUALRANK;

	}
}
