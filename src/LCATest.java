import static org.junit.Assert.*;
import org.junit.Test;

public class LCATest {

    @Test
    public void EmptyRoot() {
        LCA tree = new LCA();

        assertEquals("LCA of 8 and 4 is ",-1, tree.findLCA(8,4)); //testing empty tree
        assertEquals("LCA of 1 and 2 is ",false, tree.findPath(tree.root,2,tree.path1)); //testing empty nodes
        assertEquals("LCA of 1 and 2 is ",false, tree.findPath(tree.root,2,tree.path2));

    }


    @Test
    public void LCATest() {

        LCA tree = new LCA();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.right.right = new Node(8);

        assertEquals("LCA of 8 and 4 is ",2, tree.findLCA(8,4));
        assertEquals("LCA of -8 and -4 is ", -1, tree.findLCA(-8, -4));
        assertEquals("LCA of 0 and 1 is ", -1, tree.findLCA(0,1));
        assertEquals("LCA of 5 and 100 is null", -1, tree.findLCA(5, 100));
    }



}