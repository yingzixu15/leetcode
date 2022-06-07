import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {
    public AddTwoNumbers.ListNode detectCycle(AddTwoNumbers.ListNode head) {
        Set<AddTwoNumbers.ListNode> seen = new HashSet<>();
        AddTwoNumbers.ListNode cur = head;
        while (cur != null) {
            if (seen.contains(cur))
                return cur;
            else seen.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
