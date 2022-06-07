import java.math.BigInteger;

public class AddTwoNumbers {
    class ListNode {
        int val;ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbersAlternativeSolution(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode leftover = null;
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (l1 != null && l2 != null) {
            int d = l1.val + l2.val + carry;
            if (d >= 10) {
                d -= 10;
                carry = 1;
            } else carry = 0;
            current.next = new ListNode(d);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            leftover = l1;
        } else if (l2 != null) {
            leftover = l2;
        }

        while (leftover != null) {
            int d = leftover.val + carry;
            if (d >= 10) {
                d -= 10;
                carry = 1;
            } else carry = 0;
            current.next = new ListNode(d);
            current = current.next;
            leftover = leftover.next;
        }
        if (carry != 0)
            current.next = new ListNode(carry);
        return result.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        if (l1 == null)
            stringBuilder1.append(0);
        if (l2 == null)
            stringBuilder2.append(0);
        while (l1 != null) {
            stringBuilder1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stringBuilder2.append(l2.val);
            l2 = l2.next;
        }
        BigInteger n1 = new BigInteger(stringBuilder1.reverse().toString());
        BigInteger n2 = new BigInteger(stringBuilder2.reverse().toString());
        String sum = String.valueOf(n1.add(n2));
        ListNode head = null;
        ListNode cur = null;
        for (int i = sum.length()-1; i >= 0; i--) {
            int digit = Integer.parseInt("" + sum.charAt(i));
            if (head == null) {
                head = new ListNode(digit);
                cur = head;
            } else {
                cur.next = new ListNode(digit);
                cur = cur.next;
            }
        }
        return head;
    }
}
