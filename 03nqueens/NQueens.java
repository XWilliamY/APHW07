public class NQueens{

    private char [][] board;

    public NQueens(int size){
	board = new char [size][size];
	//the way NQueens works is a lot like a maze in that
	//once you set a Queen, there are certain spaces you can and cannot fill
	//subsequently, we should document this change
	//the best way to do so would be to fill in the board
	//and as we lay down queens edit the characters in them
	//so as to signify which spaces can and cannot be used 
	for(int a = 0; a < board.length; a++){
	    for(int b = 0; b < board[0].length; b++){
		board[a][b] = '.';
	    }
	}
    }

    public String toString(){
	String ans = "";
	for(int a = 0; a < board.length; a++){
	    for(int b = 0; b < board[0].length; b++){
		ans += board[a][b] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public String name(){
	return "yang.william";
    }

    public boolean solve(){
	//starting at 0,0
	//if you try to put down a queens at (0, y)
	//or (x, 0)
	//or (x, y) where y = x
	//it's gonna go down poorly 
	//btw board[y][x] means y rows and x columns 
	//board.length is its y length 
	for(int i = 0; i < board[0].length; i++){
	    if(solve(i)){
		return true;
	    }
	}
	return false;
    }

    public boolean solve(int y){
	board[y][0] = '@';
	//the first '@' will most likely be placed at 0, 0
	//we can automatically assume that the first row or column can not have
	//any values 
	//note that it's [row][col] 
	//we want to check if board[y][0] = '@' is valid or not 
	boolean canPut = false;
	//GUILTY UNTIL PROVEN INNOCENT 
	for(int a = 0; a < board[0].length; a++){
	    //we're going down the columns
	    //it makes sense that no '@' can be put at the same row as this one
	    //but queens can certainly be placed at other locations
	    //at the same column
	    canPut = canPut || solveH(y, a, 1);
	}
	if(canPut){
	    return true;
	}
	board[y][0] = '.';
	return false;
    }

    public boolean solveH(int y, int row, int col){
	if(col == board[0].length){
	    return true;
	}
	for(int a = 0; a < board.length; a++){
	    for(int b = 0; b < board[0].length; b++){
		if( !(row == a &&
		      row == b) && 
		    board[a][b] == '@' &&
		    ((Math.abs(row - a) == Math.abs(col - b)) 
		     || row == a
		     || col == b) ){
		    //all curricula the point cannot meet if it wishes
		    //to be a queen
		    return false;
		}
	    }
	}
	board[row][col] = '@';
	boolean canPutHere = false;
	for(int i = 0; i < board[0].length; i++){
	    canPutHere = canPutHere || solveH(y, i, col +1);
	}
	if(canPutHere){
	    return true;
	}
	board[row][col] = '.';
	return false;
    }

  

    public static void main(String[] args){
	NQueens t = new NQueens(10);
	System.out.println(t.name());
	System.out.println("NQueens:");
	t.solve(3);
	System.out.println(t);

    }
}


