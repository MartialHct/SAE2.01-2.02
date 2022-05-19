
public class Entrepot {
private int stock;
private boolean or;
private int idEntrepot;
private int x;
private int y;

public Entrepot(boolean o,int id,int x, int y) {
	this.idEntrepot=id;
	this.or=o;
	this.stock=0;
	this.x=x;
	this.y=y;
}



public int getIdEntrepot() {
	return idEntrepot;
}



public Entrepot() {
	this.idEntrepot=1;
	this.or=true;
	this.stock=0;
	this.x=3;
	this.y=7;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}

public boolean isOr() {
	return or;
}


public int getX() {
	return x;
}


public int getY() {
	return y;
}


}
