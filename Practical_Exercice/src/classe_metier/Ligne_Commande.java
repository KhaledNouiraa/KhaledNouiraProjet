package classe_metier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import dataBase.Connexion;

public class Ligne_Commande {
	int id_livre;
	int id_commande;
	private int id_Ligne ;
	Connexion conn ;
	private int quantite_commande ;
	private Date date_commande;
	
	Ligne_Commande(int id_livre,int id_commande ,int quantite ){
		this.id_livre=id_livre;
		this.id_commande=id_commande ;

		this.quantite_commande=quantite;	
	}
	void maconnexion() throws ClassNotFoundException, SQLException {
		conn  = new Connexion();
	}
	
	public int getId_livre() {
		return id_livre;
	}


	public void setId_livre(int id_livre) {
		this.id_livre = id_livre;
	}


	public int getId_commande() {
		return id_commande;
	}


	public int getId_Ligne() {
		return id_Ligne;
	}
	public void setId_commande(int id_commande) {
		this.id_Ligne = id_commande;
	}
	public int getQuantite_commande() {
		return quantite_commande;
	}
	public void setQuantite_commande(int quantite_commande) {
		this.quantite_commande = quantite_commande;
	} //
	public Date getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	double calculate_Commande() throws ClassNotFoundException, SQLException {
		int quantity_choix =0;
		double prix=0 ;
	
		ResultSet rs =Connexion.executerRequeteConsultation("select * from book where id_book ='"+this.id_livre+"'");
		while(rs.next()) {
		 prix= rs.getDouble(4);
		 quantity_choix =rs.getInt(6);
		
		}
		if(quantity_choix>=this.getQuantite_commande())
		{ Connexion.executerRequeteMiseAJour("update book set quantity = quantity - '"+this.quantite_commande+"' where id_book ='"+this.id_livre+"'");
		return prix*this.getQuantite_commande();}
		else 
			return 0;
	}
	
	void afficherLigne() throws SQLException, ClassNotFoundException {
		
		System.out.println("ID livre    :"+this.getId_livre());
		System.out.println("ID Commande :"+ this.getId_commande());
		System.out.println("Quantite    :" +this.getQuantite_commande());
		
		
		}
	
	}
	


