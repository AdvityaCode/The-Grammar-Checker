/**
 * Binary Search Tree Data Structure. Allows user to hold any comparable data type. Allows BST operations like searching, inserting, deleting, etc.
 * @author: Advitya Singh and Chris Fernandez
 * @version June 6, 2025
 * 
 * Honor Code: I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus.
 */

package proj5;

public class BinarySearchTree<E extends Comparable<E>>
{
    // Only one instance variable: root of BST
    private BSTNode<E> root;

    /**
     * Default constructor: creates BST. 
     */
    public BinarySearchTree() {
    	root = null; 
    }
     
    /**
    * inserts recursively.  I include this one so you can
    * make your own trees in the testing class
    * 
    * @param subroot inserts into subtree rooted at subroot
    * @param newNode node to insert
    * @return the BST rooted at subroot that has newNode inserted
    */
    private BSTNode<E> recursiveInsert(BSTNode<E> subroot, E comparableItem) {
        if (subroot == null) {
            return new BSTNode<>(comparableItem);
        }
        else if (comparableItem.compareTo(subroot.data) > 0) {
            subroot.rlink = recursiveInsert(subroot.rlink, comparableItem);
            return subroot;
        }
        else {  // newNode.data smaller than subroot.data, so newNode goes on left
            subroot.llink = recursiveInsert(subroot.llink, comparableItem);
            return subroot;
        }
    }
     
    /**
    * inserts recursively. Use this in your JUnit tests to
    * build a starting tree correctly
    * 
    * @param newString String to insert
    */
    public void insert(E ComparableItem){
        root = recursiveInsert(root, ComparableItem);
    }
     
    /**
     * Helper method for the search method.
     * @param current Node currently checking if target is at. 
     * @param target String to look for
     * @return boolean true is string is in node, false if not. 
     */
    private boolean recursiveSearch(BSTNode<E> current, E target) {
        if (current == null) {
            return false;
        }

        if (target.compareTo(current.data) == 0 ){
            return true;
        }

        else if (target.compareTo(current.data) > 0) {
            return recursiveSearch(current.rlink, target);
        }
        else {
            return recursiveSearch(current.llink, target);
        }
    }

    /**
     * Checks if a certain string is in the BST recursively.
     * @param target String the user is looking for.
     * @return boolean true is target in BST, false if not. 
     */
    public boolean search(E target) {
        return recursiveSearch(root, target); 
    }

    /**
     * Deletes a value from the BST.
     * @param value to be deleted from the BST.
     */
    public void delete(E value) {
        root = delete(root, value);
    }

    /**
     * Private helper method for delete and does the recursion.
     * @param subroot
     * @param value
     * @return
     */
    private BSTNode<E> delete(BSTNode<E> subroot, E value) {
        // Case: value is not in tree. 
        if (subroot == null) {
            return null;  
        }

        int comparator = value.compareTo(subroot.data);

        // 3 Cases:
        if (comparator < 0) {
            subroot.llink = delete(subroot.llink, value);
        } else if (comparator > 0) {
            subroot.rlink = delete(subroot.rlink, value);
        } else {
            // Value found: 4 deletion cases
            // Case 1: No children (leaf)
            if (subroot.llink == null && subroot.rlink == null) {
                return null;
            }

            // Case 2: Only right child
            else if (subroot.llink == null) {
                return subroot.rlink;
            }

            // Case 3: Only left child
            else if (subroot.rlink == null) {
                return subroot.llink;
            }

            // Case 4: Two children
            else {
                // Find in-order successor (leftmost node of right subtree)
                BSTNode<E> successor = findMin(subroot.rlink);

                // Copy successor's data into current node
                subroot.data = successor.data;

                // Delete successor from right subtree
                subroot.rlink = delete(subroot.rlink, successor.data);
            }
        }

        return subroot;
    }

    /**
     * Helper method for recursiveDelete. Finds the minimum value in the tree. 
     * @param node finds the node with the smallest value. 
     * @return
     */
    private BSTNode<E> findMin(BSTNode<E> node) {
        while (node.llink != null) {
            node = node.llink;
        }
        return node;
    }


    /**
     * Method to find a return a comparable object present in the BST.
     * @param target object to look for and return.
     * @return The object looking for, if found. Else, null. 
     */
    public E find(E target) {
        return findHelper(root, target);
    }

    /**
     * Recursive helper method for find. 
     * @param node to look through. 
     * @param target object to look for. 
     * @return E object when found, or else null.
     */
    private E findHelper(BSTNode<E> node, E target) {
        if (node == null) return null;

        int comparator = target.compareTo(node.data);
        if (comparator == 0) return node.data;
        else if (comparator < 0) return findHelper(node.llink, target);
        else return findHelper(node.rlink, target);
    }

    /**
     * Returns the number of data items (nodes) in the tree.
     * @return int for number of nodes
     */
    public int size() {
        return recursiveSize(root);
    }

    /**
     * Recursive helper method for size()
     * @param node Node to be accounted for in final size
     * @return number of nodes so far 
     */
    private int recursiveSize(BSTNode<E> node) {
        if (node == null) {
            return 0;
        }

        return 1 + recursiveSize(node.llink) + recursiveSize(node.rlink);
    }

    /**
     * Returns a String showing the contents of the tree using inorder traversal.
     */
    public String toString() {
        return toString(root);
    }

    /**
     * Recursive helper method for toString method.
     * @param node to be extracted string from.
     * @return String of the BST so far. 
     */
    private String toString(BSTNode<E> node) {
        if (node == null) {
            return "";
        }

        String left = toString(node.llink);
        // \n is put in here but could be removed and put into Thesaurus and WordCounter.
        String middle = (node.data).toString() + "\n";
        String right = toString(node.rlink);
        return left + middle + right;
    }

	
    /** recursive helper for toStringParen
     * 
     * @param subroot root of subtree to start at
     * @return inorder string of elements in this subtree
     */
    private String toStringParen(BSTNode<E> subroot) {
  	  if (subroot == null) // base case
  		  return "";
  	  else
  		  return "(" + toStringParen(subroot.llink) + " " +
                  subroot.toString() + " " + toStringParen(subroot.rlink) + ")";
    }
    
    /**
     * returns string showing tree structure using parentheses, as shown in class
     */
    public String toStringParen() {
  	  return toStringParen(root);
    }

}