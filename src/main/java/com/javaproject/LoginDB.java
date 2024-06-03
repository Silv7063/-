package com.javaproject;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB {
    private Connection con = null; 
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    public int ConnectMysql(String inputUsername, char[] inputPassword)
    {
        try {
                con = DatabaseManager.getConnection();

                // Prevent SQL Injection
                stmt = con.prepareStatement("SELECT username, password FROM datasystem WHERE username = ?");
                stmt.setString(1, inputUsername);
                rs = stmt.executeQuery();
                Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

                if (rs.next()){ // Only Read One Line
                    String dataUsername = rs.getString("username");
                    String dataPassword = rs.getString("password");
                    if (dataUsername.equals(inputUsername)){
                            if (argon2.verify(dataPassword, inputPassword)){
                                argon2.wipeArray(inputPassword);
                                return 1;
                            }else{
                                return 2;
                            }
                    }
                }
                else
                {
                    return 3;
                }
        } catch (SQLException ce) {
                ce.printStackTrace();
        } finally {
                if (rs != null) { 
                        try {
                                rs.close();
                        } catch (SQLException se) {
                                se.printStackTrace();
                        }
                }
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
        return 0;
    }
}
