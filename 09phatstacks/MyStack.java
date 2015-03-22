import java.util.*;

public class MyStack<T>{

    private LinkedList<T> tack;

    public String name(){
	return "yang.william";
    }

    public T push(T value){
	tack.add(0, value);
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
	A.push(5);
	A.push(6);
	System.out.println(A.toString());
    }
}