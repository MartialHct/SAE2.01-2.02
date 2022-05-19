
public class appli {
	public static void main(String[] args) {
		Entrepot a;
		Robot c;
		Secteur b;
		Secteur [][]d;
		d=new Secteur[10][10];
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				d[i][j]=new Secteur(i,j);
				d[i][j].afficherl1();
			}
			System.out.print("\n");
			for(int j=0;j<10;j++) {
				d[i][j].afficherl2();
			}
			System.out.println();
		}
		
		System.out.println("///////////////////");
		
		Monde f;
		f=new Monde();
		f.setSect(d);
		PointEau k=new PointEau(0,0);
		PointEau[] obstacle=new PointEau[]{k};
		f.setObstacle(obstacle);
		Secteur s=new Secteur(k);
		f.set(0, 0, s);
		f.creerMonde();
		f.ajouterEntrepot();
		for(int z=0;z<f.getObstacle().length;z++) {
			System.out.println(f.getObstacle()[z].getX()+"  "+f.getObstacle()[z].getY());
		}
		//f.set(0, 0, s);
		f.afficherMonde();

		
		//a=new Entrepot(true,1,1,2);
		//c=new Robot(true,1,1,2);
		//b=new Secteur(a,c);
		//b.afficher();
		
		// TODO Auto-generated method stub

	}
}
