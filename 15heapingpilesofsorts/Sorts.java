public class Sorts{

    
    public static void heapSort(int [] ary){
	MyHeap heap = new MyHeap();

	//shout out to wikipedia: http://en.wikipedia.org/wiki/Heapsort
	//'a heap is built out of the data'
	for(int i = 0; i < ary.length; i++){
	    heap.add(ary[i]);
	}
    }

    public String toString(MyHeap hep){
	return hep.toString();
    }

    public static void main(String[]args){
	int [] A = new int [10];
	for(int i = 0; i < 10; i++){
	    A[i] = i;
	}
	heapSort(A);
	System.out.println(toString(A));
    }
}