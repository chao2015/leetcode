package s142;

/**
 * Created by chao on 2018/11/28.
 *
 * 思路见图示
 */
public class Solution1 {

class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        if (head==null || head.next==null) {
            return null;
        }
        // 1. 判断有无环
        boolean hasCycle = false;
        ListNode low = head, fast = head;
        while (fast.next!=null && fast.next.next!=null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                hasCycle = true;
                break;
            }
        }
        // 2. 两指针，分别从原点和前面的相遇点出发，同样速度，相遇点即为所求
        if (hasCycle == true) {
            ListNode p = head;
            while (p != low) {
                p = p.next;
                low = low.next;
            }
            return p;
        }
        return null;
    }
}
