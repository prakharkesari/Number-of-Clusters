import java.util.*; 

class NumberOfClusters { 
	static int ROW , COL; 

	
	boolean check(int M[][], int i, int j, 
				boolean visited[][]) 
	{ 
		
		
		return (i >= 0) && (i < ROW) && (j >= 0) && (j < COL) && (M[i][j] == 1 && !visited[i][j]); 
	} 

	
	void DFS(int M[][], int row, int col, boolean visited[][]) 
	{ 

		int rowTraverse[] = new int[] { -1, 0, 0, 1 }; 
		int colTraverse[] = new int[] {  0, -1, +1, 0 }; 

		visited[row][col] = true; 

		for (int k = 0; k < 4; ++k) 
			if (check(M, row + rowTraverse[k], col + colTraverse[k], visited)) 
			{
				DFS(M, row + rowTraverse[k], col + colTraverse[k], visited); 
			} 
	}
	
	int getNumberOfClusters(int arr[][]) 
	{ 
		
		boolean visited[][] = new boolean[ROW][COL]; 

		
		int count = 0; 
		for (int i = 0; i < ROW; ++i) 
			for (int j = 0; j < COL; ++j) 
				if (arr[i][j] == 1 && !visited[i][j]) // If a cell with 
				{ 
					++count;
					DFS(arr, i, j, visited); 
					 
				} 

		return count; 
	} 

	public static void main(String[] args) throws java.lang.Exception 
	{ 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns");
		ROW = sc.nextInt();
		COL = sc.nextInt();
		int matrix[][] = new int[ROW][COL];
		System.out.println("Enter the array in 1 and 0");
		for(int i = 0; i< ROW; i++)
		{
			for (int j = 0; j < COL; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i< ROW; i++)
		{
			for (int j = 0; j < COL; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		NumberOfClusters I = new NumberOfClusters(); 
		System.out.println("Number of Clusters: " + I.getNumberOfClusters(matrix)); 
	} 
}