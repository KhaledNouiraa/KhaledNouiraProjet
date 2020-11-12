package classe_metier;
import java.sql.ResultSet;
import dataBase.Connexion;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;



public class Administrateur extends Personne {
	static Vector<Utilisateur> tabUser = new Vector<Utilisateur>(); 
	static Vector<Livre> tabProduit = new Vector<Livre>(); 
	
	Administrateur(String nom, String prenom) {
		super(nom, prenom);
		
	} //

	public void ajouterUser (Utilisateur user ) throws ClassNotFoundException, SQLException {
		
        int a=Connexion.executerRequeteMiseAJour("insert into user(first_name,last_name ,username ,password) values('"+user.getNom()+"','"+user.getPrenom()+"','"+user.getPassword()+"','"+user.getUsername()+"')");
        if(a!=0)
     	   System.out.println("Ajout Effectue !");
        else 
     	   System.out.println("echec !");
	}
	
	public void modifierUser (int id ,String nom ,String prenom ) throws ClassNotFoundException, SQLException {
		
        int a =Connexion.executerRequeteMiseAJour("update user set first_name ='"+nom+"', last_name= '"+prenom+"' where id_user ='"+id+"'");
        if(a!=0)
     	   System.out.println("update Effectue !");
        else 
     	   System.out.println("echec !");


	}
		

	public void supprimerUser(int id) throws ClassNotFoundException, SQLException {
	
       int a =Connexion.executerRequeteMiseAJour("Delete From user where id_user = '"+id+"'");
       
       if(a!=0)
    	   System.out.println("Suppression Effectue !");
       else 
    	   System.out.println("echec !");
	}
	
	public void ajouterLivre (Livre l) throws ClassNotFoundException, SQLException {
		
       int a= Connexion.executerRequeteMiseAJour("insert into book(title_book,author_book ,price_book,releaseDate_book ,quantity) values('"+l.getTitle()+"','"+l.getAuteur()+"','"+l.getPrix()+"','"+l.getDate()+"','"+l.getQuantite_stock()+"')");
       if(a!=0)
    	   System.out.println("Ajout Effectue !");
       else 
    	   System.out.println("echec !");
	}
		
	
    public void modifierLivre(int id ,String title ,String auteur ,Date date, double price , int quantite) throws ClassNotFoundException, SQLException {
        	
        int a=Connexion.executerRequeteMiseAJour("update book set title_book ='"+title+"', author_book= '"+auteur+"'"
            		+ " ,price_book ='"+price+"', releaseDate_book = '"+date+"', quantity = '"+quantite+"' where id_book ='"+id+"'");
            	    if(a!=0)
            	    	   System.out.println("update Effectue !");
            	       else 
            	    	   System.out.println("echec !");
				
    }
        		

        
    void supprimerLivre(int id ) throws ClassNotFoundException, SQLException {
    		
            int a=Connexion.executerRequeteMiseAJour("Delete From book where id_book = '"+id+"'");
            if(a!=0)
         	   System.out.println("Suppression Effectue !");
            else 
         	   System.out.println("echec !");
    }
    	
    
    void afficherAdmin() {
    		afficherPersonne();
    }
    
    
    void ConsulterUtilisateurs() throws ClassNotFoundException, SQLException {
    	
    		ResultSet rs =Connexion.executerRequeteConsultation("select * from user");
    		while(rs.next()) {
    		tabUser.add(new Utilisateur(rs.getString(2), rs.getString(3),rs.getString(5),rs.getString(4)));
    		System.out.println("l ID Utilisateur : "+rs.getInt(1));
    		tabUser.lastElement().afficherUtilisateur();
    		}
    		
    		
    		
    		
    	}
    	 
    void ConsulterLivre() throws ClassNotFoundException, SQLException {
    	    	
     		ResultSet rs =Connexion.executerRequeteConsultation("select * from book");
     		while(rs.next()) {
     		tabProduit.add(new Livre(rs.getDouble(4), rs.getString(2),rs.getString(3),rs.getDate(5),rs.getInt(6)));
     		System.out.println("l ID Livre : "+rs.getInt(1));
     		tabProduit.lastElement().afficherLivre();
     		}
     		
     	
     			
     		
    	 }
    	 
     void afficherUtilisateurByID(int id) throws ClassNotFoundException, SQLException {
    		 
    		
        	ResultSet rs =Connexion.executerRequeteConsultation("select * from user where id_user = '"+id+"' ");
        	while(rs.next()) {
        	tabUser.add(new Utilisateur(rs.getString(2), rs.getString(3),rs.getString(5),rs.getString(4)));
        	}

        	tabUser.lastElement().afficherUtilisateur();
        		
    	 }
    

     		
     		
 	 }
    	

