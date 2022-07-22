public class Lec_101_Symmetric_Tree {
  public boolean isSymmetric(TreeNode root) {
    return isSameTreeUtil(root.left, root.right);
  }

  public boolean isSameTreeUtil(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    return p.val == q.val && isSameTreeUtil(p.left, q.right) && isSameTreeUtil(p.right, q.left);
  }
}
