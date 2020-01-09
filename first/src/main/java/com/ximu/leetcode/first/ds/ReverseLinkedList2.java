package com.ximu.leetcode.first.ds;

import com.ximu.leetcode.first.ListNode;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class ReverseLinkedList2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, new int[] { 1, 2, 3, 4, 5 }, 2, 4);
        exec(solution, new int[] { 1, 2, 3, 4, 5 }, 1, 4);
    }

    private static void exec(Solution solution, int[] arr, int m, int n) {
        ListNode l = ListNode.build(arr);
        ListNode rs = solution.reverseBetween(l, m, n);
        System.out.println(String.format("l: %s\nrs: %s\n\n", ListNode.listNodeToString(l),
                                         ListNode.listNodeToString(rs)));
    }
}

class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                pre = pre.next;
            }
            end = end.next;
        }

        ListNode start = pre.next;
        ListNode next = end.next;
        end.next = null;

        pre.next = reverse(start);
        start.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
}
