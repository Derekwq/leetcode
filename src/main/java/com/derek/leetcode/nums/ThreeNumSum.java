package com.derek.leetcode.nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * Problem 15: 三数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]， 满足要求的三元组 集合为：
 * [[-1, 0, 1], [-1, -1, 2]]
 * <p>
 * <p>
 * <p/>
 *
 * @author derek.wu
 * @date 2019-07-08
 * @since v1.0.0
 */
public class ThreeNumSum {

    /**
     * 双指针解法:
     * cost: 0ms
     * resList: [[-1,-1,2],[-1,0,1]]
     * DFS:
     * cost: 0ms
     * resList: [[-1,-1,2],[-1,0,1]]
     * ----------
     * 双指针解法:
     * cost: 0ms
     * resList: [[0,0,0]]
     * DFS:
     * cost: 0ms
     * resList: [[0,0,0]]
     * ----------
     * 双指针解法:
     * cost: 0ms
     * resList: [[-1,-1,2],[-1,0,1],[0,0,0]]
     * DFS:
     * cost: 2ms
     * resList: [[-1,-1,2],[-1,0,1],[0,0,0]]
     * ----------
     * 双指针解法:
     * cost: 0ms
     * resList: [[-4,2,2],[-1,-1,2],[-1,0,1],[0,0,0]]
     * DFS:
     * cost: 0ms
     * resList: [[-4,2,2],[-1,-1,2],[-1,0,1],[0,0,0]]
     * ----------
     * 双指针解法:
     * cost: 0ms
     * resList:
     * [[-10,2,8],[-10,3,7],[-10,5,5],[-8,1,7],[-8,3,5],[-7,-1,8],[-7,2,5],[-6,-2,8],[-6,-1,7],[-6,1,5],[-6,3,3],[-5,-3,8],[-5,-2,7],[-5,2,3],[-4,-4,8],[-4,-3,7],[-4,-1,5],[-4,1,3],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,-1,3]]
     * DFS:
     * cost: 6191ms
     * resList:
     * [[-10,2,8],[-10,3,7],[-10,5,5],[-8,1,7],[-8,3,5],[-7,-1,8],[-7,2,5],[-6,-2,8],[-6,-1,7],[-6,1,5],[-6,3,3],[-5,-3,8],[-5,-2,7],[-5,2,3],[-4,-4,8],[-4,-3,7],[-4,-1,5],[-4,1,3],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,-1,3]]
     * ----------
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        int nums[] = { -1, 0, 1, 2, -1, -4 };
        print(solution, nums);

        int[] nums2 = { 0, 0, 0, 0 };
        print(solution, nums2);

        int[] nums3 = { -1, -1, -1, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2 };
        print(solution, nums3);

        int[] nums4 = { -4, -1, -1, 0, 0, 0, 1, 1, 2, 2 };
        print(solution, nums4);

        int[] nums5 = { -7, -5, 5, -6, -2, 1, 7, 3, -4, -2, -2, -4, -8, -1, 8, 8, -2, -7, 3, 2, -7, 8, -3, -10, 5, 2, 8,
                        7, 7 };
        print(solution, nums5);
    }

    public static void print(Solution solution, int[] nums) {
        long startTime = System.currentTimeMillis();
        Object res = solution.threeSum(nums);
        long cost = System.currentTimeMillis() - startTime;
        System.out.println(String.format("双指针解法: \n\tcost: %8dms\n\tresList: %s", cost, JSON.toJSONString(res)));

        startTime = System.currentTimeMillis();
        res = solution.threeSumDfs(nums, 0);
        cost = System.currentTimeMillis() - startTime;
        System.out.println(String.format("DFS: \n\tcost: %8dms\n\tresList: %s", cost, JSON.toJSONString(res)));

        System.out.println("----------");
    }

    static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return new ArrayList<>();
            }

            Arrays.sort(nums);
            return threeSum(nums, 0);
        }

        /**
         * 运行结果：WA
         * 共 313 个测试用例，通过 69个
         * 不通过case：
         * input: [0, 0, 0, 0]
         * output: [[0, 0, 0], [0, 0, 0]]
         * 预期：[[0, 0, 0]]
         */
        private List<List<Integer>> threeSum1(int[] nums, int target) {
            List<List<Integer>> resultList = new ArrayList<>();
            for (int i = 1; i < nums.length - 1; i++) {
                int p = 0;
                int q = nums.length - 1;
                int subTarget = target - nums[i];
                while (true) {
                    List<Integer> list;
                    if (p >= i || q <= i) {
                        // 保证 p < i < q
                        break;
                    }
                    int tmp = subTarget - nums[p];
                    if (nums[q] == tmp) {
                        list = new ArrayList<>();
                        list.add(nums[p]);
                        list.add(nums[i]);
                        list.add(nums[q]);
                        resultList.add(list);
                        break;
                    }
                    if (nums[q] > tmp) {
                        q--;
                        continue;
                    }
                    if (nums[q] < tmp) {
                        p++;
                    }
                }
            }
            return resultList;
        }

        /**
         * Run 结果
         * 提交结果：AC
         * 执行用时：90ms
         * 内存消耗：72.5MB
         *
         * 核心：双指针 + 去重（core）
         *
         * @param nums
         * @param target
         * @return
         */
        private List<List<Integer>> threeSum(int[] nums, int target) {
            List<List<Integer>> resultList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > target) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    // 去重
                    continue;
                }
                int subTarget = target - nums[i];
                int p = i + 1;
                int q = nums.length - 1;
                while (p < q) {
                    // 去重
                    if ((p > i + 1 && nums[p] == nums[p - 1]) || nums[p] + nums[q] < subTarget) {
                        p++;
                    } else if ((q < nums.length - 1 && nums[q] == nums[q + 1]) || nums[p] + nums[q] > subTarget) {
                        q--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[p++]);
                        list.add(nums[q--]);
                        resultList.add(list);
                    }
                }
            }
            return resultList;
        }

        /**
         * 深搜
         * 
         */
        private List<List<Integer>> threeSumDfs(int[] nums, int target) {
            List<List<Integer>> resList = new ArrayList<>();
            dfs(nums, new ArrayList<>(), resList, 0, 0, 3, target);
            return resList;
        }

        private void dfs(int[] nums, List<Integer> list, List<List<Integer>> resList, int start, int count, int len,
                         int target) {
            // 找到了符合条件的个数，且目标值为0
            if (count == len && target == 0 && !resList.contains(list)) {
                resList.add(new ArrayList<>(list));
                return;
            }
            // 设置一个起点
            for (int i = start; i < nums.length; i++) {
                // 已经搜索了count+1个数，还剩 len - (count + 1) 个数，剩下的最小和是 arr[i] * (len - (count + 1)),
                // 剩下的实际和是：target - num[i]
                if (target - nums[i] < nums[i] * (len - count - 1)) {
                    break;
                }
                list.add(nums[i]);
                dfs(nums, list, resList, i + 1, count + 1, len, target - nums[i]);
                list.remove(list.size() - 1);
            }

        }
    }
}
