package com.derek.leetcode.dfs;

import com.derek.leetcode.TreeNode;

/**
 * 100. 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * 
 * @author derek.wu
 * @date 2019-11-01
 * @since v1.0.0
 */
public class SameTree {

}

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
