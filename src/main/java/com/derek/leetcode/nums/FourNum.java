package com.derek.leetcode.nums;

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
public class FourNum {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int nums[] = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        print(solution, nums, target);
    }

    private static void print(Solution solution, int[] nums, int target) {
        long startTime = System.currentTimeMillis();
        Object resList = solution.fourSum(nums, target);
        long cost = System.currentTimeMillis() - startTime;
        System.out.println(String.format("cost: %8dms\nresList: %s", cost, JSON.toJSONString(resList)));
    }

    static class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            // TODO by derek.wu
            return null;
        }

    }
}
