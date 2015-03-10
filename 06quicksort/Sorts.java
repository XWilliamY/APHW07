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
	Random rand = new Random();
	int pivot = si + rand.nextInt(ei - si + 1); //random pivot
	//System.out.println(pivot);
	swap(ary, ei, pivot); //swap pivot with the end value
	for(int i = si; i < ei; i++){
	    //System.out.println(Arrays.toString(ary));
	    if(ary[i] < ary[ei]){ //if something is smaller than the pivot
		swap(ary, i, si); //send it to the beginning
		si++;
	    }
	}
	swap(ary, si, ei); //swap si and ei 
	return si;
    }

    public static void swap(int [] ary, int orig, int newer){
	int temp = ary[orig];
	ary[orig] = ary [ newer];
	ary [newer] = temp;
    }

    public static void main(String[]args){
	Random rand = new Random();
	int [] A = new int[10];
	for(int i = 0; i < A.length;i++){
	    A[i] = rand.nextInt(A.length);
	}
	quickSort(A);
	System.out.println(Arrays.toString(A));
    }
}


