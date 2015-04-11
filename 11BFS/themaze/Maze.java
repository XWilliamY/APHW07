import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private int maxx, maxy;
    private int startx, starty;
    private Frontier frontier = new Frontier();

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
	}
    }
    /*  private char [][] ary = new char [10][10];


    public Maze(){
	ary[0][0] = 'x';
	Frontier A = new Frontier();
	for(int row = 0; row < ary.length;row++){
	    for(int col = 0; col < ary[row].length;col++){
		if(ary[row][col] != 'x'){		
		    A.addLast(new Coordinate(row, col));
		    System.out.println(A.getLastCoordinate());
		}
	    }
	}
	System.out.println(A.getFirstCoordinate());
    }

    public static void main(String[]args){
	Maze A = new Maze();
	}*/

}