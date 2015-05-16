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
	    if(index % 2 == 0 && index != 1){
		System.out.println("this is the index: " + index);
		int tempIndex = index;
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
	    }
	    else{
		//is right
		int tempIndex = index;
		while(heap[temp
	    index += index;
	    System.out.println("this is the new index: " + index);
	    size++;
	    resize();
	}
    }

    public int peek(){
	return heap[1];
    }

    //borrowed Brandon's toString, will write my own after getting add and remove done

    public String toString(){
	String ans = "";
	for(int i = 0; i < heap.length; i++){
	    ans += heap[i];
	}
	return ans;
    }

    public static void main(String[]args){
	MyHeap A = new MyHeap();
	//index at 1
	A.add(1); //index at 2
	A.add(2); //index at 4
	System.out.println(A.toString());
	System.out.println("NEW ADD");
	A.add(3);
	System.out.println(A.toString());
	System.out.println(A.peek());
	System.out.println("NEW ADD");
	A.add(4);
	System.out.println(A.toString());
	System.out.println(A.peek());
	A.add(5);
	A.add(6);
	A.add(7);
	System.out.println(A.peek());
    }
}