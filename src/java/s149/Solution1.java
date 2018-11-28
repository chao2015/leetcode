package s149;

import java.util.HashMap;

/**
 * Created by chao on 2018/11/27.
 （1）新建一个长度为点的数量的数组count，用以保存对于每一个点i其斜率存在的情况下的直线的经过的最多的点数。

 （2）首先设置一个外循环依次遍历所有的点，外循环变量记为i。
 每一次循环都新建一个哈希表用以记录与i点在同一条直线上的直线的斜率以及该斜率直线下点的个数。
 再新建一个变量same，用以记录与点i在坐标平面上位置相同的点j的数量。
 还得新建一个变量size，用以记录经过点i且垂直于x轴（即斜率不存在）的直线的情况。

 （3）再设置一个内循环依次遍历所有的点，内循环变量记为j。

 （4）如果遍历到的点满足i ！= j，说明遍历到的不是同一个点，那么我们就需要来判断点j和点i是否在同一条直线上。
 由数学基本知识可知，平面上的一点以及相应的斜率就可以确定一条直线。

 （5）当点i的x坐标与点j的x坐标不相等时，点i和点j的斜率是存在的。由于直接求斜率会产生误差，LeetCode上的一些测试用例不能通过。
 因此我们计算其分数形式表示的斜率，即dy/dx，其中dy为点i和点j的y坐标的差值，dx为点i和点j的x坐标的差值。
 另外，我们需要把分数dy/dx化简到不能约分的形式，防止4/2和2/1这两条斜率明明相同的直线却被视作两条直线的情况出现。
 需要保存两个变量dy和dx，可以用一个长度为2的整型数组nums来保存，其中nums[0]保存dy，nums[1]保存dx。
 如果（1）中新建的哈希表中已经保存了nums的值，那么相应nums对应的值+1即可；否则，在哈希表中新增一个键nums，其值为1。

 （6）在（4）中我们说需要对dy/dx进行约分处理，那么我们就需要一个函数来求dy和dx的最大公约数gcd，令dy = dy / gcd，dx = dx / gcd。
 该函数其实很简单，我们可以用欧几里得算法递归地求解，公式为gcd(a, b) = gcd(b, a mod b)

 （7）如果点i的x坐标与点j的x坐标相等，这又可以分为两种情况。

 a.如果点i的y坐标和点j的y坐标也相等，那么说明点i和点j的点在坐标平面上是同一个点，那么我们需要same++，同时垂直于x轴的直线的数量需要size++

 b.如果点i的y坐标和点j的y坐标不相等，我们只需要对垂直于x轴的直线的数量进行++处理。

 （8）对于每一个点i，经过点i且经过点数最多的直线应该在size和（same + count[i]）中取最大值。

 （9）遍历一遍count数组，求得其最大值返回即可。
 *
 */
public class Solution1 {

    class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
    }

    public int maxPoints(Point[] points) {
        if(points.length == 0) {
            return 0;
        }
        int[] count = new int[points.length];
            for (int i = 0; i < points.length; i++) {
            count[i] = 1;
            int size = 1;
            int same = 0;
            HashMap<Integer[], Integer> hashMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(i != j) {
                    if(points[i].x != points[j].x) {
                        int dy = points[i].y - points[j].y;
                        int dx = points[i].x - points[j].x;
                        int gcd = generateGCD(dy, dx);
                        if(gcd != 0) {
                            dy = dy / gcd;
                            dx = dx / gcd;
                        }
                        Integer[] nums = new Integer[2];
                        nums[0] = dy;
                        nums[1] = dx;
                        boolean flag = false;
                        for (Integer[] array : hashMap.keySet()) {
                            if(nums[0].equals(array[0]) && nums[1].equals(array[1])) {
                                flag = true;
                                hashMap.put(array, hashMap.get(array) + 1);
                            }
                        }
                        if(!flag) {
                            hashMap.put(nums, 1);
                        }
                    }else {
                        if(points[i].y == points[j].y) {
                            same++;
                        }
                        size++;
                    }
                }
            }
            for (Integer[] array : hashMap.keySet()) {
                if(hashMap.get(array) + 1 > count[i]) {
                    count[i] = hashMap.get(array) + 1;
                }
            }
            count[i] += same;
            count[i] = Math.max(count[i], size);
        }
        int maxIndex = 0;
            for (int i = 1; i < count.length; i++) {
            if(count[i] > count[maxIndex]) {
                maxIndex = i;
            }
        }
            return count[maxIndex];
    }

    // 欧几里得算法：计算最大公约数
    private int generateGCD(int x, int y) {
        if (y == 0)
            return x;
        return generateGCD(y, x % y);
    }
}
