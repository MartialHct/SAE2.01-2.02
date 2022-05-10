import java.util.Comparator;
import java.util.Random;

public class Robot {
private boolean or;
private int stockMax;
private int stockActuel;
private int capaciteExtraction;
private int idRobot;
private int x;
private int y;

public Robot(boolean o,int id,int x,int y) {
	Random random = new Random();
	int value = random.nextInt(3)+1;
	int min = 5;
	int max = 9;
	Random random2 = new Random();
	int value2 = random2.nextInt((max - min) + 1) + min;
	this.y=y;
	this.x=x;
	this.or=o;
	this.idRobot=id;
	this.stockActuel=5;
	this.capaciteExtraction=value;
	this.stockMax=value2;
}

public Robot() {
	this.stockMax=6;
	this.or=true;
	this.idRobot=1;
	this.stockActuel=5;
	this.capaciteExtraction=2;
	this.x=4;
	this.y=5;
}

public Robot(boolean o,int id,int x,int y,int val,int max) {	
	this.y=y;
	this.x=x;
	this.or=o;
	this.idRobot=id;
	this.stockActuel=0;
	this.capaciteExtraction=val;
	this.stockMax=max;
}


public int getStockActuel() {
	return stockActuel;
}

public void miner(Mine m) {
	if(this.or=!m.isOr()|| this.x!=m.getX()||this.y!=m.getY()|| m.getQuantite()==0) {
		throw new IllegalArgumentException("imposible");
	}else {
		if(this.capaciteExtraction>m.getQuantite()||this.stockMax-this.stockActuel>m.getQuantite()) {
			this.stockActuel=this.stockActuel+m.getQuantite();
			m.setQuantite(0);
		}
		else if(this.capaciteExtraction>this.stockMax-this.stockActuel) {
			m.setQuantite(m.getQuantite()-(this.stockMax-this.stockActuel));
			this.stockActuel=this.stockMax-this.stockActuel;
		}else {
			this.stockActuel=this.stockActuel+this.capaciteExtraction;
			m.setQuantite(m.getQuantite()-this.capaciteExtraction);
		}
	}
}
public void destocker(Entrepot e) {
	if(this.or=!e.isOr()|| this.x!=e.getX()||this.y!=e.getY()) {
		throw new IllegalArgumentException("imposible");
	}else {
		e.setStock(e.getStock()+this.stockActuel);
		this.stockActuel=0;
	}
}

public void deplacer(String A) {
	Comparator comparator = String.CASE_INSENSITIVE_ORDER;
	int z = comparator.compare(A, "H");
	int y = comparator.compare(A, "B");
	int x = comparator.compare(A, "G");
	int w = comparator.compare(A, "D");
	if(z==0 && this.x>0) {
		this.x=this.x-1;
	}
	else if(y==0 && this.x<9) {
		this.x=this.x+1;
	}
	else if(w==0 && this.y<9) {
		this.y=this.y+1;
	}
	else if(x==0 && this.y>0) {
		this.y=this.y-1;
	}
	else {
		throw new IllegalArgumentException("deplacement imposible");
	}
	
}



public int getX() {
	return x;
}


public int getY() {
	return y;
}


public boolean isOr() {
	return or;
}

public boolean colissionRobot(Robot r) {
	if(this.equals(r)==true) {
		return false;
	}
	else {
		if(this.x==r.getX()&&this.y==r.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
}

public boolean colissionObstacle(PointEau[] p) {
	for(int i=0;i<p.length;i++) {
		if(this.x==p[i].getX()&&this.y==p[i].getY()) {
			return true;
		}
	}
	return false;

}

public int getID() {
	return this.idRobot;
}

}

