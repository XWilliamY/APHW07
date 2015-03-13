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
	while(counter < index){
	    temp.getNext();
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
	    temp.getNext();
	}
	if(temp.getNext() == null){
	    temp.setValue(value);
	    size++;
	}
	else{
	    temp.setValue(value);
	}
    }

    public boolean add(int value){
	LNode temp = head;
	while(temp.getNext() != null){
	    temp.getNext();
	}
	//the while loop will bring us to the end
	size ++; //increase the size
	temp.setValue(value);
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
	A.add(5);
	A.add(6);
	A.set(1, 1);
	System.out.println(A.get(0));
	System.out.println(A.get(1));
	System.out.println(A.size());
	System.out.println(A.toString());

    }

}

