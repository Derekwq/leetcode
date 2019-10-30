package com.derek.leetcode.ds;

import com.derek.leetcode.ListNode;

/**
 * 25. K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        Solution solution = new Solution();
        exec(solution, new int[] { 1, 2, 3, 4, 5 }, 2);
        exec(solution, new int[] { 1, 2, 3, 4, 5 }, 3);
    }

    private static void exec(Solution solution, int[] arr, int k) {
        ListNode l = ListNode.build(arr);
        ListNode rs = solution.reverseKGroup(l, k);
        System.out.println(String.format("l: %s\nrs: %s\n\n", ListNode.listNodeToString(l),
                                         ListNode.listNodeToString(rs)));
    }
}

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 已翻转区域的终点
        ListNode pre = dummy;
        // 待翻转区域的终点
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 未翻转区域的起点
            ListNode next = end.next;
            // 待翻转区域的起点
            ListNode start = pre.next;
            end.next = null;

            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
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
