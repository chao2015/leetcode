package s104;

/**
 * Created by chao on 2018/11/26.
 *
 * 时间复杂度: O(n), n是树中的节点个数
 * 空间复杂度: O(h), h是树的高度
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
