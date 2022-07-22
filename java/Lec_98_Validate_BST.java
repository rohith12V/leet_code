public class Lec_98_Validate_BST {
  public static void main(String[] args) {
    //
  }

  public boolean isValidBST(TreeNode root) {
    long low = Long.MIN_VALUE;
    long high = Long.MAX_VALUE;
    return isValidBSTUtil(root, low, high);
  }

  private boolean isValidBSTUtil(TreeNode node, long low, long high) {
    if (node == null) return true;
    if (!(low < node.val && high > node.val)) return false;
    return isValidBSTUtil(node.left, low, node.val) && isValidBSTUtil(node.right, node.val, high);
  }
}
