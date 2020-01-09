package com.ximu.leetcode.first.dp;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, "babad");
        exec(solution, "cbbd");
    }

    private static void exec(Solution solution, String s) {
        System.out.println(s);
        System.out.println(solution.longestPalindrome(s) + "\n");
    }

    static class Solution {

        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            int len = s.length();
            String lps = s.substring(0, 1);
            int lpsLen = 0;
            int dp[][] = new int[len][len];

            // 0 <= i <= j < len
            for (int j = 0; j < len; j++) {
                for (int i = 0; i <= j; i++) {
                    // 此处 包含了 两种情况：
                    // 1、s[i] == s[j] && dp[i+1][j-1] = 1 此处隐含条件(i+1 < j-1 ==> j-i > 2)
                    // 2、s[i] == s[j] && j - i <= 2
                    // 另注意：后半部分 j - 1 <= 2 必须在前，起断路作用，不然会引起 数组越界
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1] == 1)) {
                        dp[i][j] = 1;
                        int curMaxLen = j - i + 1;
                        if (curMaxLen > lpsLen) {
                            lpsLen = curMaxLen;
                            lps = s.substring(i, j + 1);
                        }
                    }
                }
            }
            return lps;
        }
    }
}
