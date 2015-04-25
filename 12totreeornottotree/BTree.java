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
	}
	else if(curr.emptyLeft()){
	    curr.setLeft(bn);
	}
	else{
	    if(where == 0){
		add(curr.getLeft(), bn);
	    }
	    else{
		add(curr.getRight(), bn);
	    }
	}
    }

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
	//top, left to right
	//down, left to right
	if(curr == null){
	    return;
	}
	System.out.print(curr + " ");
	//top
	preOrder(curr.getLeft());
	//left -> recursive
	preOrder(curr.getRight());
	//right -> recursive
    }

    public void postOrder(TreeNode<E> curr){
	//in order is CCV
	//meaning leftmost left value first
	//going back to the leftmost
	//finally the center
	if(curr == null){
	    return;
	}
	postOrder(curr.getLeft());
	postOrder(curr.getRight());
	System.out.print(curr + " ");
    }

    public void inOrder(TreeNode<E> curr){
	//in order is CVC 
	//meaning leftmost then root then right value
	if(curr == null){
	    return;
	}
	inOrder(curr.getLeft());
	System.out.print(curr + " ");
	inOrder(curr.getRight());
    }

    public int getHeight(){
	return getHeight(root);
    }

    public int getHeight(TreeNode<E> curr){
	if (curr == null){
	    return 0;
	}
	else if(curr.getRight() == null && curr.getLeft() == null){
	    return 1;
	}
	else{
	    return 1 + Math.max(getHeight(curr.getLeft()), getHeight(curr.getRight()));
	    //adds one if the 'curr' has left and right, otherwise returns zero 
	}
    }

    public String getLevel(int level){
	return getLevel(root, level);
    }

    public String getLevel(TreeNode<E> curr, int level){
	if(level > getHeight()){
	    throw new Error("Bah humbug!");
	}
	//         0
	//    1         2 
	//   2 3       3 4
	//would return 2, 3, 3, 4 if getLevel(2)
	if(curr == null){
	    return "";
	}
	if(level == 0){
	    return "" + curr;
	}
       	else{
	    return getLevel(curr.getLeft(), level-1) + " " + getLevel(curr.getRight(), level-1);
	    //go down one, subtract one from level 
	    //in order from left to right
	}
    }



    public static void main(String[]args){
	BTree<Integer> A = new BTree<Integer>();
	for(int i = 0; i < 8; i++){
	    A.add(i);
	}
	System.out.println("PRE_ORDER: ");
	BTree<Integer> B = new BTree<Integer>();
	System.out.println("pre order: ");
	A.traverse(PRE_ORDER);
	System.out.println("in order: ");
	A.traverse(IN_ORDER);
	System.out.println("post order:  ");
	A.traverse(POST_ORDER);
	System.out.println(A.getHeight());
	System.out.println("get levels");
	System.out.println(A.getLevel(0));
	System.out.println(A.getLevel(1));
	System.out.println(A.getLevel(2));
	System.out.println(A.getLevel(3));
	System.out.println(A.getLevel(4));
    }
}