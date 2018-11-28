package s144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chao on 2018/11/28.
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return result;
        }

        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return result;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            result.add(node.val);
        }

        return result;
    }
}
