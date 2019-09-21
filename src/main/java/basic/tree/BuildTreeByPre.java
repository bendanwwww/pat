package basic.tree;

import leetcode.utils.TreeNode;

/**
 * 前序 + 中序 还原二叉树
 */
public class BuildTreeByPre {

    int state = 0;

    public TreeNode buildTreeByPre(int[] preorder, int[] inorder) {

        if(preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        return buildTreeByPre(0, preorder.length - 1, preorder, inorder);
    }


    public TreeNode buildTreeByPre(int inStart, int inEnd, int[] preorder, int[] inorder) {

        if(inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[state];
        TreeNode root = new TreeNode(rootValue);

        int i = 0;
        for(; i < inorder.length ; i++) {
            if(inorder[i] == rootValue) {
                break;
            }
        }

        state++;

        root.left = buildTreeByPre(inStart, i - 1, preorder, inorder);
        root.right = buildTreeByPre(i + 1, inEnd, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        BuildTreeByPre buildTree = new BuildTreeByPre();
        TreeNode head = buildTree.buildTreeByPre(new int[]{3, 5, 10, 2, 8, 9}, new int[]{10, 5, 2, 3, 8, 9});
        System.out.println(head.toString());
    }
}
