package dataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	public static Connection c = null;
	
	public Connexion() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/buildstore(1)", "root", "");
		
	}
	  
	public static int executerRequeteMiseAJour(String requete) throws SQLException, ClassNotFoundException {
		
		PreparedStatement stmt = c.prepareStatement(requete);
		return stmt.executeUpdate();
		
		
	}
	public static ResultSet executerRequeteConsultation(String requete) throws SQLException {
		PreparedStatement stmt = c.prepareStatement(requete);
		return stmt.executeQuery();
	}

}