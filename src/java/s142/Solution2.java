package s142;

/**
 * Created by chao on 2018/11/28.
 *
 * 思路一样，写法更简洁
 */
public class Solution2 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != fast) {
                    head = head.next;
                    fast = fast.next;
                }
                return head;
            }
        }
        return null;
    }
}
