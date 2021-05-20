/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.storage;

import java.sql.*;
import java.util.Date;
import java.util.Vector;

public class Database {
	private static Connection con;

	// Singleton:

	private static Database uniqueInstance;

	public static Database getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Database();
		}
		return uniqueInstance;
	}

	private Database() {
		// Get a connection
		// con = Connectivity.getConnection("booksys.properties"); //원본버전
		// C:\Users\82105\git\SE_Project\SE_Project-develop\SE_Project-develop\booksys\booksys.properties
		con = Connectivity.getConnection(
				"C:\\Users\\82105\\git\\SE_Project\\SE_Project-develop\\SE_Project-develop\\booksys\\booksys.properties");// booksys.properties
																															// 파일몾찾아서
																															// 지정해줌 //이부분 말고 원본버전으로 실행시키면 될겁니다. 안되면 이렇게 지정해주세요
	}

	public static Connection getConnection() {
		return con;
	}

	// Get a fresh object ID

	public int getId() {
		int id = 0;
		try {
			Statement stmt = con.createStatement();

			ResultSet rset = stmt.executeQuery("SELECT * FROM Oid");
			while (rset.next()) {
				id = rset.getInt(1);
			}
			rset.close();

			id++;

			int updateCount = stmt.executeUpdate("UPDATE Oid SET last_id = '" + id + "'");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}
}
