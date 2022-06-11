public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode resultHead = new ListNode(-101, head);
        ListNode resultPrev = resultHead;
        ListNode cur = head;
        while (cur != null) {
            // repeat exists -> skip till the last of the repeated value
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                // repeated value is included in the result -> remove
                if (resultPrev.next.val == cur.val)
                    resultPrev.next = cur.next;
            } else {
                resultPrev = resultPrev.next;
            }
            cur = cur.next;
        }
        return resultHead.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
