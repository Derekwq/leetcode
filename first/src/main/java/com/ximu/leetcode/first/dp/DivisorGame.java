package com.ximu.leetcode.first.dp;

/**
 * 1025. 除数博弈
 * https://leetcode-cn.com/problems/divisor-game/
 *
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class DivisorGame {

    public static void main(String[] args) {
        System.out.println("method 1:");
        Solution s1 = new Solution1();
        exec(s1, 2);
        exec(s1, 3);
        System.out.println("method 2:");
        Solution s2 = new Solution2();
        exec(s2, 2);
        exec(s2, 3);
    }

    private static void exec(Solution solution, int n) {
        System.out.println(String.format("N: %s, ans: %s\n", n, solution.divisorGame(n)));
    }

    interface Solution {

        boolean divisorGame(int n);
    }

    static class Solution1 implements Solution {

        @Override
        public boolean divisorGame(int n) {
            return n % 2 == 0;
        }
    }

    static class Solution2 implements Solution {

        @Override
        public boolean divisorGame(int n) {
            if (n <= 1) {
                return false;
            }
            if (n == 2) {
                return true;
            }
            int[] dp = new int[n + 1];
            dp[1] = 0;
            dp[2] = 1;
            for (int k = 3; k <= n; k++) {
                for (int x = 1; x < k; x++) {
                    if (k % x == 0 && dp[k - x] == 0) {
                        dp[k] = 1;
                        break;
                    }
                }
            }
            return dp[n] == 1;
        }
    }

}
