public class Maze{
    private char [][] ary = new char [10][10];

    public class Frontier{
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
	public Frontier(){
	    MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();	    
	    //if valid, make a coordinate and then add it to frontier
	    for(int i = 0; i < ary.length; i++){
		for(int a = 0; a < ary[0].length;a++){
		    Coordinate A = new Coordinate();
		    A.setRow(i);
		    A.setCol(a);
		}
		frontier.addFirst(A);
	    }
	}
    }
}