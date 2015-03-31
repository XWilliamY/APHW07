import java.util.*;

public class Maze{

    public class Coordinate{
	private int x, y;
	public Coordinate(int x, int y){
	    this.x = x;
	    this.y = y;
	}
    }

    MyDeque<Coordinate> ListOfCoordinates = new MyDeque<Coordinate>();
    
}