public class MyHeap{
    
    private int [] heap;
    private boolean isMax, isEmpty;
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
	    if(index == 1){
		//first time adding 
		heap[index] = n;
		isEmpty = false;
		index = 2 * index;
	    }
	    

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