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
	add(heap[0], n); 
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

    public void add(int index, int value){
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
	else{
	    String ans = "";
	    for(int i =0; i < heap.length; i++){
		ans += heap[i] + " ";
	    }
	    return ans;
	}
    }

    public static void main(String[]args){
	MyHeap A = new MyHeap();
	//index at 1
	A.add(50);
	System.out.println(A.toString(false));
    }
}