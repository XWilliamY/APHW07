public class LNode{

    private int value;
    private LNode next;

    //an object can refer to itself 

    public LNode(int value){
	setValue(value);
	next = null;
    }

    public LNode(){
    }

    public LNode getNext(){
	return next;
    }

    public int getValue(){
	return value;
    }

    public void setValue(int value){
	this.value = value;
    }

    public void setNext(LNode next){
	this.next = next;
    }

    public String toString(){
	return "" + getValue();
    }

}