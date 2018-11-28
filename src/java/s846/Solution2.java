package s846;

import java.util.Arrays;

/**
 * Created by chao on 2018/11/20.
 *
 * 思路二：17ms
 * 1. 先查看能否整除，不能返回false
 * 2. 对int[]排序
 * 3. 两层for循环来寻找hand[i]的下一个满足条件的数(即大1的数)，找到了就标记；外层循环不变式是标记了W个数，不变式被破坏返回false
 * 4. 循环不变式维持到遍历结束就返回true
 */
class Solution2 {

    public boolean isNStraightHand(int[] hand, int W) {

        int size = hand.length;
        if (size%W != 0) {
            return false;
        }

        Arrays.sort(hand);

        int[] visited = new int[size];
        for (int i=0; i<size; i++) {
            if (visited[i] == 0) {
                int count = 1;
                int num = hand[i];
                int next = i+1;
                visited[i] = 1;
                for (;next<size && count<W; next++) {
                    if (num+1 == hand[next] && visited[next]==0) {
                        visited[next] = 1;
                        count++;
                        num = hand[next];
                    }
                }
                if (count != W) {
                    return false;
                }
            }
        }
        return true;
    }
}
