package org.poker.gameRules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.poker.card.Card;
import org.poker.card.CardRank;
import org.poker.deck.Deck;

import java.util.Set;

public class PokerRules {
	
	PokerRank rank;
	public List<Card> playerDeck = new ArrayList<>();
	Deck cardDeck;
	List<PokerRank> rankList= new ArrayList<PokerRank>();
	
	public PokerRules(Deck deck){
		this.cardDeck =deck;
		this.playerDeck=deck.getDeckofCards();
		}
	
	public PokerRank getPokerRank(){
		
		checkPairsandKind();
		checkStraightRoyalFlush();
		int noOfRules = this.rankList.size();
		if(noOfRules==0)
		rank=PokerRank.HIGH_CARD;
		else {
		
			Collections.sort(this.rankList);
			rank=this.rankList.get(noOfRules-1);
			
		}
		return rank;
		
	}
	
     public int checkHighestRank(){
		
		int highestRank =-1;
		for(Card c: playerDeck){
			if(c.getRank().getCardRank()<highestRank){
				highestRank=c.getRank().getCardRank();
			}
		}
		return highestRank;
		
	}
	
	private void checkPairsandKind(){
		
		HashMap<CardRank,Integer> characterCount =new HashMap<CardRank,Integer>();
		int pairs=0;
		PokerRank pairsandKindRank=null;
		for(Card card : playerDeck){
			Integer count=characterCount.get(card.getRank());
			if(count==null)
			characterCount.put(card.getRank(), 1);
			else
			characterCount.put(card.getRank(), ++count);
		}
		
		Set<Entry<CardRank, Integer>> entrySet = characterCount.entrySet(); 
		for (Entry<CardRank, Integer> entry : entrySet) {

			if(entry.getValue()==4){
				pairsandKindRank=PokerRank.FOUR_OF_A_KIND;
			}
			else if(entry.getValue()==3){
				pairsandKindRank=PokerRank.THREE_OF_A_KIND;
			}
			else if(entry.getValue()==2){
				pairs+=1;
			}
		}	
		
		if(pairs==1 && rank==PokerRank.THREE_OF_A_KIND){
			pairsandKindRank=PokerRank.FULL_HOUSE;
		}
		else if(pairs ==2){
			pairsandKindRank=PokerRank.TWO_PAIRS;
		}
		if(pairsandKindRank!=null)
		this.rankList.add(pairsandKindRank);
	}
	
	private void checkStraightRoyalFlush() {
		
		if(this.isRoyalFlush())
			this.rankList.add(PokerRank.ROYAL_FLUSH);
		else if(this.isStraightFlush())
			this.rankList.add(PokerRank.STRAIGHT_FLUSH);
		else if(this.checkStraight())
			this.rankList.add(PokerRank.STRAIGHT);
			
	}
	
	private boolean isRoyalFlush(){
		return this.checkStraight() && this.checkFlush() && this.checkRoyalCardDeck();
	}
	
	private boolean isStraightFlush(){
		return this.checkStraight() && this.checkFlush() && !this.checkRoyalCardDeck();
	}
	
	private boolean checkStraight(){
	
		ListIterator<Card> list = playerDeck.listIterator();
		boolean consecutive=false;
		while(list.hasNext()){
	    Integer current,previous;
	    current = list.hasNext()?list.next().getRank().getCardRank():null;
	    previous = list.hasPrevious()?list.next().getRank().getCardRank():null;
	    if(current!=null && previous!=null){
	    if(current==previous+1){
	    	consecutive=true;
	    }
	    else{
	    	consecutive=false;
	    	break;
	    }
		}
		}
		return consecutive;	
	}
	
	private boolean checkFlush(){
		
		boolean flushRank=false;
		flushRank=(Collections.frequency(playerDeck, new Card.sameSuit())==5)?true : false;
		return flushRank;
	}
	
	private boolean checkRoyalCardDeck(){
		
		boolean royalDeck = false;
		for(Card c: playerDeck){
			if(c.getRank().getCardRank() >= 10){
				royalDeck = true;
			}
			else{
				royalDeck = false;
				break;
			}
		}
		return royalDeck;
	}
}
