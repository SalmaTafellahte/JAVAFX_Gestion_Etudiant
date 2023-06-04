//Models:classe bean
package application;

import java.sql.Date;

public class Model {
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private int anneeScolaire;
    private String codeMassar;
    private String niveau;
   public Model(int id,String nom, String prenom, int age, int anneeScolaire, String codeMassar, String niveau) {
        this.id=id;
	    this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.anneeScolaire = anneeScolaire;
        this.codeMassar = codeMassar;
        this.niveau = niveau;
    }
   public Model(String nom, String prenom, int age, int anneeScolaire, String codeMassar, String niveau) {
      
	    this.nom = nom;
       this.prenom = prenom;
       this.age = age;
       this.anneeScolaire = anneeScolaire;
       this.codeMassar = codeMassar;
       this.niveau = niveau;
   }

public  void setId(int Id){
   	this.id=Id;
      }	
  public  int getId(){
   	return this.id;
   }	
  public  void setNom(String nom){
    	this.nom=nom;
    }	
 public  String getNom(){
    	return this.nom;
    }	
     // Getter et Setter pour "prenom"
     public String getPrenom() {
         return prenom;
     }

     public void setPrenom(String prenom) {
         this.prenom = prenom;
     }

     // Getter et Setter pour "age"
     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     // Getter et Setter pour "anneeScolaire"
     public int  getAnneeScolaire() {
         return anneeScolaire;
     }

     public void setAnneeScolaire(int anneeScolaire) {
         this.anneeScolaire = anneeScolaire;
     }

     // Getter et Setter pour "codeMassar"
     public String getCodeMassar() {
         return codeMassar;
     }

     public void setCodeMassar(String codeMassar) {
         this.codeMassar = codeMassar;
     }

     // Getter et Setter pour "niveau"
     public String getNiveau() {
         return niveau;
     }

     public void setNiveau(String niveau) {
         this.niveau = niveau;
     }
 }

    

