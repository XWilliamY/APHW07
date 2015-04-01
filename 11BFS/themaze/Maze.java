public class Maze{
    private char [][] ary = new char [10][10];

    public class Frontier{
	MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();
	public class Coordinate{
	    private int row, col;
	    public void setRow(int row){
		this.row = row;
	    }
	    public void setCol(int col){
		this.col = col;
	    }
	    public int getRow(){
		return row;
	    }
	    public int getCol(){
		return col;
	    }
	}
    
}