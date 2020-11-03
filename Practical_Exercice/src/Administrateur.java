import java.util.Date;
import java.util.Vector;

public class Administrateur extends Personne {
	static Vector<Utilisateur> tabUser = new Vector<Utilisateur>(); 
	static Vector<Produit> tabProduit = new Vector<Produit>(); 
	
	Administrateur(String nom, String prenom, int id) {
		super(nom, prenom, id);
		
	}
		void ajouterUser (Utilisateur user ) {
	tabUser.addElement(user);
	
}
		void msodifierUser (int id ,String nom ,String prenom , String mail ,String mot_de_passe ) {
			for(int i=0;i<tabUser.size();i++) {
				if (tabUser.elementAt(i).getId()==id) {
					tabUser.elementAt(i).setNom(prenom);
					tabUser.elementAt(i).setPrenom(nom);
					
				}
				
			}
			
		}
		void supprimerUser(Utilisateur user) {
			tabUser.removeElement(user);
		}
		void ajouterProduit(Produit p) {
			tabProduit.addElement(p);	
		}
	
        void modifierProduit(int id ,String title ,String categorie ,Date date) {
        	for(int i=0;i<tabUser.size();i++) {
				if (tabProduit.elementAt(i).getId_Produit()==id) {
					tabProduit.elementAt(i).setTitle(title);
					tabProduit.elementAt(i).setCategorie(categorie);
					tabProduit.elementAt(i).setDate_Produit(date);
				
				}
				
			}
        		
        }
        
    	void supprimerProduit(Produit p) {
    		tabProduit.removeElement(p);
    	}
    	void afficherAdmin() {
    		afficherPersonne();
    	}
    	
    	void afficherUtilisateurs() {
    		for(int i=0 ; i<tabUser.size();i++) 
    			{System.out.println("Utilisateur N"+i);
    			tabUser.elementAt(i).afficherUtilisateur();	}
    	}
    	void afficherProduit() {
    		for(int i=0 ; i<tabProduit.size();i++) 
    			{System.out.println("Produit N"+i);
    			tabProduit.elementAt(i).afficherProduit();	}
    	}
}
