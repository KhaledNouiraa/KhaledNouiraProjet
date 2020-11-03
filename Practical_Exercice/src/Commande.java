import java.util.Date;
import java.util.Vector;

public class Commande {
	private int id_commande ;
	static int compteur_ligne =0 ;
	Vector<Ligne_Commande> tabCommande; 
	Commande (int id_commande){
		this.id_commande=id_commande ;
		tabCommande=new Vector<Ligne_Commande>();
		
	}
	void ajouter_ligne(Ligne_Commande l) {
	
	tabCommande.addElement(l);
	compteur_ligne+=1;
}

	void modifier_ligne(int id ,int quantite ,Produit p ,Date d) {
		
	for (int i =0 ;i< tabCommande.size();i++)
	{
		if(tabCommande.elementAt(i).getId_Ligne()==id) {
			tabCommande.elementAt(i).setP(p);
			tabCommande.elementAt(i).setDate_commande(d);
			
		}
		
	}
	
}
	void supprimer_ligne(Ligne_Commande l) {
		tabCommande.removeElement(l);
		compteur_ligne-=1;
		
	}
	double calculate_TotalPrices() {
		double sum = 0;
		for(int i=0 ;i<tabCommande.size();i++) {
		
		sum=tabCommande.elementAt(i).calculate_Commande()+sum;
		
	}return sum;}
	
		
	
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
	void afficherTotal() {
		System.out.println("Le total Generale :"+calculate_TotalPrices());
	}
	void AfficherCommande() {
		for(int i = 0;i<tabCommande.size();i++) {
			System.out.println("la Ligne de Commande N "+i);
			tabCommande.elementAt(i).afficherLigne();
			System.out.println("\n");
		}
			afficherTotal();
			
		}
}
