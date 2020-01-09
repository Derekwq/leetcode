package com.ximu.leetcode.first.string;

/**
 * Problem 5: 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * <p>
 * 给定一个字符串 s, 找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 * </p>
 * 
 * @author derek.wu
 * @date 2019-07-15
 * @since v1.0.0
 */
public class LongestPalindromicSubString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution, "babad");
        print(solution, "bab");
        print(solution, "bb");
    }

    private static void print(Solution solution, String str) {
        long startTime = System.currentTimeMillis();
        String res = solution.longestPalindrome(str);
        long cost = System.currentTimeMillis() - startTime;
        System.out.println(String.format("origin Str: \t%s\nlongest palindromic sub str: %s\ncost: %5dms", str, res,
                                         cost));
        System.out.println("----------");
    }

    static class Solution {

        public String longestPalindrome(String s) {
            return centerExpand(s);
        }

        /**
         * 动态规划解法
         * 提交结果：AC
         * 执行用时：129ms
         * 内存消耗：69.8MB
         * 
         * @param s input str
         * @return longest palindrome sub str
         */
        private String dp(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            int len = s.length();
            int longestPaiLen = 1;
            String longestPaiStr = s.substring(0, 1);

            int[][] dp = new int[len][len];
            // dp[left][right] = (s[left] == s[right]) and ( (right-left <= 2) or ( dp[left + 1][right -1] = true) )
            for (int right = 1; right < len; right++) {
                for (int left = 0; left <= right; left++) {
                    if (s.charAt(left) == s.charAt(right) && ((right - left <= 2) || dp[left + 1][right - 1] == 1)) {
                        dp[left][right] = 1;
                        int subStrLen = right - left + 1;
                        if (subStrLen > longestPaiLen) {
                            longestPaiLen = subStrLen;
                            longestPaiStr = s.substring(left, right + 1);
                        }
                    }
                }
            }
            return longestPaiStr;
        }

        /**
         * 中心扩散法
         * 提交结果：AC
         * 执行用时：14ms
         * 内存消耗：36.2MB
         * 
         * @param s input str
         * @return longest palindrome sub str
         */
        private String centerExpand(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            int len = s.length();
            int startIdx = 0;
            int endIdx = 0;
            for (int i = 0; i < len; i++) {
                int len1 = centerExpand(s, len, i, i);
                int len2 = centerExpand(s, len, i, i + 1);
                int maxLen = len1 > len2 ? len1 : len2;
                if (maxLen > (endIdx - startIdx + 1)) {
                    startIdx = i - (maxLen - 1) / 2;
                    endIdx = i + maxLen / 2;
                }
            }
            return s.substring(startIdx, endIdx + 1);
        }

        private int centerExpand(String s, int len, int left, int right) {
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // (right - 1) - (left + 1) + 1 = right - left - 1
            return right - left - 1;
        }

        /**
         * Manacher算法（专门用于解决"最长回文子串"问题的算子，时间复杂度：o(n)）
         * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
         * 
         * @param s input str
         * @return longest palindrome sub str
         */
        private String manacher(String s) {
            // TODO
            return null;
        }
    }
}
