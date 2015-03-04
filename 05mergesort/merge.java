public class merge{

    public void merge(int [] ary){
	ArrayList <Comparable> aL = new ArrayList <Comparable>();

	//an ArrayList of <Comparable> will allow you to use any sort of array for sorting

	for(int a = 0 ; a < ary.length ; a++){
	    aL.add(ary[a]);
	}

	//copy the values over 