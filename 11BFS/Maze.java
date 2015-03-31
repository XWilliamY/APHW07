import java.util.*;

public class Maze{

    public class Coordinate{
	private int x, y;
	public Coordinate(int x, int y){
	    this.x = x;
	    this.y = y;
	}
	public int getX(){
	    return x;
	}
	public int getY(){
	    return y;
	}
    }

    public static void main(String[]args){

    private MyDeque<Coordinate> ListofCoordinates = new MyDeque<Coordinate>();
    
    
Coordinate A = new Coordinate(5, 10);    
    System.out.println(A.getX());
    System.out.println(A.getY());
    //ListofCoordinates.addFirst(A);
    //System.out.println(ListofCoordinates.getFirst().getX());
}