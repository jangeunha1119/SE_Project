/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksysapp1 ;

public class Table
{
  private int number ;
  private int places ;
  
  public Table(int n, int p)
  {
    number = n ;
    places = p ;
  }

  public int getNumber()
  {
    return number ;
  }

  public int getPlaces()
  {
    return places ;
  }
}
