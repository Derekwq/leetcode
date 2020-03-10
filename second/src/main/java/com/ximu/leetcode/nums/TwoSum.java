package com.ximu.leetcode.nums;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author derek.wu
 * @date 2020-01-09
 * @since v1.0.0
 */
public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(JSON.toJSONString(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9)));
    }

    static class Solution {

        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int idx = 0; idx < nums.length; idx++) {
                int tmp = target - nums[idx];
                Integer secIdx;
                if ((secIdx = map.get(tmp)) != null) {
                    return new int[] { secIdx, idx };
                }
                map.put(nums[idx], idx);
            }
            return null;
        }
    }
}
