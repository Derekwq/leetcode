package com.ximu.leetcode.first.dp;

/**
 * 97. 交错字符串
 * https://leetcode-cn.com/problems/interleaving-string/solution/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class InterleavingString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, "aabcc", "dbbca", "aadbbcbcac");
        exec(solution, "aabcc", "dbbca", "aadbbbaccc");
    }

    private static void exec(Solution solution, String s1, String s2, String s3) {
        boolean ans = solution.isInterleave(s1, s2, s3);
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
        System.out.println("ans: " + ans + "\n");
    }

    static class Solution {

        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1 == null || s2 == null || s3 == null) {
                return false;
            }
            if (s3.length() != s1.length() + s2.length()) {
                return false;
            }

            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 2];
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0) {
                        dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                    } else if (j == 0) {
                        dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
                    } else {
                        dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                                   || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }
}
