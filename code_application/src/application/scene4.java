//scene4:vue
package application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.io.File;
import java.io.IOException;

public class scene4 extends Application {
    private Model etudiant;
    private GridPane gridPane;

    public scene4(Model  etudiant) {
        this.etudiant = etudiant;
        this.gridPane = new GridPane();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
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
        // Créer et ajouter des labels et des champs de texte pour chaque information de l'étudiant
        Label nomLabel = new Label("Nom:");
        Text nomText = new Text(etudiant.getNom());
        nomText.getStyleClass().add("text2");
        Label prenomLabel = new Label("Prénom:");
        Text prenomText = new Text(etudiant.getPrenom());
        prenomText.getStyleClass().add("text2");
        Label ageLabel = new Label("Âge:");
        Text ageText = new Text(String.valueOf(etudiant.getAge()));
        ageText.getStyleClass().add("text2");
        Label anneeScolaireLabel = new Label("Année scolaire:");
        Text anneeScolaireText = new Text(String.valueOf(etudiant.getAnneeScolaire()));
        anneeScolaireText.getStyleClass().add("text2");
        Label codeMassarLabel = new Label("Code Massar:");
        Text codeMassarText = new Text(etudiant.getCodeMassar());
        codeMassarText.getStyleClass().add("text2");
        Label niveauLabel = new Label("Niveau:");
        Text niveauText = new Text(etudiant.getNiveau());
        niveauText.getStyleClass().add("text2");

        // Positionner les labels et les champs de texte dans le GridPane
        
        gridPane.add(nomLabel, 0, 0);
        gridPane.add(nomText, 1, 0);

        gridPane.add(prenomLabel, 0, 1);
        gridPane.add(prenomText, 1, 1);

        gridPane.add(ageLabel, 0, 2);
        gridPane.add(ageText, 1, 2);

        gridPane.add(anneeScolaireLabel, 0, 3);
        gridPane.add(anneeScolaireText, 1, 3);

        gridPane.add(codeMassarLabel, 0, 4);
        gridPane.add(codeMassarText, 1, 4);

        gridPane.add(niveauLabel, 0, 5);
        gridPane.add(niveauText, 1, 5);
  
        // Créer un bouton pour générer le PDF
        Button downloadButton = new Button("Télécharger le profil en PDF");
        gridPane.add(downloadButton, 1, 6);
        downloadButton.getStyleClass().add("downloadButton");

        // Définir les marges et l'espacement du GridPane
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
     
        // Centrer le GridPane horizontalement et verticalement dans la fenêtre
        gridPane.setAlignment(Pos.CENTER);

        // Gérer l'action du bouton de téléchargement
        downloadButton.setOnAction(e -> {
            generatePDF();
        });
        VBox root =new VBox();
        root.setSpacing(70);
        root.getChildren().addAll(header,gridPane);
        // Créer une nouvelle scène avec le GridPane
        Scene scene = new Scene(root, 700, 700);
       
     	//evenement
        button2.setOnAction (event -> {
        	main main1 = new main();
            main1.start(primaryStage);
       
});
        // Configurer la scène et l'afficher dans la fenêtre principale
        primaryStage.setTitle("Profil de l'étudiant");
        scene.getStylesheets().add(getClass().getResource("style_scene4.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void generatePDF() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files (.pdf)", ".pdf"));
        File initialDirectory = new File("C:\\Users\\dell\\Documents\\pdf");
        fileChooser.setInitialDirectory(initialDirectory);
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try {
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();
                Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Font.UNDERLINE);
                Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
                Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 11);

                Paragraph title = new Paragraph("Profil de l'étudiant", titleFont);
                title.setAlignment(Element.ALIGN_CENTER);
                title.setSpacingAfter(10);
                document.add(title);

                document.add(new Paragraph("Nom: ", sectionFont));
                document.add(new Paragraph(etudiant.getNom(), contentFont));

                document.add(new Paragraph("Prénom: ", sectionFont));
                document.add(new Paragraph(etudiant.getPrenom(), contentFont));

                document.add(new Paragraph("Âge: ", sectionFont));
                document.add(new Paragraph(String.valueOf(etudiant.getAge()), contentFont));

                document.add(new Paragraph("Année scolaire: ", sectionFont));
                document.add(new Paragraph(String.valueOf(etudiant.getAnneeScolaire()), contentFont));

                document.add(new Paragraph("Code Massar: ", sectionFont));
                document.add(new Paragraph(etudiant.getCodeMassar(), contentFont));

                document.add(new Paragraph("Niveau: ", sectionFont));
                document.add(new Paragraph(etudiant.getNiveau(), contentFont));

                document.close();

                document.close();

                File saveDirectory = new File("C:\\Users\\dell\\Documents\\pdf");
                if (!saveDirectory.exists()) {
                    saveDirectory.mkdirs();
                }
                File savedFile = new File(saveDirectory, file.getName());
                Files.copy(file.toPath(), savedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (DocumentException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}

