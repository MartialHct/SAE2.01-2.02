import java.util.Scanner;



public class appli {
	public static void main(String[] args) {
		
		Monde f;
		Mine m;
		Robot r;
		//r=new Robot(true,5,5,5);
		//m=new Mine(true,1,5,5);
		//System.out.println(r.getStockActuel());
		//System.out.println(m.getQuantite());
		//r.miner(m);
		//System.out.println(r.getStockActuel());
		//System.out.println(m.getQuantite());

		f=new Monde();
		f.creerMonde();
		f.ajouterEntrepot();
		f.ajouterMine();
		f.ajouterRobot();
		//f.set(0, 0, s);
		f.game();
		
		//System.out.println("///////////////////");
		//f.afficherMonde();
		//f.afficherEtat();

		
		//a=new Entrepot(true,1,1,2);
		//c=new Robot(true,1,1,2);
		//b=new Secteur(a,c);
		//b.afficher();
		
		 //TODO Auto-generated method stub
		
		//Scanner inputReader = new Scanner(System.in);
        //System.out.println("Enter a number: ");
        //int number = inputReader.nextInt();

    		//System.out.println(number==5);        


	}
}
