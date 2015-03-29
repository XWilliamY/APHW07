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
	//if it's at left most, loop around to end
	if(head < 0){
	    head += deque.length; //bring it to the end
	    //it won't be on deque.length since less than zero
	    deque[head] = value;
	}
	//otherwise decrement to the left 
	if(head >= 0){
       	    deque[head] = value; //set this place to value
	    head--;	
	}
	size ++;

    }

    public int removeFirst(){
	//First in First Out
	if(size == 0){
	    throw new NoSuchElementException();
	}
	int removed = deque[head];
	deque[head] = 0;
	head --;
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
	return deque[head];
    }
    public int getLast(){
	return -1;
    }

    public int getHeadFirst(){
	return head;
    }

    public int getSize(){
	return size;
    }
    public static void main(String[]args){
	MyDeque A = new MyDeque();
	A.addFirst(1);
	A.addFirst(0);
	A.addFirst(-1);
	A.addFirst(-2);
	System.out.println(A.toString());
    }
}

 