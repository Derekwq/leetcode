package com.ximu.leetcode.first.dp;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 *
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class DecodeWays {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, "12");
        exec(solution, "226");
        exec(solution, "0");
        exec(solution, "010");
        exec(solution, "0110");
        exec(solution, "110");
        exec(solution, "27");
    }

    private static void exec(Solution solution, String s) {
        System.out.println("s: " + s);
        System.out.println("ans: " + solution.numDecodings(s));
    }

    static class Solution {

        public int numDecodings(String s) {
            if (s == null || s.length() == 0 || s.charAt(0) == '0') {
                return 0;
            }

            int pre = 1;
            int cur = 1;
            for (int i = 1; i < s.length(); i++) {
                int tmp = cur;
                if (s.charAt(i) == '0') {
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                        cur = pre;
                    } else {
                        return 0;
                    }
                } else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                    cur += pre;
                }
                pre = tmp;
            }
            return cur;
        }
    }
}
