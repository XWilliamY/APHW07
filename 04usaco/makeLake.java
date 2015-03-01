import java.io.*;
import java.util.*;

public class makeLake{
    private int [][] lake;
    private int elevation;
    private int [][] instructions;

    public  void importFile(String fileName) throws FileNotFoundException{
	Scanner s = null;
	s = new Scanner(new BufferedReader (new FileReader(fileName)));
	//supposedly BufferedReaders read files one line at a time
	lake = new int[Integer.parseInt(s.next())][Integer.parseInt(s.next())];
	//first two integers set up row and col of lake
	elevation = Integer.parseInt(s.next());
	//third number is the target elevation
	//testing purposes: System.out.println(elevation);
	instructions = [Integer.parseInt(s.next())][3];
	//the next number describes how many instructions there are
	//set rows = the number of instructions
	//set cols = 3 (row, col, and by what number to stomp)
	for(int a = 0; a < lake.length;a++){
	    for(int b = 0; b < lake[0].length;b++){
		lake[a][b] = Integer.parseInt(s.next());
	    }
	}
	//after we previously set up the size of the lake
	//now we want to add the given values to it 
	for(int a = 0; a < instructions.length;a++){
	    for(int b = 0; b < instructions[0].length;b++){
		instructions[a][b] = Integer.parseInt(s.next());
	    }
	}
	//now we fill in the commands 
    }

    public makeLake(String fileName)throws FileNotFoundException{
	importFile(fileName);
    }

    public static void main(String[]args)throws FileNotFoundException{
	//makeLake A = new makeLake("makeLake.in");
    }





}