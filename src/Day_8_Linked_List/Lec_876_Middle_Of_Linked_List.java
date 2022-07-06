package Day_8_Linked_List;

public class Lec_876_Middle_Of_Linked_List {
  public ListNode middleNode(ListNode head) {
    ListNode fastPtr = head;
    ListNode slowPtr = head;

    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
    }
    return slowPtr;
  }
}
