package com.derek.leetcode.ds;

import com.derek.leetcode.TreeNode;

/**
 * Problem: 222. 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * 
 * @author derek.wu
 * @date 2019-10-29
 * @since v1.0.0
 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 4, 5, 6 };
        int[] arr = { 1, 2, 3 };
        TreeNode root = TreeNode.build(arr);
        int count = new CountCompleteTreeNodes().countNodes(root);
        System.out.println("count: " + count);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubTreeDepth = depthOfCompleteTree(root.left);
        if (leftSubTreeDepth == 0) {
            return 1;
        }

        // 求得右子树的深度
        int rightSubTreeDepth = depthOfCompleteTree(root.right);

        if (leftSubTreeDepth == rightSubTreeDepth) {
            // 说明 左子树全满了
            int countOfLeftTree = (int) Math.pow(2, leftSubTreeDepth) - 1;
            int countOfRightTree = countNodes(root.right);
            return 1 + countOfLeftTree + countOfRightTree;
        } else {
            // 说明右子树全满了
            int countOfLeftTree = countNodes(root.left);
            int countOfRightTree = rightSubTreeDepth == 0 ? 0 : (int) Math.pow(2, rightSubTreeDepth) - 1;
            return 1 + countOfLeftTree + countOfRightTree;
        }
    }

    private int depthOfCompleteTree(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int depth = 1;
        TreeNode node = treeNode;
        while (node.left != null) {
            depth += 1;
            node = node.left;
        }
        return depth;
    }

}
