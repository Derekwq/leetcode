package com.ximu.leetcode.first.dfs;

import com.ximu.leetcode.first.TreeNode;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 
 * @author derek.wu
 * @date 2019-11-01
 * @since v1.0.0
 */
public class MaximumDepthOfBinaryTree {

    static class Solution {

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
