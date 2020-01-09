package com.ximu.leetcode.first.dp;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * 
 * @author derek.wu
 * @date 2019-11-01
 * @since v1.0.0
 */
public class WordBreak {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, "leetcode", Lists.newArrayList("leet", "code"));
        exec(solution, "applepenapple", Lists.newArrayList("apple", "pen"));
        exec(solution, "catsandog", Lists.newArrayList("cats", "dog", "sand"));
    }

    private static void exec(Solution solution, String s, List<String> wordDict) {
        System.out.println("s: " + s);
        System.out.println("wordDict: " + JSON.toJSONString(wordDict));
        System.out.println("ans: " + solution.wordBreak(s, wordDict) + "\n");
    }

    static class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || wordDict == null || wordDict.isEmpty()) {
                return false;
            }
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int j = 1; j <= s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    if (dp[i] && wordDict.contains(s.substring(i, j))) {
                        dp[j] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
