
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		
		Button button1 = new Button("Monter");
    	Button button2 = new Button("Descendre");
    	Button button3 = new Button("Gauche");
    	Button button4 = new Button("Droite");
    	
    	Button button5 = new Button("Miner");
    	button5.setOnMouseClicked(e -> {
    		
    	});
    	
    	Button button6 = new Button("Destocker");
    	button6.setOnMouseClicked(e -> {
    		
    	});
    	
    	button1.setLayoutX(575);
    	button1.setLayoutY(800);
    	button2.setLayoutX(575);
    	button2.setLayoutY(850);
    	button3.setLayoutX(475);
    	button3.setLayoutY(830);
    	button4.setLayoutX(680);
    	button4.setLayoutY(830);
    	button5.setLayoutX(500);
        button5.setLayoutY(700);
        button6.setLayoutX(600);
        button6.setLayoutY(700);

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
        for(int i=0;i<ob.length;i++) {
        	GridPane [][] test2 = new GridPane[10][10];
            test2[0][0] = new GridPane();
    		test2[0][0].setGridLinesVisible(true);
    		test2[0][0].getColumnConstraints().add(new ColumnConstraints(30));
    		test2[0][0].getColumnConstraints().add(new ColumnConstraints(30));
    		test2[0][0].getRowConstraints().add(new RowConstraints(30));
    		test2[0][0].getRowConstraints().add(new RowConstraints(30));
    		test2[0][0].add(new Label("   X"),0,0);
    		test2[0][0].add(new Label("   X"),0,1);
    		test2[0][0].add(new Label("   X"),1,0);
    		test2[0][0].add(new Label("   X"),1,1);
            grille.add(test2[0][0],ob[i].getY(),ob[i].getX());  
        }
        
        
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
        for(int i=0;i<e.length;i++) {
        	GridPane [][] test2 = new GridPane[10][10];
            test2[0][0] = new GridPane();
    		test2[0][0].setGridLinesVisible(true);
    		test2[0][0].getColumnConstraints().add(new ColumnConstraints(30));
    		test2[0][0].getColumnConstraints().add(new ColumnConstraints(30));
    		test2[0][0].getRowConstraints().add(new RowConstraints(30));
    		test2[0][0].getRowConstraints().add(new RowConstraints(30));
    		test2[0][0].add(new Label("   E"),0,0);
    		test2[0][0].add(new Label("   "),0,1);
    		test2[0][0].add(new Label("  "+e[i].getIdEntrepot()),1,0);
    		test2[0][0].add(new Label("   "),1,1);
            grille.add(test2[0][0],e[i].getY(),e[i].getX());  
        }
        
        for(int i=0;i<m.length;i++) {
        	GridPane [][] test2 = new GridPane[10][10];
            test2[0][0] = new GridPane();
    		test2[0][0].setGridLinesVisible(true);
    		test2[0][0].getColumnConstraints().add(new ColumnConstraints(30));
    		test2[0][0].getColumnConstraints().add(new ColumnConstraints(30));
    		test2[0][0].getRowConstraints().add(new RowConstraints(30));
    		test2[0][0].getRowConstraints().add(new RowConstraints(30));
    		test2[0][0].add(new Label("   M"),0,0);
    		test2[0][0].add(new Label("   "),0,1);
    		test2[0][0].add(new Label("  "+m[i].getIdMine()),1,0);
    		test2[0][0].add(new Label("   "),1,1);
            grille.add(test2[0][0],m[i].getY(),m[i].getX());  
        }
        
        for(int i=0;i<r.length;i++) {
        	GridPane [][] test2 = new GridPane[10][10];
            test2[0][0] = new GridPane();
    		test2[0][0].setGridLinesVisible(true);
    		test2[0][0].getColumnConstraints().add(new ColumnConstraints(30));
    		test2[0][0].getColumnConstraints().add(new ColumnConstraints(30));
    		test2[0][0].getRowConstraints().add(new RowConstraints(30));
    		test2[0][0].getRowConstraints().add(new RowConstraints(30));
    		test2[0][0].add(new Label("   "),0,0);
    		test2[0][0].add(new Label("   R"),0,1);
    		test2[0][0].add(new Label("  "+r[i].getID()),1,1);
    		test2[0][0].add(new Label("   "),1,0);
            grille.add(test2[0][0],r[i].getY(),r[i].getX());  
        }
        
        
        Text nbTour=new Text(80,500,"Nombre de tours :  "+f.getNbTour());
        group.getChildren().add(nbTour);
        group.getChildren().add(texte);
        group.getChildren().add(grille);
        group.getChildren().add(button1);
        group.getChildren().add(button2);
        group.getChildren().add(button3);
        group.getChildren().add(button4);
        group.getChildren().add(button5);
        group.getChildren().add(button6);
        stage.setTitle(" Robot Mineurs SAE 2.01 ");
        stage.show();
        stage.setScene(scene);

    }

    public static void main(String [] args) {
        Application.launch(args);
    }

}