package com.derek.leetcode.ds;

import com.derek.leetcode.ListNode;

/**
 * 86. 分隔链表
 * https://leetcode-cn.com/problems/partition-list/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class PartitionList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, new int[] { 1, 4, 3, 2, 5, 2 }, 3);
    }

    private static void exec(Solution solution, int[] arr, int x) {
        ListNode l = ListNode.build(arr);
        ListNode rs = solution.partition(l, x);
        System.out.println(String.format("l: %s\nrs: %s\n\n", ListNode.listNodeToString(l),
                                         ListNode.listNodeToString(rs)));
    }

    static class Solution {

        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode beforeHead = new ListNode(-1);
            ListNode beforePoint = beforeHead;
            ListNode afterHead = new ListNode(-1);
            ListNode afterPoint = afterHead;

            ListNode p = head;
            while (p != null) {
                if (p.val < x) {
                    beforePoint.next = p;
                    beforePoint = beforePoint.next;
                } else {
                    afterPoint.next = p;
                    afterPoint = afterPoint.next;
                }
                p = p.next;
            }
            afterPoint.next = null;
            beforePoint.next = afterHead.next;
            return beforeHead.next;
        }
    }

}
