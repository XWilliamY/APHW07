public class Maze{
    private char [][] ary = new char [10][10];

    public Maze(){
	ary[0][0] = 'x';
	Frontier A = new Frontier();
	for(int row = 0; row < ary.length;row++){
	    for(int col = 0; col < ary[row].length;col++){
		if(ary[row][col] != 'x'){		
		    A.addLast(new Coordinate(row, col));
		    System.out.println(A.getLastCoordinate());
		}
	    }
	}
	System.out.println(A.getFirstCoordinate());
    }

    public static void main(String[]args){
	Maze A = new Maze();
    }

}