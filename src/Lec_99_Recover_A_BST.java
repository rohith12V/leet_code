import java.util.ArrayList;
import java.util.List;

public class Lec_99_Recover_A_BST {
  public static void main(String[] args) {
    //
  }

  public void recoverTree(TreeNode root) {
    List<Integer> inorderTraversalResult = new ArrayList<>();
    recoverTreeUtil(root, inorderTraversalResult);
    int low = 0;
    int high = inorderTraversalResult.size() - 1;

    int firstIndex = -1;
    int secondIndex = -1;
  }

  private void recoverTreeUtil(TreeNode root, List<Integer> result) {
    if (root == null) return;
    recoverTreeUtil(root.left, result);
    result.add(root.val);
    recoverTreeUtil(root.right, result);
  }
}
