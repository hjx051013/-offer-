package com.leetcode;

import java.util.Scanner;
/*
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5

方法：
单链表归并排序
 */
public class SortList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Solution10 s = new Solution10();
        ListNode list = MergeList.buildListFromStr(line);
        MergeList.printList(s.sortList(list));
        in.close();
    }
}


class Solution10 {
    public ListNode sortList(ListNode head) {
        //  0个节点 ||  1个节点
        if (head == null || head.next == null)
            return head;
        //  >= 2个节点
        ListNode first = head, second = null, mid = getMid(head);
        second = mid.next;
        mid.next = null;  //将链表分为两段！！！！
        //递归
        first = sortList(first);
        second = sortList(second);
        return merge(first, second);
    }

    private ListNode merge(ListNode left,ListNode right) {
        if(left==null) return right;
        if(right==null) return left;
        ListNode first = new ListNode(0),curr = first;
        while(left!=null&&right!=null) {
            if(left.val<right.val) {
                curr.next = left;
                curr = curr.next;
                left = left.next;
            } else {
                curr.next = right;
                curr = curr.next;
                right = right.next;
            }
        }
        if(left!=null) {
            curr.next = left;
        }
        if(right!=null) {
            curr.next = right;
        }
        return first.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head,fast = head.next;
        while(fast!=null&&fast.next!=null) {
            fast = slow.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
