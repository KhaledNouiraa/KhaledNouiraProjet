package classe_metier;
import java.sql.SQLException;

import java.util.Scanner;
import java.sql.Date ;

import dataBase.Connexion;

public class Main {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// y compris les lignes de order
		Scanner S = new Scanner(System.in);
		Connexion conn =new Connexion();
		System.out.println("Creer Un Admninistrateur");
		Long time = System.currentTimeMillis();
		Date d =  new Date(time);
		Administrateur a = new Administrateur("khaled", "Nouira");
		Utilisateur user_ = new Utilisateur("Etudiant", "Polytech", "****", "polyUser");
		int Choix_fermer_Session=0;
		while(Choix_fermer_Session!=1){
			System.out.println("Choisir : Fermer :1 ou Reprendre : 2 ");
			Choix_fermer_Session= S.nextInt(); 
		int try_Session_admin =0;
		int id_commande= Commande.GetLastID() +1 ;
		Commande c = new Commande(id_commande,d, user_.GetId());

		
		a.afficherAdmin();
		int choix =0;
		while(choix!=9) { // try_Session_admin est le nb pour tester tous le Menu Admin
			
		System.out.println("*** Menu Administrateur *** ");
		System.out.print("1. Creer User        ");
		System.out.println("2. Creer Livre ");
		System.out.print("3. Display Livres    ");
		System.out.println("4. Modifier Livre   ");
		System.out.print("5. Supprimer  Livre  ");//
		System.out.println("6. Modifier User ");
		System.out.print("7. Supprimer User    "); 
		System.out.println("8. Display Users ");
		System.out.print("9. Deconnexion Admin   ");
		System.out.println("Taper votre choix:");
	 choix =S.nextInt();
		
		
		switch (choix) {
		  case 1: 
			  	System.out.println("Cree un Utilisateur");
				System.out.println("Donner Nom :");
				String nom = S.next();
				System.out.println("Donner Prenom :");
				String prenom = S.next();
				System.out.println("Donner login :");
				String login = S.next();
				System.out.println("Donner Password :");
				String password = S.next();
				Utilisateur U = new Utilisateur(nom,prenom,password,login);
				a.ajouterUser(U);
		    break;
		  case 2:
		    System.out.println("Cree un Livre");
		    System.out.println("Donner Titre :");
			String title = S.next();
			System.out.println("Donner Auteur :");
			String auteur = S.next();
			System.out.println("Donner prix :");
			Double prix = S.nextDouble();
			System.out.println("Donner Quantite :");
			int quantite = S.nextInt();
		    Livre l = new Livre(prix, title, auteur, d, quantite);
		    a.ajouterLivre(l);
		    break;
		  case 3:
		    System.out.println("Display Livres");
		    a.ConsulterLivre();
		    break;
		  case 4:
		    System.out.println("Modifier Livre");
		    System.out.println("Donner ID Livre");
		    int id =S.nextInt();
		    System.out.println("Donner Titre :");
			String title1 = S.next();
			System.out.println("Donner Auteur :");
			String auteur1 = S.next();
			System.out.println("Donner prix :");
			Double prix1 = S.nextDouble();
			System.out.println("Donner Quantite :");
			int quantite1 = S.nextInt();
		    a.modifierLivre(id, title1, auteur1, d, prix1, quantite1);
		    break;
		  case 5:
		    System.out.println("Supprimer un Livre");
		    System.out.println("Donner ID Livre");
		    int id1 =S.nextInt();
		    a.supprimerLivre(id1);
		    break;
		  case 6:
		    System.out.println("Modifier un Utilisateur");
		    System.out.println("Donner ID Utilisateur");
		    int id3 =S.nextInt();
		    System.out.println("Donner Nom :");
			String nom1 = S.next();
			System.out.println("Donner preNom :");
			String prenom1 = S.next();
		    a.modifierUser(id3, nom1, prenom1);
		    break;
		  case 7:
		    System.out.println("Supprimer Utilisateur");
		    System.out.println("Donner ID Utilisateur");
		    int id4 =S.nextInt();
		    a.supprimerUser(id4);
		    break;
		  case 8 :
			   System.out.println("Display Utilisateurs");
			    a.ConsulterUtilisateurs();
			    break;
		  case 9 :
			  System.out.println("Deconnecte !");
			  
			}
		}
		int choix_user =0; // try_Session est le nb pour tester tous le Menu User
		while(choix_user !=9) { 
			System.out.println("*** Menu Utilisateur ***");
			System.out.print("1. Display Livres              ");
			System.out.println("2 .Ajouter ligne"); // Ajouter un ligne au Commande Courante
			System.out.print("3. Display Commandes           "); 
			System.out.println("4. Display lignes "); // Afficher les lignes de Commande Courante
			System.out.print("5. Modifier Quantite Ligne     ");
			System.out.println("6. Supprimer Commande ");
			System.out.print("7. Passer Commande              "); 
			System.out.println("8. Supprimer Ligne "); //Supprimer le ligne d'une Commande Courante
			System.out.print("9. Deconnecter Utilisateur      ");
			System.out.print("Taper votre choix:");
		 choix_user= S.nextInt();
		
	 switch (choix_user) {
	case 1 :
		System.out.println("Display Livres");
		user_.ConsulterLivre();
		break;
	case 2 :
		System.out.println("Ajouter un ligne de Commande");
		 System.out.println("Donner ID Livre");
		    int id_livre  =S.nextInt();
			
			System.out.println("Donner Quantite :");
			int quantity_line= S.nextInt();
	
		Ligne_Commande lg = new Ligne_Commande(id_livre, c.getId_commande(), quantity_line);
		c.ajouterLigne_collection(lg);
		break;
	case 3 :
		System.out.println(" Display tous mes Commandes ");
		user_.consulterCommandes();
		break ;
	case 4 : 
		System.out.println("Display tous les lignes de commande Courant");
		c.consulterLignes();
		break ;
	case 5:
		System.out.println(" Modifier Quantite Ligne de Coumande Courant ");
		System.out.println("Donner ID Ligne");
		int id_line_ = S.nextInt();
		System.out.println("Donner la Nouvelle Quantite");
		int quantity_=S.nextInt();
		c.modifier_ligne_Quantite(id_line_, quantity_);
		break ;
	case 6 :
		System.out.println("Supprimer une Commande");
		System.out.println("Donner ID Commande");
		int id_comm = S.nextInt();
		user_.supprimerCommande(id_comm);
		break ;
	case 7: 
		System.out.println("Passer la Commande ");
		user_.ajouterCommande(c);
		break ;
		
	case 8 : 
		System.out.println("Supprimer un Ligne");
		System.out.println("Donner ID Ligne");
		int id_line_DEl = S.nextInt();
		c.supprimer_ligne(id_line_DEl);
		break ;
	case 9 :
		System.out.println("Deconnexion USer");
	}
	
		}
	}
	}
}
