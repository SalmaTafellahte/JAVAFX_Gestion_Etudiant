//code de la scene1:vue
package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) {
    	 try {
	            BorderPane root = new BorderPane();

	            // Créez le bouton
	            Button button = new Button("liste des etudiants");
	            Button button1 = new Button("profil etudiant");
	            
	            // Créez le conteneur du header
	            Label l1 = new Label("Ecole Nationale des sciences appliquées");
	           l1.getStyleClass().add("l1");
	            HBox header = new HBox(3);
	            header.getStyleClass().add("header");
	            header.setAlignment(Pos.CENTER_RIGHT);

	            // Créez un espace flexible à gauche du bouton
	            Region spacer = new Region();
	            HBox.setHgrow(spacer, Priority.ALWAYS);

	            // Ajoutez les éléments au conteneur du header
	            header.getChildren().addAll(l1,spacer, button,button1);

	            // Ajoutez le conteneur du header au haut du BorderPane
	            root.setTop(header);

	            Label welcomeLabel = new Label("Bienvenue dans notre Application ");
	            Label welcomeLabel2 = new Label(" de ");
	            Label welcomeLabel3 = new Label(" Gestion de scolarité ");
	            //message d'acceuil
	            welcomeLabel.getStyleClass().add("welcome-label");
	            welcomeLabel2.getStyleClass().add("welcome-label2");
	            welcomeLabel3.getStyleClass().add("welcome-label3");
	            // Créer le conteneur VBox pour centrer le label
	            VBox centerBox = new VBox(welcomeLabel, welcomeLabel2,welcomeLabel3);
	            centerBox.setAlignment(Pos.CENTER);

	            // Ajouter le conteneur VBox au centre du BorderPane
	            root.setCenter(centerBox);
	          //passer a l'autre scene
	            button.setOnAction (event -> {
	            	Scene2 main = new Scene2();
	                main.show(primaryStage);
	            });
	            button1.setOnAction (event -> {
	            	scene3 scene = new scene3();
	                scene.show(primaryStage);
	            });
	            Scene scene = new Scene(root, 700, 700);
	            scene.getStylesheets().add(getClass().getResource("style_scene1.css").toExternalForm());
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
        
  

    public static void main(String[] args) {
        launch(args);
    }
} 