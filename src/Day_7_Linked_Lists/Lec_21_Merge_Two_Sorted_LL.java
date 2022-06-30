package Day_7_Linked_Lists;


public class Lec_21_Merge_Two_Sorted_LL {
  public static void main(String[] args) {
      new Lec_21_Merge_Two_Sorted_LL()
              .mergeTwoLists(
                      new ListNode(1, new ListNode(7, new ListNode(9))),
                      new ListNode(3, new ListNode(4))
              );
  }

  public ListNode mergeTwoLists(ListNode aPtr, ListNode bPtr) {
      ListNode dummyNode = new ListNode(-1);
      ListNode result = dummyNode;

      // common stage
      while (aPtr!=null && bPtr!=null) {
          if (aPtr.val <= bPtr.val) {
              dummyNode.next = aPtr;
              aPtr = aPtr.next;
          }
          else {
              dummyNode.next = bPtr;
              bPtr = bPtr.next;
          }
          dummyNode = dummyNode.next;
      }
      // exhaust aptr
      while (aPtr!=null) {
          dummyNode.next = aPtr;
          dummyNode = dummyNode.next;
          aPtr = aPtr.next;
      }

      // exhaust bptr
      while (bPtr!=null) {
          dummyNode.next = bPtr;
          dummyNode = dummyNode.next;
          bPtr = bPtr.next;
      }

      return result.next;
  }
}
