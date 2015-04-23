import java.util.*;

public class TreeNode<T>{

    private T value;
    private TreeNode<T> left, right;

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
	left = n;
    }

    public void setRight(TreeNode<T> n){
	right = n;
    }

    public String toString(){
	return "" + getValue();
    }

    public static void main(String[]args){
	TreeNode<Integer> A = new TreeNode<Integer>();
	A.setValue(new Integer(10));
	TreeNode<Integer> B = new TreeNode<Integer>(5);
	A.setRight(B);
	System.out.println(A.getRight().toString());
	System.out.println(A.toString());
    }


}