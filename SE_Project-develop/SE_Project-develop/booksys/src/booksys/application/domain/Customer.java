/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.domain;

public class Customer {
	private String name;
	private String phoneNumber;
//노쇼 noshow, 블랙리스트 blacklist 추가함.
	private int noshow;
	private boolean blacklist;

//노쇼 ns, 블랙리스트 b 추가함.
	public Customer(String n, String p, int ns, boolean b) {
		name = n;
		phoneNumber = p;
		noshow = ns;
		blacklist = b;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

//노쇼 getNoShow(),setNoShow() 메소드, getBlackList(),setBlackList() 메소드 추가함.
	public int getNoShow() {
		return noshow;
	}

	public void setNoShow(int n) {
		noshow = n;
	}

	public boolean getBlackList() {
		return blacklist;
	}

	public void setBlackList(boolean b) {
		blacklist = b;
	}

}
