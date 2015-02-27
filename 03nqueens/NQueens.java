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
	//the first queen will be put down at zero
	//we'll cycle through the board to see where we can put others
	board[0][0] = '@';
	//block off the other parts 
	for(int a = 0; a < board.length; a++){
	    if(!(board[a][0] == '@')){
		board[a][0] = 'i';
	    }
	    for(int b = 0; b < board[0].length;b++){
		if(!(board[0][b] == '@')){
		    board[0][b] = 'i';
		}
	    }
	}
	return true;
    }

    
    public static void main(String[] args){
	NQueens a = new NQueens(10);
	a.solve();
	System.out.println(a.toString());
    }
}