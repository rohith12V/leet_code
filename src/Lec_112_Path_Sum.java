
public class Lec_112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasSumUtil(root, 0, targetSum);
    }

    /**
     * Given the root of a binary tree and an integer targetSum,
     * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
     *
     * A leaf is a node with no children.
     */
    private boolean hasSumUtil(TreeNode node, int currentSum, int targetSum) {
        // return false if node is null
        if (node == null) return false;
        // add up current nodes value
        currentSum += node.val;
        // check if that's a lead node
        if (node.left == null && node.right == null) return currentSum == targetSum;
        // traverse left and right - as we are only searching for existence OR condition can be used to ignore the searching of right subtree when we found a match in left subtree
        return hasSumUtil(node.left, currentSum, targetSum) || hasSumUtil(node.right, currentSum, targetSum);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13, null, null), new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        );

        TreeNode two = new TreeNode(
                10,
                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11))
        );

        boolean result = new Lec_112_Path_Sum().hasPathSum(treeNode, 22);
        System.out.println(result);
    }
}
