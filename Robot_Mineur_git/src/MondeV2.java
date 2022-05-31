import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;



public class MondeV2 {
	private PointEau[]obstacle;
	private Robot[] rob;
	private Mine[] min;
	private Entrepot[] ent;
	private int nbTour;
	private Secteur[][] sect;




	public MondeV2(PointEau[] obstacle, Robot[] rob) {
		super();
		this.nbTour=0;
		this.obstacle = obstacle;
		this.rob = rob;
	}
	
	public void creerMondeV2() {
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

	public void ajouterEntrepotV2() {
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

	public void ajouterMineV2() {
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

	public void ajouterRobotV2() {
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
	
	public void updateMondeV2() {
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

public boolean verifV2(Robot R,String H) {
	Comparator comparator = String.CASE_INSENSITIVE_ORDER;
	int z = comparator.compare(H, "H");
	int y = comparator.compare(H, "B");
	int x = comparator.compare(H, "G");
	int w = comparator.compare(H, "D");
	if(z==0) {
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
	else if(y==0) {
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
	else if(x==0) {
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
	else if(w==0) {
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

	public void afficherMondeV2() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				sect[i][j].afficherl1();
			}
			System.out.print("\n");
			for(int j=0;j<10;j++) {
				sect[i][j].afficherl2();
			}
			System.out.println();
		}
	}

	public MondeV2() {
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

	public void afficherEtatV2() {
		System.out.println("tours:  "+this.nbTour);
		
		for (int i=0;i<this.ent.length;i++) {
			if(this.ent[i].isOr()==true) {
				System.out.println("E  "+this.ent[i].getIdEntrepot()+" X:  "+this.ent[i].getX()+" Y:  "+this.ent[i].getY()+"  OR  "+this.ent[i].getStock());
			}
			else {
				System.out.println("E  "+this.ent[i].getIdEntrepot()+" X:  "+this.ent[i].getX()+" Y:  "+this.ent[i].getY()+"  NI  "+this.ent[i].getStock());
			}
			System.out.println();
		}
		for (int i=0;i<this.min.length;i++) {
			if(this.min[i].isOr()==true) {
				System.out.println("M  "+this.min[i].getIdMine()+" X:  "+this.min[i].getX()+" Y:  "+this.min[i].getY()+"  OR  "+this.min[i].getQuantite()+" / "+this.min[i].getQuantiteD());
			}
			else {
				System.out.println("M  "+this.min[i].getIdMine()+" X:  "+this.min[i].getX()+" Y:  "+this.min[i].getY()+"  NI  "+this.min[i].getQuantite()+" / "+this.min[i].getQuantiteD());
			}
			System.out.println();
		}
		for (int i=0;i<this.rob.length;i++) {
			if(this.rob[i].isOr()==true) {
				System.out.println("R  "+this.rob[i].getID()+" X:  "+this.rob[i].getX()+" Y:  "+this.rob[i].getY()+"  OR  "+this.rob[i].getStockActuel()+" / "+this.rob[i].getStockMax());
			}
			else {
				System.out.println("R  "+this.rob[i].getID()+" X:  "+this.rob[i].getX()+" Y:  "+this.rob[i].getY()+"  NI  "+this.rob[i].getStockActuel()+" / "+this.rob[i].getStockMax());
			}
			System.out.println();
		}
	}
	
	public void game() {
		boolean e=false;
		this.afficherMondeV2();
		this.afficherEtatV2();
		while(e==false) {
			for (int i=0;i<this.rob.length;i++) {
				for(int j=0;j<this.ent.length;j++) {
					if(this.rob[i].getX()==this.ent[j].getX()&&this.rob[i].getY()==this.ent[j].getY()) {
						Scanner inputReader = new Scanner(System.in);
						System.out.println("voulez vous destocker  R "+this.rob[i].getID()+"dans E "+this.ent[j].getIdEntrepot()+"si oui entrez 1");
				        int number2 = inputReader.nextInt();
				        if(number2==1) {
				        	this.rob[i].destocker(this.ent[j]);
				        	this.nbTour=this.nbTour+1;
				        }
					}
				}
				for(int j=0;j<this.ent.length;j++) {
					if(this.rob[i].getX()==this.min[j].getX()&&this.rob[i].getY()==this.min[j].getY()) {
						Scanner inputReader = new Scanner(System.in);
						System.out.println("voulez vous miner  R "+this.rob[i].getID()+"dans M "+this.min[j].getIdMine()+" si oui entrez 1");
				        int number2 = inputReader.nextInt();
				        if(number2==1) {
				        	this.rob[i].miner(this.min[j]);
				        	this.nbTour=this.nbTour+1;
				        }
					}
				}
			}
			boolean t=false;
			boolean d=false;
			int id;
			String dep;
			while(d==false||t==false) {
				Scanner inputReader = new Scanner(System.in);
				for(int i=0;i<this.rob.length;i++) {
					System.out.println("R: "+this.rob[i].getID());
				}
				int a=this.rob.length;
				System.out.println("entre le numero d'id d'un robot");
				int number2 = inputReader.nextInt();
				Scanner inputReader2 = new Scanner(System.in);
				System.out.println("haut=1  bas=2  gauche=3 droite=4 entrer le numero du déplacement");
				int number3 = inputReader.nextInt();
				if(number3 >0&&number3<=4&&number2>=0&&number2<a) {
					t=true;
					d=true;
					if(number3>=1&&number3<=4) {
						d=true;
						if(number3==1) {
							this.rob[number2].deplacerV2("H", this);
						}
						else if(number3==2) {
							this.rob[number2].deplacerV2("B", this);
						}
						else if(number3==3) {
							this.rob[number2].deplacerV2("G", this);
						}
						else if(number3==4) {
							this.rob[number2].deplacerV2("D", this);
						}
				}
			}
			this.updateMondeV2();
			this.afficherMondeV2();
			this.afficherEtatV2();
			Scanner inputReader4 = new Scanner(System.in);
	        System.out.println("Voulez vous arrêter si oui entrez 1");
	        int number = inputReader4.nextInt();
	        if(number==1) {
	        	e=true;
	        }
		}
	}
		System.out.println("Merci d'avoir jouer");

}
	
	
}