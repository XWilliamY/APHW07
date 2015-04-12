public class Frontier{

    MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();

    //addFirst is stack
    public void addFirst(Coordinate coordinate){
	frontier.addFirst(coordinate);
    }

    public Coordinate removeFirst(){
	return frontier.removeFirst();
    }

    //addLast is queue?
    public void addLast(Coordinate coordinate){
	frontier.addLast(coordinate);
    }

    public Coordinate removeLast(){
	return frontier.removeLast();
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
	Coordinate A = new Coordinate(5, 5, 1);
	Frontier frontier = new Frontier();
	frontier.addFirst(A);
	System.out.println(frontier.getSize());
	System.out.println(frontier.removeLast());
    }
}