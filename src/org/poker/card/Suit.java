package org.poker.card;

public enum Suit {
	
	SPADE("S"), 
	CLUB("C"), 
	HEART("H"), 
	DIAMOND("D")
	;
	
	/* Important Note: Must have semicolon at
	   * the end when there is a enum field or method
	   */
	  private final String code;
		  
	Suit(String code) {
	      this.code = code;
	  }
		  
	  public String getSuit() {
	      return this.code;
	  }
	  
}
