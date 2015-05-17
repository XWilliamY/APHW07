import java.util.*;
public class MyHeap{
    
    private int [] heap;
    private boolean isMax, isEmpty, leftEmpty, rightEmpty;
    private int index, size;
    
    public MyHeap(){
	heap = new int [10];
	isMax = true;
	index = 1;
	isEmpty = true;
    }

    public MyHeap(boolean isMax){
	heap = new int [10];
	index = 1;
	isEmpty = true;
	this.isMax = isMax;
    }

    public void resize(){
	if(heap[0] == heap.length-2){
	    int [] newHeap = new int [heap.length *2];
	    for(int i = 0; i < heap.length; i++){
	    newHeap[i] = heap[i];
	    }
	    heap = newHeap;
	}
    }

    public void add(int n){
	//we can use the first space heap[0] to store the size of the array
	resize();
	heap[heap[0] + 1] = n;
	heap[0] = heap[0] + 1;
	//and now we're going to call a helper function
	upSwap(heap[0], n); 
    }

    public boolean compare(int prevIndex, int thisIndex, boolean up){
	if(up){
	    if(isMax){
		return heap[prevIndex] < heap[thisIndex]; // previous has to be lesser in order to swap
	    }
	    else{
		return heap[prevIndex] > heap[thisIndex];
		//next has to be smaller to merit swapping
	    }
	}
	else{
	    if(isMax){
		return heap[prevIndex] > heap[thisIndex];
	    }
	    else{
		return heap[prevIndex] < heap[thisIndex];
	    }
	}
    }

    public void upSwap(int index, int value){
	//we've already added the new value to the array so just need to check if swap is needed
	while(index/2 != 0 && index != 1 && compare(index/2, index, true)){
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
    public String toString(boolean which){
	if(which){
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
	else{
	    String ans = "";
	    for(int i =0; i < heap.length; i++){
		ans += heap[i] + " ";
	    }
	    return ans;
	}
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
	heap[1] = heap[heap[0]];
	heap[0] = heap[0] - 1;
	downSwap(1, heap[1]);
	//3. While the item you inserted is smaller than the largest of its children, swap it 
	//   with the largest child 
	return removedValue;
    }

    public void downSwap(int index, int value){
	//stop once index reaches the end
	while(index != heap[0] && compare(index*2, index, false)){
	    //if swappable and not swapping wtih zero
	    int temp = heap[index*2];
	    System.out.println("value in our hands: " + heap[index]);
	    System.out.println("next value: " + temp);
	    heap[index*2] = heap[index];
	    heap[index] = temp;
	    index = index*2;
	}
    }

    public static void main(String[]args){
	MyHeap A = new MyHeap();
	//index at 1
	A.add(1);
	A.add(2);
	A.add(3);
	A.add(4);
	A.add(5);
	A.add(6);
	A.add(7);
	A.remove();
	System.out.println("Brandon's toString");
	System.out.println(A.toString(true));
	System.out.println("Array toString");
	System.out.println(A.toString(false));
	//maxHeap functional
	/*MyHeap B = new MyHeap(false);
	B.add(100);
	B.add(20);
	B.add(30);
	B.add(400);
	B.add(500);
	B.add(60000);*/
	//minHeap functional
    }
}
