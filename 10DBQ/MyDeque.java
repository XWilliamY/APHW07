import java.util.*;
public class MyDeque{
    private int [] deque;
    private int headfirst;
    private int tailfirst;
    private int headlast;
    private int taillast;
    private int size;
    private int maxSize;
    public MyDeque(){
	deque = new int [1];
	size = 0;
	maxSize = 1;
    }

    public void addFirst(int value){
	//First in First Out
	/*if(value == null){
	  throw new NullPointerException();
	  }*/
	if(size == 0){
	    headfirst = 0;
	    deque[headfirst] = value; //set head to value
	    tailfirst = headfirst;
	    size++;
	}// head increments down, tail stays the same
	if((size + 1) > maxSize){
	    //0, 1, 2, 3, 4, 5, your head is at 5 and your tail is at 0
	    //adding to new array would still be 0,1, 2, 3, 4, 5, null, null
	    //head at 5 tail at 0
	    int [] newdeque = new int [maxSize * 2];
	    for(int i = tailfirst; i <= headfirst;i++){
		newdeque[i] = deque[i];
	    }
	    deque = newdeque;
	    maxSize = maxSize*2;
	}
	else{
	    headfirst ++;
	    deque[headfirst] = value;
	    size++;
	}
    }

    public int removeFirst(){
	//First in First Out
	if(size == 0){
	    throw new NoSuchElementException();
	}
	int removed = deque[headfirst];
	headfirst --;
	size--;
	return removed;
    }
    public void addLast(int value){
	//head stays, tail increments
	//Last In First Out
    }
    public int removeLast(){
	return -1;
    }
    public int getFirst(){
	return deque[headfirst];
    }
    public int getLast(){
	return -1;
    }
    public int[] resize(int[] old, int[] newOne){
	deque = new int [5];
	return deque;
    }
    public int getHeadFirst(){
	return headfirst;
    }

    public int getSize(){
	return size;
    }
    public static void main(String[]args){
	MyDeque A = new MyDeque();
	A.addFirst(10);
	A.addFirst(11);
	A.removeFirst();
	A.addFirst(12);
	System.out.println(A.getFirst());
    }
}

 