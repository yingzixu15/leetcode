public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slowPt = head;
        ListNode fastPt = head;

        // h1: head of first half
        ListNode h1 = head;
        ListNode prev = null;
        while (fastPt != null && fastPt.next != null) {
            prev = slowPt;
            slowPt = slowPt.next;
            fastPt = fastPt.next.next;
        }
        prev.next = null;
        // reverse the second half of the list
        // h2: head of second half
        ListNode h2 = null;
        ListNode temp;
        while (slowPt != null) {
            temp = slowPt.next;
            slowPt.next = h2;
            h2 = slowPt;
            slowPt = temp;
        }

        // merge two lists, second half can be one unit longer.
        ListNode t1, t2;
        while (h1 != null && h2 != null) {
            t1 = h1.next;
            t2 = h2.next;
            h1.next = h2;
            h2.next = t1;
            if (t1 == null && t2 != null)
                h2.next = t2;
            h1 = t1;
            h2 = t2;
        }

    }


    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
