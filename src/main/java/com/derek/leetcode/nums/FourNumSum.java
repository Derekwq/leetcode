package com.derek.leetcode.nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * Problem 18: 四数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意： 答案中不可以包含重复的四元组
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [[-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2]]
 * </p>
 * https://leetcode-cn.com/problems/4sum/
 * 
 * @author derek.wu
 * @date 2019-07-10
 * @since v1.0.0
 */
public class FourNumSum {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int nums[] = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        print(solution, nums, target);

        int[] nums2 = { 1, -2, -5, -4, -3, 3, 3, 5 };
        int target2 = -11;
        print(solution, nums2, target2);
    }

    private static void print(Solution solution, int[] nums, int target) {
        long startTime = System.currentTimeMillis();
        Object resList = solution.fourSum(nums, target);
        long cost = System.currentTimeMillis() - startTime;
        System.out.println(String.format("cost: %8dms\nresList: %s", cost, JSON.toJSONString(resList)));
        System.out.println("----------");
    }

    static class Solution {

        /**
         * Run 结果
         * 提交结果：AC
         * 执行用时：32ms
         * 内存消耗：36.8MB
         *
         * 思路：固定两个数，用双指针去找另外两个数
         * 时间复杂度：o(n^3)
         * 
         * @param nums
         * @param target
         * @return
         */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums == null || nums.length <= 0) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);

            List<List<Integer>> resList = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int subTarget = target - nums[i];
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int innerTarget = subTarget - nums[j];
                    int p = j + 1;
                    int q = nums.length - 1;
                    while (p < q) {
                        int tmp = nums[p] + nums[q];
                        if ((p > j + 1 && nums[p] == nums[p - 1]) || tmp < innerTarget) {
                            p++;
                        } else if ((q < nums.length - 1 && nums[q] == nums[q + 1]) || tmp > innerTarget) {
                            q--;
                        } else {
                            List<Integer> list = toList(nums[i], nums[j], nums[p++], nums[q--]);
                            resList.add(list);
                        }
                    }
                }
            }
            return resList;
        }

        private List<Integer> toList(int iVal, int jVal, int pVal, int qVal) {
            List<Integer> list = new ArrayList<>();
            list.add(iVal);
            list.add(jVal);
            list.add(pVal);
            list.add(qVal);
            return list;
        }
    }
}
