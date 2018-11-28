package s147;

/**
 * Created by chao on 2018/11/28.
 *
 * 一次遍历，用了5个额外节点：pre, cur, sortedPre, sortedCur, node
 */
public class Solution2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;

        ListNode pre = head;
        // 循环过程中，保证待排序节点是pre.next，cur中间会改变，每次循环再次赋值即可
        while(pre.next != null){
            // cur是待排序节点
            ListNode cur = pre.next;
            // 遍历已排序链表，与cur比较的sortedCur节点和它的前节点sortedPre
            ListNode sortedPre = dummyhead;
            ListNode sortedCur = dummyhead.next;

            while(sortedCur != cur){
                if(sortedCur.val > cur.val){
                    ListNode node = cur;
                    pre.next = node.next;
                    sortedPre.next = node;
                    node.next = sortedCur;
                    break;
                }
                sortedPre = sortedPre.next;
                sortedCur = sortedCur.next;
            }

            // 该节点的位置不用调整的情况
            if (sortedCur == cur) {
                pre = pre.next;
            }
        }

        return dummyhead.next;
    }
}
