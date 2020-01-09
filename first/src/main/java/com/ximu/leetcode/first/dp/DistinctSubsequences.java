package com.ximu.leetcode.first.dp;

/**
 * 115. 不同的子序列
 * https://leetcode-cn.com/problems/distinct-subsequences/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class DistinctSubsequences {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, "rabbbit", "rabbit");
        exec(solution, "babgbag", "bag");
    }

    private static void exec(Solution solution, String s, String t) {
        System.out.println("s: " + s);
        System.out.println("t: " + t);
        System.out.println("count: " + solution.numDistinct(s, t) + "\n");
    }

    static class Solution {

        public int numDistinct(String s, String t) {
            if (s == null || t == null || s.length() < t.length()) {
                return 0;
            }
            int[][] dp = new int[t.length() + 1][s.length() + 1];
            for (int j = 0; j <= s.length(); j++) {
                dp[0][j] = 1;
            }
            for (int j = 1; j <= s.length(); j++) {
                for (int i = 1; i <= j && i <= t.length(); i++) {
                    if (s.charAt(j - 1) == t.charAt(i - 1)) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[t.length()][s.length()];
        }
    }
}
