public class MyLinkedList{

    private LNode head;
    private int size;

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
	ans.substring(0, ans.length()-1);
	ans += " ]";	
	return ans;
    }

    public int get(int index){
	int counter = 0;
	LNode temp = head;
	while(temp != null){
	    if(counter == index){ // if we've reached the destination
		return temp.getValue();
	    }
	    temp.getNext();
	    counter ++;
	}
	return -1;
    }

    public void set(int index, int value){
	int counter = 0;
	LNode temp = head;
	while(temp != null){
	    if(counter == index){
		temp.setValue(value);
	    }
	    counter ++;
	    temp.getNext();
	}
    }

    public void add(int value){
	LNode temp = head;
	while(temp != null){
	    temp.getNext();
	}
	//the while loop will bring us to the end
	size ++; //increase the size
	temp.setValue(value);
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
	System.out.println(A.toString());

    }

}

