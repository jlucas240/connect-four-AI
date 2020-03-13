import java.io.IOException;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class tst {
	
	
	/*public void start(Stage stage) throws IOException {
		
		//  instantiate the FXMainPane, name it root
		GUI root = new GUI();		
		//  set the scene to hold root
		stage.setScene(new Scene(root, 600, 500)); 
		//set stage title
		stage.setTitle("AI_overlord");
		//display the stage
		stage.show();

	}*/

	/*public static void main(String[] args) throws IOException {
		
		
		
		//in this test player goes first goes first
		/*connect_four game = new connect_four();
		
		Scanner myObj = new Scanner(System.in);
		
		while (game.winner == 0) {
			System.out.print("pic column: ");
			int move = myObj.nextInt();
			
			game.insert(1, move);
			
			AI crashMeBaby = new AI(1);
			
			int[][] hold = new int[6][7];
			for (int i = 5; i >=0 ; i--)
			{
				for (int j = 0; j < 7; j++)
					hold[i][j] = game.bord[i][j];
			}
			
			crashMeBaby.build(hold);
			int max = -5000;
			move = 0;
			for(int i = 0; i < 7; i++) {
				if(crashMeBaby.brain.root.children[i] != null)
					if(max < crashMeBaby.brain.root.children[i].value) {
						max = crashMeBaby.brain.root.children[i].value;
						move = i+1;
					}
					
			}
			game.insert(2, move);
			
			System.out.println("Current bord state:  ");
			
			for (int i = 5; i >=0 ; i--)
			{
				for (int j = 0; j < 7; j++)
					System.out.print(game.bord[i][j]);
				System.out.println("");
			}
		}
		
		System.out.print("winner is player: ");
		/*AI crashMeBaby = new AI(1);
		crashMeBaby.build();*/
		
	//}

}
