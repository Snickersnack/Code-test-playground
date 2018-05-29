package test;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeToDList {

	public static void main(String[] args){
		
		
		BST tree = new BST(30);
		tree.insert(10);
		tree.insert(50);
		tree.insert(5);
		tree.insert(15);
		tree.insert(45);
		tree.insert(60);
		tree.display(tree.root);
		Node node = solve(tree.root);
		while(node.left != null){
			node = node.left;
		}
		while(node.right != null){
			System.out.println("DLL: " + node.value);
			node = node.right;
		}

		
		
	}
	
	public static Node solve(Node root){
		if(root.left == null && root.right == null){
			return root;
		}
		Node currentLeft = null;
		Node currentRight = null;

		if(root.left != null){
			currentLeft = root.left;
			while(currentLeft.right !=null){
				currentLeft = currentLeft.right;
			}

			
		}
		if(root.right != null){
			currentRight = root.right;
			while(currentRight.left != null){
				currentRight = currentRight.left;
			}

		}
		System.out.println(root.value);

		solve(root.left);
		solve(root.right);
		root.left = currentLeft;
		currentLeft.right = root;
		root.right = currentRight;
		currentRight.left = root;
		return root;
	}
	
	

	
	public static class Node{
		Node left;
		Node right;
		int value;
		
		public Node(int value){
			this.value = value;
		}
	}
	
	public static class BST{
		Node root;
		
		public BST(int value){
			Node node = new Node(value);
			root = node;
		}
		
		public void insert(int value){
			Node node = new Node(value);
			if(root == null){
				root = node;
			}
			
			Node current = root;
			boolean found = false;
			while(!found){
				if(node.value<current.value){
					if(current.left== null){
						current.left = node;
						return;
					}else{
						current=current.left;
					}
				}else{
					if(current.right==null){
						current.right = node;
						return;
					}else{
						current=current.right;
					}
				}
			}
		}
		
		public void display(Node root){
			if(root == null){
				return;
			}
			display(root.left);
			System.out.println(root.value);
			display(root.right);

		}
	}
}
