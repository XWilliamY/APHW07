public class Frontier{

    MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();

    public void addFirst(Coordinate coordinate){
	frontier.addFirst(coordinate);
    }

    public void removeFirst(){
	frontier.removeFirst();
    }

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

    public static void main(String[]args){
	Frontier A = new Frontier();
	for(int i = 0; i < 10; i++){
	    A.addFirst(new Coordinate(5, 5));
	}
	System.out.println(A.getFirstCoordinate());
    }
}