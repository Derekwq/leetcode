package com.ximu.leetcode.first.dp;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ximu.leetcode.first.TreeNode;

/**
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class UniqueBinarySearchTrees2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, 1);
        exec(solution, 2);
        exec(solution, 3);
        exec(solution, 4);
    }

    private static void exec(Solution solution, int n) {
        List<TreeNode> treeNodes = solution.generateTrees(n);
        System.out.println(String.format("n: %d, count: %s\n %s\n", n, treeNodes.size(), JSON.toJSONString(treeNodes)));
    }

    static class Solution {

        public List<TreeNode> generateTrees(int n) {
            if (n < 1) {
                return new ArrayList<>();
            }
            return generate(1, n);
        }

        private List<TreeNode> generate(int start, int end) {
            if (start > end) {
                return new ArrayList<>();
            }
            if (start == end) {
                TreeNode node = new TreeNode(start);
                List<TreeNode> list = new ArrayList<>();
                list.add(node);
                return list;
            }

            List<TreeNode> list = new ArrayList<>();
            for (int p = start; p <= end; p++) {
                List<TreeNode> leftTree = generate(start, p - 1);
                List<TreeNode> rightTree = generate(p + 1, end);
                if (leftTree.isEmpty() && rightTree.isEmpty()) {
                    list.add(new TreeNode(p));
                } else if (!leftTree.isEmpty() && rightTree.isEmpty()) {
                    for (TreeNode left : leftTree) {
                        TreeNode root = new TreeNode(p);
                        root.left = left;
                        list.add(root);
                    }
                } else if (leftTree.isEmpty() && !rightTree.isEmpty()) {
                    for (TreeNode right : rightTree) {
                        TreeNode root = new TreeNode(p);
                        root.right = right;
                        list.add(root);
                    }
                } else {
                    for (TreeNode left : leftTree) {
                        for (TreeNode right : rightTree) {
                            TreeNode root = new TreeNode(p);
                            root.left = left;
                            root.right = right;
                            list.add(root);
                        }
                    }
                }
            }
            return list;
        }
    }
}
