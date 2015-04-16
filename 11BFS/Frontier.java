public class Frontier{
    MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();
    int mode;

    public Frontier(int mode){
	this.mode = mode;
    }

    public void add(Coordinate coordinate){
	frontier.addLast(coordinate);
    }

    public void remove(Coordinate coordinate){
	if(mode == 0){
	    //mode == 0 is bfs
	    frontier.removeFirst();
	}
	if(mode == 1){
	    //mode == 1 is dfs
	    frontier.removeFirst();
	}
    }

    public int returnFirstRow(){
	return frontier.getFirst().getRow();
    }

    public int returnFirstCol(){
	return frontier.getFirst().getCol();
    }

    public int returnLastRow(){
	return frontier.getLast().getRow();
    }

    public int returnLastCol(){
	return frontier.getLast().getCol();
    }

    public String getFirstCoordinate(){
	return "(" + frontier.getFirst().getRow() + ", " + frontier.getFirst().getCol() + ")";
    }

    public String getLastCoordinate(){
	return "("+frontier.getLast().getRow()+", "+frontier.getLast().getCol()+")";
    }

    public int getSize(){
	return frontier.getSize();
    }

    public static void main(String[]args){
	Coordinate A = new Coordinate(5, 5);
	Frontier B = new Frontier(0);
	B.add(A);
	System.out.println(B.remove());
    }
}