package h_oto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti {

	static Connection myConn = null;
	static Statement myStat = null;


	public static ResultSet yap() {
		ResultSet myRs = null;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
			myStat = myConn.createStatement();
			myRs = myStat.executeQuery("select * from doktorlar");

		} catch (Exception e) {  
			e.printStackTrace();
		}
		return myRs;

	}
	
	public static ResultSet yap2() {
		ResultSet myRs = null;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
			myStat = myConn.createStatement();
			myRs = myStat.executeQuery("select * from klinikler");

		} catch (Exception e) { 
			e.printStackTrace();
		}
		return myRs;

	}
	public static ResultSet yap3() {
		ResultSet myRs = null;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
			myStat = myConn.createStatement();
			myRs = myStat.executeQuery("select * from hastalar");

		} catch (Exception e) { 
			e.printStackTrace();
		}
		return myRs;

	}
	public static ResultSet yap4() {
		ResultSet myRs2 = null;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
			myStat = myConn.createStatement();
			myRs2 = myStat.executeQuery("select * from randevular");

		} catch (Exception e) { 
			e.printStackTrace();
		}
		return myRs2;

	}

	public static void ekle(String sql_sorgu) {

		try {
			myStat.executeUpdate(sql_sorgu);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	static ResultSet sorgula(String sql_sorgu) {
		ResultSet myRs = null;		
		try {			
			myRs = myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myRs;
	}
	static ResultSet sorgula1(String sql_sorgu1) {
		ResultSet myRs = null;		
		try {			
			myRs = myStat.executeQuery(sql_sorgu1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myRs;
	}
	static ResultSet sorgula2(String sql_sorgu2) {
		ResultSet myRs = null;		
		try {			
			myRs = myStat.executeQuery(sql_sorgu2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myRs;
	}
	static ResultSet sorgula3(String sql_sorgu3) {
		ResultSet myRs = null;		
		try {			
			myRs = myStat.executeQuery(sql_sorgu3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myRs;
	}
	static void update(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static ResultSet cbox_veri(String sql_sorgu) {
		ResultSet myRs = null;		
		try {			
			myRs = myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myRs;
	}
	public static ResultSet cbox_veri_klinik() {
		ResultSet myRs2 = null;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
			myStat = myConn.createStatement();
			myRs2 = myStat.executeQuery("select * from klinikler");

		} catch (Exception e) { 
			e.printStackTrace();
		}
		return myRs2;

	}
	public static ResultSet cbox_veri_doktor() {
		ResultSet myRs3 = null;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hastane?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
			myStat = myConn.createStatement();
			myRs3 = myStat.executeQuery("select * from doktorlar");

		} catch (Exception e) { 
			e.printStackTrace();
		}
		return myRs3;

	}


}
