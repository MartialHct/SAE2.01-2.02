
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Interface extends Application {

    @Override public void start (Stage stage) {
    	Monde f = new Monde();
    	f.creerMonde();
		f.ajouterEntrepot();
		f.ajouterMine();
		f.ajouterRobot();
    	
    	stage.setTitle(" Robot Mineurs SAE 2.01 ");
        stage.show();
        Scene sc = new Scene(f.View(),1000,1000);
        stage.setScene(sc);
    }

    public static void main(String [] args) {
        Application.launch(args);
    }

}