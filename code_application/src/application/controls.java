package application;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.scene.control.*;
public class controls {
	//fonction pour boutton insertion
	public void insertion(TableView<Model> table,TextField T1,TextField T2,TextField T3,TextField T4,TextField T5,TextField T6,TextField T7) {
	try {
	    // Établir la connexion à la base de données en utilisant la classe base_de_donnee
	    Connection connection = base_de_donnee.getConnection();
	    // Créer un objet Statement
	    Statement statement = connection.createStatement();
	    
	    // Récupérer les valeurs des champs de texte
	    int id = Integer.parseInt(T1.getText());
	    String nom = T2.getText();
	    String prenom = T3.getText();
	    int age = Integer.parseInt(T4.getText());
	    int anneeScolaire = Integer.parseInt(T5.getText());
	    String codeMassar = T6.getText();
	    String niveau = T7.getText();
	    
	    // Construire la requête d'insertion avec les valeurs récupérées
	    String insertQuery = "INSERT INTO student (id, nom, prenom, age, anneeScolaire, codeMassar, niveau) " +
	            "VALUES (" + id + ", '" + nom + "', '" + prenom + "', " + age + ", " + anneeScolaire + ", '" + codeMassar + "', '" + niveau + "')";
	    
	    // Exécuter la requête SQL d'insertion
	    statement.executeUpdate(insertQuery);

	    // Fermer les ressources
	    statement.close();
	    connection.close();
	    // Ajouter les nouvelles données à la liste et rafraîchir la TableView
	    Model newStudent = new Model(id, nom, prenom, age, anneeScolaire, codeMassar, niveau);
        table.getItems().add(newStudent);
        table.refresh();

        // Effacer les champs de saisie
        T1.clear();
        T2.clear();
        T3.clear();
        T4.clear();
        T5.clear();
        T6.clear();
        T7.clear();
	} catch (SQLException e) {
	    System.out.println("Erreur lors de l'insertion des données dans la base de données.");
	    e.printStackTrace();
	}}
	//fonction pour boutton suppression
	public void suppression(TableView<Model> table){
		    // Récupérer l'élément sélectionné dans la TableView
		Model selectedStudent = table.getSelectionModel().getSelectedItem();
		    
		    if (selectedStudent != null) {
		        try {
		            // Établir la connexion à la base de données en utilisant la classe base_de_donnee
		            Connection connection = base_de_donnee.getConnection();
		            // Créer un objet Statement
		            Statement statement = connection.createStatement();
		            
		            // Récupérer l'ID de l'élève sélectionné
		            int selectedId = selectedStudent.getId();
		            
		            // Construire la requête de suppression avec l'ID sélectionné
		            String deleteQuery = "DELETE FROM student WHERE id = " + selectedId;
		            
		            // Exécuter la requête SQL de suppression
		            statement.executeUpdate(deleteQuery);
		            
		            // Fermer les ressources
		            statement.close();
		            connection.close();
		            
		            // Supprimer l'élément de la TableView
		            table.getItems().remove(selectedStudent);
		        } catch (SQLException e) {
		            System.out.println("Erreur lors de la suppression des données dans la base de données.");
		            e.printStackTrace();
		        }
		    }
		}
	//fonction pour boutton update
	public void modification(TableView<Model> table,TextField T1,TextField T2,TextField T3,TextField T4,TextField T5,TextField T6,TextField T7) {	 
		    // Récupérer l'élément sélectionné dans la TableView
		Model selectedStudent = table.getSelectionModel().getSelectedItem();
		    
		    if (selectedStudent != null) {
		        try {
		            // Établir la connexion à la base de données en utilisant la classe base_de_donnee
		            Connection connection = base_de_donnee.getConnection();
		            // Créer un objet Statement
		            Statement statement = connection.createStatement();
		            
		            // Récupérer les nouvelles valeurs des champs de saisie
		            int id = Integer.parseInt(T1.getText());
		            String nom = T2.getText();
		            String prenom = T3.getText();
		            int age = Integer.parseInt(T4.getText());
		            int anneeScolaire = Integer.parseInt(T5.getText());
		            String codeMassar = T6.getText();
		            String niveau = T7.getText();
		            
		            // Construire la requête de modification avec les nouvelles valeurs
		            String updateQuery = "UPDATE student SET id = " + id + ", nom = '" + nom + "', prenom = '" + prenom + "', age = " + age + ", anneeScolaire = " + anneeScolaire + ", codeMassar = '" + codeMassar + "', niveau = '" + niveau + "' WHERE id = " + selectedStudent.getId();
		            
		            // Exécuter la requête SQL de modification
		            statement.executeUpdate(updateQuery);
		            
		            // Mettre à jour les valeurs de l'élément sélectionné dans la TableView
		            selectedStudent.setId(id);
		            selectedStudent.setNom(nom);
		            selectedStudent.setPrenom(prenom);
		            selectedStudent.setAge(age);
		            selectedStudent.setAnneeScolaire(anneeScolaire);
		            selectedStudent.setCodeMassar(codeMassar);
		            selectedStudent.setNiveau(niveau);
		            
		            // Rafraîchir la TableView
		            table.refresh();
		            
		            // Fermer les ressources
		            statement.close();
		            connection.close();
		        } catch (SQLException e) {
		            System.out.println("Erreur lors de la modification des données dans la base de données.");
		            e.printStackTrace();
		        }
		    }
	 

	}

	}
        
  
