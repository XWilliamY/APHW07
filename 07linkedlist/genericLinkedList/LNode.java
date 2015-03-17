import java.util.*;

public class LNode<T>{

    private T value;
    private LNode<T> next;

    public String name(){
	return "yang.william";
    }

    public LNode(T v){
	value = v;
    }

    public LNode(){
    }

    public LNode<T> getNext(){
	return next;
    }

    public T getValue(){
	return value;
    }

    public void setValue(T v){
	value = v;
    }

    public void setNext(LNode<T> n){
	next = n;
    }

    public String toString(){
	return "" + getValue();
    }

    public static void main(String[]args){
	LNode<Integer> A = new LNode<Integer>();
	A.setValue(3);
	System.out.println(A.toString());
	System.out.println(A.getNext());
    }
}
