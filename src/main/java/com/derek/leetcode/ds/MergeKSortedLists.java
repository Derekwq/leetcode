package com.derek.leetcode.ds;

import com.derek.leetcode.ListNode;

/**
 * 23. 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode l1 = ListNode.build(new int[] { 1, 4, 5 });
        ListNode l2 = ListNode.build(new int[] { 1, 3, 4 });
        ListNode l3 = ListNode.build(new int[] { 2, 6 });

        ListNode[] lArr = new ListNode[] { l1, l2, l3 };
        ListNode newL = new MergeKSortedLists().mergeKLists(lArr);
        System.out.println("newL: " + ListNode.listNodeToString(newL));
    }

    /**
     * 纯链表操作解法。 O(n*n)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode[] pArr = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            pArr[i] = lists[i];
        }
        if (!isGoOn(pArr)) {
            return null;
        }
        int min = minOf(pArr);
        ListNode newL = new ListNode(min);
        ListNode pn = newL;

        while (isGoOn(pArr)) {
            int curMin = minOf(pArr);
            pn.next = new ListNode(curMin);
            pn = pn.next;
        }
        return newL;
    }

    private int minOf(ListNode[] pArr) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < pArr.length; i++) {
            if (pArr[i] == null) {
                continue;
            }
            if (pArr[i].val < min) {
                min = pArr[i].val;
                idx = i;
            }
        }
        if (idx >= 0) {
            pArr[idx] = pArr[idx].next;
        }
        return min;
    }

    private boolean isGoOn(ListNode[] pArr) {
        if (pArr == null || pArr.length == 0) {
            return false;
        }
        for (ListNode p : pArr) {
            if (p != null) {
                return true;
            }
        }
        return false;
    }
}
