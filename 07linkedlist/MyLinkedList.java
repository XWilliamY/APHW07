public class MyLinkedList{

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
	    ans = temp.getValue() + ",";
	    temp = temp.getNext();
	    //eventually will become null
	}
	
	ans += " ]";	
	return ans;
    }

    public int get(int index){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	counter = 0;
	LNode temp = head;
	while(counter < index && temp.getNext() != null){
	    temp = temp.getNext();
	    counter++;
	}
	return temp.getValue();
	
    }

    public void set(int index, int value){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}	

	int counter = 0;
	LNode temp = head;

	while(counter < index){
	    counter ++;
	    temp = temp.getNext();
	}
	if(temp == null){
	    temp.setValue(value);
	    size++;
	}
	else{
	    temp.setValue(value);
	}
    }

    public boolean add(int value){
	//add to the last value 
	LNode addOn = new LNode(value);
	LNode temp = head;
	System.out.println("before if");
	if(temp.getNext() == null){
	    temp.setNext(addOn);
	}
	int counter = 0;/*
	while(temp.getNext() != null){
	    temp = temp.getNext();
	    }*/
	temp.setNext(addOn);
	//the while loop will bring us to the end
	size ++; //increase the size
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

    public MyLinkedList(){
	head = new LNode();
	size = 0;
    }


    public static void main(String[]args){
	MyLinkedList A = new MyLinkedList();
	A.add(1);
	A.add(2);
	A.add(3);
	A.add(4);
	System.out.println(A.get(0));
	System.out.println(A.get(1));
	System.out.println(A.get(2));
	System.out.println(A.get(3));
	System.out.println(A.get(0));
	System.out.println(A.get(1));
	System.out.println(A.get(2));
	System.out.println(A.get(3));
	System.out.println(A.toString());

    }

}

