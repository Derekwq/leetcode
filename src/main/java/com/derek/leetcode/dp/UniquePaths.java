package com.derek.leetcode.dp;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class UniquePaths {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, 3, 2);
        exec(solution, 7, 3);
        exec(solution, 1, 10);
    }

    private static void exec(Solution solution, int m, int n) {
        System.out.println(String.format("m: %d, n: %d ==> ans: %d", m, n, solution.uniquePaths(m, n)));
    }

    static class Solution {

        public int uniquePaths(int m, int n) {
            if (m <= 0 || n <= 0) {
                return 0;
            }
            if (m == 1) {
                return 1;
            }
            if (n == 1) {
                return 1;
            }
            int[][] dp = new int[m][n];
            for (int i = 1; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
