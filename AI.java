import java.io.IOException;



// notes on the simulation AI will always be 1 and enemy will be 2




public class AI {
	
	int level;
	int player;
	Tree brain;
	connect_four simulation;
	
	public AI(int p) {
		player = p;
		level = 0;
	}
	
	public boolean build(int[][] b) throws IOException {
		
		int height = 0; // when height is positive use max, else use min
		
		brain = new Tree();	
		brain.root.A = 1000000000;
		brain.root.B = -1000000000;
		simulation = new connect_four();
		simulation.bord = b;
		
		DFS(height+1, 0, brain.root);
		
		for(int i = 0; i< 7; i++)
			System.out.println(brain.root.children[i].value +"I am a hoe lmao");
		
		//brain.root.children.get(0);
		
		return false;
	}
	
	public void DFS(int h, int columb, Tree.Node c) throws IOException{
		
		
		for (int i = 5; i >=0 ; i--)
		{
			for (int j = 0; j < 7; j++)
				System.out.print(simulation.bord[i][j]);
			System.out.println("");
		}
		
		System.out.println("\n");
		
		int current_columb = columb;
		System.out.println("winner : "+ simulation.winner);
		if(level < 6) // try for 6 and if you do alpha beta pruning 8
			if (simulation.winner == 0) {
				for(int i = 0; i < 7; i++) {
					if(simulation.bord[5][i] == 0) {
						simulation.insert(h%2+1, i+1);
						
						System.out.println("\n");
						System.out.println(i);
						System.out.println("\n");
						if(h%2 == 0)
							brain.insert(c, -1000000000, i); // max state
						else
							brain.insert(c, 1000000000, i); // min state
						level++;
						DFS(h+1, i, c.children[i] );
					}
				}
			}
		// stuff to be done while recursing back up
		//_____________________________________________________________________________
		
		int state = -1; // Weather the node will be a max or a min 
		
		if(h%2 == 0)
			state = 0; // max state
		else
			state = 1; // min state
		
		// caluclations done if the value if at leaf node
		//_____________________________________________________________________________
		
		if(level == 6 || simulation.spots == 6*7) { // ALSO update here when canging the leve to stop at
			c.value = hyristic();
			System.out.println(c.value+"I am a slutttttt");
		}
		
		
		
		
		
		
		/*if(simulation.winner != 0) {
			System.out.println(c.value);
			int value = 0;
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7; j++) {
					if( simulation.bord[i][j] == 1)
						value++;
				}
			}
			if(simulation.winner == 1)
				c.value = value;
			else
				c.value = value*-1;
			simulation.undo(current_columb, h%2+1);
			level--;
			return; // add undo
		}
		else if(simulation.spots == 6*7) { // if board is full aka a draw
			c.value = 0;
			simulation.undo(current_columb, h%2+1);
			level--;
			return;
		}*/
		
		// compare childrens values then take the lowest or highest
		//_____________________________________________________________________________
		if (state == 0) {
			for(int i = 0; i < 7; i++)
				if (c.children[i] != null)
					if (c.children[i].value < c.value)
						c.value = c.children[i].value;
		}
		else {
			for(int i = 0; i < 7; i++)
				if (c.children[i] != null)
					if (c.children[i].value > c.value)
						c.value = c.children[i].value;
		}
		
		simulation.undo(current_columb, h%2+1);
		System.out.println(c.value);
		level--;
		return;
	}
	
