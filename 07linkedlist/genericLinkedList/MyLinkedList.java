public class MyLinkedList<T>{

    private LNode<T> head;
    private LNode<T> current;
    private LNode<T> tail;
    private int size;
    private int counter;

    public String name(){
	return "yang.william";
    }

    public String toString(){
	String ans = "[ ";
	LNode<T> temp = head;
	while(temp != null){
	    ans += temp.getValue() + ",";
	    temp = temp.getNext();
	}
	ans = ans.substring(0, ans.length()-1);
	ans += " ]";
	return ans;
    }

    public T get(int index){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	counter = 0;
	LNode<T> temp = head;
	while(counter < index){
	    temp = temp.getNext();
	    counter++;
	}
	return temp.getValue();
    }

    public void set(int index, T value){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	int counter = 0;
	LNode<T> temp = head;

	while(counter < index){
	    temp = temp.getNext();
	    counter++;
	}
	temp.setValue(value);
    }

    public boolean add(T value){
	LNode<T> temp = head;

	if(size == 0){
	    head = new LNode<T>(value);
	    tail = head;
	}

	else{
	    LNode<T> addOn = new LNode<T>(value);
	    tail.setNext(addOn);
	    tail = addOn;
	}
	size++;
	return true;
    }

    public void add(int index, T value){

	if(index < 0 || index >= size && size > 0){
	    throw new IndexOutOfBoundsException();
	}

	if(index == 0){
	    LNode<T> addNode = new LNode<T>(value);
	    addNode.setNext(head);
	    head = addNode;
	}
	else{
	    LNode<T> temp = head;
	    for(int i = 0; i < index-1; i++){
		temp = temp.getNext();
	    }
	    LNode<T> addNode = new LNode<T>(value);
	    addNode.setNext(temp.getNext());
	    temp.setNext(addNode);
	}
	size++;
    }

    public void remove(int index){
	LNode<T> temp = head;
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    head = head.getNext();
	}
	for(int i = 0; i < index-1;i++){
	    temp = temp.getNext();
	}
	temp.setNext(temp.getNext().getNext());
	tail = temp;
	size--;
    }

    public int size(){
	return size;
    }

    public int indexOf(T value){
	LNode<T> temp = head;
	for(int i = 0; i < size; i++){
	    if(temp.getValue() == value){
		return i;
	    }
	    temp = temp.getNext();
	}
	return -1;
    }


    public static void main(String[]args){
	MyLinkedList A = new MyLinkedList();
	A.add(1);
	A.add(2);
	A.add(3);
	A.add(4);
	A.add(5);
	A.add(3, 5);
	A.remove(3);
	A.remove(2);
	A.remove(1);
	A.remove(0);
	System.out.println(A.toString());
	System.out.println(A.size());
	A.add(1);
	System.out.println(A.toString());
	System.out.println(A.size());
    }

}

