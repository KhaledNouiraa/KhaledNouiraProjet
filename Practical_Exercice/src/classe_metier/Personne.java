package classe_metier;

public class Personne {

	private String nom;
	private String prenom ;
	 


	Personne (String nom,String prenom  ){
		
	
		this.nom=nom;
		this.prenom=prenom;
	}
	
//

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String toString() {
		return "le nom : "+getNom()+" , le prenom : "+getPrenom()+" ";
	}
	void afficherPersonne() {
		System.out.println(toString());
	}
}
