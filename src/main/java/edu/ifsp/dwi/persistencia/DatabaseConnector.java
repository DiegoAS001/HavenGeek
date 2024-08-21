package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	
	 	private static final String JDBC_URL = "jdbc:h2:~/HavenGeek"; 
	    private static final String USER = "sa";
	    private static final String PASSWORD = "";

	    static {
	    	try {
				Class.forName("org.h2.Driver");	
			} catch (ClassNotFoundException ex) {
				throw new RuntimeException(ex);
			}
	    }
	    
	    public static Connection connect() {
	        Connection connection = null;
	        try {
	            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	            System.out.println("Conexão estabelecida com sucesso!");
	        } catch (SQLException e) {
	            System.out.println("Erro ao conectar ao banco de dados");
	            e.printStackTrace();
	        }
	        return connection;
	    }

}