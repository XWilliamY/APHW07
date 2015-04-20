import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private int maxx, maxy;
    private int startx, starty;
    private int endx, endy;
    private int solutionx, solutiony;
    private int[][] solutionSet;
    private int[] solution;
    private int finalCount;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private final int bfs = 0;
    private final int dfs = 1;
    private final int best = 2;
    private final int astar = 3;

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
	solutionSet = new int[maze.length][maze[0].length];
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

    public int getDistance(int x, int y){
	return Math.abs(x-endx) + Math.abs(y-endy);
    }


    public boolean solveBFS(){
	return solveMaze(bfs, false);
    }

    public boolean solveDFS(){
	return solveMaze(dfs, false);
    }

    public boolean solveBest(){
	return solveMaze(best, false);
    }

    public boolean solveAStar(){
	return solveMaze(astar, false);
    }

    public boolean solveBFS(boolean animate){
	return solveMaze(bfs, animate);
    }

    public boolean solveDFS(boolean animate){
	return solveMaze(dfs, animate);
    }

    public boolean solveBest(boolean animate){
	return solveMaze(best, animate);
    }

    public boolean solveAStar(boolean animate){
	return solveMaze(astar, animate);
    }
		 
    public boolean solveMaze(int mode, boolean animate){
	//start at startx, starty
	//store value in frontier deque
	Frontier frontier = new Frontier(mode);
	if(mode == bfs || mode == dfs){
	    frontier.add(new Coordinate(startx, starty, 1));
	}
	else{
	    frontier.add(new Coordinate(startx, starty, 1), 0);
	}
	//frontier.add() should take care of the rest
	while(frontier.getSize() != 0){
	    if(animate){
		System.out.println(this.toString(true));
		wait(20);
	    }
	    Coordinate A = new Coordinate(0, 0, 2);
	    if(mode == bfs){
		A = frontier.removeFirst();
	    }
	    else if(mode == dfs){
		A = frontier.removeLast();
	    }
	    else if(mode == best || mode == astar){
		A = frontier.remove();
	    }
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
		    maze[x][y] = 'x';
		    solutionSet[x][y] = A.getCount(); //since it's the prev one
		    solutionSet[possibility[0]][possibility[1]]=A.getCount()+1;
		    solutionx = possibility[0];
		    solutiony = possibility[1];
		    finalCount = A.getCount()+1;
		    solve(solutionx, solutiony, finalCount);
		    return true;
		}
		if(maze[possibility[0]][possibility[1]] == ' '){
		    solutionSet[x][y] = A.getCount();
		    if(mode == bfs || mode == dfs){
			frontier.add(new Coordinate(possibility[0],possibility[1],A.getCount()+1));
		    }
		    else if(mode == best){
			frontier.add(new Coordinate(possibility[0], possibility[1], A.getCount()+1), (getDistance(possibility[0], possibility[1])));
		    }
		    else if (mode == astar){
			frontier.add(new Coordinate(possibility[0], possibility[1], A.getCount()+1), getDistance(possibility[0], possibility[1]) + A.getCount()+1);
		    }		     
		    maze[x][y] = 'x';
		}
	    }
	}
	return false;
    }

    public void empty(){
	for(int i = 0; i < maze.length; i++){
	    for(int a = 0; a < maze[i].length; a++){
		if(i == startx && a == starty){
		    maze[i][a] = 'S';
		}
		if(maze[i][a] == 'x'){
		    maze[i][a] = ' ';
		}
	    }
	}
    }

    /*
    public String lookAtSolutionSet(){
	String ans = "";
	for(int a = 0; a < solutionSet.length; a++){
	    for(int b = 0; b < solutionSet[a].length; b++){
		ans += solutionSet[a][b]+ " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
    */

    public void solve(int x, int y, int finalCount){
	//retracing our steps should be similar to how we found the solution
	//but instead of checking if empty or 'E', we're checking to see if the
	//count of the new location is one less than the one we're on right now 
	solution = new int[finalCount*2+2];
	//finalCount * 2 since it's a single dimensional array 
	//meaning we have to store x, y separately 
	solution[solution.length-1] = y;
	solution[solution.length-2] = x;
	//the last two will be the coordinate right before the end 
	int halfacoordinate = solution.length -3;
	while(halfacoordinate > 0){
	    int[][]possibilities = {
		{x, y+1},
		{x, y-1},
		{x+1, y},
		{x-1, y}
	    };
	    for(int[]possibility : possibilities){
		//if it qualifies, we add it to solution 
		if(solutionSet[possibility[0]][possibility[1]] == finalCount-1){
		    //finalCount - 1 since we're technically looking at the last coordinate
		    //before the last coordinate 
		    solution[halfacoordinate] = possibility[1];
		    halfacoordinate--;
		    solution[halfacoordinate] = possibility[0];
		    maze[possibility[0]][possibility[1]] = 'P';
		    x = possibility[0];
		    y = possibility[1];
		    halfacoordinate --;
		    finalCount--;
		}
	    }
	}
    }

    public int[] solutionCoordinates(){
	int [] actualSolution = new int [finalCount*2];
	for(int i = 0; i < actualSolution.length; i++){
	    actualSolution[i] = solution[i+2];
	}
	return actualSolution;
    }

    public static void main(String[]args){
	Maze A = new Maze("data3.dat");
	System.out.println(A.solveBFS(true));
	A.empty();
	//System.out.println(A.lookAtSolutionSet());
	System.out.println(Arrays.toString(A.solutionCoordinates()));
	Maze B = new Maze("data2.dat");
	System.out.println(B.solveDFS(false));
	B.empty();
	System.out.println(Arrays.toString(B.solutionCoordinates()));
    }			  
}