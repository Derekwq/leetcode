package com.derek.leetcode.dp;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, 1);
        exec(solution, 2);
        exec(solution, 3);
        exec(solution, 4);
        exec(solution, 5);
        exec(solution, 6);
        exec(solution, 7);
        exec(solution, 8);
        exec(solution, 9);
        exec(solution, 10);
    }

    private static void exec(Solution solution, int n) {
        System.out.println(String.format("n: %d --> ans: %d", n, solution.numTrees(n)));
    }

    static class Solution {

        public int numTrees(int n) {
            if (n < 1) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int m = 2; m <= n; m++) {
                int count = 0;
                for (int k = 1; k <= m; k++) {
                    count = count + dp[k - 1] * dp[m - k];
                }
                dp[m] = count;
            }
            return dp[n];
        }
    }

}
