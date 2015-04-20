import java.util.*;
public class MyDeque<T>{
    private Object [] deque;
    private int [] parallel;
    private int head, phead;
    private int tail, ptail;
    private int size;
    //maxSize = deque.length;
    public MyDeque(){
	deque = new Object [1];
	parallel = new int [1];
	size = 0;
    }

    public void resize(){
	phead = head;
	ptail = tail;
	if(size == deque.length){
	    Object [] newdeque = new Object [size*2];
	    for(int i = 0; i < size; i++){
		newdeque[i] = deque[(head+i)%size];
	    }
	    deque = newdeque;
	    head = 0;
	    tail = size-1;//last value
	}
    }


    public void resizeparallel(){
	if(size == parallel.length){
	    int [] newparallel = new int [size*2];
	    for(int i = 0; i < size; i ++){
		newparallel[i] = parallel[(phead+i)%size];
	    }
	    parallel = newparallel;
	    phead = 0; 
	    ptail = size-1;
	}
    }

    public String name(){
	return "yang.william";
    }

    public String toString(){
	return Arrays.toString(deque);
    }

    //add to the left, basically  
    public void addFirst(T value){
	resize();
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
	resize();
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

    public void add(T value, int priority){
	resizeparallel();
	addLast(value);
	parallel[head] = priority;
    }

    public T removeSmallest(){
	if(deque.length == 1){
	    //if there's only one element
	    T removed = removeLast();
	    return removed;
	}
	//more intuitive way?
	int fhead = head;
	int ftail = tail;
	int lowestpriority = parallel[head];
	T Objectlowest = (T)deque[head];
	int where = head;
	while(fhead%deque.length != ftail){
	    //the fhead will loop around 
	    if(parallel[fhead%deque.length] < lowestpriority){
		lowestpriority = parallel[fhead%deque.length];
		Objectlowest = (T)deque[fhead%deque.length];
		where = fhead%deque.length;
	    }
	    fhead++;
	}
	deque[where] = deque[head];
	parallel[where] = parallel[head];
	deque[head] = null;
	size--;
	head = (head+1)%deque.length;
	return Objectlowest;
    

	/*
	int lowestpriority = parallel[head];
	//start at the head
	int end;
	if(head < tail){
	    end = tail;
	    //say head = 0, tail = 10
	}
	else{
	    end = tail + parallel.length;
	    //head = 9, tail = 0
	    //end = 0 + 9 = 9
	}
	int i = 0;
	int where=0;
	int a=0;
	while(i <= end){
	    a = i%deque.length;
	    if(parallel[a] < lowestpriority){
		lowestpriority = parallel[a];
		where = a;
	    }
	}
	T smallest = (T)deque[a]; 
	//swap deque at head with deque at where
	deque[where] = deque[head];
	deque[head] = null;
	parallel[where] = parallel[head];
	head = (head+1)%deque.length;
	return smallest;*/
    }


    public static void main(String[]args){
	MyDeque<Integer> A = new MyDeque<Integer>();
	A.addLast(new Integer(54));
	A.addLast(new Integer(5));
	A.addLast(new Integer(100));
	A.addLast(new Integer(1));
	A.addFirst(new Integer(511));
	MyDeque<Integer> B = new MyDeque<Integer>();
	B.add(new Integer(1), 1);
	B.add(new Integer(2), 3);
	System.out.println(B.removeSmallest());
	System.out.println(B.toString());
    }
}
 