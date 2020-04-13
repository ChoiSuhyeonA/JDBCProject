package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/databasetest?serverTimezone=UTC";
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "123456");
			Statement st = con.createStatement();
			String sql = "SELECT * FROM databasetest.member";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("username");
				String birth = rs.getString("birth");
				String dept = rs.getString("dept");
				String mail = rs.getString("email");
				System.out.printf("id:  %d, userName: %s, birth: %s, dept: %s, email: %s"
						+ "\n", id, userName, birth, dept, mail);
			}		
			
			rs.close();
			st.close();
			con.close();
			
			/* 실습 2번
			String sql = "INSERT INTO databasetest.member VALUES (7, 'Park', '1999-02-15', 'Art', 'park')";
			st.executeUpdate(sql);
			*/
			
			/* 실습 3번
			String sql = "SELECT * FROM databasetest.member WHERE dept = 'computer'";
			*/
			
			/* 실습 4번: PreparedStatement Example 
			String stSql = "INSERT INTO databasetest.member VALUES (?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(stSql);
			st.setInt(1, 8);
			st.setString(2, "Oh");
			st.setString(3, "1989-03-05");
			st.setString(4, "Art");
			st.setString(5, "oh");
			st.executeUpdate();
			*/		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
