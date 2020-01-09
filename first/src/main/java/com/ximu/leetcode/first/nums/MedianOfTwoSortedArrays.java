package com.ximu.leetcode.first.nums;

import com.alibaba.fastjson.JSON;

/**
 * Problem 4: 寻找两个有序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * </p>
 * 
 * @author derek.wu
 * @date 2019-07-11
 * @since v1.0.0
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution, new int[] { 1, 1 }, new int[] { 1, 1 });
        print(solution, new int[] {}, new int[] { 1 });
        print(solution, new int[] { 1, 3 }, new int[] { 2 });
        print(solution, new int[] { 1, 2 }, new int[] { 3, 4 });
    }

    private static void print(Solution solution, int[] nums1, int[] nums2) {
        long startTime = System.currentTimeMillis();
        double res = solution.findMedianSortedArrays(nums1, nums2);
        long cost = System.currentTimeMillis() - startTime;
        System.out.println(String.format("num1: %s\nnum2: %s\ncost: %4d\tres: %s", JSON.toJSONString(nums1),
                                         JSON.toJSONString(nums2), cost, res));
        System.out.println("---------");
    }

    static class Solution {

        /**
         * 提交结果：AC
         * 执行用时：14ms
         * 内存消耗：53MB
         * 数学推导过程：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-shu-b/
         * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
         *
         * 时间复杂度：o(log(min(m, n)))
         * 
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if (m > n) {
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
                m = nums1.length;
                n = nums2.length;
            }

            if (m == 0) {
                return findMedianSortedArray(nums2);
            }

            int iMin = 0;
            int iMax = m;
            int halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && nums2[j - 1] > nums1[i]) {
                    // 此分支说明i太小，需要在i的右边搜索，因此，需要保证i<iMax, 确保 iMin = i + 1 <= iMax
                    iMin = i + 1;
                } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                    // 此分支说明你太大，需要在i的左边搜索，因此，需要保证i>iMin, 确保 iMax = i -1 >= iMin
                    iMax = i - 1;
                } else {
                    // 已满足条件
                    int maxLeft;
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                    }

                    if ((m + n) % 2 == 1) {
                        // 如果总长度为奇数，则中位数即为 maxLeft
                        return maxLeft;
                    }

                    int minRight;
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums1[i], nums2[j]);
                    }
                    return (maxLeft + minRight) / 2.0;
                }
            }

            return 0.0;
        }

        private double findMedianSortedArray(int[] nums) {
            int len = nums.length;
            if (len % 2 == 0) {
                return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
            }
            return nums[len / 2] * 1.0;
        }
    }
}
