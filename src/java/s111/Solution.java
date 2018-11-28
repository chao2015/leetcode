package s111;

/**
 * Created by chao on 2018/11/26.
 *
 * 分析：
 * 空树，最小深度为0
 * 左右子树都为空，最小深度为1
 * 左右子树不都为空，左右子树中有空树的情况，最小深度一定是在非空树中产生，因为最小深度定义为到最近叶子节点的深度。
 * 一旦左右子树有空的情况，这边的深度就可以置为正无穷，表示最小深度不可能再这里产生。
 * 然后分别计算左右子树的最小深度，使用递归策略。
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return minDepth(root.right)+1;
        else if (root.right == null)
            return minDepth(root.left)+1;
        else
            return Math.min(minDepth(root.right), minDepth(root.left))+1;
    }
}
