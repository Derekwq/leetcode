package com.ximu.leetcode.first.ds;

import com.ximu.leetcode.first.ListNode;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4 };
        int[] arr2 = { 1, 3, 4 };
        ListNode l1 = ListNode.build(arr1);
        ListNode l2 = ListNode.build(arr2);
        ListNode newL = new MergeTwoSortedLists().mergeTwoLists(l1, l2);

        System.out.println("l1: " + ListNode.listNodeToString(l1));
        System.out.println("l2: " + ListNode.listNodeToString(l2));
        System.out.println("newL: " + ListNode.listNodeToString(newL));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode newL;
        ListNode pn;
        ListNode p1 = l1;
        ListNode p2 = l2;
        if (p1.val < p2.val) {
            newL = copyNodeVal(p1);
            p1 = p1.next;
        } else {
            newL = copyNodeVal(p2);
            p2 = p2.next;
        }
        pn = newL;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pn.next = copyNodeVal(p1);
                p1 = p1.next;
            } else {
                pn.next = copyNodeVal(p2);
                p2 = p2.next;
            }
            pn = pn.next;
        }
        if (p1 != null) {
            appendList(pn, p1);
        }
        if (p2 != null) {
            appendList(pn, p2);
        }
        return newL;
    }

    private void appendList(ListNode pn, ListNode pNode) {
        pn.next = copyNodeVal(pNode);
        pn = pn.next;
        while (pNode.next != null) {
            pNode = pNode.next;
            pn.next = copyNodeVal(pNode);
            pn = pn.next;
        }
    }

    private ListNode copyNodeVal(ListNode node) {
        return new ListNode(node.val);
    }

}
