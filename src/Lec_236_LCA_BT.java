public class Lec_236_LCA_BT {
  public static void main(String[] args) {
    //
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (root.val == p.val) return p;
    if (root.val == q.val) return q;
    TreeNode leftSubTree = lowestCommonAncestor(root.left, p, q);
    TreeNode rightSubTree = lowestCommonAncestor(root.right, p, q);
    if (leftSubTree != null && rightSubTree != null) return root;
    if (leftSubTree != null) return leftSubTree;
    return rightSubTree;
  }
}
