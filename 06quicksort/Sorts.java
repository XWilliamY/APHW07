import java.util.*;

public class Sorts{

    public static void quickSort(int[]ary){
	//make a call to partition 
	quickSort(ary, 0, ary.length-1);
    }

    public static void quickSort(int[]ary, int si, int ei){
	if(si < ei){
	    int pi = partition(ary, si, ei);
	    //boundary will be the pivot point
	    //being either the lesser or greater limit 
	    quickSort(ary, si, pi-1); //the left side
	    quickSort(ary, pi + 1, ei); // the right side
	}
    }

    public static int partition(int[]ary, int si, int ei){
	int[] D = new int [ary.length];
	int start = si;
	int end = ei;
	Random rand = new Random();
	
	for(int a = 0; a < D.length; a++){
	    if(a < si || a > ei){
		D[a] = ary[a];
	    }
	}
	
	int ri = si + (rand.nextInt(ei-si+1));
	int pivot = ary[ri];
	
	for(int i = start; i < end;i++){
	    if(ary[i] < pivot){
		D[si] = ary[i];
		si++;
	    }
	    else if (ary[i] > pivot){
		D[ei] = ary[i];
		ei--;
	    }
	}
	
	ri = si;
	int pivotpoint = ri;
	while(si <= ei){
	    D[si] = pivot;
	    si++;
	}

	return pivotpoint;
    }

    public static void main(String[]args){
	int [] A = {0, 13, 7, 21, 69, 41, 410, 123, 231};
	quickSort(A);
	System.out.println(Arrays.toString(A));
    }
}


