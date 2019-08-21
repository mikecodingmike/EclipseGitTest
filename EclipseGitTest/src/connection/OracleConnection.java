package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import domain.BankAccountException;

public class OracleConnection {

	private Connection con;
	
	public OracleConnection() throws BankAccountException{
		
		try {
			//JDBC driver is imported here after adding to build paths
			Class.forName("oracle.jdbc.OracleDriver");
		}
		catch(ClassNotFoundException e) {
			throw new BankAccountException("Could not find Database driver!");
		}
		
	}
	
	public void open() throws BankAccountException {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL", "DEMO", "oracle");
			con.setAutoCommit(false);
		}
		catch(SQLException e) {
			throw new BankAccountException("Could not open database connection!");
		}
	}
	
	public void close() throws BankAccountException {
		
		try {
			con.close();
		}
		catch(SQLException e) {
			throw new BankAccountException("Could not close the database connection");
		}
	}
	
	public Connection getConnection() {
		return con;
	}
}
