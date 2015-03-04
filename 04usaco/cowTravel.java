import java.util.*;
import java.io.*;

public class cowTravel{

    private char [][] pasture;
    private int T, r1, c1, r2, c2;

    public void importFile(String fileName) throws FileNotFoundException{
	Scanner s = null;
	s = new Scanner(new BufferedReader(new FileReader(fileName)));
	pasture = new char [Integer.parseInt(s.next())][Integer.parseInt(s.next())];
	T = Integer.parseInt(s.next());
	for(int a = 0; a < pasture.length; a++){
	    String c = s.next();
	    for(int b = 0; b < pasture[0].length; b++){
		pasture[a][b] = c.charAt(b);
		//c.charAt(b), not c.charAt(0)
	    }
	}
	r1 = Integer.parseInt(s.next())-1;
	c1 = Integer.parseInt(s.next())-1;
	r2 = Integer.parseInt(s.next())-1;
	c2 = Integer.parseInt(s.next())-1;
	//System.out.println("" + pasture.length + pasture[0].length + T + this + r1 + c1 + r2 + c2);
	
	//System.out.println(this);
    }
 
    public String toString(){ 
	String ans = "";
	for(int a = 0; a < pasture.length; a++){
	    for(int b = 0; b < pasture[0].length; b++){
		ans += "" + pasture[a][b];
	    }
	    ans += "\n";
	}
	return ans;
    }

    public int go(int startx, int starty){
	return goGo(startx, starty, T);
    }

    public int goGo(int startx, int starty, int newT){
	
	//check if in range
	if(startx < 0 ||
	   startx >= pasture.length ||
	   starty < 0 ||
	   starty >= pasture[0].length){
	    return 0;
	}

	//check if you have arrived at destination 
	if(newT == T && (startx != r2 || starty != c2)){
	    return 0;
	}

	if(newT == T && (startx == r2 || starty == c2)){
	    return 1;
	}

	//check if you're on 'forbidden space' 
	if(pasture[startx][starty] == '*'){
	    return 0;
	}
	
	//recursion happens here 
	return goGo(startx+1, starty, newT+1) 
	    +goGo(startx, starty+1, newT+1)
	    +goGo(startx-1, starty+1, newT+1)
	    +goGo(startx, starty-1, newT+1);
    }


    public cowTravel(String fileName) throws FileNotFoundException{
	importFile(fileName);
	System.out.println(go(r1, c1));
    }

    public static void main(String[]args)throws FileNotFoundException{
	//parse the file and import all information
	//the cow will travel up down left or right 
	//when the time is up, check to see if it's at the right position
	//if it is at the right position...
	//hmm how would you do the rest from here? 
	cowTravel A = new cowTravel("ctravel.in");
    }
}
