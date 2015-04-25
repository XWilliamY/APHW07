import java.io.*;
import java.util.*;

public class BTree<E> {
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<E> root;

    public String name(){
	return "yang.william";
    }

    public BTree(){
	root = null;
    }

    public void add(E d){
	if(root == null){
	    root = new TreeNode<E> (d);
	    System.out.println(root.getValue());
	}
	else{
	    TreeNode<E> bn = new TreeNode<E> (d);
	    add(root, bn);
	}
    }

    private void add( TreeNode<E> curr, TreeNode<E> bn){
	Random rand = new Random();
	int where = rand.nextInt(2); //0-1
	if(curr.emptyRight()){
	    curr.setRight(bn);
	    //System.out.println(curr.getRight().getValue());
	}
	else if(curr.emptyLeft()){
	    curr.setLeft(bn);
	    //System.out.println(curr.getLeft().getValue());
	}
	else{
	    if(where == 0){
		//where == 0, add left
		add(curr.getLeft(), bn);
	    }
	    else{
		add(curr.getRight(), bn);
		//System.out.println(curr.getRight().getValue());
	    }
	}
    }
    /*
    public void traverse(int mode){
	if(mode == PRE_ORDER)
	    preOrder(root);
	else if(mode == IN_ORDER)
	    inOrder(root);
	else
	    postOrder(root);
	System.out.println();
    }
    
    public void preOrder(TreeNode<E> curr){
	if(curr != null){
	    //add the root value to the string first
	    String ans = "" + curr.getValue();
	    //if both left and right are empty, then end and return
	    if(curr.noChildren()){
		System.out.println(ans);
	    }
	    else{
		System.out.println(ans + preOrder(curr.getLeft()) + preOrder(curr.getRight()));
		//VCC
		//root + left side down + right side down 
	    }
	}
	}*/

    public static void main(String[]args){
	BTree A = new BTree();
	System.out.println("null: ");
	A.add(new Integer(5));
	System.out.println("the bn: ");
	A.add(new Integer(10));
	System.out.println("the bn after:");
	A.add(new Integer(154));
	A.add(new Integer(200));
	//System.out.println(A.preOrder());

    }
}