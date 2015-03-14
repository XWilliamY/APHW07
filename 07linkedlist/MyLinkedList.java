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
	    tail.setNext(addOn);
	    //the one after tail is the newer tail
	    tail = addOn;
	    //make addOn the newer tail	
	}
	size++;
	return true;
    }
    /*
    public void remove(int index){
	int counter = 0;
	LNode temp = head;
	while(temp != null){
	    if(counter == index){
		temp.setValue(null);
	    }
	    counter ++;
	    temp.getNext();
	}
    }
    */
    public int size(){
	return size;
    }

    public int indexOf(int value){
	int counter = 0;
	LNode temp = head;
	while(temp != null){
	    if(temp.getValue() == value){
		return counter;
	    }
	    counter ++;
	    temp.getNext();
	}
	return -1;
    }

    public static void main(String[]args){
	MyLinkedList A = new MyLinkedList();
	A.add(5);
	A.add(1);
	A.add(2);
	A.add(4);
	System.out.println(A.get(0));
	System.out.println(A.get(1));
	System.out.println(A.get(2));
	System.out.println(A.get(3));

	System.out.println(A.toString());

    }

}

