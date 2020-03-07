
public class AI {
	
	int player;
	Tree brain;
	connect_four simulation;
	
	public AI(int p) {
		player = p;
	}
	
	public boolean build() {
		
		int height = 0; // when height is positive use max, else use min
		
		brain = new Tree();	
		brain.root.A = 1000000000;
		brain.root.B = -1000000000;
		
		DFS(height+1, 0, brain.root);
		
		brain.root.children.get(0);
		
		return false;
	}
	
	public void DFS(int h, int columb, Tree.Node c){
		
		for (int i = 5; i >=0 ; i--)
		{
			for (int j = 0; j < 7; j++)
				System.out.print(simulation.bord[i][j]);
			System.out.println("");
		}
		
		int current_columb = columb;
		for(int i = 0; i < 7; i++) {
			if(simulation.bord[5][i] == 0) {
				simulation.insert(h%2+1, i);
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
		if(simulation.winner != 0) {
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
			return;
		}
		else if(simulation.spots == 6*7) { // if board is full aka a draw
			c.value = 0;
			return;
		}
		
		// compare childrens values then take the lowest or highest
		//_____________________________________________________________________________
		if (state == 0) {
			for(int i = 0; i < 7; i++)
				if (c.children.get(i).value > c.value)
					c.value = c.children.get(i).value;
		}
		else {
			for(int i = 0; i < 7; i++)
				if (c.children.get(i).value < c.value)
					c.value = c.children.get(i).value;
		}
		
		simulation.undo(current_columb);
		return;
	}
	
	public int move() {
		
		return 0;
	}

}
