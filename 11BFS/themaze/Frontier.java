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

    public int returnRow(){
	return frontier.getFirst().getRow();
    }

    public int returnCol(){
	return frontier.getFirst().getCol();
    }

    public String returnFirstCoordinate(){
	return "(" + frontier.getFirst().getRow() + ", " + frontier.getFirst().getCol() + ")";
    }

    public String returnLastCoordinate(){
	return "("+frontier.getLast().getRow()+", "+frontier.getLast().getCol()+")";
    }

    public static void main(String[]args){
	Coordinate A = new Coordinate(1, 2);
	Frontier B = new Frontier();
	Coordinate C = new Coordinate(2, 3);
	B.addFirst(A);
	System.out.println(B.returnRow());
	System.out.println(B.returnFirstCoordinate());  
	B.addFirst(C);
	System.out.println(B.returnFirstCoordinate());  
	B.removeFirst();
	System.out.println(B.returnFirstCoordinate());
	B.addLast(C);
	System.out.println(B.returnLastCoordinate());
	B.addLast(A);
	System.out.println(B.returnLastCoordinate());
    }
}