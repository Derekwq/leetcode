package com.ximu.leetcode.first.string;

/**
 * 392. 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class IsSubsequence {

    public static void main(String[] args) {
        Solution s1 = new Solution1();
        exec(s1, "abc", "ahbgdc");
        exec(s1, "axc", "ahbgdc");
        exec(s1, "", "ahbgdc");
    }

    private static void exec(Solution solution, String s, String t) {
        System.out.println("t: " + t);
        System.out.println("s: " + s);
        System.out.println("ans: " + solution.isSubsequence(s, t) + "\n");
    }

    interface Solution {

        boolean isSubsequence(String s, String t);
    }
}

/**
 * 字符串指针移动
 * AC
 */
class Solution1 implements IsSubsequence.Solution {

    @Override
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }

        int sPoint = 0;
        for (int i = 0; i < t.length() && sPoint < s.length(); i++) {
            if (s.charAt(sPoint) == t.charAt(i)) {
                sPoint++;
                continue;
            }
        }
        return sPoint == s.length();
    }
}
