import java.util.ArrayList;
import java.util.List;

public class Lec_94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        inorderTraversalUtil(root, result);
        return result;
    }
    public void inorderTraversalUtil(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversalUtil(root.left, result);
        result.add(root.val);
        inorderTraversalUtil(root.right, result);
    }
}

