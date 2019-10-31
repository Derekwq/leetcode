package com.derek.leetcode.dp;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } });
        exec(solution, new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 }, { 1, 5, 2 } });
    }

    private static void exec(Solution solution, int[][] grid) {
        System.out.println(solution.minPathSum(grid));
    }
}

class Solution {

    /**
     * dp[i][j] = max{dp[i-1][j], dp[i][j-1]} + grid[i][j]
     * 处理好边界
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
