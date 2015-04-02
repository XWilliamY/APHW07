public class Frontier{

    MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();

    public void add(Coordinate coordinate){
	frontier.addFirst(coordinate);
    }

    public int returnRow(){
	return frontier.getFirst().getRow();
    }

    public int returnCol(){
	return frontier.getFirst().getCol();
    }

    public String returnCoordinate(){
	return "(" + frontier.getFirst().getRow() + ", " + frontier.getFirst().getCol() + ")";
    }

    public static void main(String[]args){
	Coordinate A = new Coordinate(1, 2);
	Frontier B = new Frontier();
	B.add(A);
	System.out.println(B.returnRow());
	System.out.println(B.returnCoordinate());    
    }
}