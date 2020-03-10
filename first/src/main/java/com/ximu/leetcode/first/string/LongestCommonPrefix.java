package com.ximu.leetcode.first.string;

/**
 * Problem 14: 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 
 * @author derek.wu
 * @date 2020-01-10
 * @since v1.0.0
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println(solution.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
    }

    static class Solution {

        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }
            int maxStrLen = Integer.MAX_VALUE;
            for (String str : strs) {
                if (str == null || str.length() == 0) {
                    return "";
                }
                maxStrLen = Math.min(maxStrLen, str.length());
            }

            int idx = 0;
            while (idx < maxStrLen) {
                Character ch = null;
                boolean eq = true;
                for (String str : strs) {
                    if (ch == null) {
                        ch = str.charAt(idx);
                    } else {
                        if (ch != str.charAt(idx)) {
                            eq = false;
                            break;
                        }
                    }
                }
                if (eq) {
                    idx++;
                } else {
                    break;
                }
            }
            return strs[0].substring(0, idx);
        }
    }
}
