public class RunningMedian{

    //maxheap and a minheap
    //doesn't matter which you add to
    MyHeap maxHeap = new MyHeap();
    MyHeap minHeap = new MyHeap(false);

    public void add(int value){
	//first time you add, doesn't matter which you add to
	//if two values, one on each side, then peek both 
	//if size difference is more than one then 
	//   if max move smallest over, otherwise move largest from small
	if(maxHeap.size() == 0 && minHeap.size() == 0){
	    maxHeap.add(value);
	}
	else if(value < maxHeap.peek()){
	    maxHeap.add(value);
	}
	else if(value > maxHeap.peek()){
	    minHeap.add(value);
	}
	else{
	    //if(value > maxHeap.peek()){
	    minHeap.add(value);
	}
	if(maxHeap.size() - minHeap.size() > 1){
	    minHeap.add(maxHeap.peek());
	    //maxHeap.remove();
	}
	else if(minHeap.size() - maxHeap.size() > 1){
	    maxHeap.add(minHeap.peek());
	    minHeap.remove();	
	    }
	System.out.println("this is max: ");
	System.out.println(maxHeap.peek());
	if(minHeap.size() > 0){
	    System.out.println("this is min: ");
	    System.out.println(minHeap.peek());
	}
    }

    public String maxToString(){
	return maxHeap.toString();
    }

    public String minToString(){
	return minHeap.toString();
    }

    public static void main(String[]args){
	RunningMedian A = new RunningMedian();
	A.add(2);
	A.add(3);
	A.add(4);
	A.add(5);
	//A.add(6);
	//A.add(7);
	//A.add(8);
	System.out.println("maxHeap");
	System.out.println(A.maxToString());
	System.out.println("minHeap");
	System.out.println(A.minToString());
    }
}