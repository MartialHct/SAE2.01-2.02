
public class Monde {
	
	

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
