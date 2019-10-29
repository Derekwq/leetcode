package com.derek.leetcode.ds;

import com.derek.leetcode.TreeNode;

/**
 * Problem 226: 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 
 * @author derek.wu
 * @date 2019-10-29
 * @since v1.0.0
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        int[] arr = { 4, 2, 7, 1, 3, 6, 9 };
        TreeNode root = TreeNode.build(arr);
        TreeNode invertTreeRoot = new InvertBinaryTree().invertTree(root);
        System.out.println("xxx");
    }

    public TreeNode invertTree(TreeNode root) {
        return invertSubTree(root);
    }

    private TreeNode invertSubTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode root2 = copyNodeVal(root);
        TreeNode leftInvert = invertSubTree(root.left);
        TreeNode rightInvert = invertSubTree(root.right);
        root2.left = rightInvert;
        root2.right = leftInvert;
        return root2;
    }

    private TreeNode copyNodeVal(TreeNode node) {
        return new TreeNode(node.val);
    }

}
