package Day_8_Linked_List;

public class Lec_142_Linked_List_Cycle_2 {
  public static void main(String[] args) {
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    one.next = two;
    two.next = one;
    new Lec_142_Linked_List_Cycle_2()
            .detectCycle(
                  new ListNode(1)
            );
  }

  public ListNode detectCycle(ListNode head) {
    ListNode fastptr = head;
    ListNode slowPtr = head;
    while (fastptr != null && fastptr.next != null) {
      fastptr = fastptr.next.next;
      slowPtr = slowPtr.next;
      if (fastptr == slowPtr) {
        break;
      }
    }
    if (fastptr == null|| fastptr.next == null) {
      return null;
    }

    ListNode startPtr = head;

    while (startPtr != slowPtr) {
      slowPtr = slowPtr.next;
      startPtr = startPtr.next;
    }
    return startPtr;
  }
}
