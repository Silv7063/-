import java.sql.*;
import java.util.Scanner;

public class loginSystem{
	static Scanner s = new Scanner(System.in);

	public static String input(){
		String input = s.nextLine();
		return input;
	}

	public static String getUsername(){
        System.out.print("Enter username:");
        return input();
	}

	public static String getPassword(){
        System.out.print("Enter password:");
		return input();
	}

	public static void main(String arge[]) {
		String URL = "jdbc:mysql://localhost:3306/ntoujava2024?serverTimezone=Asia/Taipei";
		String USER = "root";
		String PASSWORD = "ntoujava2024";
		Connection con = null; 
		Statement stmt = null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  	System.setProperty("jdbc.drivers", "com.mysql.cj.jdbc.Driver");
			System.out.println("00");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("11");

			String inputUsername = getUsername();
			String inputPassword = getPassword();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT username, password FROM datasystem");
			boolean k=false;
			while(rs.next()){
				String dataUsername = rs.getString("username");
				String dataPassword = rs.getString("password");
				if (dataUsername.equals(inputUsername)){
					if (dataPassword.equals(inputPassword)){
						System.out.printf("Login success");
						k=true;
						break;
					}else{
						System.out.printf("Wrong password");
					}
				}
			}
			if (!k) System.out.printf("user do not exist");

			
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
		s.close();

	}


}
