public class Lec_100_Same_Tree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return isSameTreeUtil(p, q);
  }

  public boolean isSameTreeUtil(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    return p.val == q.val && isSameTreeUtil(p.left, q.left) && isSameTreeUtil(p.right, q.right);
  }
}
