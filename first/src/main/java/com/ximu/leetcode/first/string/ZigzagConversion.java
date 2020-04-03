package com.ximu.leetcode.first.string;

/**
 * Problem 6
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * 
 * @author derek.wu
 * @date 2020-04-03
 * @since v1.0.0
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("LEETCODEISHIRING", 3));
        System.out.println(solution.convert("LEETCODEISHIRING", 4));
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }

    static class Solution {

        public String convert(String s, int numRows) {
            if (numRows < 2) {
                return s;
            }
            // 对于第一行和最后一行，都是按此递增
            // 对于 其他行，此 step 递增的中间还会有一个值，
            int step = (numRows - 1) * 2;
            StringBuilder sb = new StringBuilder();
            for (int line = 1; line <= numRows; line++) {
                if (line == 1 || line == numRows) {
                    int idx = line - 1;
                    while (idx < s.length()) {
                        sb.append(s.charAt(idx));
                        idx += step;
                    }
                } else {
                    int idx = line - 1;
                    int idx2 = (numRows - line) * 2 + idx;
                    while (idx < s.length()) {
                        sb.append(s.charAt(idx));
                        if (idx2 < s.length()) {
                            sb.append(s.charAt(idx2));
                        }
                        idx += step;
                        idx2 += step;
                    }
                }
            }
            return sb.toString();
        }
    }
}
