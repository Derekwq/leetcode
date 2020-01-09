package com.ximu.leetcode.first.dp;

import com.ximu.leetcode.first.Tool;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 
 * @author derek.wu
 * @date 2019-10-31
 * @since v1.0.0
 */
public class RangeSumQueryImmutable extends Tool {

    public static void main(String[] args) {
        exec(new int[] { -2, 0, 3, -5, 2, -1 }, 0, 2);
        exec(new int[] { -2, 0, 3, -5, 2, -1 }, 2, 5);
        exec(new int[] { -2, 0, 3, -5, 2, -1 }, 0, 5);

        exec(new int[] { 2 }, 0, 0);

        exec(new int[] {}, 0, 0);
    }

    private static void exec(int[] nums, int i, int j) {
        NumArray numArray = new NumArray(nums);
        System.out.println(printArr(nums) + " (i, j) \n ans: " + numArray.sumRange(i, j) + "\n");
    }
}

/**
 * 注意，在上面的代码中，我们插入了一个虚拟 0 作为 sum 数组中的第一个元素。这个技巧可以避免在 sumrange 函数中进行额外的条件检查。
 */
class NumArray {

    private int[]   nums;
    private int[]   sum;
    private boolean isEmpty;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            isEmpty = true;
            return;
        }
        this.nums = nums;
        this.sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (isEmpty) {
            return 0;
        }
        return sum[j + 1] - sum[i];
    }
}
