public class Lec235_LCA_BST {
  public static void main(String[] args) {
    //
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // if we do not find the node
    if (root == null) {
      return null;
    }
    // case -1 when p & q lie on different sides of tree
    if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
      return root;
    }

    // if one of the node matches either left / right view
    if (p.val == root.val) {
      return p;
    }
    if (q.val == root.val) {
      return q;
    }

    //
    if (p.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    return lowestCommonAncestor(root.right, p, q);
  }
}
