package com.ximu.leetcode.first.nums;

/**
 * Problem 9
 * https://leetcode-cn.com/problems/palindrome-number/submissions/
 * 
 * @author derek.wu
 * @date 2020-04-03
 * @since v1.0.0
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(-1));
        System.out.println(solution.isPalindrome(1));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(1221));
        System.out.println(solution.isPalindrome(1231));
        System.out.println(solution.isPalindrome(12321));
    }

    static class Solution {

        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            String s = String.valueOf(x);
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
