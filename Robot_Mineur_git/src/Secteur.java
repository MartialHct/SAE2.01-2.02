
public class Secteur {
private int x;
private int y;
private String [][] nature;
public Secteur(int x, int y, String[][] nature) {
	super();
	this.x = x;
	this.y = y;
	this.nature = nature;
}

public void afficherl1() {
	for(int i=0;i<2;i++) {
			System.out.print("|"+this.nature[0][i]+"|");
	}
}

public void afficherl2() {
	for(int i=0;i<2;i++) {
			System.out.print("|"+this.nature[1][i]+"|");
	}
}

public  Secteur(PointEau p) {
	String[][] t= {{"X","X"},{"X","X"}};
	this.nature=t;
	this.x=p.getX();
	this.y=p.getY();
}

public  Secteur(int x,int y) {
	String[][] t= {{" "," "},{" "," "}};
	this.nature=t;
	this.x=x;
	this.y=y;
}

public Secteur(Robot R) {
	this.x=R.getX();
	this.y=R.getY();
	String[][] t= {{" "," "},{"R",String.valueOf(R.getID())}};
	this.nature=t;
}

public Secteur(Mine M) {
	this.x=M.getX();
	this.y=M.getY();
	String[][] t= {{"M",String.valueOf(M.getIdMine())},{" "," "}};
	this.nature=t;
}

public Secteur(Entrepot E) {
	this.x=E.getX();
	this.y=E.getY();
	String[][] t= {{"E",String.valueOf(E.getIdEntrepot())},{" "," "}};
	this.nature=t;
}

public Secteur(Entrepot E,Robot r) {
	this.x=E.getX();
	this.y=E.getY();
	String[][] t= {{"E",String.valueOf(E.getIdEntrepot())},{"R",String.valueOf(r.getID())}};
	this.nature=t;
}

public Secteur(Mine E,Robot r) {
	this.x=E.getX();
	this.y=E.getY();
	String[][] t= {{"M",String.valueOf(E.getIdMine())},{"R",String.valueOf(r.getID())}};
	this.nature=t;
}
}

