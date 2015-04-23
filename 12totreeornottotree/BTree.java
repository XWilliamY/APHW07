import java.io.*;
import java.util.*;

public class BTree<E> {
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<E> root;
    private TreeNode<E> left;
    private TreeNode<E> right;


    public BTree(){
	root = null;
    }

    public void add(E d){ }

    private void add( TreeNode<E> curr, TreeNode<E> bn){
    }

    public void traverse(int mode){
	if(mode == PRE_ORDER){
	    preOrder(root);
	}
	else if(mode == IN_ORDER){
	    inOrder(root);
	}
	else{
	    postOrder(root);
	}
	System.out.println();
    }