import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Orientation; 


/**
 * pritty user inter face
 * 
 * @author Joshua Lucas
 *
 */

public class GUI extends VBox {

	BorderPane mainPane;
	HBox title, gameBord, player1choice, player2choice, calumnChoice, buttons;
	VBox main;
	Label  titleLable, player1Lable, player2Lable, columnLable;
	RadioButton p1AI, p1R, p1p;
	RadioButton p2AI, p2R, p2p;
	Button c1, c2, c3, c4, c5, c6, c7;
	Button playButton, exitButton;
	
	public GUI() {
		titleLable = new Label("Connect Four");
		titleLable.setFont(Font.font ("Verdana", 20));
		titleLable.setTextFill(Color.BLACK);
		
		exitButton = new Button("Exit");
		exitButton.setOnAction(new ButtonHandler());
		exitButton.setFont(Font.font ("Verdana", 14));
		exitButton.setTextFill(Color.BLACK);
		
		playButton = new Button("Play");
		playButton.setOnAction(new ButtonHandler());
		playButton.setFont(Font.font ("Verdana", 14));
		playButton.setTextFill(Color.BLACK);
		
		player1Lable = new Label("Choose your fighter: ");
		player1Lable.setFont(Font.font ("Verdana", 16));
		player1Lable.setTextFill(Color.BLACK);
		
		p1AI = new RadioButton("AI");
		p1AI.setOnAction(new RadioButtonHandlerP1()); 
		p1AI.setFont(Font.font ("Verdana", 14));
		p1AI.setSelected(false);
		
		p1R = new RadioButton("Random");
		p1R.setOnAction(new RadioButtonHandlerP1()); 
		p1R.setFont(Font.font ("Verdana", 14));
		p1R.setSelected(false);
		
		p1p = new RadioButton("Person");
		p1p.setOnAction(new RadioButtonHandlerP1()); 
		p1p.setFont(Font.font ("Verdana", 14));
		p1p.setSelected(false);
		
		player2Lable = new Label("Choose your fighter: ");
		player2Lable.setFont(Font.font ("Verdana", 16));
		player2Lable.setTextFill(Color.BLACK);
		
		p2AI = new RadioButton("AI");
		p2AI.setOnAction(new RadioButtonHandlerP2()); 
		p2AI.setFont(Font.font ("Verdana", 14));
		p2AI.setSelected(false);
		
		p2R = new RadioButton("Random");
		p2R.setOnAction(new RadioButtonHandlerP2()); 
		p2R.setFont(Font.font ("Verdana", 14));
		p2R.setSelected(false);
		
		p2p = new RadioButton("Person");
		p2p.setOnAction(new RadioButtonHandlerP2()); 
		p2p.setFont(Font.font ("Verdana", 14));
		p2p.setSelected(false);
		
		columnLable = new Label("Make a move I dare you: ");
		columnLable.setFont(Font.font ("Verdana", 16));
		columnLable.setTextFill(Color.BLACK);
		
		c1 = new Button("1");
		c1.setOnAction(new ButtonHandler());
		c1.setFont(Font.font ("Verdana", 14));
		c1.setTextFill(Color.BLACK);
		
		c2 = new Button("2");
		c2.setOnAction(new ButtonHandler());
		c2.setFont(Font.font ("Verdana", 14));
		c2.setTextFill(Color.BLACK);
		
		c3 = new Button("3");
		c3.setOnAction(new ButtonHandler());
		c3.setFont(Font.font ("Verdana", 14));
		c3.setTextFill(Color.BLACK);
		
		c4 = new Button("4");
		c4.setOnAction(new ButtonHandler());
		c4.setFont(Font.font ("Verdana", 14));
		c4.setTextFill(Color.BLACK);
		
		c5 = new Button("5");
		c5.setOnAction(new ButtonHandler());
		c5.setFont(Font.font ("Verdana", 14));
		c5.setTextFill(Color.BLACK);
		
		c6 = new Button("6");
		c6.setOnAction(new ButtonHandler());
		c6.setFont(Font.font ("Verdana", 14));
		c6.setTextFill(Color.BLACK);
		
		c7 = new Button("7");
		c7.setOnAction(new ButtonHandler());
		c7.setFont(Font.font ("Verdana", 14));
		c7.setTextFill(Color.BLACK);
		
		/////////////////////////////////////////////////////////////////////////////////////
		// title, gameBord, player1choice, player2choice, calumnChoice, buttons;
		
		title = new HBox(titleLable);
		player1choice = new HBox(player1Lable, p1p, p1AI, p1R); 
		player2choice = new HBox(player2Lable, p2p, p2AI, p2R); 
		calumnChoice = new HBox(columnLable, c1,c2,c3,c4,c5,c6,c7);
		buttons = new HBox(playButton, exitButton);
		main = new VBox(title,player1choice,player2choice, calumnChoice, buttons);
		getChildren().addAll(main);
	}
	
	private class RadioButtonHandlerP1 implements EventHandler<ActionEvent> {
	   	@Override
	    public void handle(ActionEvent event) {
	   		
	   		if(p1p.isSelected()) {
	   			/*p1AI.setSelected(false);
	   			p1R.setSelected(false);*/
	   		}
	   		else if(p1AI.isSelected()) {
	   			/*p1p.setSelected(false);
	   			p1R.setSelected(false);*/
	   		}
	   		else if(p1R.isSelected()) {
	   			/*p1AI.setSelected(false);
	   			p1p.setSelected(false);*/
	   		}
	   	}
	}
	
	private class RadioButtonHandlerP2 implements EventHandler<ActionEvent> {
	   	@Override
	    public void handle(ActionEvent event) {
	   	}
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
	   	@Override
	    public void handle(ActionEvent event) {
	   		Object selectedButton = event.getSource();
	   		
	   		if (selectedButton == exitButton)
		       {
		    	 Platform.exit();
		         System.exit(0);
		       }
	   	}
	}
}
