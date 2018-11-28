package s150;

import java.util.Stack;

/**
 * Created by chao on 2018/11/27.
 *
 * 遇到一个操作符就从stack里pop两个元素进行操作再push进stack里
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String item : tokens) {
            if ("+".equals(item)) {
                int temp = stack.pop() + stack.pop();
                stack.push(temp);
            } else if ("-".equals(item)) {
                int substraction = stack.pop();
                int temp = stack.pop() - substraction;
                stack.push(temp);
            } else if ("*".equals(item)) {
                int temp = stack.pop() * stack.pop();
                stack.push(temp);
            } else if ("/".equals(item)) {
                int divisor = stack.pop();
                int temp = stack.pop() / divisor;
                stack.push(temp);
            } else {
                stack.push(Integer.valueOf(item));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(tokens));
    }
}
