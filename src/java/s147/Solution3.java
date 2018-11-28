package s147;

/**
 * Created by chao on 2018/11/28.
 *
 * 用两个指针pre和cur，
 * 使用dummyhead就可以不用单独考虑right插入到head之前的情况（多写一个else单独考虑right插入到head之前的情况似乎更快一点，6ms）
 * 这个方法最快，9ms
 */
public class Solution3 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {

        if(head==null || head.next==null) {
            return head;
        }

        ListNode dummyhead = new ListNode(Integer.MIN_VALUE);
        dummyhead.next = head;

        // 两个指针，cur是待插入节点
        ListNode pre = dummyhead;
        ListNode cur = dummyhead.next;
        while(cur != null) {
            // 如果cur不小于pre的值，则一起向右移动
            if(pre.val <= cur.val) {
                pre = pre.next;
                cur = cur.next;
            } else {
                // 否则从头遍历链表，找到合适位置的前节点insert，在其后插入cur
                ListNode insert = dummyhead;
                while(insert.next.val <= cur.val) {
                    insert = insert.next;
                }
                ListNode tmp = cur.next;
                pre.next = tmp;
                cur.next = insert.next;
                insert.next = cur;
                cur = tmp;
            }
        }

        return dummyhead.next;
    }
}
