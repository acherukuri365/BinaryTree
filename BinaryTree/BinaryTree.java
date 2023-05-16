/**
 *	Binary Tree of Comparable values.
 *	The tree only has unique values. It does not add duplicate values.
 *	
 *	@author	Anirudh Cherukuri
 *	@since	May 16 2023
 */
public class BinaryTree<E extends Comparable<E>> {

	private TreeNode<E> root;		// the root of the tree
	
	private final int PRINT_SPACES = 3;	// print spaces between tree levels
										// used by printTree()
	
	/**	constructor for BinaryTree */
	public BinaryTree() {
		root = null;
	}
	
	/**	Field accessors and modifiers */
	
	/**	Add a node to the tree
	 *	@param value		the value to put into the tree
	 */
	public void add(E value) {
		//~ TreeNode<E> node = new TreeNode<E>(root.getValue(), root.getLeft(), root.getRight());
		//~ TreeNode<E> node = root;
		if(root == null) {
			//~ System.out.println("happy");
			root = new TreeNode<E>(value);
			return;
		}
		TreeNode<E> node = new TreeNode<E>(root.getValue(), root.getLeft(), root.getRight());
		//~ System.out.println("happy2");
		while(node.getLeft() != null || node.getRight() != null) {
			if(value.compareTo(node.getValue()) < 0)
				node = node.getLeft();
			else
				node = node.getRight();
		}
		
		if(value.compareTo(node.getValue()) < 0) {
			node.setLeft(new TreeNode(value));
			System.out.println("less than");
		}
		else
			node.setRight(new TreeNode(value));
	}
	
	/**
	 *	Print Binary Tree Inorder
	 */
	public void printInorder() {
		printInorder(root);
	}
	
	public void printInorder(TreeNode<E> node) {
		if(node == null)
			return;
		
		printInorder(node.getLeft());
		
		System.out.println(node.getValue() + " ");
		
		printInorder(node.getRight());
	}
	
	/**
	 *	Print Binary Tree Preorder
	 */
	public void printPreorder() {
		if(node == null)
			return;
		
		System.out.println(node.getValue() + " ");
		
		printInorder(node.getLeft());
		
		printInorder(node.getRight());
	}
	
	/**
	 *	Print Binary Tree Postorder
	 */
	public void printPostorder() {
		if(node == null)
			return;
		
		printInorder(node.getLeft());
		
		printInorder(node.getRight());
		
		System.out.println(node.getValue() + " ");
	}
		
	/**	Return a balanced version of this binary tree
	 *	@return		the balanced tree
	 */
	public BinaryTree<E> makeBalancedTree() {
		BinaryTree<E> balancedTree = new BinaryTree<E>();

		return balancedTree;
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
