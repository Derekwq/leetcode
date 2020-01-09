package com.ximu.leetcode.first.ds;

import com.ximu.leetcode.first.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, new int[] { 1, 1, 2 });
        exec(solution, new int[] { 1, 1, 2, 3, 3 });
    }

    private static void exec(Solution solution, int[] arr) {
        ListNode l = ListNode.build(arr);
        ListNode rs = solution.deleteDuplicates(l);
        System.out.println(String.format("l: %s\nrs: %s\n\n", ListNode.listNodeToString(l),
                                         ListNode.listNodeToString(rs)));
    }

    static class Solution {

        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p = head;
            while (p.next != null) {
                if (p.val != p.next.val) {
                    p = p.next;
                    continue;
                }
                p.next = p.next.next;
            }
            return head;
        }
    }
}
