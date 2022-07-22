package Day_7_Linked_Lists;

public class Lec206_Reverse_a_LL {
  public static void main(String[] args) {
    new Lec206_Reverse_a_LL().reverseList(new ListNode(1, new ListNode(2)));
  }

  public ListNode reverseList(ListNode head) {
    ListNode previous = null;
    ListNode current = head;

    while (current != null) {
      ListNode nextNode = current.next;
      current.next = previous;
      previous = current;
      current = nextNode;
    }
    return previous;
  }
}
