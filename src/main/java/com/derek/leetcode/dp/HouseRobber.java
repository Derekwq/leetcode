package com.derek.leetcode.dp;

import com.derek.leetcode.Tool;

/**
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class HouseRobber extends Tool {

    public static void main(String[] args) {
        System.out.println("method1: ");
        Solution s1 = new Solution1();
        exec(s1, new int[] { 1, 2, 3, 1 });
        exec(s1, new int[] { 2, 7, 9, 3, 1 });

        System.out.println("method2: ");
        Solution s2 = new Solution2();
        exec(s2, new int[] { 1, 2, 3, 1 });
        exec(s2, new int[] { 2, 7, 9, 3, 1 });
    }

    private static void exec(Solution solution, int[] nums) {
        System.out.println(printArr(nums) + " ==> " + solution.rob(nums));
    }

    interface Solution {

        int rob(int[] nums);
    }

    static class Solution1 implements Solution {

        @Override
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return nums[0] > nums[1] ? nums[0] : nums[1];
            }
            int dp[] = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            return dp[nums.length - 1];
        }
    }

    static class Solution2 implements Solution {

        @Override
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int preMax = nums[0];
            int curMax = preMax;
            for (int i = 1; i < nums.length; i++) {
                int tmp = curMax;
                curMax = Math.max(curMax, preMax + nums[i]);
                preMax = tmp;
            }
            return curMax;
        }
    }
}
