package com.ximu.leetcode.first.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 3: 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例2
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例3
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p/>
 * 
 * @author derek.wu
 * @date 2019-07-11
 * @since v1.0.0
 */
public class LongestSubStringWithoutRepeatChar {

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution, "abcabcbb");
        print(solution, "bbbbb");
        print(solution, "pwwkew");
        print(solution, "abba");
    }

    private static void print(Solution solution, String str) {
        long startTime = System.currentTimeMillis();
        int res = solution.lengthOfLongestSubstring(str);
        long cost = System.currentTimeMillis() - startTime;
        System.out.println(String.format("origin str: %s\nlongest sub-str len: %d\ncost: %4d", str, res, cost));
        System.out.println("---------");
    }

    static class Solution {

        /**
         * 提交结果：AC
         * 执行用时：28ms
         * 内存消耗：39.6MB
         * 
         * @param str
         * @return
         */
        public int lengthOfLongestSubstring(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            int startIndex = 0;
            int maxLen = 0;
            for (int curIndex = 0; curIndex < str.length(); curIndex++) {
                Character curCharacter = str.charAt(curIndex);
                if (map.containsKey(curCharacter)) {
                    // abba, 遍历到第四个a时，如果 已存在a的下标+1 仍小于 startIndex，则不用重置startIndex
                    startIndex = Math.max(startIndex, map.get(str.charAt(curIndex)) + 1);
                }
                map.put(curCharacter, curIndex);
                maxLen = Math.max(maxLen, curIndex - startIndex + 1);
            }
            return maxLen;
        }
    }
}
