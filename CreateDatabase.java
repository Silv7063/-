import java.sql.*;

public class CreateDatabase {
    public static final String URL = "jdbc:mysql://localhost:3306/ntoujava2024?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "ntoujava2024";

	public static void main(String[] args) {
		Connection con = null; 
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  	System.setProperty("jdbc.drivers", "com.mysql.cj.jdbc.Driver");
			System.out.println("00");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("11");

			stmt = con.createStatement();
			
			



		} catch (ClassNotFoundException ce) { 
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			if (stmt != null) { 
				try {
					stmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if (con != null) { 
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}
}
