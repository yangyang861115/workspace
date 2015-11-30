package cs61b.src.lab6;


/* BadTransactionException */

/**
 *  Implements an exception that should be thrown for withdraw an invalid amount.
 **/

public class BadTransactionException extends Exception {

  public int amount;  // The invalid amount.

  /**
   *  Creates an exception object 
   **/
  public BadTransactionException(int badAmount) {
	  super("Invalid deposit amount: " + badAmount);
	  
      amount = badAmount;
  }
}
