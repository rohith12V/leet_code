import java.util.ArrayList;
import java.util.List;

public class Lec_437_Path_Sum_3 {
    public static void main(String[] args) {
        TreeNode two = new TreeNode(
                10,
                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11))
        );
        int pathSum = new Lec_437_Path_Sum_3().pathSum(two, 8);
        System.out.println(pathSum);
    }

    public int pathSum(TreeNode root, int targetSum) {
        return hasSumUtil(root, 0, targetSum);
    }

    private int hasSumUtil(TreeNode node, int currentSum, int targetSum) {
        // check if that's a leaf node
        if (currentSum == targetSum) {
            return 1;
        }
        if (node == null) {
            return 0;
        }
        // traverse left and right - as we are only searching for existence OR condition can be used to ignore the searching of right subtree when we found a match in left subtree
        return hasSumUtil(node.left, currentSum, targetSum)
                + hasSumUtil(node.left, currentSum + node.val, targetSum)
                + hasSumUtil(node.right, currentSum, targetSum)
                + hasSumUtil(node.right, currentSum + node.val, targetSum);
    }
}
