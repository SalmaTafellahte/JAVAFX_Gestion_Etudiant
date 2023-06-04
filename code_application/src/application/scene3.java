//scene3:vue
package application;
	
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.control.*; 
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
public class scene3  {
	public void show(Stage Stage3) {
        	try {
        		
        		//creation scene3 et layout
    			VBox root3 = new VBox(10);
    			root3.getStyleClass().add("root3");
    			Scene scene3 = new Scene(root3,700,700);
    			Stage3.setScene(scene3);
    			//creation des champs de recherche de l'etudiant
    			TextField nomText = new TextField();
    			nomText.getStyleClass().add("nomText");
    			nomText.setMaxWidth(500);
    			TextField MassarText = new TextField();
    			MassarText.getStyleClass().add("MassarText");
    			MassarText.setMaxWidth(500);
    			Button btn_chercher = new Button();
    			btn_chercher.getStyleClass().add("btn_chercher");
    			btn_chercher.setText("chercher");
    			Label lblB_nom = new Label();
    			lblB_nom .getStyleClass().add("lblB_nom");
    			lblB_nom .setText("nom de l'etudiant:");
    			Label lblB_Code = new Label();
    			lblB_Code .getStyleClass().add("lblB_Code");
    			lblB_Code .setText("Code Massar:");
    			Label resultLabel = new Label();
    			//evenement:si le choix de l'etudiant n'existe pas dans la base de donnée
    	     	btn_chercher.setOnAction(e -> {
    	            String nom = nomText.getText();
    	            String CodeMassar =  MassarText.getText();
    	            // Établir la connexion à la base de données en utilisant la classe base_de_donnee
    	            Connection connection;
					try {
						connection = base_de_donnee.getConnection();
					     // Créer un objet Statement
	    	            Statement statement = connection.createStatement();
	    	            // Exécuter la requête SQL pour récupérer les données
	    	            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
	    	            //verification d'egalite
	    	            boolean found = false;
	    	            while (resultSet.next()) {
	    	                String nomEtudiant = resultSet.getString("nom");
	    	                String codeMassarEtudiant = resultSet.getString("codeMassar");
	    	                if (nom.equals(nomEtudiant) && CodeMassar.equals(codeMassarEtudiant)) {
	    	                    found = true;
	    	                    break;
	    	                }
	    	            }
	    	            if (found) {
	    	                resultLabel.setText("Authentication successful");
	    	                resultLabel.setTextFill(Color.GREEN);
	    	             // Récupérez les informations spécifiques de l'étudiant à partir de la base de données
	    	                int id = resultSet.getInt("id");
	    	                String nom1 = resultSet.getString("nom");
	    	                String prenom = resultSet.getString("prenom");
	    	                int age = resultSet.getInt("age");
	    	                int anneeScolaire = resultSet.getInt("anneeScolaire");
	    	                String codeMassar = resultSet.getString("codeMassar");
	    	                String niveau = resultSet.getString("niveau");
	    	                // Créez un objet student correspondant aux informations récupérées
	    	                Model etudiant = new Model(id, nom1, prenom, age, anneeScolaire, codeMassar, niveau);
	    	             // Créez une instance de la classe ProfilEtudiant
	    	                scene4 profilEtudiant = new scene4(etudiant);
	    	                
	    	                // Appelez la méthode show() pour afficher la scène du profil de l'étudiant
	    	                profilEtudiant.start(Stage3);
	    	            } else {
	    	                resultLabel.setText("Authentication failed");
	    	                resultLabel.setTextFill(Color.RED);
	    	            }

	    	            // Fermer les ressources
	    	            resultSet.close();
	    	            statement.close();
	    	            connection.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
    	       });
    	
    			//position des differents conposonts de la scene3
    			root3.getChildren().addAll( lblB_nom ,nomText,lblB_Code ,MassarText, btn_chercher,resultLabel);
    		    scene3.getStylesheets().add(getClass().getResource("style_scene3.css").toExternalForm());
			   Stage3.setScene(scene3);
            Stage3.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		 
	}
   

}


