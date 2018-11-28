package s855;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by chao on 2018/11/20.
 *
 * 思路一：N = 10^9 时超出内存限制，用cpp的set可以通过
 * 选用Integer元素有序的HashSet存储已经占用的位置，每次遍历一遍set，同时更新maxDistance和result
 * 注意0和capacity-1的位置计算maxDistance要特殊处理
 */
class Solution1 {

    private HashSet<Integer> set;
    private int capacity;

    public Solution1(int N) {
        set = new HashSet<Integer>(N);
        capacity = N;
    }

    public int seat() {
        int size = set.size();
        int result = 0;
        if (size != 0) {
            Iterator<Integer> iterable = set.iterator();
            int pre = iterable.next();
            int maxDistance = 0;
            // 查看0是否占用
            if (pre != 0) {
                maxDistance = pre - 0;
            }
            int last = 0;
            while (iterable.hasNext()) {
                last = iterable.next();
                int temp = (last-pre)/2;
                if (temp > maxDistance) {
                    maxDistance = temp;
                    result = pre+maxDistance;
                }
                pre = last;
            }
            // 查看最后的位置是否占用
            if (last != capacity-1) {
                int temp = (capacity-1) - last;
                if (temp > maxDistance) {
                    maxDistance = temp;
                    result = last+maxDistance;
                }
            }
        }

        set.add(result);
        return result;

    }

    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
