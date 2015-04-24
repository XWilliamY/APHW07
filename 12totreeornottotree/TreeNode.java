import java.util.*;

public class TreeNode<T>{

    private T value;
    private TreeNode<T> left, right;
    private int full;

    public String name(){
	return "yang.william";
    }

    public TreeNode(T v){
	value = v;
    }

    public TreeNode(){
    }

    public TreeNode<T> getLeft(){
	return left;
    }

    public TreeNode<T> getRight(){
	return right;
    }

    public T getValue(){
	return value;
    }

    public void setValue(T v){
	value = v;
    }

    public void setLeft(TreeNode<T> n){
	full++;
	left = n;
    }

    public void setRight(TreeNode<T> n){
	full++;
	right = n;
    }

    public String toString(){
	return "" + getValue();
    }

    public boolean noChildren(){
	if(full == 0){
	    return true;
	}
	return false;
    }

    public int howFull(){
	return full;
    }

    public boolean emptyRight(){
	return (right == null);
    }

    public boolean emptyLeft(){
	return left == null;
    }


    public static void main(String[]args){
	TreeNode<Integer> A = new TreeNode<Integer>();
	A.setValue(new Integer(10));
	TreeNode<Integer> B = new TreeNode<Integer>(5);
	A.setRight(B);
	System.out.println(A.getRight().toString());
	System.out.println(A.toString());
	System.out.println(A.howFull());
	System.out.println(A.emptyRight());
	System.out.println(A.noChildren());
    }


}