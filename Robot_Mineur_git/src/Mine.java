
import java.util.Random;

public class Mine {
private int quantite;
private boolean or;
private int idMine;
private int x;
private int y;

public Mine(boolean o,int id,int x,int y) {
	int min = 50;
	int max = 100;
	Random random = new Random();
	int value = random.nextInt((max - min) + 1) + min;
	this.idMine=id;
	this.or=o;
	this.quantite=value;
	this.x=x;
	this.y=y;
}

public boolean isOr() {
	return or;
}

public int getX() {
	return x;
}

public int getQuantite() {
	return quantite;
}

public void setQuantite(int quantite) {
	this.quantite = quantite;
}

public int getY() {
	return y;
}


public void setOr(boolean or) {
	this.or = or;
}

}