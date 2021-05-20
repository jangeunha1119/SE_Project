/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.persistency;

import booksys.storage.*;

import java.sql.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class CustomerMapper {
	// Implementation of hidden cache

	private Hashtable cache;

	private PersistentCustomer getFromCache(int oid) {
		Integer key = new Integer(oid);
		return (PersistentCustomer) cache.get(key);
	}

//노쇼 noshow, 블랙리스트 blacklist 추가함.
	private PersistentCustomer getFromCacheByDetails(String name, String phone, int noshow, boolean blacklist) {
		PersistentCustomer c = null;
		Enumeration enums = cache.elements();
		while (c == null && enums.hasMoreElements()) {
			PersistentCustomer tmp = (PersistentCustomer) enums.nextElement();
			if (name.equals(tmp.getName()) && phone.equals(tmp.getPhoneNumber())) {
				c = tmp;
			}
		}
		return c;
	}

	private void addToCache(PersistentCustomer c) {
		Integer key = new Integer(c.getId());
		cache.put(key, c);
	}

	// Constructor:

	private CustomerMapper() {
		cache = new Hashtable();
	}

	// Singleton:

	private static CustomerMapper uniqueInstance;

	public static CustomerMapper getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CustomerMapper();
		}
		return uniqueInstance;
	}

////노쇼 ns, 블랙리스트 b 추가함.
	public PersistentCustomer getCustomer(String n, String p, int ns, boolean b) {
		PersistentCustomer c = getFromCacheByDetails(n, p, ns, b);
		if (c == null) {
			c = getCustomer("SELECT * FROM Customer WHERE name = '" + n + "' AND phoneNumber = '" + p + "'");
			if (c == null) {
				c = createCustomer(n, p, ns, b);
			}
			addToCache(c);
		}
		return c;
	}

	PersistentCustomer getCustomerForOid(int oid) {
		PersistentCustomer c = getFromCache(oid);
		if (c == null) {
			c = getCustomer("SELECT * FROM Customer WHERE oid ='" + oid + "'");
			if (c != null) {
				addToCache(c);
			}
		}
		return c;
	}

	// Add a customer to the database
	// 노쇼 noshow, 블랙리스트 blacklist 추가함.
	PersistentCustomer createCustomer(String name, String phone, int noshow, boolean blacklist) {
		PersistentCustomer c = getFromCacheByDetails(name, phone, noshow, blacklist);
		if (c == null) {
			try {
				Statement stmt = Database.getInstance().getConnection().createStatement();
				int updateCount = stmt.executeUpdate(
						"INSERT INTO Customer (name, phoneNumber)" + "VALUES ('" + name + "', '" + phone + "')");
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			c = getCustomer(name, phone, noshow, blacklist);
		}
		return c;
	}

	private PersistentCustomer getCustomer(String sql) {
		PersistentCustomer c = null;
		try {
			Statement stmt = Database.getInstance().getConnection().createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				int oid = rset.getInt(1);
				String name = rset.getString(2);
				String phone = rset.getString(3);
				// db에서 noshow, blacklist 속성 가져오기
				int noshow = rset.getInt(4);
				boolean blacklist = rset.getBoolean(5);
				c = new PersistentCustomer(oid, name, phone, noshow, blacklist);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
