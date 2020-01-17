package com.leetcode;

import java.util.Scanner;

/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

方法：
正常链表操作
* */
public class SwapPairs {
    public static void main(String[] args) {
        Solution48 s = new Solution48();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        ListNode head = MergeList.buildListFromStr(line);
        ListNode newHead = s.swapPairs(head);
        MergeList.printList(newHead);
        in.close();
    }
}

class Solution48 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode prev = new ListNode(-1), first = head, second = head.next, next = head.next.next;
        prev.next = first;
        head = prev;
        while(first!=null&&second!=null) {
            prev.next = second;
            second.next = first;
            first.next = next;

            prev = first; //交换后prev应当指向first
            first = next;
            second = first!=null?first.next:null;
            next = second!=null?second.next:null;
        }
        return head.next;
    }
}
