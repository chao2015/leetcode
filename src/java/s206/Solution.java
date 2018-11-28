package s206;

/**
 * Created by chao on 2018/11/28.
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead, cur = pre.next;
        // 循环不变式：pre和cur永远指向待排的前节点和待排节点
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;

        return pre;
    }
}
