package s143;

/**
 * Created by chao on 2018/11/28.
 */
public class Solution2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {

        if(head==null || head.next==null || head.next.next==null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        // 找链表中点，一分为二
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        ListNode pre = null;
        // 反转后一半链表
        while(fast != null){
            ListNode next = fast.next;
            fast.next = pre;
            pre = fast;
            fast = next;
        }
        fast = pre;

        // 两个链表依次取出即可，维护head与fast指针
        while(head!=null && fast!=null){
            ListNode tmp = head.next;
            ListNode tmp2 = fast.next;
            head.next = fast;
            fast.next = tmp;
            head = tmp;
            fast = tmp2;
        }
    }
}
