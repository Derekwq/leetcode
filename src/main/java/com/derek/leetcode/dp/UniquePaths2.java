package com.derek.leetcode.dp;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/submissions/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class UniquePaths2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } });

        exec(solution, new int[][] { { 0, 0 } });

        exec(solution, new int[][] { { 0, 0 }, { 1, 1 }, { 0, 0 } });
    }

    private static void exec(Solution solution, int[][] obstacleGrid) {
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }

    static class Solution {

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) {
                return 0;
            }
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;
            if (obstacleGrid[0][0] == 1) {
                return 0;
            }

            int[][] dp = new int[n][m];
            dp[0][0] = 1;
            for (int i = 1; i < n; i++) {
                dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
            }
            for (int j = 1; j < m; j++) {
                dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : dp[0][j - 1];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[n - 1][m - 1];
        }
    }

}
