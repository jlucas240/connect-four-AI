import java.io.IOException;
import java.util.Scanner;

public class tst {

	public static void main(String[] args) throws IOException {
		
		
		//in this test player goes first goes first
		connect_four game = new connect_four();
		
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
			int max = 0;
			move = 0;
			for(int i = 0; i < 7; i++) {
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
		
	}

}
