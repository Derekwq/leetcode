package com.ximu.leetcode.nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 
 * @author derek.wu
 * @date 2020-01-14
 * @since v1.0.0
 */
public class FourNumSum {

    class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums == null || nums.length < 4) {
                return null;
            }
            Arrays.sort(nums);

            List<List<Integer>> resList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > target) {
                    break;
                }
                int subTarget = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > subTarget) {
                        break;
                    }
                    if (nums[j] == nums[i] || (j > i + 2 && nums[j] == nums[j - 1])) {
                        continue;
                    }
                    int p = j + 1;
                    int q = nums.length - 1;
                    int subTar = subTarget - nums[j];
                    while (p < q) {
                        if ((p > j + 1 && nums[p] == nums[p - 1]) || nums[p] + nums[q] < subTar) {
                            p++;
                        } else if ((q < nums.length - 2 && nums[q] == nums[q + 1]) || nums[p] + nums[q] > subTar) {
                            q--;
                        } else {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[p++]);
                            list.add(nums[q--]);
                            resList.add(list);
                        }
                    }
                }
            }
            return resList;
        }
    }
}
