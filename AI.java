import java.io.IOException;



// notes on the simulation AI will always be 1 and enemy will be 2

/**
 * 
 * @author Joshua Lucas
 *
 */


public class AI {
	
	int level; // how fare down the tree has expanded
	int player; // Always 2
	Tree brain; // minimax tree
	connect_four simulation; // bord used to grow minimax
	
	/**
	 *  basic contructor sets up player and initiates the trees level
	 * @param p players id
	 */
	
	public AI(int p) {
		player = p;
		level = 0;
	}
	
	/**
	 * makes the minimax tree initialy
	 * @param b the bord state of the game
	 * @return i don't know realy why this is here
	 * @throws IOException cause of errors i didn't want to check
	 */
	
	public boolean build(int[][] b) throws IOException {
		
		int height = 0; // when height is positive use max, else use min
		
		brain = new Tree();	
		brain.root.A = 1000000000; // didn't get around to setting up
		brain.root.B = -1000000000; // didn't get around to setting up
		simulation = new connect_four();
		simulation.bord = b;
		
		DFS(height+1, 0, brain.root);
		
		
		for(int i = 0; i< 7; i++)
			if(brain.root.children[i] != null)
				//System.out.println(brain.root.children[i].value +"I am a hoe lmao");
		
		//brain.root.children.get(0);
		
		return false;
		return false;
	}
	/**
	 * does dfs to find the leaf nodes then uses a heuristic to determine the values of each node
	 * @param h height of the tree
	 * @param columb column of the bord
	 * @param c current node
	 * @throws IOException
	 */
	public void DFS(int h, int columb, Tree.Node c) throws IOException{
		
		// prints the board to console is currently commented out because no longer needed
		/*for (int i = 5; i >=0 ; i--) 
		{
			for (int j = 0; j < 7; j++)
				System.out.print(simulation.bord[i][j]);
			System.out.println("");
		}
		
		System.out.println("\n");*/
		
		int current_columb = columb; 
		//System.out.println("winner : "+ simulation.winner);
		if(level < 6) // try for 6 and if you do alpha beta pruning 8
			if (simulation.winner == 0) { // this grows the tree to its limited depth
				for(int i = 0; i < 7; i++) {
					if(simulation.bord[5][i] == 0) {
						simulation.insert(h%2+1, i+1);
						
						//System.out.println("\n");
						//System.out.println(i);
						//System.out.println("\n");
						if(h%2 == 0)
							brain.insert(c, -1000000000, i); // max state
						else
							brain.insert(c, 1000000000, i); // min state
						level++;
						DFS(h+1, i, c.children[i] ); // recursive call to grow the tree
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
		// find the correct hyristic for the current spot on the tree
		if(level == 6 || simulation.spots == 6*7) { // ALSO update here when canging the leve to stop at
			c.value = hyristic();
			//System.out.println(c.value+"I am a slutttttt");
		}
		
		// compare childrens values then take the lowest or highest
		//_____________________________________________________________________________
		if (state == 0) { // if the node is a maximiser then get max child
			for(int i = 0; i < 7; i++)
				if (c.children[i] != null)
					if (c.children[i].value < c.value)
						c.value = c.children[i].value;
		}
		else { // if node is minimizer then get min child
			for(int i = 0; i < 7; i++)
				if (c.children[i] != null)
					if (c.children[i].value > c.value)
						c.value = c.children[i].value;
		}
		
		simulation.undo(current_columb, h%2+1); // remove play from bord
		//System.out.println(c.value);
		level--;
		return;
	}
	
	/**
	 * heuristic function
	 * - it looks for more than 1 in a row
	 * - more than 1 in a column
	 * - more than 1 on the diaganoal in both directions
	 * these are done for both the ai and its opponent 
	 * the lowest possible is -400 for a lose
	 * @return
	 */
	
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
					else if(hold == 4) 
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
