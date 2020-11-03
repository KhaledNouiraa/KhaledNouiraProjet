import java.util.Date;

public class Ligne_Commande {
	private Produit p ;
	Commande c ;
	private int id_Ligne ;

	private int quantite_commande ;
	private Date date_commande;
	Ligne_Commande(Produit p,Commande c,int id_co ,int quantite ,Date date){
		this.p=p;
		this.c=c;
		this.date_commande=date;
		this.quantite_commande=quantite;	
	}
	
	public Produit getP() {
		return p;
	}
	public void setP(Produit p) {
		this.p = p;
	}
	public Commande getC() {
		return c;
	}
	public void setC(Commande c) {
		this.c = c;
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
	}
	public Date getDate_commande() {
		return date_commande;
	}
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	double calculate_Commande() {
		return this.p.getPrix()*this.quantite_commande;
	}
	void afficherLigne() {
		p.afficherProduit();
		System.out.println("la Quantite : "+getQuantite_commande());
		System.out.println("le total : "+calculate_Commande());
	}
	

}
