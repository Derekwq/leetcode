package com.ximu.leetcode.nums;

import com.ximu.leetcode.ListNode;

/**
 * @author derek.wu
 * @date 2020-01-09
 * @since v1.0.0
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1.val == 0) {
                return l2;
            }
            if (l2.val == 0) {
                return l1;
            }

            ListNode l3 = null;
            ListNode tail = null;

            ListNode p1 = l1;
            ListNode p2 = l2;
            int carry = 0;
            while (p1 != null || p2 != null) {
                int v1 = p1 == null ? 0 : p1.val;
                int v2 = p2 == null ? 0 : p2.val;
                int sum = v1 + v2 + carry;
                int val = sum % 10;
                carry = sum > 9 ? 1 : 0;
                ListNode node = new ListNode(val);
                if (l3 == null) {
                    l3 = node;
                    tail = l3;
                } else {
                    tail.next = node;
                    tail = tail.next;
                }
                p1 = p1 == null ? null : p1.next;
                p2 = p2 == null ? null : p2.next;
            }
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return l3;
        }
    }
}
