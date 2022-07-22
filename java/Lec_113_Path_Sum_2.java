import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lec_113_Path_Sum_2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        final List<List<Integer>> possiblePaths = new ArrayList<>();
        hasSumUtil(root, 0, targetSum, possiblePaths, new Stack<>());
        return possiblePaths;
    }

    private void hasSumUtil(TreeNode node, int currentSum, int targetSum, List<List<Integer>> possiblePaths, Stack<Integer> currentStack) {
        // return false if node is null
        if (node == null) return;
        // add up current nodes value
        currentStack.add(node.val);
        currentSum += node.val;
        // check if that's a leaf node
        if (node.left == null && node.right == null && currentSum == targetSum) possiblePaths.add(new ArrayList<>(currentStack));
        // traverse left and right - as we are only searching for existence OR condition can be used to ignore the searching of right subtree when we found a match in left subtree
        hasSumUtil(node.left, currentSum, targetSum, possiblePaths, currentStack);
        hasSumUtil(node.right, currentSum, targetSum, possiblePaths, currentStack);
        currentStack.pop();
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13, null, null), new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        );
        List<List<Integer>> pathSum = new Lec_113_Path_Sum_2().pathSum(treeNode, 22);
        System.out.println(pathSum);
    }
}
