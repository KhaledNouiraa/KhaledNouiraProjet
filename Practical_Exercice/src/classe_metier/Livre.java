package classe_metier;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataBase.Connexion;

public class Livre {

	private String title ;
	private String auteur ;
	private Date date;
	private int quantite_stock ;
	private double prix_unitaire ;
	Connexion conn; 

	Livre( double prix ,String title ,String auteur ,Date d, int quantite){
		
		this.auteur=auteur;
		this.date= d;
		this.title=title;
		this.prix_unitaire=prix;
		this.quantite_stock = quantite ;
	}

	public int getQuantite_stock() {
		return quantite_stock;
	}

	public void setQuantite_stock(int quantite_stock) {
		this.quantite_stock = quantite_stock;
	}

	public double getPrix() {
		return prix_unitaire;
	} //

	public void setPrix(double prix) {
		this.prix_unitaire = prix;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	


	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String toString() {
		return "|le Titre :"+this.getTitle()+"| Auteur : "+this.getAuteur()+"| Prix : "+this.getPrix()
		+"| Date Release : "+this.getDate()+ " | Quantite Disponible : "+this.getQuantite_stock();
	}
	
		void afficherLivre() {
			System.out.println(toString());
			
		}
		static void afficherLivre(int id) throws SQLException {
			 String result = null ;
				ResultSet rs =Connexion.executerRequeteConsultation("select * from book where id_book ='"+id+"'");
				while(rs.next()) {
					result ="le titre :"+rs.getString(2)+" Prix : "+ rs.getDouble(4);
			
		 }
		  System.out.println(result);
		}

}

