public class Maze{
    private char [][] ary = new char [10][10];

    public Maze(){
	Frontier A = new Frontier();
	for(int row = 0; row < ary.length;row++){
	    for(int col = 0; col < ary[row].length;col++){
		A.addLast(new Coordinate(row, col));
	    }
	}
	System.out.println(A.getLastCoordinate());
    }

    public static void main(String[]args){
	Maze A = new Maze();
    }

}