import java.util.*;

public class LNode<T>{

    private T value;
    private LNode<T> next;

    public LNode(T value){
	this.value = value;
    }

    public LNode(){
    }

    public LNode getNext(){
	return next;
    }

    public T getValue(){
	return value;
    }

    public void setValue(T value){
	this.value = value;
    }

    public void setNext(LNode<T> next){
	this.next = next;
    }

    public String toString(){
	return "" + getValue();
    }
}
