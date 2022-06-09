public class Lec82_Remove_Duplicates_From_Sorted_LL {
    public ListNode deleteDuplicates(final ListNode head) {
        // 8 -> null
        if (head == null || head.next == null) return head;
        ListNode next = head.next;

        // if there is a match return the first different element
        // 1 -> 1 -> 2 -> 2 -> 3 ... => return 2 -> 2 -> 3 ...
        // 1 -> 1 => return null
        if (next.val == head.val) {
            while (next!=null && next.val == head.val) next = next.next;
            return deleteDuplicates(next);
        }
        // 1 -> 2 -> 3 -> 3 ...
        else {
            head.next = deleteDuplicates(next);
            return head;
        }
    }

    private static ListNode generateNode(int[] nums) {
        ListNode node = new ListNode(-1);
        ListNode result = node;
        for (int num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return  result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = generateNode(new int[] {1,1,1,2,2,2,2,3,3,4,5,6,7,7,7,90});
        new Lec82_Remove_Duplicates_From_Sorted_LL().deleteDuplicates(listNode);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
