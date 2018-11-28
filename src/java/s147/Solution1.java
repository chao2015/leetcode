package s147;

/**
 * Created by chao on 2018/11/27.
 *
 * 新建一个链表，遍历原链表的节点，依次在新链表中找到合适的位置插入新节点
 * 一次遍历，用了一个新的链表空间和4个额外节点：cur, newPre, newCur, node
 * 注意：ListNode node = new ListNode(cur.val) 与 ListNode node = cur 大大不同！
 */
public class Solution1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(head.val);
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = newHead;

        ListNode cur = head.next;
        while (cur != null) {
            ListNode newPre = dummyhead, newCur = newPre.next;
            ListNode node = new ListNode(cur.val);

            while (newCur != null) {
                if (newCur.val > cur.val) {
                    newPre.next = node;
                    node.next = newCur;
                    break;
                }
                newPre = newPre.next;
                newCur = newCur.next;
            }
            if (newCur == null) {
                newPre.next = node;
            }
            cur = cur.next;
        }

        return dummyhead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(node1.next.val);

        // 以下这句不是新建的一个node节点，而是一个指向node1的引用
        ListNode node3 = node1;
        node3.val = 10;
        System.out.println(node1.val);
        System.out.println(node1);
        System.out.println(node3);

        ListNode node4 = new ListNode(node1.val);
        System.out.println(node4);
    }
}
