import java.util.ArrayList;
import java.util.List;

public class Lec_102_Level_Order_Traversal {
  public static void main(String[] args) {
    List<List<Integer>> lists =
        new Lec_102_Level_Order_Traversal()
            .levelOrder(
                new TreeNode(
                    2, new TreeNode(4, new TreeNode(6), new TreeNode(8)), new TreeNode(5)));
    System.out.println(lists);
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    final List<List<Integer>> levelOrderTraversal = new ArrayList<>();
    levelOrderUtil(root, 0, levelOrderTraversal);
    return levelOrderTraversal;
  }

  private void levelOrderUtil(
      TreeNode root, int currentLevel, List<List<Integer>> levelOrderTraversal) {
    if (root == null) return;
    if (levelOrderTraversal.size() < currentLevel + 1) {
      levelOrderTraversal.add(new ArrayList<>());
    }
    levelOrderTraversal.get(currentLevel).add(root.val);
    levelOrderUtil(root.left, currentLevel + 1, levelOrderTraversal);
    levelOrderUtil(root.right, currentLevel + 1, levelOrderTraversal);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
