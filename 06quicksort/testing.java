import java.util.*;

public class testing{

    public static void partition(int ary[]){
	int si = 0;
	int ei = ary.length-1;
	int intati;
	int intatsi;
	int intatei;
	Random rand = new Random();
	int pivot = ary[1];

	System.out.println(pivot);
	for(int i = 0 ; i < ary.length; i ++){
	    System.out.println(Arrays.toString(ary));
	    if(ary[i] < pivot){
		intati = ary[i];
		intatsi = ary[si]; 
		ary[si] = intati;
		ary[i] = intatsi;
		System.out.println("intati: " + intati + " intatsi: " + intatsi + " si :" + si + " i: " + i);
		si++;
	    }
	    else if(ary[i] > pivot){
		intati = ary[i]; //intati = 10
		intatei = ary[ei]; //intatei = 1
		ary[ei] = intati;
		ary[i] = intatei;
		System.out.println("intati: " + intati +  " intatei: " + intatei + " ei: " + ei + " i: " + i);
		ei--;
	    }
	}
	System.out.println(si);
	System.out.println(ei);
	//ary[ei] = pivot;
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



