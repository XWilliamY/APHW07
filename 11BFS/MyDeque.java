import java.util.*;
public class MyDeque<T>{
    private Object [] deque;
    private Object [] parallel;
    private int head;
    private int tail;
    private int size;
    //maxSize = deque.length;
    public MyDeque(){
	deque = new Object [1];
	size = 0;
	parallel = new Object [1];
    }

    public void resize(){
	if(size == deque.length){
	    Object [] newdeque = new Object [size*2];
	    for(int i = 0; i < size; i++){
		newarray[i] = array[(head+i)%size];
	    }
	    array = newarray;
	    head = 0;
	    tail = size-1;//last value
	}
    }
    /*
    public void resizeparallel(){
    	if(size == parallel.length){
    		int [] newparallel = new int[size*2];
    		for(int i = 0; i < size; i++){
    			newparallel[i] = parallel[(head+i)%size];
    		}
    		parallel = newparallel;
    		head = 0;
    		tail = size-1;
    	}		
	}*/
    
  public void add(T value, int priority){
  	//too used to 'normal' way of adding to end
  	addLast(value);
  	resize(parallel);
  	//resize() already in addLast
  	tail++;
  	if(tail >= deque.length){
	    tail = tail - deque.length;
	}
  	parallel[tail] = priority;
	System.out.println(Arrays.toString(parallel));
  	size++;
  }

    public String name(){
	return "yang.william";
    }

    public String toString(){
	return Arrays.toString(deque);
    }

    //add to the left, basically  
    public void addFirst(T value){
	resize(deque);
	//at 0 is the head
	//since we're adding to the first, we decrement by one
	head--;
	//if we're out of range
	if(head < 0){
	    //bring it back into the array
	    head = (head+deque.length)%deque.length;
	    //head = (-1+20)%20 = 19
	}
	deque[head] = value;
	size += 1;
    }

    public T removeFirst(){
	T removed = (T)deque[head];
	//set deque[head] = null;
	deque[head] = null;
	//head++
	head++;
	//if it's out of range, bring it back by modding
	if(head >= deque.length){
	    head = head - deque.length;
	}
	//decrement size
	size --;
	//return value
	return removed;
    }

    public void addLast(T value){
	//resize in case array too small
	resize(deque);
	//increment tail
	tail++;
	//if it exceeds the array
	if(tail >= deque.length){
	    //bring it back in
	    tail = tail - deque.length;
	}
	//set the new tail to value
	deque[tail] = value;
	//increase size
	size++;
    }

    public T removeLast(){
	//remove last is arguably similar to addFirst
	//since we're moving to the left and back
	T removed = (T)deque[tail];
	deque[tail] = null;
	tail--;
	if(tail < 0){
	    tail += deque.length;
	}
	size--;
	return removed;
    }

    public T getFirst(){
	return (T)deque[head];
    }

    public T getLast(){
	return (T)deque[tail];
    }

    public int getSize(){
	return size;
    }

    public static void main(String[]args){
	MyDeque<Integer> A = new MyDeque<Integer>();
	A.addLast(new Integer(5));
	A.addLast(new Integer(1));
	System.out.println(A.toString());
    }
}
 
