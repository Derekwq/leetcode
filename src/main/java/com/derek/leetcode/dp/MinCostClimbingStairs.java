package com.derek.leetcode.dp;

import com.derek.leetcode.Tool;

/**
 * 746. 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class MinCostClimbingStairs extends Tool {

    public static void main(String[] args) {
        Solution s = new Solution();
        exec(s, new int[] { 10, 15, 20 });
        exec(s, new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 });
    }

    private static void exec(Solution solution, int[] cost) {
        System.out.println(printArr(cost) + " ==> " + solution.minCostClimbingStairs(cost));
    }

}

class Solution {

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
