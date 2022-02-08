package BackTracking;

public class KnightMoves {

	
	public static void printKnigtMoves(int [][] chess , int r , int c , int moves)
	{
		if(r<0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] > 0)
		{
			return;
		}
		else if(moves == chess.length*chess[0].length)
		{
			chess[r][c] = moves;
			// display
			chess[r][c] = 0;
			return;
			
		}
		
		chess[r][c] = 1;
		printKnigtMoves(chess, r-1, c-2, moves+1);
		printKnigtMoves(chess, r-1, c+2, moves+1);
		printKnigtMoves(chess, r-2, c-1, moves+1);
		printKnigtMoves(chess, r-2, c+1, moves+1);
		printKnigtMoves(chess, r+1, c-2, moves+1);
		printKnigtMoves(chess, r+1, c+2, moves+1);
		printKnigtMoves(chess, r+2, c-1, moves+1);
		printKnigtMoves(chess, r+2, c+1, moves+1);
		chess[r][c] = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] [] chess = new int[5][5];
		
	}

}
