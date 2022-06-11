public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // base case: empty list
        if (head == null)
            return null;
        // base case: singleton list
        ListNode secondNode = head.next;
        if (secondNode == null)
            return head;
        // recursive case
        ListNode swappedTail = swapPairs(secondNode.next);
        secondNode.next = head;
        head.next = swappedTail;
        return secondNode;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
