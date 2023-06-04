package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class base_de_donnee {
	   private static final String url = "jdbc:mysql://localhost/javafx";
	    private  static final String username = "root";
	    private static final String  password="";
	    public static Connection getConnection() throws SQLException{
	    
	            return DriverManager.getConnection(url, username, password);
	         
	}}
