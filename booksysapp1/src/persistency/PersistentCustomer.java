/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package persistency ;

import booksysapp1.Customer;

class PersistentCustomer extends Customer
{
  private int oid ;

  PersistentCustomer(int id, String n, String p)
  {
    super(n, p) ;
    oid = id ;
  }

  int getId() {
    return oid ;
  }
}
