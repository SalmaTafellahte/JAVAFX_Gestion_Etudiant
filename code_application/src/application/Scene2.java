//scene2:vue
package application;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
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
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



public class Scene2 {
    //deuxieme scene
    private TableView<Model> table = new TableView<>();

    public void show(Stage stage) {
    	 // Créez le bouton
        Button button2 = new Button("retour à la page d'accueil");
        button2.getStyleClass().add("button2");
        Label l1 = new Label("Ecole Nationale des sciences appliquées");
        l1.getStyleClass().add("l1");
    	 // Créez le conteneur du header
        HBox header = new HBox(8);

        // Créez un espace flexible à gauche du bouton
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        // Ajoutez les éléments au conteneur du header
        header.getChildren().addAll(l1,spacer,button2);
        header.getStyleClass().add("header");
        header.setAlignment(Pos.CENTER_RIGHT);
        table.setEditable(true);
        table.setId("myTableView");
        //creation de la table
        TableColumn<Model, Integer> idcol = new TableColumn<>("Id");
        TableColumn<Model, String> nomCol = new TableColumn<>("Nom");
        TableColumn<Model, String> prenomCol = new TableColumn<>("Prénom");
        TableColumn<Model, Integer> ageCol = new TableColumn<>("Age");
        TableColumn<Model, Integer> anneeScolaireCol = new TableColumn<>("Année Scolaire");
        TableColumn<Model, String> codeMassarCol = new TableColumn<>("Code Massar");
        TableColumn<Model, String> niveauCol = new TableColumn<>("Niveau");
        table.getColumns().addAll(idcol, nomCol, prenomCol, ageCol, anneeScolaireCol, codeMassarCol, niveauCol);
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        anneeScolaireCol.setCellValueFactory(new PropertyValueFactory<>("anneeScolaire"));
        codeMassarCol.setCellValueFactory(new PropertyValueFactory<>("codeMassar"));
        niveauCol.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        //connexion base de donnée + remplissage table
        try {
            // Établir la connexion à la base de données en utilisant la classe base_de_donnee
            Connection connection = base_de_donnee.getConnection();
            // Créer un objet Statement
            Statement statement = connection.createStatement();
            // Exécuter la requête SQL pour récupérer les données
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            // Parcourir les résultats de la requête et ajouter les objets Eleve au TableView
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                int age = resultSet.getInt("age");
                int anneeScolaire = resultSet.getInt("anneeScolaire");
                String codeMassar = resultSet.getString("codeMassar");
                String niveau = resultSet.getString("niveau");
                Model eleve = new Model(id, nom, prenom, age, anneeScolaire, codeMassar, niveau);
                table.getItems().add(eleve);
            }
            // Fermer les ressources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //creation des champs
        HBox root1 = new HBox(4);
        HBox root2 = new HBox(7);
        VBox Root0 = new VBox(15);
        Root0.getStyleClass().add("VBox-styling");
        Text text = new Text("Champs de changement ");
        text.getStyleClass().add("text-styling");
        TextField T1 = new TextField("id");
        T1.getStyleClass().add("T1");
        TextField T2 = new TextField("nom");
        T2.getStyleClass().add("T2");
        TextField T3 = new TextField("prenom");
        T3.getStyleClass().add("T3");
        TextField T4 = new TextField("age");
        T4.getStyleClass().add("T4");
        TextField T5 = new TextField("annee Scolaire");
        T5.getStyleClass().add("T5");
        TextField T6 = new TextField("code Massar");
        T6.getStyleClass().add("T6");
        TextField T7 = new TextField("niveau");
        T7.getStyleClass().add("T7");
        root1.getChildren().addAll(T1, T2, T3, T4, T5, T6, T7);
        Button bnt1 = new Button("Insertion");
        bnt1.getStyleClass().add("btn1");
        Button bnt2 = new Button("Modification");
        bnt2.getStyleClass().add("btn2");
        Button bnt3 = new Button("Suppression");
        bnt3.getStyleClass().add("btn3");
        root2.getChildren().addAll(bnt1, bnt2, bnt3);
        root2.getStyleClass().add("root2-styling");
        VBox root = new VBox();
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        Root0.getChildren().addAll(text, root1, root2);
        Root0.getStyleClass().add("Root0-styling");
        //evenement des bouttons
        bnt1.setOnAction(event -> {
            controls modifiaction = new controls();
            modifiaction.insertion(table, T1, T2, T3, T4, T5, T6, T7);
        });
        bnt2.setOnAction(event -> {
        	controls modifiaction = new controls();
            modifiaction.modification(table, T1, T2, T3, T4, T5, T6, T7);
        });
        bnt3.setOnAction(event -> {
        	controls modifiaction = new controls();
            modifiaction.suppression(table);
        });
        button2.setOnAction (event -> {
	            	main main1 = new main();
	                main1.start(stage);
	           
        });
        scene.getStylesheets().add(getClass().getResource("style_scene2.css").toExternalForm());
        root.getChildren().addAll(header,table, Root0);
         
        stage.show();
    }}
    
  