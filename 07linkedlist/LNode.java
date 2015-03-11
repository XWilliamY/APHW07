public class LNode{

    private int value;
    private LNode next;

    //an object can refer to itself 

    public int getNext(){
	return next.getValue();
    }

    public int getValue(){
	return value;
    }

    public void setValue(int n){
	value = n;
    }

    public void setNext(int n){
	next.setValue(n);
    }

    public String toString(){
	return "[ " + getValue() + " ]";
    }

    public static void main(String[]args){
	LNode A = new LNode();
	A.setValue(5);
	A.setNext(5);
	System.out.println(A.toString());
    }
}