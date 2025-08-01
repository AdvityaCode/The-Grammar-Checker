package proj5;

import org.junit.*;

import static org.junit.Assert.*;
import org.junit.rules.Timeout;

public class BSTTesting {
    @Rule
	public Timeout timeout = Timeout.millis(100); 

    private BinarySearchTree<String> tree;


    @Before
    public void setUp() {
        tree = new BinarySearchTree<String>();
    }

    // Testing search should be true.
   @Test
   public void testDefaultConstruct1() {
    tree.insert("A");
    tree.insert("B");
    tree.insert("C");
    tree.insert("D");
    assertEquals(true, tree.search("A"));
    }

    // Testing a simple search. Should be true. 
    @Test
    public void testSearchTrue() {
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        assertTrue(tree.search("C"));
    }

    // Testing a simple search. Should be false. 
    @Test
    public void testSearchFalse() {
        tree.insert("A");
        tree.insert("A");
        tree.insert("A");
        assertFalse(tree.search("Z"));
    }

    // Testing a simple size. 
    @Test
    public void testSizeGeneralCase() {
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        assertEquals(4, tree.size());
    }

    // An empty tree should have size 0
    @Test
    public void testSizeEmptyTree() {
        assertEquals(0, tree.size());
    }

    // Searching in an empty tree. 
    @Test
    public void testSearchEmptyTree() {
        assertFalse(tree.search("X"));
    }

    //toString should work for empty tree.
    @Test
    public void testToStringEmptyTree() {
        assertEquals("", tree.toString());
    }

    // Searching in a left leaf
    @Test
    public void searchLeftLeaf() {
        tree.insert("M");
        tree.insert("P");
        tree.insert("V");
        assertEquals(true, tree.search("M"));
    }

    // Searching in a right leaf
    @Test
    public void searchRightLeaf() {
        tree.insert("M");
        tree.insert("P");
        tree.insert("V");
        assertEquals(true, tree.search("V"));
    }

    // Searching in the root node should be truwe
    @Test
    public void searchRoot() {
        tree.insert("M");
        assertEquals(true, tree.search("M"));
    }
}
