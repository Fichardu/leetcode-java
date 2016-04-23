// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return buildTreeCore(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeCore(int[] inorder, int instart, int inend, int[] postorder, int postart, int poend) {
        int root = postorder[poend];
        TreeNode node = new TreeNode(root);
        if (postart == poend) {
            return node;
        }

        int left = instart;
        while (left <= inend && inorder[left] != root) ++left;
        int leftLength = left - instart;
        if (leftLength > 0) {
            node.left = buildTreeCore(inorder, instart, left-1, postorder, postart, postart+leftLength-1);
        }
        if (leftLength < poend - postart) {
            node.right = buildTreeCore(inorder, left+1, inend, postorder, postart+leftLength, poend-1);
        }
        return node;
    }
}
