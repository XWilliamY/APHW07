import java.util.*;
public class MyHeap{
    
    private int [] heap;
    private boolean isMax, isEmpty, leftEmpty, rightEmpty;
    private int  size;
    
    public String name(){
	return "yang.william";
    }

    public int size(){
	return heap[0];
    }

    public MyHeap(){
	heap = new int [10];
	isMax = true;
	isEmpty = true;
    }

    public MyHeap(boolean isMax){
	heap = new int [10];
	this.isMax = isMax;
    }

    public void resize(){
	if(heap[0] == heap.length-1){
	    int [] newHeap = new int [heap.length *2];
	    for(int i = 0; i < heap.length; i++){
	    newHeap[i] = heap[i];
	    }
	    heap = newHeap;
	}
    }

    public void add(int n){
	//we can use the first space heap[0] to store the size of the array
	heap[heap[0] + 1] = n;
	heap[0] = heap[0] + 1;
	//and now we're going to call a helper function
	upSwap(heap[0], n); 
	resize();
    }

    public boolean compare(int prevIndex, int thisIndex){
	if(isMax){
	    return heap[prevIndex] < heap[thisIndex]; // previous has to be lesser in order to swap
	}
	else{
	    return heap[prevIndex] > heap[thisIndex];
	    //next has to be smaller to merit swapping
	}
    }

    public void upSwap(int index, int value){
	//we've already added the new value to the array so just need to check if swap is needed
	while(index/2 != 0 && index != 1 && compare(index/2, index)){
	    //if swappable and not swapping wtih zero
	    int temp = heap[index/2];
	    heap[index/2] = heap[index];
	    heap[index] = temp;
	    index = index/2;
	}
    }

    public int peek(){
	if(heap[0] == 0){
	    throw new NoSuchElementException();
	}
	return heap[1];
    }

    //toString courtesy of Brandon Lin 
    //https://github.com/esqu1/2APCSHW-Pd6/blob/master/13TheGrimHeaper/MyHeap.java
    public String toString(){
	String s = "";
	int power = 1;
	for(int i = 1; i <= heap[0]; i++){
	    if((int)Math.pow(2,power) == i){
		s += "\n";
		power++;
	    }
	    s += heap[i] + " ";
	}
	return s;
    }

    //my feable toString
    public String toString(boolean weak){
	String ans = "";
	if(weak){
    	    for(int i =0; i < heap.length; i++){
		ans += heap[i] + " ";
	    }
	}
	return ans;
    }

    //shoutout to Yicheng for redirecting me to stackoverflow
    //http://stackoverflow.com/questions/20179614/algorithm-to-delete-root-node-from-binary-max-heap
    //information used: 
    //1. The result is the node at the top of the heap(i.e. the root).
    //2. Move the item from the end of the heap to the top of the heap.
    //3. While the item you inserted is smaller than the largest of its children, swap it with
    //   the largest child. 
    public int remove(){
	if(heap[0] == 0){
	    throw new NoSuchElementException();
	}
	//2. Move the item from the end of the heap to the top of the heap
	int removedValue = heap[1];
	System.out.println("Array before everything: " + toString(true));
	heap[1] = heap[heap[0]];
	System.out.println("Array after very first swap: " + toString(true));
	downSwap(1, heap[1]);
	//3. While the item you inserted is smaller than the largest of its children, swap it 
	//   with the largest child 
	heap[0] = heap[0] - 1;
	return removedValue;
    }

    public void downSwap(int index, int value){
	//stop once index reaches the end
	System.out.println("array before while: " + toString(true));
	System.out.println(heap[index] < heap[index*2]);
	while(index < heap[0] && index*2 < heap[0] && index*2+1 < heap[0] && (compare(index, index*2) || (compare(index, index*2+1)))){
	    //will differentiate between maxHeap and minHeap
	    //i did forget about one thing: we want to see which of its children is larger too
	    if(compare(index*2, index*2+1)){// if left child < right child
		System.out.println("index before: " + index);
		int temp = heap[index*2+1];
		System.out.println("this is the temp: " + temp);
		System.out.println("this is the other value: " + heap[index]);
		heap[index*2+1] = heap[index];
		heap[index] = temp;
		index = index *2+1;
		System.out.println("array after: " + toString(true));
		System.out.println("index after: " + index);
	    }
	    else{
		//otherwise swap with left 
		//that should make things work out at least for max
		//if swappable and not swapping wtih zero
		int temp = heap[index*2];
		System.out.println("index: " + index);
		System.out.println("temp: " + temp);
		System.out.println("This is the other value: " + heap[index]);
		heap[index*2] = heap[index];
		heap[index] = temp;
		index = index*2;
		System.out.println("array after: " + toString(true));
		System.out.println("index after: " + index);
	    }
	}
    }

    public static void main(String[]args){
	MyHeap A = new MyHeap(true);
	A.add(1);
	A.add(5);
	A.add(2);
	A.add(4);
	A.add(3);
	A.remove();
	A.remove();
	A.remove();
	A.remove();
	System.out.println("final array:"); 
	System.out.println(A.toString());
    }
}
