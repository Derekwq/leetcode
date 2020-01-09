package com.ximu.leetcode.first;

/**
 * @author derek.wu
 * @date 2019-10-30
 * @since v1.0.0
 */
public class ListNode {

    public int      val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode build(int[] arr) {
        ListNode l = new ListNode(arr[0]);
        ListNode p = l;
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                p.next = new ListNode(arr[i]);
                p = p.next;
            }
        }
        return l;
    }

    public static String listNodeToString(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val);
            listNode = listNode.next;
            if (listNode != null) {
                sb.append("->");
            }
        }
        return sb.toString();
    }
}
