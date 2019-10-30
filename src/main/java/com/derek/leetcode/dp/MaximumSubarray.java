package com.derek.leetcode.dp;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
    }

    private static void exec(Solution solution, int[] nums) {
        int max = solution.maxSubArray(nums);
        System.out.println(printArr(nums) + " ==> " + max);
    }

    private static String printArr(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
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
