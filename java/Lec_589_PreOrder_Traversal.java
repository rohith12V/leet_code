import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Depth First Traversals: (a) Inorder (Left, Root, Right) : 4 2 5 1 3 (b) Preorder (Root,
 * Left,Right) : 1 2 4 5 3 (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class Lec_589_PreOrder_Traversal {
  public static void main(String[] args) {
    new Lec_589_PreOrder_Traversal().preorderUtilIterative(new Node(1));
  }

  private List<Integer> preorderUtilIterative(Node root) {
    final Stack<Node> stack = new Stack<>();
    final List<Integer> resultList = new ArrayList<>();
    if (root == null) return resultList;
    Node temp = null;
    stack.add(root);
    while (!stack.isEmpty()) {
      temp = stack.pop();
      resultList.add(temp.val);
      if (temp.children != null) {
        for (int i = temp.children.size() - 1; i >= 0; i--) {
          stack.add(temp.children.get(i));
        }
      }
    }
    return resultList;
  }

  public List<Integer> preorder(Node root) {
    final List<Integer> result = new ArrayList<>();
    preorderUtil(root, result);
    return result;
  }

  private void preorderUtil(Node root, List<Integer> result) {
    if (root == null) return;
    result.add(root.val);
    root.children.forEach(child -> preorderUtil(child, result));
  }
}

// Definition for a Node.
class Node {
  public int val;
  public List<Node> children;

  public Node() {}

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, List<Node> _children) {
    val = _val;
    children = _children;
  }
}
