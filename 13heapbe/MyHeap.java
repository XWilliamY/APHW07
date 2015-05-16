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
		while(heap[index/2] < heap [index]){
		    //while the one before is less than this one
		    int temp = heap[index/2];
		    heap[index/2] = heap[index];
		    heap[index] = temp;
		}
	    }
	    index = index*2;
	}
    }

    public int peek(){
	return heap[1];
    }

    //borrowed Brandon's toString, will write my own after getting add and remove done

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
	A.add(5);
	A.add(6);
	A.add(7);
	A.add(10);
	//System.out.println(A.toString());
	System.out.println(A.peek());
    }
}