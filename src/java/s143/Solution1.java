package s143;

import java.util.LinkedList;

/**
 * Created by chao on 2018/11/28.
 *
 * LinkedList模拟双端队列实现
 */
public class Solution1 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            // queue顺序存储原链表
            queue.addLast(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            // 1.上一次循环使cur=null，这里初始化cur，先加第一个
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                // 3.加第2个
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            // 2.再加倒数第1个、4.倒数第2个
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }

    }
}
