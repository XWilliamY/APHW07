import java.util.*;

public class testing{

    public static void swap(int[]ary, int org, int n){
	//org = original
	//n = new

	int temp = ary[org];
	ary[org] = ary[n];
	ary[n] = temp;
    }

    public static void partition(int ary[]){
	int si = 0;
	int ei = ary.length-1;
	System.out.println(ary.length);
	Random rand = new Random();
	int pivot = ary[2];

	for(int i = 0; i < ary.length; i++){
	    System.out.println(Arrays.toString(ary));
	    if(ary[i] < pivot){
		swap(ary, si, i);
		si++;
		System.out.println(si);
	    }
	    if(ary[i] > pivot){
		swap(ary, ei, i);
		ei--;
		i--;
		System.out.println(ei);
	    }
	    System.out.println(i);
	}

	System.out.println("si " + si + " ei " + ei);
	ary[si] = pivot;
	System.out.println(Arrays.toString(ary));
    }

    public testing(){
	int [] ary = new int[10];
	for(int i = 0; i < ary.length; i++){
	    ary[i] = 10-i;
	}

	partition(ary);
    }

    public static void main(String[]args){
	testing A = new testing();
    }
}



