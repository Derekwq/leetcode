package com.derek.leetcode.ds;

import com.derek.leetcode.ListNode;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[] { 1, 2, 3, 4 });
        Solution solution = new Solution();

        ListNode r1 = solution.swapPairs(l1);
        System.out.println("r1: " + ListNode.listNodeToString(r1));
    }

    static class Solution {

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            head.next = swapPairs(next.next);
            next.next = head;
            return next;
        }

    }
}
