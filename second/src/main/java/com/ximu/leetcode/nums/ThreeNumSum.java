package com.ximu.leetcode.nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 
 * @author derek.wu
 * @date 2020-01-14
 * @since v1.0.0
 */
public class ThreeNumSum {

    static class Solution {

        /**
         * 先排序
         * 再 定一移二，双指针
         * 
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return null;
            }
            Arrays.sort(nums);

            List<List<Integer>> resList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int p = i + 1;
                int q = nums.length - 1;
                int subTarget = 0 - nums[i];
                while (p < q) {
                    if ((p > i + 1 && nums[p] == nums[p - 1]) || nums[p] + nums[q] < subTarget) {
                        p++;
                    } else if ((q < nums.length - 2 && nums[q] == nums[q + 1]) || nums[p] + nums[q] > subTarget) {
                        q--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[p++]);
                        list.add(nums[q--]);
                        resList.add(list);
                    }
                }
            }
            return resList;
        }

    }
}
