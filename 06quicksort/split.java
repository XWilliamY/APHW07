import java.util.*;

public class split{

    public void partition(int[]ary, int si, int ei){
	int [] D = new int [ary.length];
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

	for( int i = 0; i < ary.length; i++){
	    System.out.println(Arrays.toString(D));
	    if(ary[i] < pivot){
		D[si] = ary[i];
		si++;
	    }
	    else if (ary[i] > pivot){
		D[ei] = ary[i];
		ei--;
	    }
	}

	System.out.println(pivot);
	ri = si;
	while(si <= ei){
	    D[si] = pivot;
	    si++;
	}

	System.out.println(Arrays.toString(D));
    }

    public split(){
	int [] ary = new int[10];
	for(int i = 0 ; i < ary.length; i++){
	    ary[i] = 10-i;
	}

	partition(ary, 0, ary.length-1);
    }

    public static void main(String[]args){
	split A = new split();
    }
}