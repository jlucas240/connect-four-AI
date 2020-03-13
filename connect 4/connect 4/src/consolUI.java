import java.io.IOException;
import java.util.Scanner;
import java.util.Random; 


public class consolUI {

	public static void main(String[] args) throws IOException {
		
		Scanner myObj = new Scanner(System.in);
		
		
		// options for players
		System.out.println("Type the number next to the option to sellect");
		System.out.println("player1 ges first always");
		System.out.print("pick player1 (1)Person, (2)Randome, (3)AI: ");
		int player1 = myObj.nextInt();
		System.out.print("pick player2 (1)Person, (2)Randome, (3)AI: ");
		int player2 = myObj.nextInt();
		
		connect_four game = new connect_four();
		
		while (game.winner == 0) {
			if(player1 == 1) {
				if(player2 == 3) {
					System.out.print("pick column: ");
					int move = myObj.nextInt();
					
					game.insert(1, move);
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
					
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
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
				}
				else if(player2 == 2) {
					System.out.print("pick column: ");
					int move = myObj.nextInt();
					Random rand = new Random(); 
					game.insert(1, move);
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
					
					int i = -1;
					while (i == -1) {
						move = rand.nextInt(7)+1;
						
						if(game.bord[5][move-1] == 0) {
							game.insert(2, move);
							i = 0;
						}
					}
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int k = 5; k >=0 ; k--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[k][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
				}
				else {
					System.out.print("Player1 pick column: ");
					int move = myObj.nextInt();
					game.insert(1, move);
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
					
					System.out.print("Player2 pick column: ");
					move = myObj.nextInt();
					game.insert(2, move);
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
				}
			}
				
			else if (player1 == 2) {
					
				if(player2 == 3) {
					int move;
					Random rand = new Random();
					
					
					int k = -1;
					while (k == -1) {
						move = rand.nextInt(7)+1;
						
						if(game.bord[5][move-1] == 0) {
							game.insert(1, move);
							k = 0;
						}
					}
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
					
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
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
				}
				else if(player2 == 2) {
					int move = 0;
					Random rand = new Random(); 
					
					int k = -1;
					while (k == -1) {
						move = rand.nextInt(7)+1;
						
						if(game.bord[5][move-1] == 0) {
							game.insert(1, move);
							k = 0;
						}
					}
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
					
					
					int i = -1;
					while (i == -1) {
						move = rand.nextInt(7)+1;
						
						if(game.bord[5][move-1] == 0) {
							game.insert(2, move);
							i = 0;
						}
					}	
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int f = 5; f >=0 ; f--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[f][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
				}
				else {
					int move;
					Random rand = new Random(); 
					
					int k = -1;
					while (k == -1) {
						move = rand.nextInt(7)+1;
						
						if(game.bord[5][move-1] == 0) {
							game.insert(1, move);
							k = 0;
						}
					}
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
					
					System.out.print("Player2 pick column: ");
					move = myObj.nextInt();
					game.insert(2, move);
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
				}
				
			}
			else {
				if(player2 == 3) {
					int move;
					int[][] flip = new int[6][7];
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							if(game.bord[i][j] == 0)
								flip[i][j] = game.bord[i][j];
							else if(game.bord[i][j] == 1)
								flip[i][j] = 2;
							else if(game.bord[i][j] == 2)
								flip[i][j] = 1;
						
					}
					
					AI crashMeBaby = new AI(1);
					
					int[][] hold1 = new int[6][7];
					hold1 = flip;
					
					crashMeBaby.build(hold1);
					int max1 = -5000;
					move = 0;
					for(int i = 0; i < 7; i++) {
						if(crashMeBaby.brain.root.children[i] != null)
							if(max1 < crashMeBaby.brain.root.children[i].value) {
								max1 = crashMeBaby.brain.root.children[i].value;
								move = i+1;
							}
							
					}
					game.insert(1, move);
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
					
					
					crashMeBaby = new AI(1);
					
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
				else if(player2 == 2) {
					int move;
					Random rand = new Random(); 

					int[][] flip = new int[6][7];
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							if(game.bord[i][j] == 0)
								flip[i][j] = game.bord[i][j];
							else if(game.bord[i][j] == 1)
								flip[i][j] = 2;
							else if(game.bord[i][j] == 2)
								flip[i][j] = 1;
						
					}
					
					AI crashMeBaby = new AI(1);
					
					int[][] hold1 = new int[6][7];
					hold1 = flip;
					
					crashMeBaby.build(hold1);
					int max1 = -5000;
					move = 0;
					for(int i = 0; i < 7; i++) {
						if(crashMeBaby.brain.root.children[i] != null)
							if(max1 < crashMeBaby.brain.root.children[i].value) {
								max1 = crashMeBaby.brain.root.children[i].value;
								move = i+1;
							}
							
					}
					game.insert(1, move);
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
					
					int i = -1;
					while (i == -1) {
						move = rand.nextInt(7)+1;
						
						if(game.bord[5][move-1] == 0) {
							game.insert(2, move);
							i = 0;
						}
					}			
				}
				else {
					int move;
					int[][] flip = new int[6][7];
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							if(game.bord[i][j] == 0)
								flip[i][j] = game.bord[i][j];
							else if(game.bord[i][j] == 1)
								flip[i][j] = 2;
							else if(game.bord[i][j] == 2)
								flip[i][j] = 1;
						
					}
					
					AI crashMeBaby = new AI(1);
					
					int[][] hold1 = new int[6][7];
					hold1 = flip;
					
					crashMeBaby.build(hold1);
					int max1 = -5000;
					move = 0;
					for(int i = 0; i < 7; i++) {
						if(crashMeBaby.brain.root.children[i] != null)
							if(max1 < crashMeBaby.brain.root.children[i].value) {
								max1 = crashMeBaby.brain.root.children[i].value;
								move = i+1;
							}
							
					}
					game.insert(1, move);
					
					System.out.println("Current bord state:  ");
					System.out.println("12334567");
					System.out.println("-------");
					
					for (int i = 5; i >=0 ; i--)
					{
						for (int j = 0; j < 7; j++)
							System.out.print(game.bord[i][j]);
						System.out.println("");
					}
					System.out.println("-------");
					System.out.println("12334567");
					
					System.out.print("Player2 pick column: ");
					move = myObj.nextInt();
					game.insert(2, move);
				}
				
			}
		}
				
			System.out.print("winner is player: " + game.winner);
			
		}
	
}
