import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int nb_Session=0; // le nbr des Session 
		int nb_Session_produit =0; // le nbr de Session pour creer les produit
		 int nb_Session_Ligne =0; //le nbr de Session pour creer les ligne de Commande
		Scanner user =new Scanner(System.in);
		System.out.println("Donner l' ID de l'Administrateur");
		int id_A= user.nextInt();
		System.out.println("Creer un Aminstrateur"); // on a crée un Seul administrateur
		System.out.println("Donner le nom de l'Administrateur \n");
		String nomA=user.next();
		System.out.println("Donner le prenom de l'Administrateur ");
		String prenomA =user.next();
		Administrateur admin = new Administrateur(nomA, prenomA, id_A);
		admin.afficherAdmin();
		System.out.println("la creation est effectuée \n");

			System.out.println("Creer un Utilisateur");
			System.out.println("Donner le nom de  Utilisateur");
			String nomC=user.next();
			System.out.println("Donner le prenom de Utilisateur ");
			String prenomC =user.next();
			System.out.println("Donner l' ID de  Utilisateur");
			int id_C= user.nextInt();
			Utilisateur client =new Utilisateur(nomC, prenomC, id_C); // on va utiliser un seul Client
			Commande c= new Commande(1); // une seul Commande pour un utilisateur
			client.afficherUtilisateur();
			System.out.println("la creation est effectuée \n");
			admin.ajouterUser(client);
			admin.afficherUtilisateurs();
	
			admin.tabUser.lastElement().afficherUtilisateur();
			
			System.out.println("la creation est effectuée \n");
			System.out.println("Deconnecté");
			while(nb_Session<2) {// 2 Session 1ere pour un Adminstrateur et 2eme  pour un Utilisateur 
		System.out.println("Connecter en tantque Administrateur -1- || Utilisateur -0-");	  
		int choix=user.nextInt(); // il faut Connecter au Session Administrateur pour creer les produits (Choix 1 au 1er Session)
		if(choix ==1) { 
			while(nb_Session_produit<2) {
				System.out.println("2:Ajouter Produit || 3: Deconnecté");
				int menu_1= user.nextInt();
				if(menu_1==2) {
				System.out.println("Creer un Produit \n");
				System.out.println("Donner le  Titre de Produit \n");
				String titre_produit=user.next();	
				System.out.println("Donner la Categorie de Produit \n");
				String categorie_produit=user.next();
				System.out.println("Donner l ID de Produit \n");
				int id_Produit=user.nextInt();
				System.out.println("Donner le Prix de Produit \n");
				int prix_Produit=user.nextInt();
				
				admin.ajouterProduit( new Produit(id_Produit,prix_Produit,titre_produit, categorie_produit, new Date()));
				
				} //
				else if (menu_1==3) {
					System.out.println("Deconnecté");
					System.exit(0);
				}
				nb_Session_produit++;
			}
			
		
				System.out.println("la liste de produits");
			admin.afficherProduit();
			
		
			
		}
		else if(choix==0) {
			System.out.println(" --Session Utilisateur--" );
			System.out.println("Donner l 'ID de Utilisateur");
			int id_user=user.nextInt();
			for(int i=0 ;i<admin.tabUser.size();i++) {
				if(Administrateur.tabUser.elementAt(i).getId()==id_user) {
					 
				while(nb_Session_Ligne <2) {
					System.out.println("2:Ajouter Ligne || 3: Deconnecté");
					int menu_2= user.nextInt();	
				if(menu_2==2) {
					System.out.println("Choisir le Produit par ID");
					int id_produit= user.nextInt();
					System.out.println("Choisir la Quantite");
					int qtq= user.nextInt();
					
					for(int j=0 ;j<admin.tabProduit.size();j++) {
						
					if(admin.tabProduit.elementAt(j).getId_Produit()==id_produit) {
					 
						admin.tabUser.elementAt(i).ajouterLigne(new Ligne_Commande(admin.tabProduit.elementAt(j),c, 1, qtq, new Date()));
						admin.tabUser.elementAt(i).ajouterCommande(c);
						System.out.println("la liste de Commande pour un seul Utilisatur "+Administrateur.tabUser.elementAt(i));
						admin.tabUser.elementAt(i).consulterCommandes();
					}
					}
				}
				else if(menu_2==3) {
					System.out.println("Deconnecté");
					System.exit(0);
				}
				nb_Session_Ligne++; }
					
					
				}
		
		}
			
	
		}
		nb_Session++;
		}
	
	
	
	

	}

}
