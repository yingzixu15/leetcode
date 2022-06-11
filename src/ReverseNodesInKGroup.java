public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = head;
        return recReverseKGroup(head, cur, k, length, 0);
    }

    private ListNode recReverseKGroup(ListNode head, ListNode pointer, int k, int length, int startPos) {
        // base case: list is shorter than k -> do nothing
        if (length - startPos < k)
            return head;

        // reverse the tail using recursion
        for (int i = 0; i < k; i++) {
            pointer = pointer.next;
        }
        ListNode dummy = pointer;
        pointer = recReverseKGroup(dummy,pointer, k, length, startPos + k);

        // reverse the current k group
        for (int i = 0; i < k; i++) {
            ListNode temp = head.next;
            head.next = pointer;
            pointer = head;
            head = temp;
        }
        return pointer;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
