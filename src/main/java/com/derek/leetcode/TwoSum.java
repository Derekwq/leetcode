package com.derek.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * Problem 1: Two sum （两数之和）
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target, 请你在该数组中找出 和为目标值 的那两个整数，并且返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是你不能重复利用这个数组中同样的元素。
 * 示例： 给定数 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9, 所以返回 [0, 1]
 * </p>
 * https://leetcode-cn.com/problems/two-sum/
 * 
 * @author derek.wu
 * @date 2019-07-08
 * @since v1.0.0
 */
public class TwoSum {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = new int[] { 2, 7, 11, 15 };

        System.out.println(JSON.toJSONString(solution.twoSum(nums, 9)));
    }

    static class Solution {

        /**
         * Run 结果
         * 提交结果：AC
         * 执行用时：2ms
         * 内存消耗：37.3MB
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int tmp = target - nums[i];
                if (map.get(tmp) != null) {
                    return new int[] { map.get(tmp), i };
                }
                map.put(nums[i], i);
            }
            return null;
        }

    }

}
