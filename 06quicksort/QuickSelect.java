import java.util.*;

public class QuickSelect{

    public static int quickSelect(int ary[], int n){
	//0 1 2 3 4 5 6 7 8 9
	//randomly pick index 5
	//if it is return the int else nope keep going
	//so the index has to match the pivot point 

	Random rand = new Random();

	int ri = rand.nextInt(ary.length); //index to get pivot point
	int pivot = ary[ri]; //the pivot point 

	//0 1 2 3 4 5 with pivot 3 -> 0 1 2 3 4 5
	//5 6 1 2 4 3 with pivot 4 -> 1 2 3 4 6 5

	//can't compare to nth element until you've run the code once 
	//int n is the index + 1 of the element you want
 
	int valueGotten = quickSelectH(ary, n, ri, pivot);

	System.out.println(valueGotten);
	if(valueGotten  == -1){
	    System.out.println("Correction");
	    ri = rand.nextInt(ary.length);
	    pivot = ary[ri];
	    quickSelectH(ary, n, ri, pivot);
	}
	if(valueGotten != -1){
	    return valueGotten;
	}
	System.out.println(Arrays.toString(ary));
	return 0;
	//gotta return the nth smallest value in the array
	//once you pivot the number will always be in the right location
	//so if pivot is on the index congratz 
	//nth smallest is n-1 index 
    }

    public static int quickSelectH(int ary[], int n, int ri, int pivot){
	int si = 0;
	int ei = ary.length-1;
	int intati;
	int intatsi;
	int intatei;

	for(int i = 0; i < ary.length; i++){
	    if(ary[i] < pivot){
		intati = ary[i];
		intatsi = ary[si];
		ary[si] = intati;
		ary[i] = intatsi;
		si++;
	    }
	    else if(ary[i] > pivot){
		intati = ary[i];
		intatei = ary[ei];
		ary[ei] = intati;
		ary[i] = intatei;
		ei--;
	    }
	}
	ary[si] = pivot;
	if(si == n){
	    return ary[si];
	}
	else{
	    return -1;
	}
    }

    public QuickSelect(){
	int [] ary = new int[10];
	for(int i = 0; i < ary.length; i++){
	    ary[i] = ary.length - i;
	}
	quickSelect(ary, 5);
    }

    public static void main(String[]args){
	QuickSelect A = new QuickSelect();
    }
}
