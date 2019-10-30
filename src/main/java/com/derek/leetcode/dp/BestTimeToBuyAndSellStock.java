package com.derek.leetcode.dp;

import com.derek.leetcode.Tool;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class BestTimeToBuyAndSellStock extends Tool {

    public static void main(String[] args) {
        System.out.println("method1: ");
        Solution s1 = new Solution1();
        exec(s1, new int[] { 7, 1, 5, 3, 6, 4 });
        exec(s1, new int[] { 7, 6, 4, 3, 1 });

        System.out.println("method2: ");
        Solution s2 = new Solution2();
        exec(s2, new int[] { 7, 1, 5, 3, 6, 4 });
        exec(s2, new int[] { 7, 6, 4, 3, 1 });
    }

    private static void exec(Solution solution, int[] prices) {
        System.out.println(printArr(prices) + " ==> " + solution.maxProfit(prices));
    }

    interface Solution {

        int maxProfit(int[] prices);
    }

    /**
     * DP方法
     * 一次AC
     * But:
     * 执行用时 : 539 ms, 在所有 java 提交中击败了 5.00% 的用户
     * 内存消耗 : 38.2 MB, 在所有 java 提交中击败了 53.97% 的用户
     */
    static class Solution1 implements Solution {

        @Override
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int dp[] = new int[prices.length];

            dp[0] = 0;
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                int curMax = 0;
                for (int j = 0; j < i; j++) {
                    curMax = Math.max(curMax, caluProfit(prices[j], prices[i]));
                }
                dp[i] = curMax;
                if (curMax > max) {
                    max = curMax;
                }
            }
            return max;
        }

        private int caluProfit(int x, int y) {
            return x >= y ? 0 : y - x;
        }
    }

    static class Solution2 implements Solution {

        @Override
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            // 找到 股票价格最小的那一天的值
            int minPrice = Integer.MAX_VALUE;
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                // 当天的与小的那一天进行比较
                max = Math.max(max, prices[i] - minPrice);
            }
            return max;
        }
    }
}
