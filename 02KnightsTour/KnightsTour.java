import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    public String name(){
	return "yang.william";
    }

    public void clearTerminal(){
	System.out.println(clear);
    }

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	for(int i=0;i < board.length;i++){
	    for(int a = 0; a < board[i].length;a++){
		if(board[i][a] <= 10){
		    ans += "  " + board[i][a];
		}
		else{
		    ans += " " + board[i][a];
		}
	    }
	    ans += "\n";
	}
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int [size][size];	
    }

    

    public boolean solve(){
	return solve(0, 0);		
    }


    public boolean solve(int x, int y){
	return solve(x, y, 1);
    }



		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	//cases:
	//are you out of range?
	//if board is 0, replace with currentMoveNumber
	//if the current number is at max number then you're done 

	if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
	    return false;
	}//if out of range

	if(currentMoveNumber == board.length * board[0].length + 1){
	    System.out.println("Completed!");
	    return true;
	}

	if(board[x][y] == 0){
	    board[x][y] = currentMoveNumber;
	    if(solve(x+2,y+1,currentMoveNumber+1)
	       ||
	       solve(x+2,y-1,currentMoveNumber+1)
	       ||
	       solve(x-2,y+1,currentMoveNumber+1)
	       ||
	       solve(x-2,y-1,currentMoveNumber+1)
	       ||
	       solve(x+1,y+2,currentMoveNumber+1)
	       ||
	       solve(x+1,y+2,currentMoveNumber+1)
	       ||
	       solve(x-1,y+2,currentMoveNumber+1)
	       ||
	       solve(x-1,y-2,currentMoveNumber+1)
	       ){
		return true;
	    }
	}
	return false; //which means you didn't have to do anything 

    }

    public static void main(String[]args){
	KnightsTour a = new KnightsTour(5);
	a.clearTerminal();
	a.solve();
    }
}