package org.poker.pokergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.poker.deck.Deck;
import org.poker.gameRules.PokerRank;
import org.poker.gameRules.PokerRules;


public class PokerGame {
    public static void main(String[] args) {
    	
    	  String line;
    	  String[] cards= {"AH","9S" ,"8C","2S","3H","JS","JH","JC","JD","2C"};
    	  int noOfHandsPlayer1 =0, noOfHandsPlayer2 =0;
    	  List<String> deckofCards = new ArrayList<String>();
    	  int startIndex=0;
    	  int endIndex=5;
    	  Deck player1 = null,player2 = null;
    	  PokerRules rulesPlayer1=null , rulesPlayer2=null;;
    	  PokerRank player1Rank,player2Rank;
          /*try(Scanner stdin = new Scanner(System.in)){*/
          /*while(stdin.hasNextLine() && !( line = stdin.nextLine() ).equals( "" ))
          {
        	  cards = line.split(" ");
        	  Arrays.asList(deckofCards);
              
          }
          }*/
    	  deckofCards=  new ArrayList<String>(Arrays.asList(cards));
        while(endIndex<=deckofCards.size()){
        	player1 =new Deck(deckofCards.subList(startIndex, endIndex));
        	player2 = new Deck(deckofCards.subList(startIndex + 5, endIndex + 5));
        	startIndex += 10;
        	endIndex += 10;
        	 rulesPlayer1 = new PokerRules(player1);
        	 player1Rank=rulesPlayer1.getPokerRank();
             rulesPlayer2 = new PokerRules(player2);
             player2Rank=rulesPlayer2.getPokerRank();
             if(player1Rank != PokerRank.HIGH_CARD || player2Rank != PokerRank.HIGH_CARD){
            	if(player1Rank.getPokerRankCode() > player2Rank.getPokerRankCode()) {
            		noOfHandsPlayer1+=1;	
            	}
            	else if(player1Rank.getPokerRankCode() < player2Rank.getPokerRankCode()){
            		noOfHandsPlayer2+=1;
            	}
            	else{
            		if(rulesPlayer1.checkHighestRank()>rulesPlayer2.checkHighestRank());
            	}
             }
        	
        }
        
        System.out.println("Player1 :" +noOfHandsPlayer1);
        System.out.println("Player2 :" +noOfHandsPlayer2);
     
      }
     
}


      