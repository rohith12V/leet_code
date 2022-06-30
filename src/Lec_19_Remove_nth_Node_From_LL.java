public class Lec_19_Remove_nth_Node_From_LL {
  public static void main(String[] args) {
    ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    listNode = new Lec_19_Remove_nth_Node_From_LL().removeNthFromEnd(listNode, 5);
  }

  // 2 pass
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // pass one
    // know the length of the LL
    int length = 0;
    ListNode temp = head;
    while (temp != null) {
      length++;
      temp = temp.next;
    }
    if (n == length) {
      return head.next;
    }

    // pass - 2
    ListNode currentPtr = head;
    int traverseLength = length - n % length;
    while (--traverseLength > 0 && currentPtr != null) {
      currentPtr = currentPtr.next;
    }
    if (currentPtr != null && currentPtr.next != null) {
      currentPtr.next = currentPtr.next.next;
    }
    return head;
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
