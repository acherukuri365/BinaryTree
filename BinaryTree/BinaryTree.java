import java.util.ArrayList;
/**
 *	Binary Tree of Comparable values.
 *	The tree only has unique values. It does not add duplicate values.
 *	
 *	@author	Anirudh Cherukuri
 *	@since	May 16 2023
 */
public class BinaryTree<E extends Comparable<E>> {

	private TreeNode<E> root;		// the root of the tree
	
	private ArrayList<E> list;		// list of values for balanced tree
	
	private final int PRINT_SPACES = 3;	// print spaces between tree levels
										// used by printTree()
	
	/**	constructor for BinaryTree */
	public BinaryTree() {
		root = null;
		list = new ArrayList<E>();
	}
	
	/**	Field accessors and modifiers */
	
	/**	Add a node to the tree
	 *	@param value		the value to put into the tree
	 */
	public void add(E value) {
		if(root == null) {
			root = new TreeNode<E>(value);
			return;
		}
			
		TreeNode<E> node = root;
		TreeNode<E> child = null;
		while(true) {
			if(value.compareTo(node.getValue()) < 0) {
				child = node.getLeft();
				if(child == null) {
					TreeNode<E> newNode = new TreeNode<E>(value);
					node.setLeft(newNode);
					return;
				}
				else
					node = node.getLeft();
			}
			else {
				child = node.getRight();
				if(child == null) {
					TreeNode<E> newNode = new TreeNode<E>(value);
					node.setRight(newNode);
					return;
				}
				else
					node = node.getRight();
			}
		}
	}
	
	/**
	 *	Print Binary Tree Inorder
	 */
	public void printInorder() {
		printInorder(root);
	}
	
	private void printInorder(TreeNode<E> node) {
		if(node == null)
			return;
		
		//~ System.out.println("\n" + node.getLeft().getValue() + "\n\n");
		
		printInorder(node.getLeft());
		
		System.out.print(node.getValue() + " ");
		list.add(node.getValue());
		
		printInorder(node.getRight());
	}
	
	/**
	 *	Print Binary Tree Preorder
	 */
	public void printPreorder() {
		printPreorder(root);
	}
	
	private void printPreorder(TreeNode<E> node) {
		if(node == null)
			return;
		
		System.out.print(node.getValue() + " ");
		
		printPreorder(node.getLeft());
		
		printPreorder(node.getRight());
	}
	
	/**
	 *	Print Binary Tree Postorder
	 */
	public void printPostorder() {
		printPostorder(root);
	}
	
	private void printPostorder(TreeNode<E> node) {
		if(node == null)
			return;
		
		printPostorder(node.getLeft());
		
		printPostorder(node.getRight());
		
		System.out.print(node.getValue() + " ");
	}
		
	/**	Return a balanced version of this binary tree
	 *	@return		the balanced tree
	 */
	public BinaryTree<E> makeBalancedTree() {
		BinaryTree<E> balancedTree = new BinaryTree<E>();
		
		int min = 0;
		int max = list.size() - 1;
		int mid = (max + min) / 2;
		
		balance(balancedTree, min, max);
		
		return balancedTree;
	}
	
	private void balance(BinaryTree<E> tree, int min, int max) {
		int mid = (min + max) / 2;
		tree.add(list.get(mid));
		
		if(min >= max)
			return;
		
		balance(tree, min, mid - 1);
		balance(tree, mid + 1, max);
	}
	
	/**
	 *	Remove value from Binary Tree
	 *	@param value		the value to remove from the tree
	 *	Precondition: value exists in the tree
	 */
	public void remove(E value) {
		root = remove(root, value);
	}
	/**
	 *	Remove value from Binary Tree
	 *	@param node			the root of the subtree
	 *	@param value		the value to remove from the subtree
	 *	@return				TreeNode that connects to parent
	 */
	public TreeNode<E> remove(TreeNode<E> node, E value) {
		if(value.compareTo(node.getValue()) < 0) {
			if(node.getLeft() != null &&
				node.getLeft().getValue().compareTo(value) == 0) {
				
				if(node.get
			}
		}
		
		if(node.getValue().compareTo(value) == 0) {
			
		}
		
		
		return null;
	}
	

	/*******************************************************************************/	
	/********************************* Utilities ***********************************/	
	/*******************************************************************************/	
	/**
	 *	Print binary tree
	 *	@param root		root node of binary tree
	 *
	 *	Prints in vertical order, top of output is right-side of tree,
	 *			bottom is left side of tree,
	 *			left side of output is root, right side is deepest leaf
	 *	Example Integer tree:
	 *			  11
	 *			/	 \
	 *		  /		   \
	 *		5			20
	 *				  /	  \
	 *				14	   32
	 *
	 *	would be output as:
	 *
	 *				 32
	 *			20
	 *				 14
	 *		11
	 *			5
	 ***********************************************************************/
	public void printTree() {
		printLevel(root, 0);
	}
	
	/**
	 *	Recursive node printing method
	 *	Prints reverse order: right subtree, node, left subtree
	 *	Prints the node spaced to the right by level number
	 *	@param node		root of subtree
	 *	@param level	level down from root (root level = 0)
	 */
	private void printLevel(TreeNode<E> node, int level) {
		if (node == null) return;
		// print right subtree
		printLevel(node.getRight(), level + 1);
		// print node: print spaces for level, then print value in node
		for (int a = 0; a < PRINT_SPACES * level; a++) System.out.print(" ");
		System.out.println(node.getValue());
		// print left subtree
		printLevel(node.getLeft(), level + 1);
	}
	
	
}
