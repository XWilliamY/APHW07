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

    public boolean solveBFS(boolean animate){
	return true;
    }

    public boolean solveDFS(boolean animate){
	//start at startx, starty
	//store value in frontier deque
	frontier.addLast(new Coordinate(startx, starty, 1));
	//get coordinates
	int x = frontier.returnLastRow();
	int y = frontier.returnLastCol();
	//loop here
	while(x != endx && y != endy){
	    if(animate){
		System.out.println(this.toString(true));
		wait(20);
	    }
	    if(maze[x][y] == ' '){
maze[x][y]
	}
	maze[x][y] = 'x';
	//from there, go to each of the four possible directions and see which is possible
	//maybe we can create a new int array of four
	//and then we can use that specialized for loop
	//if we're at the solution, return an array of directions to the solution
	//empty the board if necessary
	//otherwise store the new coordinate in frontier with its count
	//mark the place 
	return true;
    }
}