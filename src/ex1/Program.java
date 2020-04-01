package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "123456");
			Statement st = con.createStatement();
			String sql = "SELECT * FROM databasetest.member";
			ResultSet rs = st.executeQuery(sql);
			
			rs.next();
			
			@SuppressWarnings("unused")
			String title = rs.getString("username");
			System.out.printf("title: %s\n", title);
			
			rs.close();
			st.close();
			con.close();			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
