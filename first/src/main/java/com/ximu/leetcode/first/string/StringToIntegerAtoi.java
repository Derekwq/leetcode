package com.ximu.leetcode.first.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author derek.wu
 * @date 2020-04-03
 * @since v1.0.0
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("-42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("   -42 adlkjdn"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("+-2"));
        System.out.println(solution.myAtoi("0-1"));
    }

}

class Solution {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        boolean isNegative = false;
        boolean firstNoneNum = false;
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!firstNoneNum && queue.size() < 1 && (c == '-' || c == '+')) {
                isNegative = c == '-';
                firstNoneNum = true;
                continue;
            }

            if (c >= '0' && c <= '9') {
                queue.add(c - '0');
            } else {
                break;
            }
        }
        if (queue.size() < 1) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < queue.size(); i++) {
            if ((Integer.MAX_VALUE - queue.get(i)) / 10 < num) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + queue.get(i);
        }
        return isNegative ? -num : num;
    }
}
