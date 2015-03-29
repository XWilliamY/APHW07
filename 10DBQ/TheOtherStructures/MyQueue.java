public class MyQueue{

    private int [] queue;
    private int head = 0;
    private int tail;
    private int size;

    public MyQueue(){
	queue = new int [10];
	size = 10;
    }

    public MyQueue(int size){
	queue = new int [size];
	this.size = size;
    }

    public int enqueue(int value){
	if(size == 0){
	    queue[head] = value;
	    tail = head;
	    size++;
	}
	else{ 
	    tail++; //increment the tail, head stays
	    queue[tail] = value;
	    size++;
	}
	return value;
    }

    public int dequeue(){/*
	if(size == 0){
	    throw new NoSuchElementException();
	    }*/
	return -1;
    }

    public int peek(){
	return queue[head];
    }

    public static void main(String[]args){
	MyQueue A = new MyQueue();
	A.enqueue(5);
	A.enqueue(10);
	A.enqueue(15);
	System.out.println(A.peek());
    }
}