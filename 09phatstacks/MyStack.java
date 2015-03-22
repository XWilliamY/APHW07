import java.util.*;

public class MyStack<T>{
    private LinkedList<T> stack = new LinkedList<T>();

    public String name(){
	return "yang.william";
    }

    public T push(T value){
	stack.addFirst(value);
	return value;
    }

    public T pop(){
	T removedValue = stack.get(0);
	stack.remove(0);
	return removedValue;
    }

    public T peek(){
	return stack.get(0);
    }

    public boolean empty(){
	return stack.size() == 0;
    }

    public static void main(String[]args){
	MyStack<Integer> A = new MyStack<Integer>();
	System.out.println(A.push(5));
	System.out.println(A.push(6));
	System.out.println(A.peek());
	System.out.println(A.pop());
	System.out.println(A.pop());
	//System.out.println(A.pop());
	System.out.println(A.empty());
	System.out.println(A.push(10));
	System.out.println(A.peek());
    }
}