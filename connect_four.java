/**
 * connect for game that will relie on a GUI for displaing and 
 * input
 * @author Joshua Lucas
 *
 */
public class connect_four {

	public int bord[][];
	public int winner;
	public int spots;
	
	public connect_four() {
		bord = new int[6][7];
		winner = 0;
		spots = 0;
	}
	/**
	 * 
	 * @param player
	 * @param columb do should be normal counting not cs counting
	 * @return
	 */
	
	public Boolean insert(int player, int columb) { 
		if (columb < 1 || columb >7) {
			//throw error
		}
		if (player < 1 || player >2) {
			//throw error
		}
		
		for(int i = 0; i < 6; i++) {
			if (bord[i][columb-1] == 0) {
				bord[i][columb-1] = player;
				check_winner(i,columb-1, player);
				spots++;
				return true;
			}
		}
		return false;
	}
	
	public void check_winner(int row, int columb, int player) { // not working
		int hold = 0;
		winner = 0;
		if (row >= 3) { // 4 stacks
			for(int i = 1; i < 4; i++) {
				if (bord[row - i][columb] == player) {}
				else
					i = 20;
				if (i == 3) {
					winner = player;
					return;
				}
			}
		}
		
		for(int i = 0; i < 7; i++) { // there is some error here and i have no clue what it is -_- this is supposed to detect 4 in a row but nah it don't do that
			if(bord[row][i] == player)
				hold++;
			else
				hold = 0;
			
			if (hold == 4) {
				winner = player;
				System.out.println("why are you not working");
				return;
			}
		}
		
		int hold2 = 0;
		int k = row;
		while(k > 0) {
			++hold2;
			--k;
		}
		
		if(columb-hold2 < 4) {// will have out of bounds index error needs to be fixed.
			hold = 0;
			int j = row - hold2;
			for (int i = columb - hold2; i < 7 && i >= 0 && j < 6; i++) {
				if (bord[j][i] == player) {
					++hold;}
				else {
					
					hold = 0;}
				if (hold == 4) {
					winner = player;
					System.out.println("i am the bug!!!!!");
					return;
				}
				++j;
			}
		}

		
		if(columb+hold2 > 3) { // will have out of bounds index error needs to be fixed.
			hold = 0;
			int j = row - hold2;
			for (int i = columb + hold2; i < 7 && i >= 0 && j < 6 ; i--) {
				if (bord[j][i] == player)
					++hold;
				else
					hold = 0;
				if (hold == 4) {
					winner = player;
					return;
				}
				++j;
			}
		}
		
		
	}
	
	public void undo(int columb, int player) {
		
		for (int i = 5; i >= 0; i--) {
			if(bord[i][columb] != 0) {
				bord[i][columb] = 0;
				spots--;
				check_winner(i, columb, player);
				return;
			}
		}
	}
}
