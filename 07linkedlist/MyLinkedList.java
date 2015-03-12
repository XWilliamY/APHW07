public class MyLinkedList{

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

    }

    public void remove(int index){
    }

    public int size(){
    }

    public int indexOf(int value){
    }

    public MyLinkedList(){
    }


    public static void main(String[]args){
    }

}

