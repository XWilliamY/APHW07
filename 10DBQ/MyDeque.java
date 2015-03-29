import java.util.*;
public class MyDeque{
    private int [] deque;
    private int head;
    private int tail;
    private int size;
    //maxSize = deque.length;
    public MyDeque(){
	deque = new int [1];
	size = 0;
    }

    public void resize(){
	if(size == deque.length){
	    int [] newdeque = new int [size*2];
	    for(int i = 0; i < size; i++){
		newdeque[i] = deque[(head+i)%size];
	    }
	    deque = newdeque;
	    head = 0;
	    tail = size-1;//last value
	}
    }

    public String toString(){
	return Arrays.toString(deque);
    }

    //add to the left, basically  
    public void addFirst(int value){
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

    public int removeFirst(){
	int removed = deque[head];
	//set deque[head] = null;
	deque[head] = 0;
	//head++
	System.out.println("head before moving: " + head);
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
    public void addLast(int value){
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
    public int removeLast(){
	return -1;
    }
    public int getFirst(){
	return deque[head];
    }
    public int getLast(){
	return -1;
    }

    public int getHead(){
	return head;
    }

    public int getSize(){
	return size;
    }
    public static void main(String[]args){
	MyDeque A = new MyDeque();
	A.addLast(1);
	A.addLast(2);
	A.addLast(3);
	A.addLast(4);
	A.addFirst(-1);
	A.addLast(5);
	A.addLast(6);
	A.addFirst(-2);
	A.addLast(7);
	System.out.println(A.toString());
    }
}
 