	private int hyristic() {
		
		int value = 0; // for the hero
		int value1 = 0; // for the player
		 
		// check for amount in a stack
		// stacks if 2 value is 4 and can win
		// stacks if 3 value is 8 and can win
		// stacks if win is 16 and can win
		
		for(int i = 0; i < 7; i++) {
			int empty = 0;
			int hold = 0;
			for(int j = 5; j >= 0 ; j--) {
				if(simulation.bord[j][i] == 0)
					empty++;
				else if(simulation.bord[j][i] == 2)
					hold++;
				else
					j = -1;	
			}
			// value assignment
			if(hold == 2 && empty >=2) 
				if (value < 2)
					value = 2;
			else if(hold == 3 && empty >=1) 
				if (value < 8)
					value = 8;
			if(hold == 4) 
				if (value < 16)
					value = 16;
		}
			
			// check for amount in row
				// if 2 value is 4 and can win
				// if 3 value is 8 and can win
				// if can win 16
		
		for(int j = 5; j >= 0 ; j--) {// will alow gapps inbetween must be fixed to produce better num will not finish the game
			int empty = 0;
			int hold = 0;
			for(int i = 0; i < 7; i++) {
				if(simulation.bord[j][i] == 0)
					empty++;
				else if(simulation.bord[j][i] == 2)
					hold++;
				else
				{
					// value assignment
					if(hold == 2 && empty >=2) 
						if (value < 2)
							value = 2;
					else if(hold == 3 && empty >=1) 
						if (value < 8)
							value = 8;
					if(hold == 4) 
						if (value < 16)
							value = 16;
					i = 7;
					empty = 0;
					hold = 0;
				}
			}
			if(hold == 2 && empty >=2) 
				if (value < 2)
					value = 2;
			else if(hold == 3 && empty >=1) 
				if (value < 8)
					value = 8;
			if(hold == 4) 
				if (value < 16)
					value = 16;
		}
		
			
			// check diagonals to the right
				// if 2 value is 2 and can win
				// if 3 value is 7
				// if can win 30
		
		for(int j = 5; j >= 0 ; j--) {
			int empty = 0;
			int hold = 0;
			for(int i = 0; i < 7; i++) {
				if(simulation.bord[j][i] == 2) { // check below
					int i1 = i;
					int j1 = j;
					while(i1 > -1 && j1 > -1) {
						if(simulation.bord[j1][i1]==2)
							hold++;
						else if(simulation.bord[j1][i1]==0)
							empty++;
						else {
							i1=-1;
							j1=-1;
						}
						i1--;
						j1--;
					}
					
					i1 = i;
					j1 = j;
					
					while(i1 < 7 && j1 < 6) { //check above
						if(simulation.bord[j1][i1]==2)
							hold++;
						else if(simulation.bord[j1][i1]==0)
							empty++;
						else {
							i1=10;
							j1=10;
						}
						i1++;
						j1++;
					}
					if(hold == 2 && empty >=2) 
						if (value < 2)
							value = 2;
					else if(hold == 3 && empty >=1) 
						if (value < 7)
							value = 7;
					if(hold == 4) 
						if (value < 30)
							value = 30;
				}
				empty = 0;
				hold = 0;
			}
		}
			
			// check diagonals to the left
				// if 2 value is 2 and can win
				// if 3 value is 7 and can win
				// if can win 30
		for(int j = 5; j >= 0 ; j--) {
			int empty = 0;
			int hold = 0;
			for(int i = 0; i < 7; i++) {
				if(simulation.bord[j][i] == 2) { // check below
					int i1 = i;
					int j1 = j;
					while(i1 < 7 && j1 > -1) {
						if(simulation.bord[j1][i1]==2)
							hold++;
						else if(simulation.bord[j1][i1]==0)
							empty++;
						else {
							i1=10;
							j1=-1;
						}
						i1++;
						j1--;
					}
					
					i1 = i;
					j1 = j;
					
					while(i1 > -1 && j1 < 6) { //check above
						if(simulation.bord[j1][i1]==2)
							hold++;
						else if(simulation.bord[j1][i1]==0)
							empty++;
						else {
							i1=-1;
							j1=10;
						}
						i1--;
						j1++;
					}
					if(hold == 2 && empty >=2) 
						if (value < 2)
							value = 2;
					else if(hold == 3 && empty >=1) 
						if (value < 7)
							value = 7;
					if(hold == 4) 
						if (value < 30)
							value = 30;
					empty = 0;
					hold = 0;
				}
			}
		}
		
		// calculation for the villain
		//________________________________________________________________________________________________________________________________________________
		
		// check for amount in a stack
				// stacks if 2 value is 4 and can win
				// stacks if 3 value is 8 and can win
				// stacks if win is 16 and can win
				
				for(int i = 0; i < 7; i++) {
					int empty = 0;
					int hold = 0;
					for(int j = 5; j >= 0 ; j--) {
						if(simulation.bord[j][i] == 0)
							empty++;
						else if(simulation.bord[j][i] == 1)
							hold++;
						else
							j = -1;	
					}
					// value assignment
					if(hold == 2 && empty >=2) 
						if (value1 < 2)
							value1 = 2;
					else if(hold == 3 && empty >=1) 
						if (value1 < 8)
							value1 = 8;
					if(hold == 4) 
						if (value1 < 400)
							value1 = 400;
				}
					
					// check for amount in row
						// if 2 value is 4 and can win
						// if 3 value is 8 and can win
						// if can win 16
				
				for(int j = 5; j >= 0 ; j--) {// will alow gapps inbetween must be fixed to produce better num will not finish the game
					int empty = 0;
					int hold = 0;
					for(int i = 0; i < 7; i++) {
						if(simulation.bord[j][i] == 0)
							empty++;
						else if(simulation.bord[j][i] == 1)
							hold++;
						else
						{
							// value assignment
							if(hold == 2 && empty >=2) 
								if (value1 < 2)
									value1 = 2;
							else if(hold == 3 && empty >=1) 
								if (value1 < 8)
									value1 = 8;
							if(hold == 4) 
								if (value1 < 400)
									value1 = 400;
							i = 7;
							empty = 0;
							hold = 0;
						}
					}
					if(hold == 2 && empty >=2) 
						if (value1 < 2)
							value1 = 2;
					else if(hold == 3 && empty >=1) 
						if (value1 < 8)
							value1 = 8;
					if(hold == 4) 
						if (value1 < 400)
							value1 = 400;
				}
				
					
					// check diagonals to the right
						// if 2 value is 2 and can win
						// if 3 value is 7
						// if can win 30
				
				for(int j = 5; j >= 0 ; j--) {
					int empty = 0;
					int hold = 0;
					for(int i = 0; i < 7; i++) {
						if(simulation.bord[j][i] == 1) { // check below
							int i1 = i;
							int j1 = j;
							while(i1 > -1 && j1 > -1) {
								if(simulation.bord[j1][i1]==1)
									hold++;
								else if(simulation.bord[j1][i1]==0)
									empty++;
								else {
									i1=-1;
									j1=-1;
								}
								i1--;
								j1--;
							}
							
							i1 = i;
							j1 = j;
							
							while(i1 < 7 && j1 < 6) { //check above
								if(simulation.bord[j1][i1]==1)
									hold++;
								else if(simulation.bord[j1][i1]==0)
									empty++;
								else {
									i1=10;
									j1=10;
								}
								i1++;
								j1++;
							}
							if(hold == 2 && empty >=2) 
								if (value1 < 2)
									value1 = 2;
							else if(hold == 3 && empty >=1) 
								if (value1 < 7)
									value1 = 7;
							if(hold == 4) 
								if (value1 < 400)
									value1 = 400;
						}
						empty = 0;
						hold = 0;
					}
				}
					
					// check diagonals to the left
						// if 2 value is 2 and can win
						// if 3 value is 7 and can win
						// if can win 30
				for(int j = 5; j >= 0 ; j--) {
					int empty = 0;
					int hold = 0;
					for(int i = 0; i < 7; i++) {
						if(simulation.bord[j][i] == 1) { // check below
							int i1 = i;
							int j1 = j;
							while(i1 < 7 && j1 > -1) {
								if(simulation.bord[j1][i1]==1)
									hold++;
								else if(simulation.bord[j1][i1]==0)
									empty++;
								else {
									i1=10;
									j1=-1;
								}
								i1++;
								j1--;
							}
							
							i1 = i;
							j1 = j;
							
							while(i1 > -1 && j1 < 6) { //check above
								if(simulation.bord[j1][i1]==1)
									hold++;
								else if(simulation.bord[j1][i1]==0)
									empty++;
								else {
									i1=-1;
									j1=10;
								}
								i1--;
								j1++;
							}
							if(hold == 2 && empty >=2) 
								if (value1 < 2)
									value1 = 2;
							else if(hold == 3 && empty >=1) 
								if (value1 < 7)
									value1 = 7;
							if(hold == 4) 
								if (value1 < 400)
									value1 = 400;
							empty = 0;
							hold = 0;
						}
					}
				}
				
				if(value < value1)
					return -value1;
			
		return value;
	}
	
	public int move() {
		
		 return 0;
	}

}
