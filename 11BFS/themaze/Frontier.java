public class Frontier{

    MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();

    //addFirst is stack
    public void addFirst(Coordinate coordinate){
	frontier.addFirst(coordinate);
    }

    public void removeFirst(){
	frontier.removeFirst();
    }

    //addLast is queue?
    public void addLast(Coordinate coordinate){
	frontier.addLast(coordinate);
    }

    public void removeLast(){
	frontier.removeLast();
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
	Frontier frontier = new Frontier();
	frontier.addLast(new Coordinate(5, 5, 1));
	System.out.println(frontier.removeFirst());
    }

}