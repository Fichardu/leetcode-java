// Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTreeCore(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeCore(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        if (preStart == preEnd) {
            return node;
        }

        int left = inStart;
        while (left <= inEnd && inorder[left] != val) ++left;
        int leftLength = left - inStart;
        if (leftLength > 0) {
            node.left = buildTreeCore(preorder, preStart+1, preStart+leftLength, inorder, inStart, left-1);
        }
        if (leftLength < preEnd - preStart) {
            node.right = buildTreeCore(preorder, preStart+leftLength+1, preEnd, inorder, left+1, inEnd);
        }
        return node;
    }
}
