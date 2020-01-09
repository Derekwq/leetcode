package com.ximu.leetcode.first.dp;

import com.ximu.leetcode.first.Tool;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class MaximumSubarray extends Tool {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
    }

    private static void exec(Solution solution, int[] nums) {
        int max = solution.maxSubArray(nums);
        System.out.println(printArr(nums) + " ==> " + max);
    }

    static class Solution {

        public int maxSubArray(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int sum = nums[0];
            int max = sum;
            for (int i = 1; i < nums.length; i++) {
                // sum = Math.max(sum + nums[i], nums[i])
                sum = sum > 0 ? sum + nums[i] : nums[i];
                max = Math.max(max, sum);
            }
            return max;
        }
    }

}
