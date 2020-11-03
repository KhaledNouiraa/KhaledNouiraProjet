import java.util.Date;
import java.util.Vector;

public class Utilisateur extends Personne {
 Vector<Commande> tabCommandes;
 
	

	Utilisateur(String nom, String prenom, int id) {
		super(nom, prenom, id);
	
		tabCommandes=new Vector<Commande>();
	}

	void ajouterLigne(Ligne_Commande l) {
		l.c.ajouter_ligne(l);
		
		
	}
	void modifierLigne(int id ,int quantite ,Produit p ,Date d,Commande c) {
		c.modifier_ligne(id, quantite, p, d);
	} //
	
	void supprimerLigne(Ligne_Commande l) {
		l.c.supprimer_ligne(l);
	}
	void ajouterCommande(Commande c) {
		tabCommandes.addElement(c);
	}
	void supprimerCommande(Commande c) {
		for(int i =0 ; i<tabCommandes.size();i++) {
			if(tabCommandes.elementAt(i)==c)
				tabCommandes.removeElement(tabCommandes.elementAt(i));
		}
	}
	void consulterCommandes() {
		for(int i=0 ;i<tabCommandes.size();i++) {
			tabCommandes.elementAt(i).AfficherCommande();
		}
	}
	void consulterProduit() {
		for(int i=0 ;i<Administrateur.tabProduit.size();i++)
		Administrateur.tabProduit.elementAt(i).afficherProduit();
	}
	void afficherUtilisateur() {
		afficherPersonne();

	}
}
