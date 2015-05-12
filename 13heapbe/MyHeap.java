public class MyHeap{
    
    private int [] heap;
    private boolean isMax, isEmpty, leftEmpty, rightEmpty;
    private int index;
    
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

    public String toString(){
	String ans = "";
	for(int i = 0; i < heap.length; i++){
	    ans += heap[i];
	}
	return ans;
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
	    if(index % 2 == 0 && index != 1){
		//if 0 is left
		while(heap[index - 1] < heap [index]){
		    int temp = heap[index -1];
		    heap[index - 1] = heap[index];
		    heap[index] = temp;
		}
	    }
	    else{
		while(heap
	    //check if it fits
	    //lastly
	    index += 1;
	}
    }

    public int peek(){
	return heap[1];
    }


    public static void main(String[]args){
	MyHeap A = new MyHeap();
	System.out.println(A.toString());
	System.out.println(A.peek());
    }
}