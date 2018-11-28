package s145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chao on 2018/11/28.
 *
 * 写法(1)：递归写法
 * 写法(2)：迭代写法，利用pre记录上一个访问过的结点，与当前结点比较，如果是当前结点的子节点，说明其左右结点均已访问，
 *          将当前结点出栈，更新pre记录的对象。
 * 写法(3)：取巧的方法。该写法的访问顺序并不是后序遍历，而是利用先序遍历“根左右”的遍历顺序，
 *          将先序遍历顺序更改为“根右左”，反转结果List，得到结果顺序为“左右根”。
 */
public class Solution {

    public List<Integer> result = new ArrayList<>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 写法一
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);

        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            // 如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
            boolean popOrNot = (cur.left==null && cur.right==null) || (pre != null && (pre==cur.left || pre==cur.right));
            if (popOrNot) {
                result.add(cur.val);
                pre = cur;
                stack.pop();
            } else {
                // 先将右结点压栈，再将左结点入栈
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return result;
    }
}
