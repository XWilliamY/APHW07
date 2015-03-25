import java.util.*;

public class MyStack{

    private int [] stack;
    private int head;
    private int tail;
    private int maxSize;
    private int size = 0;
    private int index = 0;

    public MyStack(int size){
	stack = new int [size];
	maxSize = size;
    }
    
    public MyStack(){
	stack = new int [10];
	maxSize = 10;
    }

    public int push(int value){
	if((size + 1) > maxSize){
	    int [] newStack = new int [2 * (size + 1)]; // make it 2x size
	    for(int i = 0; i < stack.length; i++){
		newStack[i] = stack[i];
	    }
	    stack = newStack;
	}
	index = size;
	stack[index] = value; //add value
	size ++; //increment counter
	return value; 
    }

    public int pop(){
	if(size == 0){
	    throw new EmptyStackException();
	}
	int removed = stack[index];
	index --; // moving back one treats the former as an empty space
	size --;	
	return removed;    
    }

    public int peek(){
	if(size == 0){
	    throw new EmptyStackException();
	}
	return stack[index];
    }

    public boolean empty(){
	return size == 0;
    }

    public int getSize(){
	return size;
    }

    public int getIndex(){
	return index;
    }

    public static void main(String[]args){
	MyStack A = new MyStack(1);
	A.push(5);
	A.push(6);
	A.push(7);
	A.push(8);
	A.push(9);
	System.out.println(A.peek());
	A.pop();
	System.out.println(A.peek());
	A.pop();
	System.out.println(A.peek());
	A.pop();
	System.out.println(A.peek());
	A.pop();
	System.out.println(A.peek());
	System.out.println(A.peek());
	System.out.println(A.empty());
	A.pop();
	System.out.println(A.empty());
	//System.out.println(A.peek());
	//A.pop();
	//System.out.println(A.peek());

    }
}


