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

    public double getMedian(){
	if(maxHeap.size() == minHeap.size()){
	    return (maxHeap.peek() + minHeap.peek())/(double)2;
	}
	else if(maxHeap.size() < minHeap.size()){
	    return minHeap.peek();
	}
	else if(minHeap.size() < maxHeap.size()){
	    return maxHeap.peek();
	}
	return 1;
    }

    public String maxToString(){
	return maxHeap.toString();
    }

    public String minToString(){
	return minHeap.toString();
    }

    public static void main(String[]args){
	RunningMedian A = new RunningMedian();
	A.add(-10);
	A.add(-9);
	A.add(10);
	A.add(111);
	A.add(1234);
	A.add(-10000);
	System.out.println(A.getMedian());
	//System.out.println("maxHeap");
	//System.out.println(A.maxToString());
	//System.out.println("minHeap");
	//System.out.println(A.minToString());
    }
}