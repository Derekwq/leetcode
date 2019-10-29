package com.derek.leetcode.ds;

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

    public static class TreeNode {

        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public static TreeNode build(int[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(arr[0]);
            fillChildren(root, 0, arr);
            return root;
        }

        private static void fillChildren(TreeNode curNode, int curIdx, int[] arr) {
            TreeNode left = null;
            TreeNode right = null;
            if (2 * curIdx + 1 < arr.length) {
                left = new TreeNode(arr[2 * curIdx + 1]);
                fillChildren(left, 2 * curIdx + 1, arr);
            }
            if (2 * curIdx + 2 < arr.length) {
                right = new TreeNode(arr[2 * curIdx + 2]);
                fillChildren(right, 2 * curIdx + 2, arr);
            }
            curNode.left = left;
            curNode.right = right;
        }
    }

}
