import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class Monde {
	private StackPane sp = new StackPane() ;
	
	private PointEau[]obstacle;
	private Robot[] rob;
	private Mine[] min;
	private Entrepot[] ent;
	private int rbt;
	private int nbTour;
	private Secteur[][] sect;




	public Monde(PointEau[] obstacle, Robot[] rob) {
		this.nbTour=0;
		this.rbt = 0;
		this.obstacle = obstacle;
		this.rob = rob;
	}
	
	public void creerMonde() {
		this.nbTour=0;
		int a=0;
		for (int k=0;k<10;k++) {
			for (int l=0;l<10;l++) {
				this.sect[k][l]=new Secteur(k,l);
			}
		}
		Random random = new Random();
		int value = random.nextInt(10)+1;
		int i=0;
		this.obstacle=new PointEau[value];
		while(i<value) {
			boolean ok=true;
			Random random2 = new Random();
			int value2 = random2.nextInt(10);
			Random random3 = new Random();
			int value3 = random3.nextInt(10);
			for(int k=0;k<a;k++) {
				if(this.obstacle[k].getY()==value3&&this.obstacle[k].getX()==value2) {
					ok=false;
				}
			}
			if(ok==true) {
				PointEau o=new PointEau(value2,value3);
				this.obstacle[i]=o;
				Secteur s=new Secteur(o);
				this.set(value2, value3, s);
				i=i+1;
				a=a+1;
			}
		}
	}

	public void ajouterEntrepot() {
		int a=0;
		Random random = new Random();
		int value = random.nextInt(2)+2;
		int i=0;
		this.ent=new Entrepot[value];
		while(i<value) {
			boolean ok=true;
			Random random2 = new Random();
			int value2 = random2.nextInt(10);
			Random random3 = new Random();
			int value3 = random3.nextInt(10);
			for(int k=0;k<this.obstacle.length;k++) {
				if(this.obstacle[k].getY()==value3&&this.obstacle[k].getX()==value2) {
					ok=false;
				} 
		}
			for(int z=0;z<a;z++) {
				if(this.ent[z].getY()==value3&&this.obstacle[z].getX()==value2) {
					ok=false;
				}
		}
			if(ok==true&&(a==0||a==2)) {
				Entrepot o=new Entrepot(true,a,value2,value3);
				this.ent[a]=o;
				Secteur s=new Secteur(o);
				this.set(value2, value3, s);
				i=i+1;
				a=a+1;
			}
			else if(ok==true&&(a==1||a==3)) {
				Entrepot o=new Entrepot(false,a,value2,value3);
				this.ent[a]=o;
				Secteur s=new Secteur(o);
				this.set(value2, value3, s);
				i=i+1;
				a=a+1;
			}
		}
	}

	public void ajouterMine() {
		int a=0;
		Random random = new Random();
		int value = random.nextInt(2)+2;
		int i=0;
		this.min=new Mine[value];
		while(i<value) {
			boolean ok=true;
			Random random2 = new Random();
			int value2 = random2.nextInt(10);
			Random random3 = new Random();
			int value3 = random3.nextInt(10);
			for(int k=0;k<this.obstacle.length;k++) {
				if(this.obstacle[k].getY()==value3&&this.obstacle[k].getX()==value2) {
					ok=false;
				} 
		}
			
			for(int k=0;k<this.ent.length;k++) {
				if(this.ent[k].getY()==value3&&this.ent[k].getX()==value2) {
					ok=false;
				} 
		}
			for(int z=0;z<a;z++) {
				if(this.min[z].getY()==value3&&this.min[z].getX()==value2) {
					ok=false;
				}
		}
			if(ok==true&&(a==0||a==2)) {
				Mine o=new Mine(true,a,value2,value3);
				this.min[a]=o;
				Secteur s=new Secteur(o);
				this.set(value2, value3, s);
				i=i+1;
				a=a+1;
			}
			else if(ok==true&&(a==1||a==3)) {
				Mine o=new Mine(false,a,value2,value3);
				this.min[a]=o;
				Secteur s=new Secteur(o);
				this.set(value2, value3, s);
				i=i+1;
				a=a+1;
			}
		}
	}

	public void ajouterRobot() {
		int a=0;
		Random random = new Random();
		int value = random.nextInt(4)+2;
		int i=0;
		this.rob=new Robot[value];
		while(i<value) {
			boolean ok=true;
			Random random2 = new Random();
			int value2 = random2.nextInt(10);
			Random random3 = new Random();
			int value3 = random3.nextInt(10);
			for(int k=0;k<this.obstacle.length;k++) {
				if(this.obstacle[k].getY()==value3&&this.obstacle[k].getX()==value2) {
					ok=false;
				} 
		}
			
			for(int k=0;k<this.ent.length;k++) {
				if(this.ent[k].getY()==value3&&this.ent[k].getX()==value2) {
					ok=false;
				} 
		}
			for(int k=0;k<this.min.length;k++) {
				if(this.min[k].getY()==value3&&this.min[k].getX()==value2) {
					ok=false;
				} 
		}
			for(int z=0;z<a;z++) {
				if(this.rob[z].getY()==value3&&this.rob[z].getX()==value2) {
					ok=false;
				}
		}
			if(ok==true&&(a==0||a==2)) {
				Robot o=new Robot(true,a,value2,value3);
				this.rob[a]=o;
				Secteur s=new Secteur(o);
				this.set(value2, value3, s);
				i=i+1;
				a=a+1;
			}
			else if(ok==true&&(a==1||a==3)) {
				Robot o=new Robot(false,a,value2,value3);
				this.rob[a]=o;
				Secteur s=new Secteur(o);
				this.set(value2, value3, s);
				i=i+1;
				a=a+1;
			}
		}
		
	}
	
	public void updateMonde() {
		this.nbTour=this.nbTour+1;
		for (int k=0;k<10;k++) {
			for (int l=0;l<10;l++) {
				this.sect[k][l]=new Secteur(k,l);
			}
		}
		for(int i=0;i<this.obstacle.length;i++) {
			Secteur s=new Secteur(this.obstacle[i]);
			this.set(this.obstacle[i].getX(), this.obstacle[i].getY(),s);
		}
		for(int i=0;i<this.ent.length;i++) {
			Secteur s=new Secteur(this.ent[i]);
			this.set(this.ent[i].getX(), this.ent[i].getY(),s);
		}
		for(int i=0;i<this.min.length;i++) {
			Secteur s=new Secteur(this.min[i]);
			this.set(this.min[i].getX(), this.min[i].getY(),s);
		}
		for(int i=0;i<this.rob.length;i++) {
			boolean ok1=true;
			boolean ok2=true;
			for (int j=0;j<this.ent.length;j++) {
				if(this.rob[i].getX()==this.ent[j].getX()&&this.rob[i].getY()==this.ent[j].getY()) {
					Secteur s=new Secteur(this.ent[j],this.rob[i]);
					this.set(this.ent[j].getX(), this.ent[j].getY(),s);
					ok1=false;
				}
			}
			for (int j=0;j<this.min.length;j++) {
				if(this.rob[i].getX()==this.min[j].getX()&&this.rob[i].getY()==this.min[j].getY()) {
					Secteur s=new Secteur(this.min[j],this.rob[i]);
					this.set(this.min[j].getX(), this.min[j].getY(),s);
					ok2=false;
				}
			}
			if(ok1==true&&ok2==true) {
				Secteur s=new Secteur(this.rob[i]);
				this.set(this.rob[i].getX(), this.rob[i].getY(),s);
			}
		}
	}


	public PointEau[] getObstacle() {
		return obstacle;
	}


public void setRob(Robot[] rob) {
		this.rob = rob;
	}

	public void setMin(Mine[] min) {
		this.min = min;
	}

	public void setEnt(Entrepot[] ent) {
		this.ent = ent;
	}

public boolean verif(Robot R,int state) {
	if(state == 1) {
		for (int i=0;i<this.obstacle.length;i++) {
			if(this.obstacle[i].getX()==R.getX()-1&&this.obstacle[i].getY()==R.getY()) {
				return true;
			}
		}
		for (int i=0;i<this.rob.length;i++) {
			if(this.rob[i].getX()==R.getX()-1&&this.rob[i].getY()==R.getY()) {
				return true;
			}
		}
	}
	else if(state == 2) {
		for (int i=0;i<this.obstacle.length;i++) {
			if(this.obstacle[i].getX()==R.getX()+1&&this.obstacle[i].getY()==R.getY()) {
				return true;
			}
		}
		for (int i=0;i<this.rob.length;i++) {
			if(this.rob[i].getX()==R.getX()+1&&this.rob[i].getY()==R.getY()) {
				return true;
			}
		}
	}
	else if(state == 3) {
		for (int i=0;i<this.obstacle.length;i++) {
			if(this.obstacle[i].getX()==R.getX()&&this.obstacle[i].getY()==R.getY()-1) {
				return true;
			}
		}
		for (int i=0;i<this.rob.length;i++) {
			if(this.rob[i].getX()==R.getX()&&this.rob[i].getY()==R.getY()-1) {
				return true;
			}
		}
	}
	else if(state == 4) {
		for (int i=0;i<this.obstacle.length;i++) {
			if(this.obstacle[i].getX()==R.getX()&&this.obstacle[i].getY()==R.getY()+1) {
				return true;
			}
		}
		for (int i=0;i<this.rob.length;i++) {
			if(this.rob[i].getX()==R.getX()&&this.rob[i].getY()==R.getY()+1) {
				return true;
			}
		}
	}
	
	return false;
}

	public void setObstacle(PointEau[] obstacle) {
		this.obstacle = obstacle;
	}

	public Monde() {
		this.nbTour=0;
		this.sect=new Secteur[10][10];
	}
	
	
	public void set(int x, int y, Secteur s) {
		this.sect[x][y]=s;
	}
	
	public void setSect(Secteur[][] sect) {
		this.sect = sect;
	}
	
	
	
	public Robot[] getRob() {
		return rob;
	}

	public Mine[] getMin() {
		return min;
	}

	public Entrepot[] getEnt() {
		return ent;
	}

	public int getNbTour() {
		return nbTour;
	}

	public Secteur[][] getSect() {
		return sect;
	}
	
	public StackPane View(){
		
		Group group = new Group();
	    sp.setPrefSize(group.getLayoutX(),group.getLayoutX());
		
		Button button1 = new Button("Monter");
    	Button button2 = new Button("Descendre");
    	Button button3 = new Button("Gauche");
    	Button button4 = new Button("Droite");
    	Button button5 = new Button("Miner");
    	Button button6 = new Button("Destocker");
    	
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
        
        
        button1.setOnMouseClicked( event ->
		{
			try
			{
				this.rob[rbt].deplacer(1, this);
				if ( (this.rob.length - 1) == rbt )
				{ rbt = 0; }
				else
				{ rbt = rbt + 1; this.nbTour = nbTour + 1 ; }
				sp = View();
			}
			catch(IllegalArgumentException e)
			{ ErrorLine.Send(sp, 1000,1000 , 1); }
		});
        
        button2.setOnMouseClicked( event ->
		{
			try
			{
				this.rob[rbt].deplacer(2, this);
				if ( (this.rob.length - 1) == rbt )
				{ rbt = 0; }
				else
				{ rbt = rbt + 1; this.nbTour = nbTour + 1 ; }
				sp = View();
			}
			catch(IllegalArgumentException e)
			{ ErrorLine.Send(sp, 1000,1000 , 1); }
		});
        
        button3.setOnMouseClicked( event ->
		{
			try
			{
				this.rob[rbt].deplacer(3, this);
				if ( (this.rob.length - 1) == rbt )
				{ rbt = 0; }
				else
				{ rbt = rbt + 1; this.nbTour = nbTour + 1 ; }
				sp = View();
			}
			catch(IllegalArgumentException e)
			{ ErrorLine.Send(sp, 1000,1000 , 1); }
		});
        
        button4.setOnMouseClicked( event ->
		{
			try
			{
				this.rob[rbt].deplacer(4, this);
				if ( (this.rob.length - 1) == rbt )
				{ rbt = 0; }
				else
				{ rbt = rbt + 1; this.nbTour = nbTour + 1 ; }
				sp = View();
			}
			catch(IllegalArgumentException e)
			{ ErrorLine.Send(sp, 1000,1000 , 1); }
		});
        
        button5.setOnMouseClicked( event ->
		{for(int i=0;i<this.min.length;i++) {
			if(this.rob[rbt].getX()==this.min[i].getX()&&this.rob[rbt].isOr()==this.min[i].isOr()&&this.rob[rbt].getY()==this.min[i].getY()&&this.rob[rbt].getStockActuel()!=this.rob[rbt].getStockMax()) {
				if ( (this.rob.length - 1) == rbt ) {
					this.rob[rbt].miner(this.min[i]);
					rbt = 0; this.nbTour = nbTour + 1 ;
					sp = View();
				}
				else {
					this.rob[rbt].miner(this.min[i]);
					rbt = rbt + 1; this.nbTour = nbTour + 1 ;
					sp = View();
				}
			}
		}
			
		});
        
        button6.setOnMouseClicked( event ->
		{for(int i=0;i<this.ent.length;i++) {
			if(this.rob[rbt].getX()==this.ent[i].getX()&&this.rob[rbt].isOr()==this.ent[i].isOr()&&this.rob[rbt].getY()==this.ent[i].getY()&&this.rob[rbt].getStockActuel()>0) {
			if ( (this.rob.length - 1) == rbt ) {
				this.rob[rbt].destocker(this.ent[i]);
				rbt = 0; this.nbTour = nbTour + 1 ;
				sp = View();
			}
			else {
				this.rob[rbt].destocker(this.ent[i]);
				rbt = rbt + 1; this.nbTour = nbTour + 1 ;
				sp = View();
			}
		}
		}
		});

        Text texte = new Text(500,50," Bienvenue sur le robot mineur ! Tour : " + this.nbTour + " / Robot : " + this.rbt);
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
        PointEau[] ob=getObstacle();
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
        e=getEnt();
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
        m=getMin();
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
        r=getRob();
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
        
        
        Text nbTour=new Text(80,500,"Nombre de tours :  "+getNbTour());
        group.getChildren().add(nbTour);
        group.getChildren().add(texte);
        group.getChildren().add(grille);
        group.getChildren().add(button1);
        group.getChildren().add(button2);
        group.getChildren().add(button3);
        group.getChildren().add(button4);
        group.getChildren().add(button5);
        group.getChildren().add(button6);
        
        sp.getChildren().clear();
        sp.getChildren().add(group);
        
        return sp;
    }
	
}