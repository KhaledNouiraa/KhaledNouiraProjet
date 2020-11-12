package classe_metier;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Vector;

import dataBase.Connexion;

public class Commande {
	private int id_commande=0 ;
	static int compteur_ligne =0 ;
	private Date d ;
	private  int id_user ;
	Vector<Ligne_Commande > tabCommande; 
	Connexion conn ;
	Commande ( int id_commande ,Date d , int id_user) {
		this.d = d ;
		this.id_commande=id_commande;
		this.id_user= id_user;
		tabCommande=new Vector<Ligne_Commande>();
	
		}
	
	
	public Date getD() {
		return d;
	}
		
	public void setD(Date d) {
		this.d = d;
	}
	
	public int getId_user() {
		return id_user;
	}
	
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_commande() {
		return id_commande;
	}
	
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	
	public Vector<Ligne_Commande> getTabCommande() {
		return tabCommande;
	}
	
	public void setTabCommande(Vector<Ligne_Commande> tabCommande) {
		this.tabCommande = tabCommande;
	}
	void ajouterLigne_collection(Ligne_Commande l) throws ClassNotFoundException, SQLException {
			if(l.calculate_Commande()>0) {
			tabCommande.add(l);
		
	        System.out.print(Connexion.executerRequeteMiseAJour("insert into order_lines(price,quantity ,id_order,id_book )"
	        		+ " values('"+l.calculate_Commande()+"','"+l.getQuantite_commande()+"','"+this.id_commande+"','"+l.getId_livre()+"')"));
			System.out.println(" Ligne est effectuee");
			}
			else 
				System.out.println("le Livre est indisponible ");
		
		}


	void modifier_ligne_Quantite(int id_line ,int quantite ) throws ClassNotFoundException, SQLException {
		double prix =0 ;
		int quantity_line=0;
		int id_book=0;
		ResultSet rs =Connexion.executerRequeteConsultation("select order_lines.quantity  as quantity_line ,order_lines.id_book as book_id, book.price_book as book_price ,book.id_book ,order_lines.id_line  from book ,order_lines where id_line ='"+id_line+"' and order_lines.id_book=book.id_book ");
		while(rs.next()) {
			prix = rs.getDouble("book_price");
			quantity_line=rs.getInt("quantity_line");
			id_book=rs.getInt("id_book");
		}
  		
				if (quantity_line>quantite) {
		Connexion.executerRequeteMiseAJour("update orders set  total_orders= total_orders -'"+(quantity_line-quantite)*prix+"'  where id_orders ='"+this.getId_commande()+"'");
		Connexion.executerRequeteMiseAJour("update order_lines set  quantity= '"+quantite+"' ,price ='"+quantite*prix+"' where id_line ='"+id_line+"'");
		Connexion.executerRequeteMiseAJour("update book set  quantity= quantity + '"+(quantity_line-quantite)+"'  where id_book ='"+id_book+"'");
		System.out.println("Mise a jour Effectue");
				}
				
				else if(quantity_line<quantite) {
		Connexion.executerRequeteMiseAJour("update orders set  total_orders= total_orders +'"+(quantite-quantity_line)*prix+"'  where id_orders ='"+this.getId_commande()+"'");
		Connexion.executerRequeteMiseAJour("update order_lines set  quantity=  quantity +'"+(quantity_line-quantite)+"'  where id_book ='"+id_line+"'");}
		Connexion.executerRequeteMiseAJour("update book set  quantity= quantity - '"+(quantite-quantity_line)+"'  where id_book ='"+id_book+"'");
		System.out.println("Mise a jour Effectue");
	}
	
	
//
	void supprimer_ligne(int id) throws ClassNotFoundException, SQLException {
	
    int a =Connexion.executerRequeteMiseAJour("Delete From order_line where id_line = '"+id+"'");
   
    if(a!=0)
 	   System.out.println("Ajout Effectue !");
    else 
 	   System.out.println("echec !");
	}
	
	double calculate_TotalPrices() throws ClassNotFoundException, SQLException {
		double prix=0;
		ResultSet rs =Connexion.executerRequeteConsultation("select order_lines.price  as price_line  from order_lines where id_order ='"+this.getId_commande()+"' ");
		while(rs.next()) {
			prix = rs.getDouble("price_line")+prix;
		
	}return prix;}
	
		// 
	
	
	
	void afficherTotal() throws ClassNotFoundException, SQLException {
		System.out.println("Le total Generale :"+calculate_TotalPrices());
	}

	void afficherCommande()  {
		System.out.print("ID commande "+this.getId_commande());
		System.out.println(" , Date "+this.getD());
		System.out.println("ID User :" +this.getId_user());
	}
	
	void consulterLignes() throws ClassNotFoundException, SQLException {
		ResultSet rs =Connexion.executerRequeteConsultation("select * from order_lines where id_order ='"+this.getId_commande()+"'");
		while(rs.next()) {
			System.out.println("ID Ligne : "+rs.getInt(1));
		tabCommande.add(new Ligne_Commande(rs.getInt(5), rs.getInt(4),rs.getInt(3)));
		
		tabCommande.lastElement().afficherLigne();
		System.out.println("Prix        :"+ rs.getDouble(2)+"\n");
		}
	}
	}