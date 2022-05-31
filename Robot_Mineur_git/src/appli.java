



public class appli {
	public static void main(String[] args) {
		//main pour jouer robot mineur en mode console
		
		MondeV2 f;
		f=new MondeV2();
		f.creerMondeV2();
		f.ajouterEntrepotV2();
		f.ajouterMineV2();
		f.ajouterRobotV2();
		f.game();      
	}
}