import java.util.*;

public class merge{

    public static void merge(int [] ary){
	//make an ArrayList
	ArrayList <Comparable> aL = new ArrayList <Comparable>();
	//copy the values over 

	for(int a = 0 ; a < ary.length ; a++){
	    aL.add(ary[a]);
	}

	//the ArrayList will be what we mergeSort()
	mergeHelp(aL);

	//Now we want to copy it back 

	for(int b = 0 ; b < aL.size() ; b++){
	    ary[b] = (int)(aL.get(b));
	}
	//System.out.println(Arrays.toString(ary));
    }

    public static void mergeHelp(ArrayList <Comparable> aL){

	//base cases

	if(aL.size() < 2){
	    return;
	}

	//split array

	ArrayList <Comparable> a = new ArrayList <Comparable>();
	ArrayList <Comparable> b = new ArrayList <Comparable>();
	
	boolean other = true;
	for(int c = 0 ; c < aL.size() ; c++){
	    if(other){
		a.add(aL.get(c));
		other = false;
		//alternate between ArrayList a and 
	    }
	    else{
		b.add(aL.get(c));
		other = true;
		//ArrayList b
	    }
	}
	
	//we want to keep splitting them until they're down to a size of one 
	mergeHelp(a);
	mergeHelp(b);
	
	//clear the original function so we can start merging
	aL.clear();

	//merge them 
	while( a.size() > 0 && b.size() > 0){
	    if(a.get(0).compareTo(b.get(0)) < 0){
		aL.add(a.remove(0));
	    }
	    else{
		aL.add(b.remove(0));
	    }
	}

	//add what's left 
	aL.addAll(a);
	aL.addAll(b);
    }

    public static void main(String[]args){
	//test case 3b
	Random rand = new Random();
	int [] A = new int[1000];
	for(int a = 0; a < A.length; a++){
	    A[a] = -1 *(rand.nextInt(1000000)) + rand.nextInt(1000000);
	}
	merge(A);
	//System.out.println(Arrays.toString(A));

	//test case 3a ish
	int [] B = new int[100];
	for(int b = 0; b < B.length;b++){
	    B[b] = rand.nextInt(3);
	}
	merge(B);
	//System.out.println(Arrays.toString(B));

	int [] C = {100, 99, 98, 97, 96, -100, -101};
	merge(C);
	//System.out.println(Arrays.toString(C));

	
    }   
}