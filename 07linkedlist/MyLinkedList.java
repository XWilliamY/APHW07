public class MyLinkedList{

    //C-k kills the line
    //C-p moves up a line
    //C-n moves down a line
    //C-a goes to the beginning of a line
    //C-e goes to the end of a line

    private LNode head;
    private LNode current;
    private LNode tail;
    private int size;
    private int counter;

    public String toString(){
	String ans = "[ ";
	LNode temp = head;
	while(temp != null){
	    //there is stuff still to be added 
	    //do something with temp
	    ans += temp.getValue() + ",";
	    temp = temp.getNext();
	    //eventually will become null
	}
	ans = ans.substring(0, ans.length()-1);	
	ans += " ]";	
	return ans;
    }

    public int get(int index){
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

    public void set(int index, int value){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}	

	int counter = 0;
	LNode temp = head;

	while(counter < index){
	    temp = temp.getNext();
	    counter++;	
	}
	// increment until counter < index by one
	//since that means temp is at right location
	//set temp = to the new value 
	temp.setValue(value);
    }

    public boolean add(int value){
	//we're adding a new node with a new value 
	LNode temp = head;

	if(size == 0){
	    head = new LNode(value);
	    tail = head;
	    //if the linkedlist has only one variable
	    //the beginning is the end
	}
	else{
	    LNode addOn = new LNode(value);
	    tail.setNext(addOn); //what comes after tail is addOn
	    //head, head+1, ....tail, addOn
	    //the one after tail is the newer tail
	    tail = addOn;
	    //make addOn the newer tail	
	    //head, head+1, ...previousTail(tail), addOn(new tail)
	}
	size++;
	return true;
    }

    public void add(int index, int value){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	if(index == 0){
	    LNode addNode = new LNode(value);
	    LNode afterNewNode = head;
	    addNode.setNext(head);
	    head = addNode;
	}/*
	else{
	    LNode temp = head;
	    for(int i = 0; i < index; i++){
		temp = temp.getNext();
	    }
	    LNode tempAfter = temp.getNext().getNext();
	    LNode newNode = new LNode(value);
	
	    newNode.setNext(tempAfter);
	    temp.setNext(newNode);
	    size++;
	    }*/
    }
	


    public void remove(int index){
	//to remove an element in a linked list
	//all you have to do is remove the link to it
	//garbage collection will render space unused
	LNode temp = head;

	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}

	//if we're deleting the first element, we only need to set
	//the second element as head
	if(index == 0){
	    head = head.getNext();
	}

	//0,1,2,3,4,5: index 3 (remove the 3)
	for(int i = 0; i < index-1; i++){
	    temp = temp.getNext();
	}
	temp.setNext(temp.getNext().getNext());
	//we get next twice to skip the first temp.getNext()
	//0, 1, 2
	//before: temp = 0, .getNext() = 1, .getNext().getNext() = 2
	//now: temp = 0, .getNext() = .getNext().getNext() = 2
	tail = temp;
	size--;	
    }
    

    public int size(){
	return size;
    }


    public int indexOf(int value){
	//increment until you find the first node with value = this 
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
	A.add(0);
	A.add(1);
	A.add(2);
	A.add(3);
	A.add(4);
	A.remove(3);
	System.out.println(A.toString());
	A.add(0, 1);
	A.add(0, 10);
	System.out.println(A.toString());
    }

}

