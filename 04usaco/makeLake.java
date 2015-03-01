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
	instructions = new int [Integer.parseInt(s.next())][3];
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

    public String toString(){
	String ans = "";
	for(int a=0;a<lake.length;a++){
	    for(int b=0;b<lake[0].length;b++){
		ans += lake[a][b] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public int getAnswer(){
	int total = 0;
	for(int a=0;a<lake.length;a++){
	    for(int b=0; b< lake[0].length;b++){
		if(lake[a][b] < elevation){
		    total += (elevation - lake[a][b]);
		}
	    }
	}
	return total * 72 * 72;
    }

    public int cowStomp(){
	//we read the instructions first
	//we'll start from lake[row][col]
	//third number will tell us how much to stomp
	//we'll go throw the affected parts of the land first
	//we'll go down three rows and right three cols 
	//and try to document the largest value 
	//the target value = largest value - stomp-digging
	//numbers that meet or are less than the target value will be unchanged
	for(int i = 0; i < instructions.length;i++){
	    int max = 0;
	    int desired = 0;
	    //int max belongs under this for since for each instruction
	    //the max will differ due to location
	    //in order to figure out where we'll start the cowstomping we need this
	    //eg: if given instructions [1, 4, 4], [1, 1, 10]
	    //when i =0, we know row = 1
	    //when i = 2, we know row = 1 ... hm, not the best examples
	    for(int a = instructions[i][0]; a < instructions[i][0] + 3; a++){
		//shift down by 1 three times
		for(int b = instructions[i][1]; b < instructions[i][1] + 3;b++){
		    //shift to the right by 1 three time
		    if(lake[a-1][b-1] > max){//substracting one since
			//they start counting at row 1 and col 1 but 
			//is actually row 0 col 0 
			max = lake[a-1][b-1];
		    }
		}
	    }
	    //now we have "the largest number" part down 
	    desired = max - instructions[i][2];
	    for(int a = instructions[i][0]; a < instructions[i][0] + 3;a++){
		for(int b = instructions[i][1]; b < instructions[i][1] + 3; b++){
		    if(lake[a-1][b-1] > desired){
			lake[a-1][b-1] = desired;
		    }
		}
	    }
	}
	return getAnswer();
	//okay we got the "find the largest number" part down
	//note that you shouldn't create a desired value here
	//since the desired value will change based on what the cow-stomping magnitude is 
    }



    public makeLake(String fileName)throws FileNotFoundException{
	importFile(fileName);
    }

    public static void main(String[]args)throws FileNotFoundException{
	makeLake A = new makeLake("makeLake.in");
	System.out.println(A);
	System.out.println(A.cowStomp());
	System.out.println(A);
    }





}