package com.ximu.leetcode.string;

/**
 * 最长回文子串
 * 
 * @author derek.wu
 * @date 2020-01-10
 * @since v1.0.0
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    static class Solution {

        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            int maxLen = 1;
            String res = s.substring(0, 1);

            int dp[][] = new int[s.length()][s.length()];
            for (int j = 1; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1] == 1)) {
                        dp[i][j] = 1;
                        int len;
                        if ((len = j - i + 1) > maxLen) {
                            maxLen = len;
                            res = s.substring(i, j + 1);
                        }
                    }
                }
            }
            return res;
        }
    }
}
