



public class appli {
	public static void main(String[] args) {
		//main pour jouer robot mineur en mode console
		
		Monde f;
		f=new Monde();
		f.creerMonde();
		f.ajouterEntrepot();
		f.ajouterMine();
		f.ajouterRobot();
		f.game();      
	}
}