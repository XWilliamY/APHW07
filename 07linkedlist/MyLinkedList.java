public class MyLinkedList<T>{

    private LNode<T> head;
    private LNode<T> current;
    private LNode<T> tail;
    private int size = 0;
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

    public boolean remove(int index){
	LNode<T> temp = head;
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    head = head.getNext();
	}
	else{
	    for(int i = 0; i < index-1;i++){
		temp = temp.getNext();
	    }
	    try{
		temp.setNext(temp.getNext().getNext());
	    }catch(NullPointerException e){
		temp.setNext(null);
		tail = temp;
	    }
	}
	size--;
	return true;
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
	MyLinkedList<String> A = new MyLinkedList<String> ();
	A.add("Hello");
	A.add("Goodbye");
	A.add("We are testing");
	A.add("see if this works");
	System.out.println(A.toString());
	A.remove(0);
	System.out.println("removed Hello. linkedlist is now: " + A.toString());
	A.set(1, "testing testing");
	System.out.println("replaced 'we are testing' with 'testing testing'; linked list: " + A.toString());
	A.add(2, "hellothere");
	System.out.println("Added 'something' between testing testing, and see if this works. Linkedlist: " + A.toString());
	System.out.println(A.get(0));
	System.out.println(A.get(1));
	System.out.println(A.get(2));
	System.out.println(A.get(3));
	//this properly leads to exception: System.out.println(A.get(4));
	//also triggers exception A.remove(10);
	//no swag: triggers exception: A.set(100, "swag");
    }

}

