package s855;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by chao on 2018/11/20.
 *
 * 思路二：把思路一的HashSet改成ArrayList，每次都要排序
 * 如果初始化就开辟N个空间，依然是N = 10^9 时超出内存限制
 * 但是HashSet如果初始化没开辟N个空间，后续开的空间无法维持set内部有序，算法错误
 */
class Solution2 {

    private ArrayList<Integer> array;
    private int capacity;

    public Solution2(int N) {
        array = new ArrayList<>();
        capacity = N;
    }

    public int seat() {
        int size = array.size();
        int result = 0;
        if (size != 0) {
            Iterator<Integer> iterable = array.iterator();
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

        array.add(result);
        Collections.sort(array);
        return result;

    }

    public void leave(int p) {
        array.remove(new Integer(p));
    }
}
