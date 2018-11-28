package s846;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by chao on 2018/11/20.
 *
 * 思路一：76ms
 * 1. 先查看能否整除，不能返回false
 * 2. 将int[]转换为ArrayList，方便后续操作
 * 3. ArrayList从小到大排序
 * 4. 两层循环，通过remove方法，每次外层循环都会从最小值开始，循环不变式是能够删除连续的W个值，如果删除失败返回false
 * 5. ArrayList全部删除成功返回true
 *
 * 第2步的转换：
 * 2.1 int[]转Integer[]
 * 2.2 Integer[]通过asList转为List再初始化ArrayList对象
 */
public class Solution1 {

    public boolean isNStraightHand(int[] hand, int W) {
        // 1.
        int size = hand.length;
        if (size%W != 0) {
            return false;
        }
        // 2.1
        Integer[] hand2 = new Integer[size];
        for (int i=0; i<size; i++) {
            hand2[i] = new Integer(hand[i]);
        }
        // 2.2
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(hand2));
        // 3.
        Collections.sort(arrayList);
        // 4.
        for (int i=0; i<size/W; i++) {
            int min = arrayList.get(0);
            for (int j=0; j<W; j++) {
                if (arrayList.remove(new Integer(min+j))) {
                    continue;
                }
                return false;
            }
        }
        // 5.
        return true;
    }
}
