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
	int [] newHeap = new int [heap.length *2];
	for(int i = 0; i < heap.length; i++){
	    newHeap[i] = heap[i];
	}
	heap = newHeap;
    }

    public void add(int n){
	if(isMax){
	    //adding left to right, where the parent > its children 
	    //starting at 1
	    //2* index = left child, 2* index + 1 = right child
	    heap[index] = n;
	    //check if left or right
	    int tempIndex = index;
	    if(index % 2 == 0){
		System.out.println("this is the index: " + index);
		while(heap[tempIndex/2] < heap [tempIndex] && tempIndex/2 != 0){
		    //while the one before is less than this one
		    int temp = heap[tempIndex/2];
		    System.out.println("this is temp: " + temp);
		    System.out.println("this is index/2: " + tempIndex/2);
		    System.out.println("this is index: " + tempIndex);
		    heap[tempIndex/2] = heap[tempIndex];
		    heap[tempIndex] = temp;
		    tempIndex = tempIndex/2;
		}
	    }//above swaps left side
	    else{
		int tempIndexHalf = (tempIndex-1)/2;
		//pretend that index = index - 1
		while(heap[(tempIndexHalf)] < heap[tempIndex] && (tempIndexHalf != 0)){
		    int temp = heap[tempIndexHalf];
		    heap[tempIndexHalf] = heap[tempIndex];
		    heap[tempIndex] = temp;
		    tempIndex = tempIndexHalf;
		}
	    }
	    index += 1;
	    heap[0] = index;
	    System.out.println("this is the new index: " + index);
	    size++;
	    resize();
	}
    }

    public int peek(){
	return heap[1];
    }

 
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

    public static void main(String[]args){
	MyHeap A = new MyHeap();
	//index at 1
	A.add(1); //index at 2
	A.add(2); //index at 4
	A.add(3);
	A.add(4);
	A.add(10);
	System.out.println(A.toString());
    }
}