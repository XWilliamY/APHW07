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

    public static void main(String[]args){
	MyQueue<Integer> A = new MyQueue<Integer>();
	System.out.println(A.enqueue(5));
	System.out.println(A.dequeue());
	//System.out.println(A.enqueue(null));
	System.out.println(A.dequeue());
    }
}
