package com.ximu.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author derek.wu
 * @date 2020-01-09
 * @since v1.0.0
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

    }

    static class Solution {

        public int lengthOfLongestSubstring(String s) {
            if (s == null) {
                return 0;
            }
            if (s.length() < 2) {
                return s.length();
            }
            int startIdx = 0;
            int maxLen = 0;
            // k: 字符，v: 该字符的最大下标
            Map<Character, Integer> map = new HashMap<>();
            for (int curIdx = 0; curIdx < s.length(); curIdx++) {
                Character curChar = s.charAt(curIdx);
                if (map.containsKey(curChar)) {
                    startIdx = Math.max(startIdx, map.get(curChar) + 1);
                }
                map.put(curChar, curIdx);
                maxLen = Math.max(maxLen, curIdx - startIdx + 1);
            }
            return maxLen;
        }
    }
}
