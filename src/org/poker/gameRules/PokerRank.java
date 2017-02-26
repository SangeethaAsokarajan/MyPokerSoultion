/**
 * 
 */
package org.poker.gameRules;

/**
 * @author Sangita
 *
 */
public enum PokerRank{
	  HIGH_CARD(1), 
	  PAIR(2), 
	  TWO_PAIRS(3), 
	  THREE_OF_A_KIND(4),
	  STRAIGHT(5),
	  FLUSH(6),
	  FULL_HOUSE(7),
	  FOUR_OF_A_KIND(8),
	  STRAIGHT_FLUSH(9),
	  ROYAL_FLUSH(10)
	  ;
	 /* Important Note: Must have semicolon at
	   * the end when there is a enum field or method
	   */
	  private final int code;
		  
	  PokerRank(int code) {
	      this.code = code;
	  }
		  
	  public int getPokerRankCode() {
	      return this.code;
	  }
	}
