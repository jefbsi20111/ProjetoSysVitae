package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jeferson
 *
 */
public class ConnectionFactory {
	Connection connection = null;
	public Connection getConnection() throws ClassNotFoundException {
		String driverName = "org.gjt.mm.mysql.Driver"; // MySQL MM JDBC driver  
		Class.forName(driverName);  
	     try {
	         connection = DriverManager.getConnection("jdbc:mysql://localhost/ProjetoSysVitae","root","");
	     } catch (SQLException e) {
	    	 System.out.println("Não foi possível conectar ao Banco de Dados"+e.getMessage());  
	         throw new RuntimeException(e);
	     }
	     return connection;
	 }
}