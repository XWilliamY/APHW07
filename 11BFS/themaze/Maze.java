import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private int maxx, maxy;
    private int startx, starty;
    private int endx, endy;
    private Frontier frontier = new Frontier();
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    public String name(){
	return "yang.william";
    }

    public Maze(String filename){
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " not found.");
	    e.printStackTrace();
	    System.exit(0);
	}

	//copy from the single string to a 2D array
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	    if(c == 'E'){
		endx = i % maxx;
		endy = i / maxx;
	    }
	}
    }

    public String toString(){
	//do not do the funky character codes, this is used for non-animated printing
	//it is just the string representation of the maze (before or after solving)
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += c;
	    }else{
		ans += c;
	    }
	}
	return ans;
   }

    public String toString(boolean animate){
	if(animate){
	    return clear + go(0, 0) + toString() + "\n" + show;
	}
	else{
	    return toString();
	}
    }

    private String go(int x, int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    public boolean solveDFS(boolean animate){
	return true;
    }

    public boolean solveBFS(boolean animate){
	//start at startx, starty
	//store value in frontier deque
	int count = 0;
	frontier.addLast(new Coordinate(startx, starty, count+1));
	//if we're using a deque the point is to be able to access only one value
	//and modify other stuff based on that value
	while(frontier.getSize() != 0){
	    if(animate){
		System.out.println(this.toString(true));
		wait(30);
	    }
	    //since we've made the while loop such that it would end
	    //once size reaches zero, we're going to add and remove to the end
	    //of the deque and call for the Coordinate's info from there
	    Coordinate A = frontier.removeFirst();
	    int x = A.getRow();
	    int y = A.getCol();
	    
	    int[][] possibilities = {
		//up
		{x, y+1},
		//down
		{x, y-1},
		//left
		{x-1, y},
		//right
		{x+1, y}
	    };
	    //use the specialized for loop thingy 
	    for(int[] possibility : possibilities){
		//if reached solution
		if(maze[possibility[0]][possibility[1]] == 'E'){
		    //we haven't marked the coordinate we were on before
		    maze[x][y] = 'x';
		    //mark its count somehow 
		    //mark the count of maze[p0][1]
		    //add the new coordinate to the solution as well
		    return true;
		}
		if(maze[possibility[0]][possibility[1]] == ' '){
		    //mark its count somehow
		    //we'll put this new coordinate in the frontier
		    //since we just discovered it
		    count++;
		    frontier.addLast(new Coordinate(possibility[0], possibility[1], count));
		    maze[x][y] = 'x';
		}
	    }
	}
	return false;
    }

    public static void main(String[]args){
	Maze A = new Maze("data1.dat");
	System.out.println(A.solveBFS(true));
    }
}
    