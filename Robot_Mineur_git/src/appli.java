public class appli {
	public static void main(String[] args) {
		
		Monde f;
		f=new Monde();
		f.creerMonde();
		f.ajouterEntrepot();
		f.ajouterMine();
		f.ajouterRobot();
		//f.set(0, 0, s);
		f.afficherMonde();
		f.afficherEtat();
		f.updateMonde();
		
		System.out.println("///////////////////");
		f.afficherMonde();
		f.afficherEtat();

		
		//a=new Entrepot(true,1,1,2);
		//c=new Robot(true,1,1,2);
		//b=new Secteur(a,c);
		//b.afficher();
		
		// TODO Auto-generated method stub
		
		//Scanner inputReader = new Scanner(System.in);
        //System.out.println("Enter a number: ");
        //int number = inputReader.nextInt();

    		//System.out.println(number==5);        


	}
}
