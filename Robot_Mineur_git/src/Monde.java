import java.util.Comparator;


public class Monde {
	private PointEau[]obstacle;
	
	
	

	public Monde(PointEau[] obstacle) {
		super();
		this.obstacle = obstacle;
	}




	public PointEau[] getObstacle() {
		return obstacle;
	}


public boolean verif(Robot R,String H) {
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
	}
	else if(y==0) {
		for (int i=0;i<this.obstacle.length;i++) {
			if(this.obstacle[i].getX()==R.getX()+1&&this.obstacle[i].getY()==R.getY()) {
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
	}
	else if(w==0) {
		for (int i=0;i<this.obstacle.length;i++) {
			if(this.obstacle[i].getX()==R.getX()&&this.obstacle[i].getY()==R.getY()+1) {
				return true;
			}
		}
	}
	
	return false;
}

	public void setObstacle(PointEau[] obstacle) {
		this.obstacle = obstacle;
	}




	public static void main(String[] args) {
		Robot a;
		Entrepot b;
		
		a=new Robot(true,1,4,5);
		b=new Entrepot(true,1,3,7);
		System.out.println(a.getX());
		a.deplacer("H");
		System.out.println(a.getX());
		a.destocker(b);
		System.out.println(b.getStock());
		
		// TODO Auto-generated method stub

	}

}
