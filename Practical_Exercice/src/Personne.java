
public class Personne {
	private int id ;
	private String nom;
	private String prenom ;
	 


	Personne (String nom,String prenom , int id ){
		
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return "le nom : "+getNom()+" , le prenom : "+getPrenom()+" ,ID : "+id +"\n";
	}
	void afficherPersonne() {
		System.out.println(toString());
	}
}
