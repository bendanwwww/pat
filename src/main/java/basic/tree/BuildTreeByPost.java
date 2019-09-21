package basic.tree;

import leetcode.utils.TreeNode;

/**
 * 后序 + 中序 还原二叉树
 */
public class BuildTreeByPost {

    public TreeNode buildTreeByPost(int[] postorder, int[] inorder) {

        if(postorder == null || inorder == null || postorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }

        return buildTreeByPost(postorder.length - 1, 0, postorder.length - 1, postorder, inorder);
    }

    public TreeNode buildTreeByPost(int state, int inStart, int inEnd, int[] postorder, int[] inorder) {

        if(state < 0 || inStart > inEnd) {
            return null;
        }

        int rootValue = postorder[state];
        TreeNode root = new TreeNode(rootValue);

        int k = inStart;
        boolean isIn = false;

        while(!isIn) {
            for(; k <= inEnd ; k++) {
                if(inorder[k] == rootValue) {
                    isIn = true;
                    break;
                }
            }
            if(!isIn) {
                k = inStart;
                state--;
                rootValue = postorder[state];
                root = new TreeNode(rootValue);
            }
        }

        root.left = buildTreeByPost(state, inStart, k - 1, postorder, inorder);
        root.right = buildTreeByPost(state, k + 1, inEnd, postorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        BuildTreeByPost buildTree = new BuildTreeByPost();
        TreeNode head = buildTree.buildTreeByPost(new int[]{10, 2, 5, 9, 8, 3}, new int[]{10, 5, 2, 3, 8, 9});
        System.out.println(head.toString());
    }
}
