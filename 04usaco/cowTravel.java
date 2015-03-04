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
	    for(int b = 0; b < pasture[0].length; b++){
		pasture[a][b] = (char)(s.next());
	    }
	}
	r1 = Integer.parseInt(s.next())-1;
	c1 = Integer.parseInt(s.next())-1;
	r2 = Integer.parseInt(s.next())-1;
	c2 = Integer.parseInt(s.next())-1;
	System.out.println(r1);
    }

    public cowTravel(String fileName) throws FileNotFoundException{
	importFile(fileName);
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
