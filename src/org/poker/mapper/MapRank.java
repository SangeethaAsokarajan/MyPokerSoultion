package org.poker.mapper;

import org.poker.card.CardRank;
import org.poker.card.Suit;

public class MapRank {
	
	public static String mapActualCardRank(CardRank rank){
		
		switch(rank.getCardRank()){
		
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "T";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		case 14: return "A";
		}
		
		return null;
	}
	
	public static CardRank mapStringtoCardRank(Character c){
		
		CardRank cardRank=null;
		switch(c){
		
		case '2': cardRank=CardRank.TWO;
		          break;
		case '3': cardRank=CardRank.THREE;
        break;
		case '4': cardRank=CardRank.FOUR;
        break;
		case '5': cardRank=CardRank.FIVE;
        break;
		case '6': cardRank=CardRank.SIX;
        break;
		case '7': cardRank=CardRank.SEVEN;
        break;
		case '8': cardRank=CardRank.EIGHT;
        break;
		case '9': cardRank=CardRank.NINE;
        break;
		case 'T': cardRank=CardRank.TEN;
        break;
		case 'J': cardRank=CardRank.JACK;
        break;
		case 'Q': cardRank=CardRank.QUEEN;
        break;
		case 'K': cardRank=CardRank.KING;
        break;
		case 'A': cardRank=CardRank.ACE;
        break;
		          
		}
		return cardRank;
	}
	
	public static Suit setSuit(Character c){
		
		Suit suit =null;
		switch(c){
		case 'S':suit=Suit.SPADE;
		         break;
		case 'D':suit=Suit.DIAMOND;
        break;
		case 'C':suit=Suit.CLUB;
        break;
		case 'H':suit=Suit.HEART;
        break;
		}
		return suit;
	}

}
