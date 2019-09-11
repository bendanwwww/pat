package leetcode;

import leetcode.utils.TreeNode;

/**
 * 题目描述
 * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution_1 {

    int min = Integer.MAX_VALUE;

    public int run(TreeNode root) {
        if(root == null) {
            return 0;
        }
        find(root, 1);
        return min;
    }

    public void find(TreeNode root, int depth) {
        if(root.left == null && root.right == null) {
            min = Math.min(min, depth);
            return;
        }
        depth++;
        if(root.left != null) {
            find(root.left, depth);
        }
        if(root.right != null) {
            find(root.right, depth);
        }
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
//        TreeNode root3 = new TreeNode(5);
//        TreeNode root4 = new TreeNode(4);
//        TreeNode root5 = new TreeNode(2);
        root1.left = root2;
//        root2.right = root3;
//        root2.right = root4;
//        root3.left = root5;
        int res = solution.run(root1);
        System.out.println(res);
    }
}


