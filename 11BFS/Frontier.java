public class Frontier{
    MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();
    int mode;

    public Frontier(int mode){
	this.mode = mode;
    }

    public Frontier(){
	mode = 0;
	//default is BFS
    }

    public void add(Coordinate coordinate){
	if(mode == 0 || mode == 1){
	    frontier.addLast(coordinate);
	    //'normal' addlast
	}
	else{
	    frontier.add(coordinate, 0);
	    //adding with priority
	}
    }

    public Coordinate removeLast(){
	return frontier.removeLast();
    }

    public Coordinate removeFirst(){
	return frontier.removeFirst();
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

    public int getMode(){
	return mode;
    }

    public static void main(String[]args){
	Coordinate c = new Coordinate(5, 5, 5);
	Frontier B = new Frontier(3);
	B.add(c);
	System.out.println(B.removeLast());
    }
}