import java.io.*;
import java.util.*;

public class BTree<E> {
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<E> root;


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
	if(curr.howFull() < 2){
	    if(curr.howFull() == 0){
		//randomly add here
		curr.setRight(bn);
		System.out.println(curr.getRight().getValue());
	    }
	    else if(curr.emptyRight()){
		curr.setRight(bn);
		System.out.println(curr.getRight().getValue());
	    }
	    else if(curr.emptyLeft()){
		curr.setLeft(bn);
		System.out.println(curr.getLeft().getValue());
	    }
	}
	else{
	    add(curr.getRight(), bn);
	    System.out.println(curr.getRight().getValue());
	}
    }

    public static void main(String[]args){
	BTree A = new BTree();
	/*
	System.out.println("null: ");
	A.add(new Integer(5));
	System.out.println("the bn: ");
	A.add(new Integer(10));
	System.out.println("the bn after:");
	A.add(new Integer(154));
	A.add(new Integer(200));
	*/

    }
}