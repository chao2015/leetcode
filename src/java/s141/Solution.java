package s141;

/**
 * Created by chao on 2018/11/28.
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head==null || head.next==null) {
            return false;
        }

        ListNode low = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }
}
