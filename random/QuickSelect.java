public class QuickSelect{

//array ary, start index si, end index ei
//make a new empty array called D of the same size as ary
//copy all elements not in the range si to ei over to the new array
//select a pivot element and pull it out of the arrrray. 
//for the elements between si and ei:
//if it's less than the pivot value copy it to d[si] and increment si
//if it's greater than the pivot value copy ot to d[ei] and decrement si
//when si and ei meet you should be out of elements. the pivot value goes here

    private int [] D;

    public void partition(int[]ary, int si, int ei){
	//make a new empty array called D of the same size as ary
	D = new int [ary.length];

	//copy all the elements not in the range si to ei over to the new array
	//less than si and greater than ei
	if(si >= 0 && ei >= 0 && si < D.length && ei < D.length && ei >= si){	
	    for(int a = 0; a < D.length; a++){
		if(a < si || a > ei){
		    //copy over
		    D[a] = ary[a];
		}
	    }
	}
	System.out.println(toString(D));

	//select a pivot element and pull it out of the array 
	int pivot = ary[si]; //Just choose L[SI] for now 
	/*
	while( si < ei){
	    if(ary[si] == pivot){
		si++;
	    }
	    if(ary[si] < pivot){
		//if it's less than the pivot value copy it to D[si]
		D[si] = ary[si];
		si++;
	    }
	    if(ary[si] > pivot){
		D[ei] = ary[si];
		si++;
		ei--;
	    }
	}
	D[si] = pivot;
	*/

	//the above can work, but doesn't really, because there's no way to
	//ignore the pivot 
	System.out.println(pivot);
	System.out.println(toString(D));
    }

    public QuickSelect(){
	int [] ary = new int [10];
	for(int i = 0; i < ary.length; i++){
	    ary[i] = 10-i;
	}

	partition(ary, 6 ,7);
	//System.out.println(D.toString());
    }

    public String toString(int [] ary){
	String ans = "";
	for(int i = 0; i < D.length;i++){
	    ans += D[i] + " ";
	}
	return ans;
    }

    public static void main(String[]args){
	QuickSelect A = new QuickSelect();
    }
}