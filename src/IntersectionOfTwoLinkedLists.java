import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> seen = new HashSet<>();
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            seen.add(curA);
            curA = curA.next;
        }
        while (curB != null) {
            if (seen.contains(curB))
                return curB;
            curB = curB.next;
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
