package com.derek.leetcode.ds;

/**
 * Problem 206: 反转链表
 * <p>
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * </p>
 * 
 * @author derek.wu
 * @date 2019-10-29
 * @since v1.0.0
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        ListNode l = ListNode.build(arr);
        ListNode rl = new ReverseList().reverseList(l);
        System.out.println(list2Str(l));
        System.out.println(list2Str(rl));
    }

    public static String list2Str(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(listNode.val).append("->");
        ListNode p = listNode;
        while (p.next != null) {
            sb.append(p.next.val).append("->");
            p = p.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p2Head = copyNodeVal(head);
        ListNode p2Next = p2Head;
        ListNode p1 = head;
        while (p1.next != null) {
            p2Head = copyNodeVal(p1.next);
            p2Head.next = p2Next;
            p2Next = p2Head;
            p1 = p1.next;
        }
        return p2Head;
    }

    private ListNode copyNodeVal(ListNode node) {
        return new ListNode(node.val);
    }

    public static class ListNode {

        int      val;
        ListNode next;

        ListNode(int x) {
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
    }
}
