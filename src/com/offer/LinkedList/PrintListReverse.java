package com.offer.LinkedList;
import com.leetcode.ListNode;
import com.leetcode.MergeList;

import java.util.Scanner;
import java.util.Stack;

/*
5. 从尾到头打印链表
题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
思路：
    1. 用栈存储数据
    2. 递归方式打印
 */
public class PrintListReverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        ListNode head = MergeList.buildListFromStr(line);
        Solution5 s = new Solution5();
        s.printListReverse(head);
        in.close();
    }
}

class Solution5 {
    /*
//    栈
    public void printListReverse(ListNode head) {
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        while(p!=null) {
            stack.push(p.val);
            p = p.next;
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    */
    public void printListReverse(ListNode head) {
        if(head==null) return;
        if(head.next == null) System.out.println(head.val);
        else {
            printListReverse(head.next);
            System.out.println(head.val);
        }
    }
}

