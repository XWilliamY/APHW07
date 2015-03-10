import java.util.*;
public class Driver{

    public static void main(String[]args){
	Random rand = new Random();
	int [] A = new int[1000000];
	for(int a = 0; a < A.length; a++){
	    A[a] = -1 * (rand.nextInt(100)) + rand.nextInt(100);
	}
	merge(A);
	System.out.println(Arrays.toString(A));
    }
}