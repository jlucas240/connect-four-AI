import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gdriver extends Application {
	
	public static void main(String[] args) {
		launch(args);   
	}
		   
	@Override
	public void start(Stage stage) throws IOException {
		
		//  instantiate the FXMainPane, name it root
		GUI root = new GUI();
		//  set the scene to hold root
		stage.setScene(new Scene(root, 600, 300)); 
		//set stage title
		stage.setTitle("AI Overlord");
		//display the stage
		stage.show();

	}
}

