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
			throw new BankAccountException(e.getMessage());
		}
		
	}
	
	public void open() throws BankAccountException {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:ORCL","DEMO","oracle");
			con.setAutoCommit(false);
		}
		catch(SQLException e) {
			throw new BankAccountException("Could not open connection");
		}
	}
	
	public void close() throws BankAccountException {
		
		try {
			con.close();
		}
		catch(SQLException e) {
			throw new BankAccountException(e.getMessage());
		}
	}
	
	public Connection getConnection() {
		return con;
	}
}
