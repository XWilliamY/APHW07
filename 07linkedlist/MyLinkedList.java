public class MyLinkedList<T>{

    private LNode<T> head;
    private LNode<T> current;
    private LNode<T> tail;
    private int size;
    private int counter;

    public String toString(){
	String ans = "[ ";
	LNode temp = head;
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
	LNode temp = head;
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
	LNode temp = head;

	while(counter < index){
	    temp = temp.getNext();
	    counter++;
	}
	temp.setValue(value);
    }

    public boolean add(T value){
	LNode temp = head;

	if(size == 0){
	    head = new LNode(value);
	    tail = head;
	}

	else{
	    LNode addOn = new LNode(value);
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
	    LNode addNode = new LNode(value);
	    addNode.setNext(head);
	    head = addNode;
	}
	else{
	    LNode temp = head;
	    for(int i = 0; i < index-1; i++){
		temp = temp.getNext();
	    }
	    LNode addNode = new LNode(value);
	    addNode.setNext(temp.getNext());
	    temp.setNext(addNode);
	}
	size++;
    }

    public void remove(int index){
	LNode temp = head;
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
	LNode temp = head;
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
	A.add(10);
	A.add(10);
	A.add(10);
	A.add(1, 5);
	A.add(2, 6);
	A.add(3, 7);
	A.add(4, 8);
	System.out.println(A.size());
	System.out.println(A.toString());
    }

}

