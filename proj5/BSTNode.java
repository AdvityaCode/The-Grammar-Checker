package proj5;

/** A reusable node class, since it can hold E data.
 * 
 * @author Chris Fernandes and Advitya Singh
 * @version June 6, 2025
 */
public class BSTNode<E> {

	// 3 instance variables
	// data is the object that the BST is holding
	// llink is the left node of the this node
	// rlink is the right node of this node
	public E data;
	public BSTNode<E> llink;
	public BSTNode<E> rlink;
	
	/**
	 * non-default constructor
	 * @param newKey string that node will hold
	 */
	public BSTNode(E newKey)
	{
		data = newKey;
		llink = null;
		rlink = null;
	}
	
	/**
	 * returns key as printable string
	 */
	public String toString()
	{
		return (String) data;
	}
}
