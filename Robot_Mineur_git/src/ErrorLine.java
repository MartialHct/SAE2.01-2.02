import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public interface ErrorLine
{
	public static StackPane Send(StackPane sp, double W, double H, int index)
	{
		Label warn  = new Label("Erreur");
		Label infos = new Label();
		switch( index )
		{
			case 1:	infos = new Label("Mouvement Impossible");				break;
		}
		
		HBox h = new HBox();		h.setPrefSize(W  ,H);	h.setAlignment(Pos.CENTER);		h.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		VBox v = new VBox();		v.setPrefSize(W/3,H);	v.setAlignment(Pos.CENTER);		v.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		sp.getChildren().get(0).setOpacity(0.5);
		VBox box = Exception_Box(W/3, H/3, (H/10));
		
		VBox lblbox = new VBox();	lblbox.setPrefSize( box.getPrefWidth() , box.getPrefHeight()*0.8 );		lblbox.setAlignment(Pos.CENTER);
		HBox btnbox = new HBox();	btnbox.setPrefSize( box.getPrefWidth() , box.getPrefHeight()*0.2 );		btnbox.setAlignment(Pos.CENTER);
		
		Button cancel = new Button("Compris");				cancel.setPrefSize( box.getPrefWidth()*0.2 , box.getPrefHeight()*0.2 );
		
		cancel.setOnMouseClicked( event ->
		{
			sp.getChildren().remove(1);
			sp.getChildren().get(0).setOpacity(1);
		});
		
		lblbox.getChildren().addAll(warn,infos);
		btnbox.getChildren().add(cancel);
		
		box.getChildren().addAll(lblbox,btnbox);
		v.getChildren().add(box);
		h.getChildren().add(v);
		sp.getChildren().add(h);
		
		return sp;
	}
	
	public static VBox Exception_Box(double W, double H, double round)
	{
		VBox box = new VBox();	box.setPrefSize(W, H);	box.setAlignment(Pos.CENTER);
		
		CornerRadii cr = new CornerRadii(round);
		box.setBackground(new Background(new BackgroundFill(Color.rgb(110, 60, 180), cr, null)));
		box.setBorder(BorderLine(5,round));
		
		return box;
	}
	
	public static Border BorderLine(double size, double round)
	{
		CornerRadii cri = new CornerRadii(round);
		BorderWidths bw1 = new BorderWidths(size);
		BorderStroke bs1 = new BorderStroke(Color.rgb(1,1,1),BorderStrokeStyle.SOLID,cri,bw1);
		return new Border(bs1);
	}
}