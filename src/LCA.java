
import java.util.ArrayList;
import java.util.List;

public class LCA {
    Node root;
    public List<Integer> path1 = new ArrayList<>();
    public List<Integer> path2 = new ArrayList<>();


    int findLCA(Node root, int n1, int n2) {

        path1.clear();
        path2.clear();

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) return -1;

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i - 1);
    }

    public boolean findPath(Node root, int n, List<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

}