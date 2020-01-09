package com.ximu.leetcode.first.dp;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class Triangle {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, testData1());
    }

    private static void exec(Solution solution, List<List<Integer>> triangle) {
        System.out.println(solution.minimumTotal(triangle));
    }

    private static List<List<Integer>> testData1() {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> l1 = Lists.newArrayList(2);
        List<Integer> l2 = Lists.newArrayList(3, 4);
        List<Integer> l3 = Lists.newArrayList(6, 5, 7);
        List<Integer> l4 = Lists.newArrayList(4, 1, 8, 3);
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        return lists;
    }

    static class Solution {

        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.isEmpty()) {
                return 0;
            }
            int len = triangle.size();
            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][len - 1] = triangle.get(len - 1).get(i);
            }

            for (int j = len - 2; j >= 0; j--) {
                for (int i = j; i >= 0; i--) {
                    dp[i][j] = triangle.get(j).get(i) + Math.min(dp[i][j + 1], dp[i + 1][j + 1]);
                }
            }
            return dp[0][0];
        }

        /**
         * 简化一维数组
         */
        public int minimumTotal2(List<List<Integer>> triangle) {
            if (triangle == null || triangle.isEmpty()) {
                return 0;
            }
            int len = triangle.size();
            int[] dp = new int[len + 1];
            for (int j = len - 1; j >= 0; j--) {
                for (int i = 0; i <= j; i++) {
                    dp[i] = triangle.get(j).get(i) + Math.min(dp[i], dp[i - 1]);
                }
            }
            return dp[0];
        }
    }

}
