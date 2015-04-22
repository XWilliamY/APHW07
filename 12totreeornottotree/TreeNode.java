import java.util.*;

public class TreeNode{

    private int value;
    private TreeNode left, right;

    public String name(){
	return "yang.william";
    }

    public TreeNode(int v){
	value = v;
    }

    public TreeNode(){
    }

    public TreeNode getLeft(){
	return left;
    }

    public TreeNode getRight(){
	return right;
    }

    public int getValue(){
	return value;
    }

    public void setValue(int v){
	value = v;
    }

    public void setLeft(TreeNode n){
	left = n;
    }

    public void setRight(TreeNode n){
	right = n;
    }

    public void add(TreeNode n){
	if(n.getValue() > value){
	    setRight(n);
	}
	else{
	    setLeft(n);
	}
    }

    public String toString(){
	return "" + getValue();
    }


    public static void main(String[]args){
	TreeNode A = new TreeNode();
	TreeNode B = new TreeNode();
	A.setValue(3);
	B.setValue(4);
	TreeNode C = new TreeNode();
	C.setValue(1);
	A.add(B);
	A.add(C);
	System.out.println(A.toString());
	System.out.println(A.getRight());
	System.out.println(A.getLeft());
    }


}