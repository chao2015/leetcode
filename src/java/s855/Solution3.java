package s855;

import java.util.ArrayList;


/**
 * Created by chao on 2018/11/20.
 *
 * 思路三：还是用ArrayList，与思路二不同的是：
 * 1. 利用ArrayList.add(index, value)来手动维护有序
 * 2. 先在三种情况中遍历找出maxDistance，再在三种情况中遍历找插入位置，在插入位置插入座位号
 */
public class Solution3 {
    private ArrayList<Integer> array;
    private int capacity;

    public Solution3(int N) {
        array = new ArrayList<>();
        capacity = N;
    }

    public int seat() {
        // 为空的情况
        int size = array.size();
        if (size == 0) {
            array.add(0);
            return 0;
        }
        // 取首尾距离最大值
        int maxDistance = Math.max(array.get(0), (capacity-1)-array.get(size-1));
        // 更新包括首尾在内的整个ArrayList中的最大距离
        for (int i = 0; i < size-1; ++i) {
            maxDistance = Math.max(maxDistance, (array.get(i+1)-array.get(i))/2);
        }

        // 如果首距离最大，应该在0位置插入座位号0
        if (array.get(0) == maxDistance) {
            array.add(0, 0);
            return 0;
        }
        // 遍历找插入位置i和i+1之间，在i+1位置插入座位号(array.get(i+1)+array.get(i))/2
        for (int i=0; i<size-1; ++i) {
            if ((array.get(i+1)-array.get(i))/2 == maxDistance) {
                array.add(i+1, (array.get(i+1)+array.get(i))/2);
                return array.get(i+1);
            }
        }
        // 最后，如果只剩尾距离最大的情况，在最后插入capacity - 1
        array.add(capacity-1);
        return capacity-1;
    }

    public void leave(int p) {
        array.remove(new Integer(p));
    }
}
