package org.poker.card;

import java.util.Comparator;

public class Card {
	
	 private Suit cardSuit;
	    private CardRank cardRank;


	    public Card(CardRank cardRank, Suit cardSuit) {
	        this.cardSuit = cardSuit;
	        this.cardRank = cardRank;
	    }

	    /**
	     * Generates a random card
	     */
	   /* public Card(){
	        this((int) (Math.random() * 9) , SUIT.values()[(int) (Math.random() * SUIT.values().length)]);
	    }*/

	    public String getSuit() {
	        return cardSuit.toString(); 
	    }

	    public CardRank getRank() {
	        return cardRank;
	    }
	    
	    /*
	     * Comparator implementation to Sort card object based on cardrank
	     */
	    public static class OrderByRank implements Comparator<Card> {

	        @Override
	        public int compare(Card c1, Card c2) {
	            return c1.getRank().getCardRank() > c2.getRank().getCardRank() ? 1 
	            		: (c1.getRank().getCardRank() < c1.getRank().getCardRank() ? -1 : 0);
	        }
	    }
	    
	    /*
	     * Comparator implementation to find if all cards are of same suit
	     */
	    public static class sameSuit implements Comparator<Card> {

	        @Override
	        public int compare(Card c1, Card c2) {
	            return c1.getSuit().equals(c2.getSuit()) ? 1 : 0;
	        }
	    }
}
