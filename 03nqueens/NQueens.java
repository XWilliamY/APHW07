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
	return "last.first";
    }

    public boolean solve(){
	//starting at 0,0
	//if you try to put down a queens at (0, y)
	//or (x, 0)
	//or (x, y) where y = x
	//it's gonna go down poorly 
	//btw board[y][x] means y rows and x columns 
	//board.length is its y length 
	for(int a = 0; a < board.length; a++){
	    if(solve(a)){
		return true;
	    }
	}
	return false;
    }

    public boolean solve(int y){
	board[y][0] = '@';
	//the first queen is placed somewhere in the first row 
	//now we want to see where we can place the second queen 
	//regardless of where we put it, we know that it can't go in the first row
	//so when we call the helper function we should start with row at 1 
	boolean canPut = false; //GUILTY UNTIL PROVEN INNOCENT
	for(int i = 0; i < board[0].length; i++){ // going down the columns
	    canPut = canPut || solveH(y, 1, i);
	    //recursive part is here
	    //starting with row 1, since nothing can go in row 0 
	}
	if(canPut){
	    return true;
	}
	return false;
    }

    public boolean solveH(int y, int row, int col){
	//we just put down a queen say at 0, 0; where y = 0
	//so canPut = canPut || solveH(y, 1, i)
	//meaning we shift to the second row 
	if(row == board.length){
	    return true;
	    //this is the base case: we've reached the end
	}
	for(int a = 0; a < board.length; a++){
	    for(int b = 0; b < board[0].length; b++){
		if(!(row == a && row == b) && 
		   board[a][b] == '@' &&
		   ((Math.abs(row - a) == Math.abs(col - b)) 
		    || row == a 
		    || col == b) ){
		    return false;
		    //if row matched row 0 or coll 0, or if a queens i there, or if it 
		    //coincides with a diagonal
		    //it's false 
		}
	    }
	}
	board[row][col] = '@';
	boolean canPut = false;
	for(int i = 0; i < board[0].length;i++){
	    canPut = canPut || solveH(y, row+1, i);
	}
	if(canPut){
	    return true;
	}
	board[row][col] = '.';
	return false;
    }
    
    public static void main(String[] args){
	NQueens a = new NQueens(4);
	a.solve();
	System.out.println(a.toString());
    }
}