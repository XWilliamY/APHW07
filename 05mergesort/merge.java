import java.util.*;

public class merge{

    public void merge(int [] ary){
	//An ArrayList of <Comparable> will allow you to use any sort of array for sorting

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
    }

    public void mergeHelp(ArrayList <Comparable> ary){

	//base cases

	if(ary.size() < 2){
	    return;
	}

	//split array

	ArrayList <Comparable> a = new ArrayList <Comparable>();
	ArrayList <Comparable> b = new ArrayList <Comparable>();
	
	boolean other = true;
	for(int c = 0 ; c < ary.size() ; c++){
	    if(other){
		a.add(ary.get(c));
	    }
	    else{
		b.add(ary.get(c));
	    }
	}
	
	//we want to keep splitting them until they're down to a size of one 
	mergeHelp(a);
	mergeHelp(b);
    
	ArrayList <Comparable> ab = new ArrayList <Comparable>();
	//merge them 
	for( int d = 0 ; d < a.size() + b.size(); d++){
	    // you reach the absolute limit when d is = a.size(0 + b.size()
	    if(d > a.size()){
		ab.addAll(b);
	    }
	    //if 

    }
}