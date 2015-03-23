import java.util.*;

public class MyQueue<T>{
    MyLinkedList<T> queue  = new MyLinkedList<T>();

    public boolean enqueue(T value){
	if(value == null){
	    throw new NullPointerException();
	}
	queue.add(value);
	return true;
    }

    public T dequeue(){
	if(queue.size() == 0){
	    throw new NoSuchElementException();
	}
	T value = queue.get(0);
	queue.remove(0);
	return value;
    }

    public T peek(){
	return queue.get(0);
    }

    public boolean empty(){
	return queue.size() == 0;
    }

    public static void main(String[]args){
	MyQueue<Integer> A = new MyQueue<Integer>();
	System.out.println(A.enqueue(5));
	System.out.println(A.dequeue());
	//System.out.println(A.enqueue(null));
	//System.out.println(A.dequeue());
	MyQueue<String> B = new MyQueue<String>();
	System.out.println("");
	System.out.println(B.enqueue("first in"));
	System.out.println(B.peek());
	System.out.println(B.enqueue("last out"));
	System.out.println(B.dequeue());
	System.out.println(B.dequeue());
	System.out.println(B.empty());
    }
}
