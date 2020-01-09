package com.ximu.leetcode.first;

/**
 * @author derek.wu
 * @date 2019-10-29
 * @since v1.0.0
 */
public class TreeNode {

    public int      val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
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
