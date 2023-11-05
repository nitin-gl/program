package DSA_GradedProject4;

import java.util.*;

public class BinarySearchTree {
static class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public static Node insert(Node root, int val) {
	if (root == null) {
		root = new Node(val);
		return root;
	}
	if (root.data > val) {
		root.left = insert(root.left, val);

	} else {
		root.right = insert(root.right, val);

	}
	return root;
}

public static void inorder(Node root) {
	if (root == null) {
		return;
	}
	inorder(root.left);
	System.out.print(root.data + " ");
	inorder(root.right);
}

static boolean findpairUtil(Node root, int sum, HashSet<Integer> set){
    // base case
  if (root == null) return false;

  if (findpairUtil(root.left, sum, set)) return true;

  if (set.contains(sum - root.data)){
      System.out.println("Pair is found:  (" + (sum - root.data) + ", " + root.data + ")");
      return true;
  }
  else set.add(root.data);

  return findpairUtil(root.right, sum, set);
}

static void findPair(Node root, int sum){
  HashSet<Integer> set = new HashSet<Integer>();
  if (!findpairUtil(root, sum, set))
      System.out.print("Pairs do not exit \n");
}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int values[] = { 40,20,60,10,30,70,50 };
		Node root = null;
		
		for (int i = 0; i < values.length; i++) {
			root = insert(root, values[i]);
		}
		System.out.println("Inorder traversal:");
		inorder(root);
		System.out.println();
		
		findPair(root,130);
	}
}
