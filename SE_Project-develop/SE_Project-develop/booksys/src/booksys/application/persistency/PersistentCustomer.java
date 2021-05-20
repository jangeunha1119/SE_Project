/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.persistency;

import booksys.application.domain.Customer;

class PersistentCustomer extends Customer {
	private int oid;

//노쇼 ns, 블랙리스트 b 추가함.
	PersistentCustomer(int id, String n, String p, int ns, boolean b) {
		super(n, p, ns, b);
		oid = id;
	}

	int getId() {
		return oid;
	}
}
