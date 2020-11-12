package classe_metier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import dataBase.Connexion;

public class Utilisateur extends Personne {
 Vector<Commande> tabCommandes;
  private String password ;
  String username ;
	Connexion conn ;

	Utilisateur(String nom, String prenom , String password ,String username) {
		super(nom, prenom);
		this.password =password ;
		this.username =username ;
		tabCommandes=new Vector<Commande>();
	}
	void maconnexion() throws ClassNotFoundException, SQLException {
		conn = new Connexion() ;
	}

	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	void ajouterCommande(Commande c) throws ClassNotFoundException, SQLException {
	
		
        System.out.println(Connexion.executerRequeteMiseAJour("insert into orders(id_orders,id_user ,date_orders,total_orders )"
        		+ " values('"+c.getId_commande()+"','"+c.getId_user()+"','"+c.getD()+"','"+c.calculate_TotalPrices()+"')"));
		
	
	}


	
	void supprimerCommande(int id_commande ) throws ClassNotFoundException, SQLException {
        System.out.println(Connexion.executerRequeteMiseAJour("Delete From orders where id_orders = '"+id_commande+"'"));
        System.out.println(Connexion.executerRequeteMiseAJour("Delete From order_lines where id_order = '"+id_commande+"'"));
	}
	
	
	int GetId() throws SQLException {
		int id =0;
	
		ResultSet rs =Connexion.executerRequeteConsultation("select * from user where username ='"+this.username+"'");
  		while(rs.next()) {
  			id=rs.getInt(1);
		
	}
  		return id;
	}
	
	
	void consulterCommandes() throws SQLException {
		
		ResultSet rs =Connexion.executerRequeteConsultation("select * from orders where id_user ='"+this.GetId()+"'");
  		while(rs.next()) {
  		tabCommandes.add(new Commande(rs.getInt(1),rs.getDate(3), rs.getInt(2)));
  		tabCommandes.lastElement().afficherCommande();
  		System.out.println("le Total :"+rs.getDouble(4));
  		}
	}
	
	
	 void ConsulterLivre() throws ClassNotFoundException, SQLException {
	    	
  		ResultSet rs =Connexion.executerRequeteConsultation("select * from book");
  		while(rs.next()) {
  		Administrateur.tabProduit.add(new Livre(rs.getDouble(4), rs.getString(2),rs.getString(3),rs.getDate(5),rs.getInt(6)));
  		System.out.println("ID Livre : "+rs.getInt(1));
  		Administrateur.tabProduit.lastElement().afficherLivre();
  			}
  		
  		}
 	 
	 
	 void afficherUtilisateur() {
		afficherPersonne();
		System.out.println("username : "+getUsername()+" le password : "+ getPassword()+"\n");

	}
	
}
