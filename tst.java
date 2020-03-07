
public class tst {

	public static void main(String[] args) {
		conect_four test = new conect_four();
		test.insert(1, 7);
		test.insert(1, 5);
		test.insert(1, 6);
		test.insert(2, 4);
		test.insert(2, 5);
		test.insert(1, 6);
		test.insert(2, 6);
		test.insert(1, 7);
		test.insert(1, 7);
		test.insert(2, 7);
		
		for (int i = 5; i >=0 ; i--)
		{
			for (int j = 0; j < 7; j++)
				System.out.print(test.bord[i][j]);
			System.out.println("");
		}
		System.out.println(test.winner);
		
	}

}
