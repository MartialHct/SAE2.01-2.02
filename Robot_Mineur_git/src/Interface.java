
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Interface extends Application {

    @Override public void start (Stage stage) {
    	Monde f;
		f=new Monde();
		f.creerMonde();
		f.ajouterEntrepot();
		f.ajouterMine();
		f.ajouterRobot();

        Group group = new Group();
        Scene scene = new Scene(group, 1000, 1000);
        Text texte = new Text(500,50," Bienvenue sur le robot mineur ! ");
        texte.setFont(new Font(15));
        texte.setFill(Color.BLACK);
        texte.setStyle("-fx-font-weight: bold");
        texte.setUnderline(true);


        	GridPane grille = new GridPane();
            GridPane [][] sect = new GridPane[10][10];
            
            
       
        
        for(int i=0; i <10;i++) {
        	for(int j=0; j <10;j++) {
        		sect[i][j] = new GridPane();
        		sect[i][j].setGridLinesVisible(true);
        		sect[i][j].getColumnConstraints().add(new ColumnConstraints(30));
        		sect[i][j].getColumnConstraints().add(new ColumnConstraints(30));
        		sect[i][j].getRowConstraints().add(new RowConstraints(30));
        		sect[i][j].getRowConstraints().add(new RowConstraints(30));
        		sect[i][j].add(new Label(""),0,0);
        		sect[i][j].add(new Label(""),0,1);
        		sect[i][j].add(new Label(""),1,0);
        		sect[i][j].add(new Label(""),1,1);
        		grille.add(sect[i][j],i,j);     		
        	}
        }
        PointEau[] ob=f.getObstacle();
        
        
        GridPane [][] test = new GridPane[10][10];
        test[0][0] = new GridPane();
		test[0][0].setGridLinesVisible(true);
		test[0][0].getColumnConstraints().add(new ColumnConstraints(30));
		test[0][0].getColumnConstraints().add(new ColumnConstraints(30));
		test[0][0].getRowConstraints().add(new RowConstraints(30));
		test[0][0].getRowConstraints().add(new RowConstraints(30));
		test[0][0].add(new Label("   X"),0,0);
		test[0][0].add(new Label("   X"),0,1);
		test[0][0].add(new Label("   X"),1,0);
		test[0][0].add(new Label("   X"),1,1);
        grille.add(test[0][0],0,0);  
        
        

        grille.setAlignment(Pos.CENTER);
        grille.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        grille.setLayoutX(320);
        grille.setLayoutY(80);
        Entrepot [] e;
        e=f.getEnt();
        for(int i=0;i<e.length;i++) {
        	if(e[i].isOr()==true) {
				Text texteEnt = new Text (80,200+i*20," E "+e[i].getIdEntrepot()+" X:  "+e[i].getX()+" Y:  "+e[i].getY()+"  Or  "+e[i].getStock());
				group.getChildren().add(texteEnt);
			}
			else {
				Text texteEnt = new Text(80,200+i*20," E "+e[i].getIdEntrepot()+" X:  "+e[i].getX()+" Y:  "+e[i].getY()+"  NI  "+e[i].getStock());
				group.getChildren().add(texteEnt);
			}
		}
        
        Mine [] m;
        m=f.getMin();
        for(int i=0; i<m.length;i++) {
        	if(m[i].isOr()==true) {
        		Text texteMin = new Text (80,300+i*20," M "+m[i].getIdMine()+" X:  "+m[i].getX()+" Y:  "+m[i].getY()+" Or "+m[i].getQuantite()+" / "+m[i].getQuantiteD());
        		group.getChildren().add(texteMin);
        	}
        	else {
        		Text texteMin = new Text (80,300+i*20," M "+m[i].getIdMine()+" X:  "+m[i].getX()+" Y:  "+m[i].getY()+" NI "+m[i].getQuantite()+" / "+m[i].getQuantiteD());
        		group.getChildren().add(texteMin);
        		
        	}
        }
        
        Robot [] r;
        r=f.getRob();
        for(int i=0;i<r.length;i++) {
        	if(r[i].isOr()==true) {
        		Text texteRob = new Text (80,400+i*20," R "+r[i].getID()+" X:  "+r[i].getX()+" Y:  "+r[i].getY()+" Or "+r[i].getStockActuel()+" / "+r[i].getStockMax());
        		group.getChildren().add(texteRob);

        	}
        	else {
        		Text texteRob = new Text (80,400+i*20," R "+r[i].getID()+" X:  "+r[i].getX()+" Y:  "+r[i].getY()+" NI "+r[i].getStockActuel()+" / "+r[i].getStockMax());
        		group.getChildren().add(texteRob);

        	}
        }
        
        
        
        Text nbTour=new Text(80,500,"Nombre de tours :  "+f.getNbTour());
        group.getChildren().add(nbTour);
        group.getChildren().add(texte);
        group.getChildren().add(grille);
        stage.setTitle(" Robot Mineurs SAE 2.01 ");
        stage.show();
        stage.setScene(scene);

    }

    public static void main(String [] args) {
        Application.launch(args);
    }

}