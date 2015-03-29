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
	if(head >= 0){
	    deque[head] = value;
	}
	head--;
	System.out.println("head before: " + head);
	size++;
	if(head < 0){
	    head+= deque.length;
	    System.out.println("length: " + deque.length + " head: " + head);
	}
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

    public int getHead(){
	return head;
    }

    public int getSize(){
	return size;
    }
    public static void main(String[]args){
	MyDeque A = new MyDeque();
	A.addFirst(4);
	A.addFirst(3);
	A.addFirst(2);
	A.addFirst(1);
	System.out.println(A.toString());
    }
}
 