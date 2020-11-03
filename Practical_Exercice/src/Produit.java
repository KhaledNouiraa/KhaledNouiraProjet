import java.util.Date;

public class Produit {
	private int id_Produit ;
	private String title ;
	private String Categorie ;
	private Date date_Produit;
	private double prix_unitaire ;


	Produit(int id , double prix ,String title ,String categorie ,Date d){
		this.id_Produit=id ;
		this.Categorie=categorie;
		this.date_Produit= d;
		this.title=title;
		this.prix_unitaire=prix;
	}

	public double getPrix() {
		return prix_unitaire;
	} //

	public void setPrix(double prix) {
		this.prix_unitaire = prix;
	}

	
	public int getId_Produit() {
		return id_Produit;
	}

	public void setId_Produit(int id_Produit) {
		this.id_Produit = id_Produit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategorie() {
		return Categorie;
	}

	public void setCategorie(String categorie) {
		Categorie = categorie;
	}

	public Date getDate_Produit() {
		return date_Produit;
	}

	public void setDate_Produit(Date date_Produit) {
		this.date_Produit = date_Produit;
	}
 public String toString () {
	 return "le titre :"+getTitle()+" ID : "+getId_Produit()+" Categorie: "+getCategorie()+
			 " Prix : "+ getPrix()+" Date : "+getDate_Produit();
 }
	
	void afficherProduit() {
		System.out.println(toString());
	}
}
