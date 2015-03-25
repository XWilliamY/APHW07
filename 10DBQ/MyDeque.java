import java.util.*;

public class MyDeque{
    private int [] deque;
    private int head;
    private int tail;
    private int size;
    private int maxSize;

    public MyDeque(){
	deque = new int [10];
	size = 0;
	maxSize = 10;
    }

    public void addFirst(int value){
	/*if(value == null){
	    throw new NullPointerException();
	    }*/
	if(size == 0){
	    head = 0;
	    deque[head] = value; //set head to value
	    tail = head;
	    size++;
	}// head increments down, tail stays the same 
	if((size + 1) > maxSize){
	    //0, 1, 2, 3, 4, 5, your head is at 5 and your tail is at 0
	    //adding to new array would still be 0,1, 2, 3, 4, 5, null, null
	    //head at 5 tail at 0
	    int [] newdeque = new int [maxSize * 2];
	    for(int i = tail; i <= head;i++){
		newdeque[i] = deque[i];
	    }
	    deque = newdeque;
	}
	else{
	    head ++;
	    deque[head] = value;
	}
    }

    public int removeFirst(){
	return -1;
    }

    public void addLast(int value){
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

    public int[] resize(int[] old, int[] newOne){
	deque = new int [5];
	return deque;    
    }

    public static void main(String[]args){
	MyDeque A = new MyDeque();
	A.addFirst(10);
	System.out.println(A.getFirst());
    }
}