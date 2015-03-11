public class LNode{

    private int value;
    private LNode next;

    //an object can refer to itself 

    public int getNext(){
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
	return "[ " + getValue() + " ]";
    }

    public static void main(String[]args){
	LNode A = new LNode();
	A.setValue(5);
	LNode B = new LNode();
	B.setValue(3);
	A.setNext(B);
	System.out.println(A + "," + B);
    }
}